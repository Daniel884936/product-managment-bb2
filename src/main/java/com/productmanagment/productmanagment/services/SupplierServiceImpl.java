package com.productmanagment.productmanagment.services;


import com.productmanagment.productmanagment.dtos.SupplierDTO;
import com.productmanagment.productmanagment.models.Supplier;
import com.productmanagment.productmanagment.repositories.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void add(SupplierDTO supplierDTO) {
        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
        supplierRepository.save(supplier);
    }

    @Override
    public SupplierDTO getById(Long id) {
        Supplier supplier = supplierRepository.getById(id);
        SupplierDTO supplierDTO = modelMapper.map(supplier, SupplierDTO.class);
        return supplierDTO;
    }

    @Override
    public List<SupplierDTO> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDTO> supplierDTOS = suppliers.stream().map(supplier-> modelMapper.map(supplier, SupplierDTO.class)).collect(Collectors.toList());
        return supplierDTOS;
    }
}
