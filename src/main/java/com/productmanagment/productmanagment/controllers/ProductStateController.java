package com.productmanagment.productmanagment.controllers;

import com.productmanagment.productmanagment.apiresponses.ApiResponse;
import com.productmanagment.productmanagment.models.ProductState;
import com.productmanagment.productmanagment.services.ProductStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/productsSate")
@RestController
public class ProductStateController {

    @Autowired
    ProductStateService productStateService;

    @GetMapping
    public ResponseEntity getAll(){
        List<ProductState> productStates = productStateService.getAll();
        return  ResponseEntity.ok(new ApiResponse<>(productStates));
    }
}
