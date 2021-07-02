package com.productmanagment.productmanagment.configs;

public class UserConf {
    private CollectionConf<ProductConf> productConfCollectionConf;

    public UserConf() {
        productConfCollectionConf = null;
    }

    public UserConf(boolean complete) {
        if(complete){
            productConfCollectionConf = new CollectionConf<>();
        }
    }
}
