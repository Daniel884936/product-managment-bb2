package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductReductionPriceDTO {

    private Long productReductionPriceId;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private Double reducedPrice;

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
        return reducedPrice;
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
        this.reducedPrice = reducedPrice;
    }
}
