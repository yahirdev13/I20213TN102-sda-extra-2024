package com.example.extrasda.controller.carrito.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CarritoDto {

    @NotBlank
    @Positive
    private int cantidad;

    @NotBlank(message = "El codigo es obligatorio")
    @Min(4)
    private int codigo;



}
