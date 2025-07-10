package com.jackson.eventdriven.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private UUID id;
    private String name;
    private Integer amount;
    private Double price;

    // Pode adicionar outros campos se quiser, tipo data de criação, status etc
}
