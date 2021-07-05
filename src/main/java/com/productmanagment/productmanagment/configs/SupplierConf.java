package com.productmanagment.productmanagment.configs;

public class SupplierConf {

    private CollectionConf<ProductConf> productConfCollectionConf;

    public SupplierConf() {
        productConfCollectionConf = null;
    }

    public SupplierConf(boolean complete) {
        if(complete){
         productConfCollectionConf = new CollectionConf<>();
        }
    }

    public CollectionConf<ProductConf> getProductConfCollectionConf() {
        return productConfCollectionConf;
    }
}
