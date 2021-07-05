package com.productmanagment.productmanagment.DTOAssemblers.productReductionPriceAssembler;

import com.productmanagment.productmanagment.dtos.ProductReductionPriceDTO;
import com.productmanagment.productmanagment.models.ProductReductionPrice;
import org.modelmapper.ModelMapper;


public class ProductReductionPriceAssemblerHibernate implements  ProductReductionPriceAssembler{

    private final ModelMapper modelMapper;

    public ProductReductionPriceAssemblerHibernate(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductReductionPrice dtoToPojo(ProductReductionPriceDTO productReductionPriceDTO) {
        if(productReductionPriceDTO == null){
            return  null;
        }
        return modelMapper.map(productReductionPriceDTO, ProductReductionPrice.class);
    }

    @Override
    public ProductReductionPriceDTO pojo2Dto(ProductReductionPrice productReductionPrice) {
        if(productReductionPrice == null){
            return  null;
        }
        ProductReductionPriceDTO result = modelMapper.map(productReductionPrice, ProductReductionPriceDTO.class);
        if(productReductionPrice.getProduct() != null){
            if(productReductionPrice.getProduct().getProductId() != null){
                result.setProductId(productReductionPrice.getProduct().getProductId());
            }
        }
        return result;
    }
}
