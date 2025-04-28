package org.cyklon.tryoutspringboot.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GRNDTO {
    private Long id;

    private LocalDateTime receivedDate;

    private Long supplierId;

    private List<GRNItemsDTO> grnItemsDTO;
}
