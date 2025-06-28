package com.MicroServices.InventorySystem.InventorySystemCategory.repository;

import com.MicroServices.InventorySystem.InventorySystemCategory.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    Category findByCategoryName(String name)throws Exception;
}
