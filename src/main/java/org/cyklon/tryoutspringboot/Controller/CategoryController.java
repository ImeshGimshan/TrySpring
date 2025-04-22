package org.cyklon.tryoutspringboot.Controller;

import org.cyklon.tryoutspringboot.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/save")
    public String saveCategory(@RequestBody CatDTOSave catDTOSave) {
        String catname = categoryService.addCategory(catDTOSave);
        return catname;
    }

    @GetMapping
    public List<CatDTO> getCategory() {
        List<CatDTO> allCategory = categoryService.getAllCategory();
        return allCategory;
    }

    @PutMapping("/update")
    public String updateCategory(@RequestBody CatDTOUpdate catDTOUpdate) {
        String id = categoryService.updateCategory(catDTOUpdate);
        return "Updated Category";
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteCategory (@PathVariable(value="id")int id) {
        boolean deleteCategory = categoryService.deleteCategory(id);
        return "Deleted the Category";
    }

}