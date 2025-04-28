package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.GRNDTO;
import org.cyklon.tryoutspringboot.DTO.GRNItemsDTO;
import org.cyklon.tryoutspringboot.Model.GRN;
import org.cyklon.tryoutspringboot.Model.GRNItems;
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
    private GRNItemsMapper grnItemsMapper;

    public GRN toEntity (GRNDTO dto){
        GRN grn = new GRN();
        grn.setId(dto.getId());
        grn.setReceivedDate(dto.getReceivedDate());
        grn.setSupplier(supplierRepository.findById(dto.getSupplierId()).orElse(null));
        if(dto.getGrnItemsDTO()!=null){
            List<GRNItems> grnItems = dto.getGrnItemsDTO().stream()
                    .map(grnItemsDTO -> {
                        GRNItems grnItem = grnItemsMapper.toEntity(grnItemsDTO);
                        grnItem.setGrn(grn);
                        return grnItem;
                    })
                    .collect(Collectors.toList());
            grn.setGrnItems(grnItems);
        }
        return grn;
    }

    public GRNDTO toDTO(GRN grn){
        GRNDTO dto = new GRNDTO();
        dto.setId(grn.getId());
        dto.setReceivedDate(grn.getReceivedDate());
        dto.setSupplierId(grn.getSupplier().getId());
        if(grn.getGrnItems() != null){
            List<GRNItemsDTO> grnItemsDTO = grn.getGrnItems().stream()
                    .map(grnItemsMapper::toDTO)
                    .collect(Collectors.toList());
            dto.setGrnItemsDTO(grnItemsDTO);
        }
        return dto;
    }
}
