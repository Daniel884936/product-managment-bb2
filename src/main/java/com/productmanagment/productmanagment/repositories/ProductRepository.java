package com.productmanagment.productmanagment.repositories;

import com.productmanagment.productmanagment.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Product Repository.
 *
 * @author Erick Tejada
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from Product p where p.code =?1 or p.product_id =?2", nativeQuery = true)
    public Product findProductByCodeOrId( Long code, Long id);

    @Query(value= "select * from Product p where p.code = ?1", nativeQuery = true)
    public Product findProductByCode( Long code);

    @Query(value= "select * from Product p where p.state =?1", nativeQuery = true)
    public List<Product> findAllProductByState(int productState);
}
