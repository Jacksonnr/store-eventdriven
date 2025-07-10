package com.jackson.eventdriven.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    private UUID id;

    @NotBlank(message = "Nome do produto é obrigatório")
    private String name;

    @NotNull(message = "Quantidade é obrigatório")
    private Integer amount;

    @NotNull(message = "Valor do produto é obrigatório")
    private Double price;
}


