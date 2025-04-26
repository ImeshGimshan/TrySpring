package org.cyklon.tryoutspringboot.Service;

import org.cyklon.tryoutspringboot.DTO.SupplierDTO;
import org.cyklon.tryoutspringboot.Mapper.SupplierMapper;
import org.cyklon.tryoutspringboot.Model.Supplier;
import org.cyklon.tryoutspringboot.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService{
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    public List<SupplierDTO> getAllSuppliers(){
        return supplierRepository.findAll()
                .stream().map(supplierMapper::toDto)
                .collect(Collectors.toList());
    }

    public SupplierDTO createSupplier(SupplierDTO supplierDTO){
        return supplierMapper.toDto(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

    public SupplierDTO getSupplierById(Long id){
        return supplierMapper.toDto(supplierRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Supplier not found")));
    }

    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO){
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Supplier not found"));
        supplier.setName(supplierDTO.getName());
        supplier.setContact(supplierDTO.getContact());
        return supplierMapper.toDto(supplierRepository.save(supplier));
    }

    public void deleteSupplier(Long id){
        supplierRepository.deleteById(id);
    }
}