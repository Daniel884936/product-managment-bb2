package com.productmanagment.productmanagment.DTOAssemblers.productReductionPriceAssembler;

import com.productmanagment.productmanagment.dtos.ProductReductionPriceDTO;
import com.productmanagment.productmanagment.models.ProductReductionPrice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductReductionPriceAssemblerHibernate implements  ProductReductionPriceAssembler{

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProductReductionPriceDTO pojo2Dto(ProductReductionPrice productReductionPrice) {
        return null;
    }

    @Override
    public ProductReductionPrice dtoToPojo(ProductReductionPriceDTO productReductionPriceDTO) {
        return null;
    }
}
