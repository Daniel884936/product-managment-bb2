package com.productmanagment.productmanagment.DTOAssemblers.DTOAssemblerFactory;

import com.productmanagment.productmanagment.DTOAssemblers.productAssembler.ProductAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.productReductionPriceAssembler.ProductReductionPriceAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.supplierAssembler.SupplierAssembler;
import org.modelmapper.ModelMapper;


public abstract class DTOAssemblerFactory {


    public static final DTOAssemblerFactory HIBERNATE = new HibernateDTOAssemblerFactory(new ModelMapper());
    public static final DTOAssemblerFactory DEFAULT = HIBERNATE;

    public abstract ProductAssembler getProductAssembler();
    public  abstract SupplierAssembler getSupplierAssembler();
    public  abstract ProductReductionPriceAssembler getProductReductionPriceAssembler();

}