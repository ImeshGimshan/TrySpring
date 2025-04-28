package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.CategoryDTO;
import org.cyklon.tryoutspringboot.Model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryDTO dto){
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    public CategoryDTO toDTO(Category entity){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
