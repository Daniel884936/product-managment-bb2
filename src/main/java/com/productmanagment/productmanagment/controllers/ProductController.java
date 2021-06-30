package com.productmanagment.productmanagment.controllers;

import com.productmanagment.productmanagment.dtos.ProductDTO;
import com.productmanagment.productmanagment.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity getAll(){
        List<ProductDTO> productDTOS = productService.getAll();
        return ResponseEntity.ok(productDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(Long id){
        ProductDTO productDTO = productService.getById(id);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ProductDTO productDTO){
        productService.add(productDTO);
        return ResponseEntity.ok(productDTO);
    }


    @PutMapping
    public ResponseEntity update(@RequestBody ProductDTO productDTO){
        productService.update(productDTO);
        return ResponseEntity.ok(productDTO);
    }
}