package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.InvoiceDTO;
import org.cyklon.tryoutspringboot.DTO.InvoiceItemDTO;
import org.cyklon.tryoutspringboot.Model.Invoice;
import org.cyklon.tryoutspringboot.Model.InvoiceItem;
import org.cyklon.tryoutspringboot.Repository.CustomerRepository;
import org.cyklon.tryoutspringboot.Repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InvoiceItemMapper invoiceItemMapper;

    public Invoice toEntity(InvoiceDTO dto){
        Invoice invoice = new Invoice();
        invoice.setId(dto.getId());
        invoice.setCustomer(customerRepository.findById(dto.getCustomerId()).orElse(null));
        invoice.setInvoiceDate(dto.getInvoiceDate());
        invoice.setTotalAmount(dto.getTotalAmount());
        if (dto.getItems() != null){
            List<InvoiceItem> items = dto.getItems().stream()
                    .map(invoiceItemMapper::toEntity)
                    .collect(Collectors.toList());
            invoice.setItem(items);
        }
        return invoice;
    }

    public InvoiceDTO toDTO(Invoice invoice){
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(invoice.getId());
        dto.setCustomerId(invoice.getCustomer().getId());
        dto.setInvoiceDate(invoice.getInvoiceDate());
        dto.setTotalAmount(invoice.getTotalAmount());
        if(invoice.getItem() != null){
            List<InvoiceItemDTO> itemDTOs = invoice.getItem().stream()
                    .map(invoiceItemMapper::toDTO)
                    .collect(Collectors.toList());
            dto.setItems(itemDTOs);
        }
        return dto;
    }
}
