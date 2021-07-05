package com.productmanagment.productmanagment.repositories;

import com.productmanagment.productmanagment.models.ProductCause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCauseRepository extends JpaRepository<ProductCause, Long> {
}
