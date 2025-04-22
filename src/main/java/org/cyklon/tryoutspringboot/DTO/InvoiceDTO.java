package org.cyklon.tryoutspringboot.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InvoiceDTO {
    private Long id;

    private LocalDateTime invoiceDate;

    private double totalAmount;

    private Long customerId;

    private List<InvoiceItemDTO> items;
}
