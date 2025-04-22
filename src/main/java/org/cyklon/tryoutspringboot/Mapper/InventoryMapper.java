package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.InventoryDTO;
import org.cyklon.tryoutspringboot.Model.Inventory;
import org.cyklon.tryoutspringboot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {

    @Autowired
    private ProductRepository productRepository;

    public Inventory toEntity (InventoryDTO dto){
        Inventory inventory = new Inventory();
        inventory.setId(dto.getId());
        inventory.setQuantityAvailable(dto.getQuantityAvailable());
        inventory.setProduct(productRepository.findById(dto.getProductId()).orElse(null));
        return inventory;
    }

    public InventoryDTO toDTO (Inventory entity){
        InventoryDTO dto = new InventoryDTO();
        dto.setId(entity.getId());
        dto.setQuantityAvailable(entity.getQuantityAvailable());
        dto.setProductId(entity.getProduct().getId());
        return dto;
    }

}
