package com.MicroServices.InventorySystem.InventorySystemCategory.controller;

import com.MicroServices.InventorySystem.InventorySystemCategory.DTO.CategoryDTO;
import com.MicroServices.InventorySystem.InventorySystemCategory.service.impl.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private CategoryServiceImpl categoryService;
    @PostMapping
    public CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO){
         CategoryDTO categoryDTO1 = categoryService.saveCategory(categoryDTO);
         return categoryDTO1;
    }

    @GetMapping
    public CategoryDTO getByCategoryName(@RequestParam String category) throws Exception {
        System.out.println(category);
        CategoryDTO categoryDTO = categoryService.getByCategoryName(category);
        return categoryDTO;
    }
}
