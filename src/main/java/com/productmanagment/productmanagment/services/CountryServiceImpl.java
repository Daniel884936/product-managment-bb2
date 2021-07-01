package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.dtos.CountryDTO;
import com.productmanagment.productmanagment.models.Country;
import com.productmanagment.productmanagment.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    //TODO implement this

    @Override
    public List<CountryDTO> getAll() {

        List<Country> countries = countryRepository.findAll();

        return null;
    }
}
