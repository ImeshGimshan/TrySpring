package org.cyklon.tryoutspringboot.Service;

import org.cyklon.tryoutspringboot.DTO.Category.CatDTO;
import org.cyklon.tryoutspringboot.DTO.Category.CatDTOSave;

import java.util.List;

public interface CategoryService {
    String addCategory(CatDTOSave catDTOSave);

    List<CatDTO> getAllCategory();
}
