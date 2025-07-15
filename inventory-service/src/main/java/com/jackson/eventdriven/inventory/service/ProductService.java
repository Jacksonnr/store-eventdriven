package com.jackson.eventdriven.inventory.service;


import com.jackson.eventdriven.inventory.dto.ProductMapper;
import com.jackson.eventdriven.inventory.dto.ProductRequestDTO;
import com.jackson.eventdriven.inventory.dto.ProductResponseDTO;
import com.jackson.eventdriven.inventory.entity.ProductEntity;
import com.jackson.eventdriven.inventory.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.kafka.common.errors.ResourceNotFoundException;
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

    public ProductResponseDTO createProduct (ProductRequestDTO productRequestDTO) {
        ProductEntity product = ProductMapper.toEntity(productRequestDTO);
        ProductEntity saved = productRepository.save(product);
        return ProductMapper.toDTO(saved);
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

    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO productRequestDTOUpdated){
        if (productRequestDTOUpdated == null){
            throw new IllegalArgumentException("Dados do produto para atualização não podem ser nulos");
        }

        ProductEntity productExisting = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("produto com o id " + id + " não foi encontrado."));

        productExisting.setName(productRequestDTOUpdated.getName());
        productExisting.setAmount(productRequestDTOUpdated.getAmount());
        productExisting.setPrice(productRequestDTOUpdated.getPrice());
        productRepository.save(productExisting);

        return ProductMapper.toDTO(productExisting);
    }

    public void deleteProduct (UUID id){
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        productRepository.delete(product);
    }
}
