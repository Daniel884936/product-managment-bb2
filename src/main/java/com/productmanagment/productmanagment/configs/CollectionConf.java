package com.productmanagment.productmanagment.configs;

import java.io.Serializable;

public class CollectionConf <TConf>  implements Serializable {

    private TConf itemConf;

    public CollectionConf() {
        this(null);
    }

    public CollectionConf(TConf itemConf) {
        this.itemConf = itemConf;
    }

    public TConf getConf() {
        return itemConf;
    }

    public void setConf(TConf itemConf) {
        this.itemConf = itemConf;
    }
}
