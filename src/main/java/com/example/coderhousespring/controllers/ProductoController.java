package com.example.coderhousespring.controllers;

import com.example.coderhousespring.documents.Producto;
import com.example.coderhousespring.models.request.ProductoRequest;
import com.example.coderhousespring.models.response.ProductoResponse;
import com.example.coderhousespring.services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/productos"})
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/add")
    public ResponseEntity<?> crearProducto(
            @RequestBody ProductoRequest producto) {
        productoService.crearProducto(producto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = productoService.listarProductos();

        return ResponseEntity.ok(productos);

    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarProducto(
            @PathVariable("id") String id,
            @RequestBody ProductoRequest producto) {

        productoService.modificarProducto(producto, id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarProducto(@PathVariable("id") String idProducto) {

        productoService.eliminarProducto(idProducto);

        return ResponseEntity.noContent().build();
    }

}
