package com.productmanagment.productmanagment.repositories;

import com.productmanagment.productmanagment.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * The interface Product Repository.
 *
 * @author Erick Tejada
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from Product p where p.code = :code or p.product_id = :id", nativeQuery = true)
    public Product findProductByCodeOrId(@Param("code") Long code, @Param("id") Long id);

    @Query(value= "select * from Product p where p.code = :code", nativeQuery = true)
    public Product findProductByCode(@Param("code") Long code);
}
