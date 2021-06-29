package com.productmanagment.productmanagment.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Table(name = "product_reduction_price")
public class ProductReductionPrice {
    @Id
    @GeneratedValue
    @Column(name = "productreductionprice_id")
    private Long productReductionPriceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Product product;

    @NonNull
    @Column(name = "start_date")
    private Date startDate;

    @NonNull
    @Column(name = "end_date")
    private Date endDate;

    @NonNull
    @Column(name = "reduced_price")
    private Double ReducedPrice;

    public void setReducedPrice( Double reducedPrice) {
        ReducedPrice = reducedPrice;
    }

    public Double getReducedPrice() {
        return ReducedPrice;
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
