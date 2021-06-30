package com.productmanagment.productmanagment.DTOs;

import com.sun.istack.NotNull;
import java.util.Date;

public class ProductReductionPriceDTO {

    private Long productReductionPriceId;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private Double ReducedPrice;

    public Long getProductReductionPriceId() {
        return productReductionPriceId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Double getReducedPrice() {
        return ReducedPrice;
    }

    public void setProductReductionPriceId(Long productReductionPriceId) {
        this.productReductionPriceId = productReductionPriceId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate( Date endDate) {
        this.endDate = endDate;
    }

    public void setReducedPrice( Double reducedPrice) {
        ReducedPrice = reducedPrice;
    }
}
