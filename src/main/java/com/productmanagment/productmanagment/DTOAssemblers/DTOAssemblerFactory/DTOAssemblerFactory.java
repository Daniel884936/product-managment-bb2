package com.productmanagment.productmanagment.DTOAssemblers.DTOAssemblerFactory;
import com.productmanagment.productmanagment.DTOAssemblers.countryAssembler.CountryAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.productAssembler.ProductAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.productCauseAssembler.ProductCauseAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.productReductionPriceAssembler.ProductReductionPriceAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.supplierAssembler.SupplierAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.userAssemblerFactory.UserAssembler;
import com.productmanagment.productmanagment.DTOAssemblers.userLoginAssembler.UserLoginAssembler;


public abstract class DTOAssemblerFactory {


    public static final DTOAssemblerFactory HIBERNATE = new HibernateDTOAssemblerFactory();
    public static final DTOAssemblerFactory DEFAULT = HIBERNATE;

    public abstract ProductAssembler getProductAssembler();
    public  abstract SupplierAssembler getSupplierAssembler();
    public  abstract ProductReductionPriceAssembler getProductReductionPriceAssembler();
    public  abstract ProductCauseAssembler getProductCauseAssembler();
    public  abstract CountryAssembler getCountryAssembler();
    public  abstract UserAssembler getUserAssembler();
    public abstract UserLoginAssembler getUserLoginAssembler();
}
