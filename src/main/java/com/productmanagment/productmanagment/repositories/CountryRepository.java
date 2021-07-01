package com.productmanagment.productmanagment.repositories;

import com.productmanagment.productmanagment.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
