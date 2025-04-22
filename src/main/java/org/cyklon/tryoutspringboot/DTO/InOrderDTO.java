package org.cyklon.tryoutspringboot.DTO;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InOrderDTO {
    private Long id;

    private Long grnId;

    private Long productId;

    @Positive
    private int quantityReceived;

    @Positive
    private double unitCost;
}
