package com.example.pubcsm.mapper;

import com.example.pubcsm.dto.ProductDTO;
import com.example.pubcsm.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity()); // Aggiungi la mappatura di quantity
        return dto;
    }

    public Product toEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity()); // Aggiungi la mappatura di quantity
        return product;
    }
}
