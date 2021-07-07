package com.productmanagment.productmanagment.controllers;

import com.productmanagment.productmanagment.apiresponses.ApiResponse;
import com.productmanagment.productmanagment.dtos.CountryDTO;
import com.productmanagment.productmanagment.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity getAll(){
        List<CountryDTO> countryDTOS = countryService.getAll() ;
        return ResponseEntity.ok(new ApiResponse<>(countryDTOS));
    }
}
