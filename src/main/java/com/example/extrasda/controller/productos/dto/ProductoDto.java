package com.example.extrasda.controller.productos.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class ProductoDto {

    @NotBlank(message = "El nombre es requerido")
    @Max(30)
    private String nombre;

    @Positive (message = "El precio debe de ser positivo")
    private double precio;

    @NotBlank(message = "El codigo es obligatorio")
    @Min(4)
    @Positive
    private int codigo;

    @Max(300)
    private String descripcion;





}
