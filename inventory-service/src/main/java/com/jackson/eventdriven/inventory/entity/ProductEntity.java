package com.jackson.eventdriven.inventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "TB_PRODUCT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Nome do produto é obrigatório")
    private String name;

    @NotNull(message = "Quantidade é obrigatório")
    private int amount;

    @NotNull(message = "Valor do produto é obrigatório")
    private double price;
}
