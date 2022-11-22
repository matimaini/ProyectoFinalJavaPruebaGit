package com.example.coderhousespring.controllers;

import com.example.coderhousespring.documents.Carrito;
import com.example.coderhousespring.models.request.CarritoRequest;
import com.example.coderhousespring.services.CarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/carrito")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;

    @PostMapping("/add")
    public ResponseEntity<Carrito> crearCarrito(@RequestBody CarritoRequest carritoRequest) {

        return ResponseEntity.ok(carritoService.nuevoCarrito(carritoRequest));
    }

    @PostMapping("/producto")
    public ResponseEntity<Carrito> agregarProducto(@RequestBody CarritoRequest carritoRequest) {

        return ResponseEntity.ok(carritoService.cargarProducto(carritoRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarCarrito(@PathVariable("id") String id) {

        carritoService.limpiarCarrito(id);

        return ResponseEntity.noContent().build();
    }





}
