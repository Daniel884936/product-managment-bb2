package com.productmanagment.productmanagment.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ProductCause pojo.
 * this class is use when productState is Discontinued
 * after this case we must to add product cause description
 * @author Erick Tejada
 */
@Entity(name = "product_cause")
public class ProductCause implements Serializable {

    @Id
    @Column(name = "product_cause_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCauseId;

    @NotNull
    private String description;

    //@OneToOne(cascade = {CascadeType.ALL})
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;


    public Long getProductCauseId() {
        return productCauseId;
    }

    public String getDescription() {
        return description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProductCauseId(Long productCauseId) {
        this.productCauseId = productCauseId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
