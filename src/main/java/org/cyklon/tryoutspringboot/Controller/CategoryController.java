package org.cyklon.tryoutspringboot.Controller;

import org.cyklon.tryoutspringboot.DTO.CategoryDTO;
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



}