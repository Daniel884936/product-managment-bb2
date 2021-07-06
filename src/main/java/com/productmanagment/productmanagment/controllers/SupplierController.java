package com.productmanagment.productmanagment.controllers;

import com.productmanagment.productmanagment.apiresponses.ApiResponse;
import com.productmanagment.productmanagment.dtos.SupplierDTO;
import com.productmanagment.productmanagment.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity getAll(){
        List<SupplierDTO> supplierDTOS = supplierService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(supplierDTOS));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        SupplierDTO supplierDTO = supplierService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(supplierDTO));
    }

    @PostMapping
    public ResponseEntity post(@Valid @RequestBody SupplierDTO supplierDTO){
        supplierService.add(supplierDTO);
        return ResponseEntity.ok(new ApiResponse<>(supplierDTO));
    }
}
