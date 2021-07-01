package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.dtos.ProductDTO;
import com.productmanagment.productmanagment.exception.BadRequestException;
import com.productmanagment.productmanagment.models.Product;
import com.productmanagment.productmanagment.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final  String PRODUCT_DOES_NOT_EXIST  = "PRODUCT DOES NOT EXIST";
    private final  String PRODUCT_EXIST  = "PRODUCT ALREADY EXIST";

    //TODO validate product reduction price and product price
    @Override
    public void add(ProductDTO productDTO) {

        Product productFromDb = productRepository.findProductByCode(productDTO.getCode());
        if(productFromDb!=null){
            throw new BadRequestException(PRODUCT_EXIST);
        }
        Product product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);
    }

    //TODO validate product reduction price and product price
    @Override
    public void update(ProductDTO productDTO) {
        Product productFromDb = productRepository.findProductByCodeOrId( productDTO.getCode(), productDTO.getProductId());
        if(productFromDb==null){
            throw new BadRequestException(PRODUCT_DOES_NOT_EXIST);
        }
        Product product = modelMapper.map(productDTO, Product.class);
    }

    @Override
    public ProductDTO getById(Long id) {
        Product product = productRepository.getById(id);
        ProductDTO productDTO = modelMapper.map(product,ProductDTO.class);
        return productDTO;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(product ->
                                        modelMapper.map(product,ProductDTO.class)).collect(Collectors.toList());
        return productDTOS;
    }
}
