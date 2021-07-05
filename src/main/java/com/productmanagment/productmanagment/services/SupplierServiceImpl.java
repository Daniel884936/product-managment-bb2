package com.productmanagment.productmanagment.services;


import com.productmanagment.productmanagment.DTOAssemblers.DTOAssemblerFactory.HibernateDTOAssemblerFactory;
import com.productmanagment.productmanagment.configs.SupplierConf;
import com.productmanagment.productmanagment.dtos.SupplierDTO;
import com.productmanagment.productmanagment.exception.BadRequestException;
import com.productmanagment.productmanagment.exception.NotFoundException;
import com.productmanagment.productmanagment.models.Country;
import com.productmanagment.productmanagment.models.Supplier;
import com.productmanagment.productmanagment.repositories.CountryRepository;
import com.productmanagment.productmanagment.repositories.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void add(SupplierDTO supplierDTO) {
        Supplier supplier = HibernateDTOAssemblerFactory.DEFAULT.getSupplierAssembler().Dto2Pojo(supplierDTO);
        if(supplierDTO.getCountryId() == null)
            throw new BadRequestException("Must have a countryId");
        Country countryFromDb = countryRepository.findById(supplierDTO.getCountryId())
                .orElseThrow(()-> new NotFoundException("Country does not exist"));
        supplier.setCountry(countryFromDb);
        supplierDTO.setSupplierId(supplier.getSupplierId());
    }

    @Override
    public SupplierDTO getById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(()->
                new NotFoundException("Supplier not found"));
        return HibernateDTOAssemblerFactory.DEFAULT.getSupplierAssembler().pojo2Dto(supplier,new SupplierConf(true));
    }

    @Override
    public List<SupplierDTO> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream().map(supplier->
                HibernateDTOAssemblerFactory.DEFAULT.getSupplierAssembler().pojo2Dto(supplier,new SupplierConf(true)))
                .collect(Collectors.toList());
    }
}
