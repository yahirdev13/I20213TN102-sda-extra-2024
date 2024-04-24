package com.example.extrasda.controller.carrito;

import com.example.extrasda.controller.carrito.dto.CarritoDto;
import com.example.extrasda.model.Carrito;
import com.example.extrasda.model.CarritoRepository;
import com.example.extrasda.service.CarritoService;
import com.example.extrasda.utils.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;

    @PostMapping("/create")
    public ResponseEntity<CustomResponse<Carrito>> create (@RequestBody CarritoDto carrito){
        try{
            return ResponseEntity.ok(carritoService.create(carrito));
        }catch (Exception e){
            return new ResponseEntity<>(
                    new CustomResponse<>(
                            null, false, 500, "Error interno del servidor"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Carrito>>> getAll(){
        try{
            return ResponseEntity.ok(carritoService.getAll());
        }catch (Exception  e){
            return ResponseEntity.status(500).body(
                    new CustomResponse<>(
                            null, false, 500, "Error interno del servidor"
                    )
            );
        }
    }


}
