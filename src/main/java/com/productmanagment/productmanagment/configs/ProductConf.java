package com.productmanagment.productmanagment.configs;

public class ProductConf {
    CollectionConf<SupplierConf> suppliersConf;

    public ProductConf() {
        suppliersConf = null;
    }

    public CollectionConf<SupplierConf> getSuppliersConf() {
        return suppliersConf;
    }

    public ProductConf(boolean complete) {
       if(complete){
           suppliersConf = new CollectionConf<>();
       }
    }

}
