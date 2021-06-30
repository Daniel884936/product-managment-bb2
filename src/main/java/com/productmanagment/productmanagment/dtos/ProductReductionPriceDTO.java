package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import java.util.Date;

public class ProductReductionPriceDTO {

    @JsonProperty(value = "id")
    private Long productReductionPriceId;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private Double ReducedPrice;

    @JsonIgnore
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
