package org.cyklon.tryoutspringboot.Service;

import java.util.List;

public interface CategoryService {
    String addCategory(CatDTOSave catDTOSave);

    List<CatDTO> getAllCategory();

    String updateCategory(CatDTOUpdate catDTOUpdate);

    boolean deleteCategory(int id);
}
