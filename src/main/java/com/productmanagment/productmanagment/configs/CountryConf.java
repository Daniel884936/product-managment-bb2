package com.productmanagment.productmanagment.configs;

public class CountryConf {
    private CollectionConf<SupplierConf> supplierConfCollectionConf;

    public CountryConf() {
        supplierConfCollectionConf = null;
    }

    public CountryConf(boolean complete) {
        if(complete){
            supplierConfCollectionConf = new CollectionConf<>();
        }
    }
}
