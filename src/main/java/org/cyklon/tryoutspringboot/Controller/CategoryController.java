package org.cyklon.tryoutspringboot.Controller;

import org.cyklon.tryoutspringboot.DTO.Category.CatDTO;
import org.cyklon.tryoutspringboot.DTO.Category.CatDTOSave;
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

}