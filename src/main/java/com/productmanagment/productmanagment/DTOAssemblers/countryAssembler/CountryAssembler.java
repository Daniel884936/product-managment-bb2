package com.productmanagment.productmanagment.DTOAssemblers.countryAssembler;

import com.productmanagment.productmanagment.dtos.CountryDTO;
import com.productmanagment.productmanagment.models.Country;

public interface CountryAssembler {
    public Country dto2Pojo(CountryDTO countryDTO);
    public  CountryDTO pojo2Dto(Country country);
}
