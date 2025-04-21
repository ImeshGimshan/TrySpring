package org.cyklon.tryoutspringboot.DTO.Category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CatDTOSave {
    private String cat_name;
    private boolean active;


}
