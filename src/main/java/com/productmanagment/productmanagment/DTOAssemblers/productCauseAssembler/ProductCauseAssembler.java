package com.productmanagment.productmanagment.DTOAssemblers.productCauseAssembler;

import com.productmanagment.productmanagment.dtos.ProductCauseDTO;
import com.productmanagment.productmanagment.models.ProductCause;

public interface ProductCauseAssembler  {

    public ProductCauseDTO pojo2Dto(ProductCause productCause);
    public  ProductCause dto2Pojo(ProductCauseDTO productCauseDTO);
}
