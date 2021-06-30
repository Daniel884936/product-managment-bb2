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

    @Query("select p from product p where p.code = :code or p.product_id = :id")
    public Product findProductByCodeOrId(@Param("id") Long id,@Param("code") Long code);

    @Query("select p from product p where p.code = :code")
    public Product findProductByCode(@Param("code") Long code);
}
