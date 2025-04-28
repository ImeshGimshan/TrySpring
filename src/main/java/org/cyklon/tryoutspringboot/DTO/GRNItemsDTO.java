package org.cyklon.tryoutspringboot.DTO;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class GRNItemsDTO {
    private Long id;

    @Positive
    private int quantityReceived;

    @Positive
    private double unitCost;

    private Long grnId;

    private Long productId;
}
