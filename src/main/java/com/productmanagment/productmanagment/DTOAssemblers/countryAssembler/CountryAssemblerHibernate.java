package com.productmanagment.productmanagment.DTOAssemblers.countryAssembler;

import com.productmanagment.productmanagment.dtos.CountryDTO;
import com.productmanagment.productmanagment.models.Country;
import org.springframework.beans.BeanUtils;

public class CountryAssemblerHibernate implements CountryAssembler{

    @Override
    public Country dto2Pojo(CountryDTO countryDTO) {

        if(countryDTO == null) return  null;
        Country result = new Country();

        BeanUtils.copyProperties(countryDTO, result);

        if(result.getCountryId()!= null && result.getCountryId() == 0){
            result.setCountryId(null);
        }
        return result;
    }

    @Override
    public CountryDTO pojo2Dto(Country country) {
        if(country == null) return null;

        CountryDTO result = new CountryDTO();
        BeanUtils.copyProperties(country, result);

        if(country.getCountryId()!= null && country.getCountryId() == 0){
            result.setCountryId(null);
        }
        return result;
    }
}
