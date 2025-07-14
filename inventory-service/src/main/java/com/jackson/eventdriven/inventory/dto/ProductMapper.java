package com.jackson.eventdriven.inventory.dto;

import com.jackson.eventdriven.inventory.entity.ProductEntity;

public class ProductMapper {
    public static ProductEntity toEntity(ProductRequestDTO dto) {
        return new ProductEntity(null, dto.getName(), dto.getAmount(), dto.getPrice());
    }

    public static ProductResponseDTO toDTO(ProductEntity product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getAmount(),
                product.getPrice()
        );
    }
}
