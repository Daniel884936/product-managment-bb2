package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.dtos.CountryDTO;
import com.productmanagment.productmanagment.models.Country;
import com.productmanagment.productmanagment.repositories.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CountryDTO> getAll() {
        List<Country> countries = countryRepository.findAll();
        List<CountryDTO> countryDTOS = countries.stream().map(country -> modelMapper.map(country, CountryDTO.class)).collect(Collectors.toList());
        return countryDTOS;
    }
}
