package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.DTOAssemblers.DTOAssemblerFactory.HibernateDTOAssemblerFactory;
import com.productmanagment.productmanagment.configs.ProductConf;
import com.productmanagment.productmanagment.dtos.ProductDTO;
import com.productmanagment.productmanagment.dtos.ProductReductionPriceDTO;
import com.productmanagment.productmanagment.dtos.SupplierDTO;
import com.productmanagment.productmanagment.exception.BadRequestException;
import com.productmanagment.productmanagment.exception.BusinessException;
import com.productmanagment.productmanagment.exception.ConflictException;
import com.productmanagment.productmanagment.exception.NotFoundException;
import com.productmanagment.productmanagment.models.*;
import com.productmanagment.productmanagment.queryFilters.ProductQueryFilter;
import com.productmanagment.productmanagment.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductReductionPriceRepository productReductionPriceRepository;

    @Autowired
    private ProductCauseRepository productCauseRepository;

    private final  String PRODUCT_DOES_NOT_EXIST  = "PRODUCT DOES NOT EXIST";
    private final  String PRODUCT_EXIST  = "PRODUCT ALREADY EXIST";
    private  final  String USER_DOES_NOT_EXIST = "USER DOES NOT EXIST";
    private  final String PRODUCT_PRICE_CAN_NOT_BE_LESS_THAN_ZERO = "PRODUCT PRICE CAN NOT BE LESS THA  ZERO";


    @Override
    public void add(ProductDTO productDTO) {
        productDTO.setProductId(null);
        productDTO.setState(ProductState.ACTIVE);
        checkIfHaveMoreThatOneSupplier(productDTO.getSuppliers());
        if(productDTO.getProductCause() != null){
            throw new BusinessException("Product must not have a product cause because is always Active when created");
        }

        checkProductDTOPrice(productDTO.getPrice());
        Product productFromDb = productRepository.findProductByCode(productDTO.getCode());

       if(productFromDb!=null){
            throw new ConflictException(PRODUCT_EXIST);
        }
        Product product = HibernateDTOAssemblerFactory.DEFAULT.getProductAssembler().Dto2Pojo(productDTO);
        checkTotalProductsReducePrice(product);

        if(product.getSuppliers()!= null){
            List<Supplier> suppliers = new ArrayList<>();
            product.getSuppliers().forEach(supplier -> {
                if(supplier.getSupplierId()==  null){
                    throw  new BadRequestException("product must to have a supplierId");
                }
                Supplier supplierFromDb = supplierRepository.findById(supplier.getSupplierId())
                        .orElseThrow(() ->new NotFoundException("Supplier not found") );
                suppliers.add(supplierFromDb);
            });
            product.getSuppliers().clear();
            product.setSuppliers(suppliers);
        }

        User creator = userRepository.findById(productDTO.getUserId())
                .orElseThrow(() -> new NotFoundException("creator not found!"));

        checkCreatorProduct(creator);
        product.setCreationDate(new Date());
        product.setCreator(creator);
        productRepository.save(product);
        productDTO.setProductId(product.getProductId());
    }


    @Override
    public void update(ProductDTO productDTO) {

        checkProductDTOPrice(productDTO.getPrice());

        Product productFromDbTracking = productRepository.findProductByCodeOrId(productDTO.getCode(), productDTO.getProductId());

        if(productFromDbTracking == null){
            throw new NotFoundException(PRODUCT_DOES_NOT_EXIST);
        }

        Product product = HibernateDTOAssemblerFactory.DEFAULT.getProductAssembler().Dto2Pojo(productDTO);
        User creator = userRepository.getById(productDTO.getUserId());
        checkCreatorProduct(creator);
        product.setCreator(creator);
        checkTotalProductsReducePrice(product);

        //In this step product is going to update when service auto commit
        updateProduct(productFromDbTracking, productDTO);

    }

    private void checkProductDTOPrice(Double price){
        if(price < 0 ){
            throw new BusinessException(PRODUCT_PRICE_CAN_NOT_BE_LESS_THAN_ZERO);
        }
    }

    private void checkCreatorProduct(User creator){

        if(creator == null){
            throw new ConflictException(USER_DOES_NOT_EXIST);
        }
    }

    private void checkTotalProductsReducePrice(Product product){
        if(product.getProductReductionPrices() != null){

            Double totalReducedPrice = 0.0 ;

            for(ProductReductionPrice productReductionPrice : product.getProductReductionPrices()){
                if(productReductionPrice.getEndDate().getTime() < new Date().getTime()){
                    totalReducedPrice +=  productReductionPrice.getReducedPrice();
                }
            }
            if(totalReducedPrice > product.getPrice()){
                throw new BusinessException("Total product reduce price must no be greater than product price");
            }
        }
    }


    private void updateProduct(Product productFromDbTracking,
                               ProductDTO productDTODestination ){

        productFromDbTracking.setPrice(productDTODestination.getPrice());
        productFromDbTracking.setName(productDTODestination.getName());

        processToUpdateProductState(productFromDbTracking, productDTODestination);

        productFromDbTracking.setDescription(productDTODestination.getDescription());

        processToUpdateProductReductionPrice(productFromDbTracking, productDTODestination.getProductReductionPrices());

        processToUpdateSupplier(productFromDbTracking, productDTODestination.getSuppliers());
    }


    private void processToUpdateProductReductionPrice(Product productFromDbTracking,
                                                      List<ProductReductionPriceDTO> productReductionPriceDTOS){

        List<ProductReductionPrice> productReductionPrices = new ArrayList<>();

        if(productReductionPriceDTOS != null){
            productReductionPriceDTOS.forEach(productReductionPriceDTO -> {
                ProductReductionPrice productReductionPrice;
                if(productReductionPriceDTO.getProductReductionPriceId() == null){

                    //CREATE NEW
                    productReductionPrice = new ProductReductionPrice();
                    productReductionPrice.setProduct(productFromDbTracking);
                }
                else{
                    //TO UPDATE
                    productReductionPrice = productReductionPriceRepository.findById(productReductionPriceDTO.getProductReductionPriceId())
                            .orElseThrow(()->new NotFoundException("Product reduction price not found"));
                }
                BeanUtils.copyProperties(productReductionPriceDTO, productReductionPrice);
                productReductionPrices.add(productReductionPrice);
            });
        }
        //In this step we apply changes after auto commit
        productFromDbTracking.getProductReductionPrices().clear();
        productFromDbTracking.getProductReductionPrices().addAll(productReductionPrices);
    }


    //This method is to product Supplier
    private void processToUpdateSupplier(Product productFromDbTracking,
                                         List<SupplierDTO> supplierDTOS) {

        checkIfHaveMoreThatOneSupplier(supplierDTOS);

        List<Supplier> suppliers = new ArrayList<>();
        if(supplierDTOS != null){
            supplierDTOS.forEach(supplierDTO -> {
                Supplier supplier;
                if(supplierDTO.getSupplierId()!= null){
                    supplier = supplierRepository.findById(supplierDTO.getSupplierId())
                            .orElseThrow(() -> new NotFoundException("Supplier does not exist"));

                    supplier.addProduct(productFromDbTracking);
                    suppliers.add(supplier);
                }
            });
        }
        productFromDbTracking.getSuppliers().clear();
        productFromDbTracking.setSuppliers(suppliers);
    }


    private void checkIfHaveMoreThatOneSupplier(List<SupplierDTO> supplierDTOS){
        if(supplierDTOS == null)
            return;

        Set<Long> suppliersId = new HashSet<>();
        supplierDTOS.forEach(supplierDTO -> {
            if(suppliersId.contains(supplierDTO.getSupplierId()))
                throw new BadRequestException("Must not have more that one supplier");
            suppliersId.add(supplierDTO.getSupplierId());
        });
    }

    //This method is to update productSata
    private void processToUpdateProductState(Product productFromDbTracking, ProductDTO productDTO){
        if(productDTO.getState() == ProductState.DISCONTINUED){

         if(productDTO.getProductCause() == null)
             throw new BusinessException("Product must to have a cause to discontinued it  ");
         ProductCause productCause = HibernateDTOAssemblerFactory.DEFAULT.getProductCauseAssembler().dto2Pojo(productDTO.getProductCause());
         productCause.setProduct(productFromDbTracking);
         productFromDbTracking.setProductCause(productCause);
         return;
        }
        productFromDbTracking.setState(productDTO.getState());
        //TODO in this step we have to remove products cause
    }


    @Override
    public ProductDTO getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return HibernateDTOAssemblerFactory.DEFAULT.getProductAssembler().pojo2Dto(product,
                new ProductConf(true));
    }

    @Override
    public List<ProductDTO> getAll(ProductQueryFilter productQueryFilter) {
        List<Product> products;
        if(productQueryFilter.getProductState() != null){
            products = productRepository.findAllProductByState(productQueryFilter.getProductState().ordinal());
        }
        else
            products = productRepository.findAll();
        return products.stream().map(product ->
             HibernateDTOAssemblerFactory.DEFAULT.getProductAssembler().pojo2Dto(product,
                     new ProductConf(true))
        ).collect(Collectors.toList());
    }
}
