package com.productmanagment.productmanagment.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


@Entity(name = "product")
public class Product {

    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Min(0)
    private Double Price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ProductReductionPrice> productReductionPrices;

    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "supplier_product",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "supplier_id") }
    )
    private List<Supplier> suppliers;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private ProductState state;

    //@OneToOne(mappedBy = "product")
    @OneToOne(mappedBy = "product", cascade = {CascadeType.ALL}, orphanRemoval=true)
    private ProductCause productCause;

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

    public List<ProductReductionPrice> getProductReductionPrices() {
        return productReductionPrices;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setProductReductionPrices(List<ProductReductionPrice> productReductionPrices) {
        this.productReductionPrices = productReductionPrices;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }


    public void addProductReductionPrice(ProductReductionPrice productReductionPrice){
        if(productReductionPrices == null){
            productReductionPrices = new ArrayList<>();
        }
        productReductionPrice.setProduct(this);
        productReductionPrices.add(productReductionPrice);
    }

    public void addSupplier(Supplier supplier){
        if(suppliers == null){
            suppliers = new ArrayList<>();
        }
        if(supplier.getProducts() == null){
            supplier.setProducts(new HashSet<>());
        }
        supplier.getProducts().add(this);
        suppliers.add(supplier);
    }

    public ProductCause getProductCause() {
        return productCause;
    }

    public void setProductCause(ProductCause productCause) {
        this.productCause = productCause;
        this.productCause.setProduct(this);
    }
}
