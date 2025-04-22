package org.cyklon.tryoutspringboot.DTO;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InvoiceItemDTO {
    private Long id;
    private Long invoiceId;
    private Long productId;

    @Positive
    private int quantity;

    @Positive
    private double unitPrice;
}
