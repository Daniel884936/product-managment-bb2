package com.productmanagment.productmanagment.DTOAssemblers.supplierAssembler;

import com.productmanagment.productmanagment.configs.SupplierConf;
import com.productmanagment.productmanagment.dtos.SupplierDTO;
import com.productmanagment.productmanagment.models.Supplier;
import org.springframework.beans.BeanUtils;


public class SupplierDTOAssemblerHibernate implements SupplierAssembler {

    @Override
    public Supplier Dto2Pojo(SupplierDTO supplierDTO) {
        if(supplierDTO == null){
            return  null;
        }
        Supplier result = new Supplier();
        BeanUtils.copyProperties(supplierDTO, result);
        if(result.getSupplierId()!= null && result.getSupplierId() == 0){
            result.setSupplierId(null);
        }

        return result;
    }

    @Override
    public SupplierDTO pojo2Dto(Supplier supplier, SupplierConf supplierConf) {
        if(supplier == null){
            return  null;
        }

        SupplierDTO result = new SupplierDTO();
        BeanUtils.copyProperties(supplier, result);
        if(result.getSupplierId()!= null && result.getSupplierId()== 0){
            result.setSupplierId(null);
        }

        if(supplier.getCountry() != null){
            if(supplier.getCountry().getCountryId() != null){
                result.setCountryId(supplier.getCountry().getCountryId());
            }
        }
        return result;
    }

}
