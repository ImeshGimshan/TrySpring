package org.cyklon.tryoutspringboot.DTO;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long productId;
    private int quantity;
}
