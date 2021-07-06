package com.productmanagment.productmanagment.controllers;

import com.productmanagment.productmanagment.apiresponses.ApiResponse;
import com.productmanagment.productmanagment.dtos.ProductDTO;
import com.productmanagment.productmanagment.queryFilters.ProductQueryFilter;
import com.productmanagment.productmanagment.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity getAll(ProductQueryFilter productQueryFilter){
        List<ProductDTO> productDTOS = productService.getAll(productQueryFilter);
        return ResponseEntity.ok(new ApiResponse<>(productDTOS));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        ProductDTO productDTO = productService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(productDTO));
    }

    @PostMapping
    public ResponseEntity post(@Valid @RequestBody ProductDTO productDTO){
        productService.add(productDTO);
        return ResponseEntity.ok(new ApiResponse<>(productDTO));
    }


    @PutMapping
    public ResponseEntity update(@RequestBody ProductDTO productDTO){
        productService.update(productDTO);
        return ResponseEntity.ok(new ApiResponse<>(productDTO));
    }
}
