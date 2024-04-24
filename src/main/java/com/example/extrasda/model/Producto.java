package com.example.extrasda.model;

import jakarta.persistence.*;
import lombok.Data;
import com.example.extrasda.model.Carrito.*;

@Entity
@Table (name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private double precio;

    private int codigo;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "carrito", referencedColumnName = "id")
    private Carrito carrito;
}
