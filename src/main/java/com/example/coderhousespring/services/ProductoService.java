package com.example.coderhousespring.services;


import com.example.coderhousespring.documents.Producto;
import com.example.coderhousespring.models.request.ProductoRequest;
import com.example.coderhousespring.models.response.ProductoResponse;
import com.example.coderhousespring.repositories.ProductoRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductoService {

    public ProductoRepository productoRepository;


    //Crear nuevo
public Producto crearProducto(ProductoRequest productoRequest) {

    Producto producto = productoRepository.save(Producto.builder()
            .descripcion(productoRequest.getDescripcion())
            .precio(productoRequest.getPrecio())
            .stock(productoRequest.getStock())
            .categoria(productoRequest.getCategoria())
            .build());
        return producto;
    }

    //buscar todos los productos
    public List<Producto> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos;
    }

    //buscar por categoria


   //modificar un producto
    public Producto modificarProducto(ProductoRequest productoRequest, String idProducto) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow( () -> new NoSuchElementException("Producto inexistente. No se puede modificar"));
        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setPrecio(productoRequest.getPrecio());
        producto.setStock(productoRequest.getStock());
        producto.setCategoria(productoRequest.getCategoria());
        productoRepository.save(producto);
        return producto;
    }

    public void eliminarProducto(String idProducto) {
        productoRepository.deleteById(idProducto);
    }

}
