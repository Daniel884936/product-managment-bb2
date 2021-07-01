package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.dtos.SupplierDTO;

import java.util.List;

public interface SupplierService {
    public void add(SupplierDTO supplierDTO);
    public SupplierDTO getById(Long id);
    public List<SupplierDTO> getAll();
}
