package com.example.extrasda.service;

import com.example.extrasda.controller.carrito.dto.CarritoDto;
import com.example.extrasda.model.Carrito;
import com.example.extrasda.model.CarritoRepository;
import com.example.extrasda.model.ProductoRepository;
import com.example.extrasda.utils.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarritoService {

    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;

    @Transactional(rollbackFor = SQLException.class)
    public CustomResponse<Carrito> create(CarritoDto carrito) {
        Carrito newCarrito = new Carrito();
        newCarrito.setCantidad(carrito.getCantidad());
        newCarrito.setCodigo(carrito.getCodigo());
        newCarrito = carritoRepository.save(newCarrito);
        return new CustomResponse<>(
                newCarrito, true, 201, "Carrito creado");
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Carrito>> getAll() {
        List<Carrito> carritos = carritoRepository.findAll();
        if (carritos.isEmpty()) {
            return new CustomResponse<>(
                    carritos, false, 404, "No hay carritos registrados");
        } else {
            return new CustomResponse<>(
                    carritos, true, 200, "Carritos encontrados");
        }
    }

    @Transactional(readOnly = true)
    public CustomResponse<Double> getTotal(CarritoDto carrito) {
        Double total = productoRepository.findByCodigo(carrito.getCodigo()).getPrecio() * carrito.getCantidad();
        return new CustomResponse<>(
                total, true, 200, "Total calculado");
    }

}
