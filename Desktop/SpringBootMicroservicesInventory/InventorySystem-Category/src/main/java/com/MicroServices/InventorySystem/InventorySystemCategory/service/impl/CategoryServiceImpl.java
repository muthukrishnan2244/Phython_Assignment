package com.MicroServices.InventorySystem.InventorySystemCategory.service.impl;

import com.MicroServices.InventorySystem.InventorySystemCategory.DTO.CategoryDTO;
import com.MicroServices.InventorySystem.InventorySystemCategory.entity.Category;
import com.MicroServices.InventorySystem.InventorySystemCategory.repository.CategoryRepo;
import com.MicroServices.InventorySystem.InventorySystemCategory.service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo categoryRepo;

    private ModelMapper  modelMapper;

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category =   modelMapper.map(categoryDTO, Category.class);
        categoryRepo.save(category);
        CategoryDTO categoryDTO1 = modelMapper.map(category,CategoryDTO.class);
        return categoryDTO1;
    }

    @Override
    public CategoryDTO getByCategoryName(String categoryname)throws Exception {
        Category category = categoryRepo.findByCategoryName(categoryname);
        CategoryDTO categoryDTO = modelMapper.map(category,CategoryDTO.class);
        return categoryDTO;
    }
}
