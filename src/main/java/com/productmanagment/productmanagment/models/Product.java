package com.productmanagment.productmanagment.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long productId;

    @Column(unique = true)
    @NotNull
    private Long code;
    @NotNull
    private String name;

    private String description;
    @NotNull
    private Date creationDate;
    @NotNull
    private Double Price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;

    @OneToMany(mappedBy = "product_reduction_price", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<ProductReductionPrice> productReductionPrice;

    @ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
    private List<Supplier> suppliers;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private ProductState state;

    public void setState(ProductState state) {
        this.state = state;
    }

    public ProductState getState() {
        return state;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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

    public User getCreator() {
        return creator;
    }

    public Set<ProductReductionPrice> getProductReductionPrice() {
        return productReductionPrice;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setProductReductionPrice(Set<ProductReductionPrice> productReductionPrice) {
        this.productReductionPrice = productReductionPrice;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
