package org.cyklon.tryoutspringboot.DTO.Category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatDTO {
    private int cat_id;
    private String cat_name;
    private boolean active;
}
