package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.SupplierDTO;
import org.cyklon.tryoutspringboot.Model.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public Supplier toEntity(SupplierDTO dto){
        Supplier supplier = new Supplier();
        supplier.setId(dto.getId());
        supplier.setName(dto.getName());
        supplier.setContact(dto.getContact());
        supplier.setAddress(dto.getAddress());
        return supplier;
    }

    public SupplierDTO toDto(Supplier entity){
        SupplierDTO dto = new SupplierDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setContact(entity.getContact());
        dto.setAddress(entity.getAddress());
        return dto;
    }
}
