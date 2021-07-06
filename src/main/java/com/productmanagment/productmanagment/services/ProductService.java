package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.dtos.ProductDTO;
import com.productmanagment.productmanagment.queryFilters.ProductQueryFilter;

import java.util.List;

public interface ProductService  {

    public void add(ProductDTO productDTO);

    public void update(ProductDTO productDTO);

    public ProductDTO getById(Long id);

    public List<ProductDTO> getAll(ProductQueryFilter productQueryFilter);
}
