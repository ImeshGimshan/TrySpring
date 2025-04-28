package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.GRNItemsDTO;
import org.cyklon.tryoutspringboot.Model.GRNItems;
import org.cyklon.tryoutspringboot.Repository.GRNRepository;
import org.cyklon.tryoutspringboot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GRNItemsMapper {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GRNRepository grnRepository;

    public GRNItems toEntity(GRNItemsDTO grnItemsDTO){
        GRNItems grnItems = new GRNItems();
        grnItems.setId(grnItemsDTO.getId());
        grnItems.setQuantityReceived(grnItemsDTO.getQuantityReceived());
        grnItems.setUnitCost(grnItemsDTO.getUnitCost());
        grnItems.setGrn(grnRepository.findById(grnItemsDTO.getGrnId()).orElse(null));
        grnItems.setProduct(productRepository.findById(grnItemsDTO.getProductId()).orElse(null));
        return grnItems;
    }

    public GRNItemsDTO toDTO(GRNItems grnItems){
        GRNItemsDTO dto = new GRNItemsDTO();
        dto.setId(grnItems.getId());
        dto.setQuantityReceived(grnItems.getQuantityReceived());
        dto.setUnitCost(grnItems.getUnitCost());
        dto.setGrnId(grnItems.getGrn().getId());
        dto.setProductId(grnItems.getProduct().getId());
        return dto;
    }
}
