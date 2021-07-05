package com.productmanagment.productmanagment.DTOAssemblers.productCauseAssembler;

import com.productmanagment.productmanagment.dtos.ProductCauseDTO;
import com.productmanagment.productmanagment.models.ProductCause;
import org.springframework.beans.BeanUtils;

public class ProductCauseAssemblerHibernate implements ProductCauseAssembler{

    @Override
    public ProductCauseDTO pojo2Dto(ProductCause productCause) {
        if(productCause == null) return  null;
        ProductCauseDTO result = new ProductCauseDTO();

        BeanUtils.copyProperties(productCause, result);

        if(result.getProductCauseId()!= null && result.getProductCauseId() == 0){
            result.setProductId(null);
        }
        result.setProductId(productCause.getProduct().getProductId());
        return result;
    }


    @Override
    public ProductCause dto2Pojo(ProductCauseDTO productCauseDTO) {
        if(productCauseDTO == null) return  null;

        ProductCause result = new ProductCause();
        BeanUtils.copyProperties(productCauseDTO, result);
        if(result.getProductCauseId() != null && result.getProductCauseId() == 1 ){
            result.setProductCauseId(null);
        }
        return  result;
    }
}
