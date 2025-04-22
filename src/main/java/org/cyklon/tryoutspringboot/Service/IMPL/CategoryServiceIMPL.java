package org.cyklon.tryoutspringboot.Service.IMPL;

import org.cyklon.tryoutspringboot.Model.Category;
import org.cyklon.tryoutspringboot.Repository.CategoryRepository;
import org.cyklon.tryoutspringboot.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceIMPL implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public String addCategory(CatDTOSave catDTOSave) {
        Category category = new Category(
                catDTOSave.getCat_name(),
                catDTOSave.isActive()
        );
        categoryRepository.save(category);

        return category.getCatName();
    }

    @Override
    public List<CatDTO> getAllCategory(){
        List<Category> getCategory = categoryRepository.findAll();

        List<CatDTO> allCategory = new ArrayList<>();
        for (Category category : getCategory){
            CatDTO catDTO = new CatDTO(
                    category.getCatId(),
                    category.getCatName(),
                    category.isActive()
            );
            allCategory.add(catDTO);
        }
        return allCategory;
    }

    @Override
    public String updateCategory(CatDTOUpdate catDTOUpdate){
        if(categoryRepository.existsById(catDTOUpdate.getCat_id())){
            Category category = categoryRepository.getById(catDTOUpdate.getCat_id());
            category.setCatName(catDTOUpdate.getCat_name());
            category.setActive(catDTOUpdate.isActive());
            categoryRepository.save(category);
        }
        else {
            System.out.println("Category not found");
        }
        return "Updated Category";
    }

    @Override
    public boolean deleteCategory(int id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }
        else {
            System.out.println("Category not found");
        }
        return false;
    }
}
