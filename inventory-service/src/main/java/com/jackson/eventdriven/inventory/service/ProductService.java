package com.jackson.eventdriven.inventory.service;


import com.jackson.eventdriven.inventory.dto.ProductMapper;
import com.jackson.eventdriven.inventory.dto.ProductResponseDTO;
import com.jackson.eventdriven.inventory.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> listAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper :: toDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO listById(UUID id){
        return productRepository.findById(id)
                .map(ProductMapper :: toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o id informado"));
    }
}
