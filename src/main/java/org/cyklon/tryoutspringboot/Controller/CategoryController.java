package org.cyklon.tryoutspringboot.Controller;

import jakarta.validation.Valid;
import org.cyklon.tryoutspringboot.DTO.CategoryDTO;
import org.cyklon.tryoutspringboot.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryDTO createCategory (@Valid @RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping
    public List<CategoryDTO> getAllcategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(id,categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory (@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}