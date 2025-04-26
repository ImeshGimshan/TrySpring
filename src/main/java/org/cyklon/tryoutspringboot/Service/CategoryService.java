package org.cyklon.tryoutspringboot.Service;

import org.cyklon.tryoutspringboot.DTO.CategoryDTO;
import org.cyklon.tryoutspringboot.Mapper.CategoryMapper;
import org.cyklon.tryoutspringboot.Model.Category;
import org.cyklon.tryoutspringboot.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDTO createCategory (CategoryDTO dto){
        Category category = categoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toDTO(saved);
    }

    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.toDTO(category);
    }

    public CategoryDTO updateCategory(Long id , CategoryDTO dto){
        Category existing = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        existing.setName(dto.getName());
        return categoryMapper.toDTO(categoryRepository.save(existing));
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
