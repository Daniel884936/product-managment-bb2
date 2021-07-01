package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private List<ProductReductionPriceDTO> productReductionPrices;

    @JsonProperty(value = "supplier")
    private List<SupplierDTO> suppliers;

    @JsonProperty(value = "productState")
    @Enumerated(EnumType.STRING)
    private ProductState state;

    @NotNull
    private  Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public List<ProductReductionPriceDTO> getProductReductionPrices() {
        return productReductionPrices;
    }

    public List<SupplierDTO> getSuppliers() {
        return suppliers;
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

    public void setProductReductionPrices(List<ProductReductionPriceDTO> productReductionPrices) {
        this.productReductionPrices = productReductionPrices;
    }

    public void setSuppliers(List<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public void setState(ProductState state) {
        this.state = state;
    }

    public ProductDTO() {


    }
}
