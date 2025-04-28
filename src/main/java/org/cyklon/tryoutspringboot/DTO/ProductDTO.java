package org.cyklon.tryoutspringboot.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;

    @NotBlank
    private Long barcode;

    @NotBlank
    private String name;

    @Positive
    private double price;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;

    //stock product quantity
    @Min(0)
    private int quantity;


    private Long categoryId;
    private Long supplierId;
}
