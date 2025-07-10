package com.jackson.eventdriven.inventory.service;


import com.jackson.eventdriven.inventory.dto.ProductResponseDTO;
import com.jackson.eventdriven.inventory.entity.ProductEntity;
import com.jackson.eventdriven.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> listAll() {
        List<ProductEntity> products = productRepository.findAll();

        return products.stream()
                .map(product -> new ProductResponseDTO(
                        product.getId(),
                        product.getName(),
                        product.getAmount(),
                        product.getPrice()
                ))
                .collect(Collectors.toList());
    }
}
