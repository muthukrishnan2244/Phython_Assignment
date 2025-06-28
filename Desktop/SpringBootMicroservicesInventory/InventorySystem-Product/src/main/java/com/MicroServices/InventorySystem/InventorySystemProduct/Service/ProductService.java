package com.MicroServices.InventorySystem.InventorySystemProduct.Service;

import com.MicroServices.InventorySystem.InventorySystemProduct.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    public ProductDTO saveProduct(ProductDTO productDTO);

    public List<ProductDTO> getByCategoryName(String categoryname);
}
