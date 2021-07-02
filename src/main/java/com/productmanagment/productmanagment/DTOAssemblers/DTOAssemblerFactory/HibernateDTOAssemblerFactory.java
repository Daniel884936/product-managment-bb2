package com.productmanagment.productmanagment.DTOAssemblers.DTOAssemblerFactory;

import com.productmanagment.productmanagment.DTOAssemblers.productAssembler.ProductAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.productAssembler.ProductAssemblerHibernate;
import com.productmanagment.productmanagment.DTOAssemblers.productReductionPriceAssembler.ProductReductionPriceAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.productReductionPriceAssembler.ProductReductionPriceAssemblerHibernate;
import com.productmanagment.productmanagment.DTOAssemblers.supplierAssembler.SupplierAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.supplierAssembler.SupplierDTOAssemblerHibernate;

public class HibernateDTOAssemblerFactory extends DTOAssemblerFactory {


    private ProductAssembler productAssembler;
    @Override
    public ProductAssembler getProductAssembler() {
        if (productAssembler== null){
            synchronized (this){
                if(productAssembler == null){
                    productAssembler = new ProductAssemblerHibernate();
                }
            }
        }
        return productAssembler;
    }

    private  SupplierAssembler supplierAssembler;
    @Override
    public SupplierAssembler getSupplierAssembler() {
        if(supplierAssembler== null){
            synchronized (this){
                if(supplierAssembler == null){
                    supplierAssembler = new SupplierDTOAssemblerHibernate();
                }
            }
        }
        return supplierAssembler;
    }

    private ProductReductionPriceAssembler productReductionPriceAssembler;
    @Override
    public ProductReductionPriceAssembler getProductReductionPriceAssembler() {
        if(productReductionPriceAssembler == null){
            synchronized (this){
                if(productReductionPriceAssembler == null){
                    productReductionPriceAssembler = new ProductReductionPriceAssemblerHibernate();
                }
            }
        }
        return productReductionPriceAssembler;
    }
}
