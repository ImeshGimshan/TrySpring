package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.GRNDTO;
import org.cyklon.tryoutspringboot.DTO.InOrderDTO;
import org.cyklon.tryoutspringboot.Model.GRN;
import org.cyklon.tryoutspringboot.Model.InOrder;
import org.cyklon.tryoutspringboot.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GRNMapper {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private InOrderMapper inOrderMapper;

    public GRN toEntity (GRNDTO dto){
        GRN grn = new GRN();
        grn.setId(dto.getId());
        grn.setReceivedDate(dto.getReceivedDate());
        grn.setSupplier(supplierRepository.findById(dto.getSupplierId()).orElse(null));
        if (dto.getInOrders() != null){
            List<InOrder> inOrder = dto.getInOrders().stream()
                    .map(inOrderMapper::toEntity)
                    .toList();
            grn.setInOrders(inOrder);
        }
        return grn;
    }

    public GRNDTO toDTO(GRN grn){
        GRNDTO dto = new GRNDTO();
        dto.setId(grn.getId());
        dto.setReceivedDate(grn.getReceivedDate());
        dto.setSupplierId(grn.getSupplier().getId());
        if (grn.getInOrders() != null){
            List<InOrderDTO> orderDTOS = grn.getInOrders().stream()
                    .map(inOrderMapper:: toDTO)
                    .collect(Collectors.toList());
            dto.setInOrders(orderDTOS);
        }
        return dto;
    }
}
