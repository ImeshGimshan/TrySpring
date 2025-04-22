package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.InvoiceItemDTO;
import org.cyklon.tryoutspringboot.Model.InvoiceItem;
import org.cyklon.tryoutspringboot.Repository.InvoiceRepository;
import org.cyklon.tryoutspringboot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceItemMapper {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductRepository productRepository;

    public InvoiceItem toEntity (InvoiceItemDTO dto){
        InvoiceItem item = new InvoiceItem();
        item.setId(dto.getId());
        item.setInvoice(invoiceRepository.findById(dto.getInvoiceId()).orElse(null));
        item.setProduct(productRepository.findById(dto.getProductId()).orElse(null));
        item.setQuantity(dto.getQuantity());
        item.setUnitPrice(dto.getUnitPrice());
        return item;
    }

    public InvoiceItemDTO toDTO (InvoiceItem entity){
        InvoiceItemDTO dto = new InvoiceItemDTO();
        dto.setId(entity.getId());
        dto.setInvoiceId(entity.getInvoice().getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setQuantity(entity.getQuantity());
        dto.setUnitPrice(entity.getUnitPrice());
        return dto;
    }
}
