package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.InOrderDTO;
import org.cyklon.tryoutspringboot.Model.InOrder;
import org.cyklon.tryoutspringboot.Repository.GRNRepository;
import org.cyklon.tryoutspringboot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InOrderMapper {

    @Autowired
    private GRNRepository grnRepository;

    @Autowired
    private ProductRepository productRepository;

    public InOrder toEntity (InOrderDTO dto){
        InOrder inorder = new InOrder();
        inorder.setId(dto.getId());
        inorder.setGrn(grnRepository.findById(dto.getGrnId()).orElse(null));
        inorder.setProduct(productRepository.findById(dto.getProductId()).orElse(null));
        inorder.setQuantityReceived(dto.getQuantityReceived());
        inorder.setUnitCost(dto.getUnitCost());
        return inorder;
    }

    public InOrderDTO toDTO (InOrder entity){
        InOrderDTO dto = new InOrderDTO();
        dto.setId(entity.getId());
        dto.setGrnId(entity.getGrn().getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setQuantityReceived(dto.getQuantityReceived());
        dto.setUnitCost(dto.getUnitCost());
        return dto;
    }
}
