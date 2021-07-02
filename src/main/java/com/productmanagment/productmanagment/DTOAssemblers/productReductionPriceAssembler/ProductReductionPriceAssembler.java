package com.productmanagment.productmanagment.DTOAssemblers.productReductionPriceAssembler;

import com.productmanagment.productmanagment.dtos.ProductReductionPriceDTO;
import com.productmanagment.productmanagment.models.ProductReductionPrice;

public interface ProductReductionPriceAssembler {
    public ProductReductionPriceDTO pojo2Dto(ProductReductionPrice productReductionPrice);
    public  ProductReductionPrice dtoToPojo(ProductReductionPriceDTO productReductionPriceDTO);
}
