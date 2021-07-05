package com.productmanagment.productmanagment.repositories;

import com.productmanagment.productmanagment.models.ProductReductionPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReductionPriceRepository extends JpaRepository<ProductReductionPrice, Long> {
}
