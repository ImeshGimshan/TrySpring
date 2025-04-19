package org.cyklon.tryoutspringboot.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private List<OrderItemDTO> items;
}
