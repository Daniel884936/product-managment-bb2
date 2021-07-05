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
import com.productmanagment.productmanagment.repositories.CountryRepository;
import com.productmanagment.productmanagment.repositories.ProductRepository;
import com.productmanagment.productmanagment.repositories.SupplierRepository;
import com.productmanagment.productmanagment.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
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

    private final  String PRODUCT_DOES_NOT_EXIST  = "PRODUCT DOES NOT EXIST";
    private final  String PRODUCT_EXIST  = "PRODUCT ALREADY EXIST";
    private  final  String USER_DOES_NOT_EXIST = "USER DOES NOT EXIST";
    private  final String CAN_NOT_CHANGE_PRODUCT_CODE = "CAN NOT CHANGE PRODUCT CODE";
    private  final String PRODUCT_PRICE_CAN_NOT_BE_LESS_THAN_ZERO = "PRODUCT PRICE CAN NOT BE LESS THA  ZERO";
    private final  String TOTAL_PRODUCT_REDUCED_PRICE_CAN_NOT_BE_LESS_THAN_ZERO = "TOTAL PRODUCT REDUCED PRICE CAN NOT BE LESS THAN ZERO";

    //TODO COMPLETE THIS METHOD

    //TODO Refactor this class---------------------------------------------------------------------------------------------------
    @Override
    public void add(ProductDTO productDTO) {
        productDTO.setProductId(null);
        productDTO.setState(ProductState.ACTIVE);

        checkProductDTOPrice(productDTO.getPrice());
        Product productFromDb = productRepository.findProductByCode(productDTO.getCode());

       if(productFromDb!=null){
            throw new ConflictException(PRODUCT_EXIST);
        }
        Product product = HibernateDTOAssemblerFactory.DEFAULT.getProductAssembler().Dto2Pojo(productDTO);
        checkTotalProductsReducePrice(product);

        //set supplier and country to supplier

        List<SupplierDTO> supplierDTOS = productDTO.getSuppliers();

        if(supplierDTOS !=null){
            for (int i = 0; i < supplierDTOS.size(); i++) {

                if(supplierDTOS.get(i).getSupplierId() == null)
                    throw  new BadRequestException("product must to have a supplierId");

                    //track supplier if have id to reference current supplierFromDb
                    Supplier supplierReference = product.getSuppliers().get(i);
                    Supplier supplierFromDb = supplierRepository.findById(supplierDTOS.get(i).getSupplierId())
                            .orElseThrow(() -> new NotFoundException("Supplier not found"));
                    product.getSuppliers().remove(supplierReference);
                    product.getSuppliers().add(supplierFromDb);

                if(supplierDTOS.get(i).getCountryId() == null)
                    throw  new BadRequestException("supplier must have a countryId");

                    Country country = countryRepository.findById(supplierDTOS.get(i).getCountryId())
                            .orElseThrow(() ->
                                    new NotFoundException("Country not found"));
                    product.getSuppliers().get(i).setCountry(country);
            }
        }
        User creator = userRepository.getById(productDTO.getUserId());
        checkCreatorProduct(creator);
        product.setCreationDate(new Date());
        product.setCreator(creator);
        productRepository.save(product);
        productDTO.setProductId(product.getProductId());
    }


    //TODO COMPLETE THIS METHOD
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
        updateProduct(productFromDbTracking, product);
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


    private void updateProduct(Product productFromDbTracking, Product productDestination){
        productFromDbTracking.setPrice(productDestination.getPrice());
        productFromDbTracking.setName(productDestination.getName());
        productFromDbTracking.setState(productDestination.getState());
        productFromDbTracking.setDescription(productDestination.getDescription());

        //TODO -----------------------------------------------
        productFromDbTracking.setSuppliers(productDestination.getSuppliers());
        productFromDbTracking.setProductReductionPrices(productDestination.getProductReductionPrices());
    }

    @Override
    public ProductDTO getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return HibernateDTOAssemblerFactory.DEFAULT.getProductAssembler().pojo2Dto(product,
                new ProductConf(true));
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();

        //convert all product to productDto

        return products.stream().map(product ->
             HibernateDTOAssemblerFactory.DEFAULT.getProductAssembler().pojo2Dto(product,
                     new ProductConf(true))
        ).collect(Collectors.toList());
    }
}
