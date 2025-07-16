package com.jackson.eventdriven.inventory.controller;

import java.util.List;

import com.jackson.eventdriven.inventory.dto.ProductRequestDTO;
import com.jackson.eventdriven.inventory.dto.ProductResponseDTO;
import com.jackson.eventdriven.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity <ProductResponseDTO> createProduct (@RequestBody @Valid ProductRequestDTO productRequestDTO){
       ProductResponseDTO product = productService.createProduct(productRequestDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping
    public List<ProductResponseDTO> listAll() {
        return productService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <ProductResponseDTO> listById(@PathVariable UUID id){
        ProductResponseDTO productResponseDTO = productService.listById(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity <ProductResponseDTO>  updateProduct(
            @PathVariable UUID id,
            @Valid @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO product = productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <ProductResponseDTO> deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
