package com.productmanagment.productmanagment.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "product_reduction_price")
public class ProductReductionPrice implements Serializable {

    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_reduction_price_id")
    private Long productReductionPriceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    @NotNull
    @Column(name = "reduced_price")
    private Double reducedPrice;

    public void setReducedPrice( Double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public Double getReducedPrice() {
        return reducedPrice;
    }

    public Long getProductReductionPriceId() {
        return productReductionPriceId;
    }

    public Product getProduct() {
        return product;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setProductReductionPriceId(Long productReductionPriceId) {
        this.productReductionPriceId = productReductionPriceId;
    }

    public void setProduct( Product product) {
        this.product = product;
    }

    public void setStartDate( Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate( Date endDate) {
        this.endDate = endDate;
    }
}
