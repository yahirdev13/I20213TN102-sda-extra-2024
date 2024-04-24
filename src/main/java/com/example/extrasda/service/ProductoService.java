package com.example.extrasda.service;

import com.example.extrasda.controller.productos.dto.ProductoDto;
import com.example.extrasda.model.Producto;
import com.example.extrasda.model.ProductoRepository;
import com.example.extrasda.utils.CustomResponse;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Transactional(rollbackFor = SQLException.class)
    public CustomResponse<Producto> create (ProductoDto producto){
        Producto newProducto = new Producto();
        newProducto.setNombre(producto.getNombre());
        newProducto.setPrecio(producto.getPrecio());
        newProducto.setCodigo(producto.getCodigo());
        newProducto.setDescripcion(producto.getDescripcion());
        newProducto = productoRepository.save(newProducto);
        return new CustomResponse<>(
                newProducto, true, 201,"Producto creado"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Producto>> getAll(){
        List<Producto> productos = productoRepository.findAll();
        if (productos.isEmpty()){
            return new CustomResponse<>(
                    productos, false, 404, "No hay productos registrados"
            );
        }else{
            return new CustomResponse<>(
                    productos, true, 200, "Productos encontrados"
            );
        }
    }


}
