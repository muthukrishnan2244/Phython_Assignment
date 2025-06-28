package com.MicroServices.InventorySystem.InventorySystemProduct.Repository;

import com.MicroServices.InventorySystem.InventorySystemProduct.DTO.ProductDTO;
import com.MicroServices.InventorySystem.InventorySystemProduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findByCategory(String categoryname);
}
