package com.productmanagment.productmanagment.dtos;

import javax.validation.constraints.NotNull;

public class ProductCauseDTO {

    private Long productCauseId;

    @NotNull
    private String description;

    @NotNull
    private Long productId;

    public Long getProductCauseId() {
        return productCauseId;
    }

    public String getDescription() {
        return description;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductCauseId(Long productCauseId) {
        this.productCauseId = productCauseId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
