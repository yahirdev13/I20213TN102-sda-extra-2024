package com.example.extrasda.controller.productos;

import com.example.extrasda.controller.productos.dto.ProductoDto;
import com.example.extrasda.model.Producto;
import com.example.extrasda.service.ProductoService;
import com.example.extrasda.utils.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/create")
    public ResponseEntity<CustomResponse<Producto>> create (@RequestBody ProductoDto producto){
        try{
            return ResponseEntity.ok(productoService.create(producto));
        }catch (Exception e){
            return new ResponseEntity<>(
                    new CustomResponse<>(
                            null, false, 500, "Error interno del servidor"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Producto>>> getAll(){
        try {
            return ResponseEntity.ok(productoService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    new CustomResponse<>(
                            null, false, 500, "Error interno del servidor"
                    )
            );
        }
    }
}
