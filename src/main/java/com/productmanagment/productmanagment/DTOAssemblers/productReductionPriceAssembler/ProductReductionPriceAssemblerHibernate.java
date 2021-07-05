package com.productmanagment.productmanagment.DTOAssemblers.productReductionPriceAssembler;

import com.productmanagment.productmanagment.dtos.ProductReductionPriceDTO;
import com.productmanagment.productmanagment.models.ProductReductionPrice;
import org.springframework.beans.BeanUtils;


public class ProductReductionPriceAssemblerHibernate implements  ProductReductionPriceAssembler{


    @Override
    public ProductReductionPrice dtoToPojo(ProductReductionPriceDTO productReductionPriceDTO) {
        if(productReductionPriceDTO == null){
            return  null;
        }

        ProductReductionPrice result = new ProductReductionPrice();
        BeanUtils.copyProperties(productReductionPriceDTO, result);

        if(productReductionPriceDTO.getProductReductionPriceId() != null &&
                productReductionPriceDTO.getProductReductionPriceId() == 0){
            result.setProductReductionPriceId(null);
        }
        return result;
    }

    @Override
    public ProductReductionPriceDTO pojo2Dto(ProductReductionPrice productReductionPrice) {
        if(productReductionPrice == null){
            return  null;
        }
        ProductReductionPriceDTO result = new ProductReductionPriceDTO();
        BeanUtils.copyProperties(productReductionPrice, result);
        if(result.getProductId()!= null && productReductionPrice.getProductReductionPriceId()==0){
            result.setProductId(null);
        }
        if(productReductionPrice.getProduct() != null){
            if(productReductionPrice.getProduct().getProductId() != null){
                result.setProductId(productReductionPrice.getProduct().getProductId());
            }
        }
        return result;
    }
}
