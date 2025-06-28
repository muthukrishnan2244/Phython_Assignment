package com.MicroServices.InventorySystem.InventorySystemProduct.Repository.impl;

import com.MicroServices.InventorySystem.InventorySystemCategory.DTO.CategoryDTO;
import com.MicroServices.InventorySystem.InventorySystemProduct.DTO.ProductDTO;
import com.MicroServices.InventorySystem.InventorySystemProduct.Exception.ResourceNotFoundException;
import com.MicroServices.InventorySystem.InventorySystemProduct.Repository.ProductRepo;
import com.MicroServices.InventorySystem.InventorySystemProduct.Service.ProductService;
import com.MicroServices.InventorySystem.InventorySystemProduct.entity.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    private ModelMapper modelMapper;

    private RestTemplate restTemplate;
    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        System.out.println(productDTO.getCategory());
        ResponseEntity<CategoryDTO> categoryDTO = restTemplate.getForEntity("http://localhost:8081/api/category?category="+productDTO.getCategory(),CategoryDTO.class);
        CategoryDTO categoryDTO1 = categoryDTO.getBody();
        if (categoryDTO1 == null){
            throw new ResourceNotFoundException("Category", "name", productDTO.getCategory());
        }
        Product product = modelMapper.map(productDTO,Product.class);
        productRepo.save(product);
        ProductDTO productDTO1 = modelMapper.map(product,ProductDTO.class);
        return productDTO1;
    }

    @Override
    public List<ProductDTO> getByCategoryName(String categoryname) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> product = productRepo.findByCategory(categoryname);
        product.stream().map(product1 -> {
            ProductDTO productDTO = modelMapper.map(product1,ProductDTO.class);
            productDTOList.add(productDTO);
            return productDTOList;
        }).collect(Collectors.toList());
        return productDTOList;
    }
}
