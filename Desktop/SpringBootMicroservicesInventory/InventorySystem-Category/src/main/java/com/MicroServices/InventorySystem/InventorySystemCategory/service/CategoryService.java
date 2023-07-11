package com.MicroServices.InventorySystem.InventorySystemCategory.service;

import com.MicroServices.InventorySystem.InventorySystemCategory.DTO.CategoryDTO;

public interface CategoryService {
    public CategoryDTO saveCategory(CategoryDTO categoryDTO);

    public CategoryDTO getByCategoryName(String categoryname)throws Exception;



}
