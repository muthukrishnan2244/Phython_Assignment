package com.MicroServices.InventorySystem.InventorySystemProduct.controller;

import com.MicroServices.InventorySystem.InventorySystemProduct.DTO.ProductDTO;
import com.MicroServices.InventorySystem.InventorySystemProduct.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = productService.saveProduct(productDTO);
        return productDTO1;
    }

    @GetMapping
    public List<ProductDTO> getByCategory(@RequestParam String category){
        List<ProductDTO> productDTO = productService.getByCategoryName(category);
        return  productDTO;
    }
}
