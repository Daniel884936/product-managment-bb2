package com.productmanagment.productmanagment.DTOAssemblers.productAssembler;

import com.productmanagment.productmanagment.DTOAssemblers.GenericDTOAssembler;
import com.productmanagment.productmanagment.configs.ProductConf;
import com.productmanagment.productmanagment.dtos.ProductDTO;
import com.productmanagment.productmanagment.models.Product;

public interface ProductAssembler extends GenericDTOAssembler<Product, ProductDTO, ProductConf> {
}
