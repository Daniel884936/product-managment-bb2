package com.productmanagment.productmanagment.DTOAssemblers.supplierAssembler;

import com.productmanagment.productmanagment.configs.SupplierConf;
import com.productmanagment.productmanagment.dtos.SupplierDTO;
import com.productmanagment.productmanagment.models.Supplier;
import org.modelmapper.ModelMapper;



public class SupplierDTOAssemblerHibernate implements SupplierAssembler {

    private final ModelMapper modelMapper;

    public SupplierDTOAssemblerHibernate(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Supplier Dto2Pojo(SupplierDTO supplierDTO) {
        if(supplierDTO == null){
            return  null;
        }
        Supplier result = modelMapper.map(supplierDTO , Supplier.class);
        return result;
    }

    @Override
    public SupplierDTO pojo2Dto(Supplier supplier, SupplierConf supplierConf) {
        if(supplier == null){
            return  null;
        }

        SupplierDTO result = modelMapper.map(supplier, SupplierDTO.class);

        if(supplier.getCountry() != null){
            if(supplier.getCountry().getCountryId() != null){
                result.setCountryId(supplier.getCountry().getCountryId());
            }
        }
        return result;
    }

}
