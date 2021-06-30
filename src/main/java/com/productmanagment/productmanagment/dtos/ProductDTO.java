package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.productmanagment.productmanagment.dtos.ProductReductionPriceDTO;
import com.productmanagment.productmanagment.dtos.SupplierDTO;
import com.productmanagment.productmanagment.models.ProductState;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

public class ProductDTO {

    @JsonProperty(value = "id")
    private Long productId;

    private Long code;
    @NotNull
    private String name;

    private String description;
    @NotNull
    private Date creationDate;
    @NotNull

    private Double Price;

    @JsonProperty(value = "ProductReductionPrice")
    private List<ProductReductionPriceDTO> productReductionPriceDTOS;

    @JsonProperty(value = "supplier")
    private List<SupplierDTO> supplierDTOS;

    @JsonProperty(value = "productState")
    @Enumerated(EnumType.STRING)
    private ProductState state;

    public Long getProductId() {
        return productId;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Double getPrice() {
        return Price;
    }

    public List<ProductReductionPriceDTO> getProductReductionPriceDTOS() {
        return productReductionPriceDTOS;
    }

    public List<SupplierDTO> getSupplierDTOS() {
        return supplierDTOS;
    }

    public ProductState getState() {
        return state;
    }

    @JsonIgnore
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName( String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public void setCreationDate( Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setPrice( Double price) {
        Price = price;
    }

    public void setProductReductionPriceDTOS(List<ProductReductionPriceDTO> productReductionPriceDTOS) {
        this.productReductionPriceDTOS = productReductionPriceDTOS;
    }

    public void setSupplierDTOS(List<SupplierDTO> supplierDTOS) {
        this.supplierDTOS = supplierDTOS;
    }

    public void setState(ProductState state) {
        this.state = state;
    }

    public ProductDTO() {


    }
}
