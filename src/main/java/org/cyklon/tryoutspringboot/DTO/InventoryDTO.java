package org.cyklon.tryoutspringboot.DTO;

import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    private int quantityAvailable;
    private Long productId;
}
