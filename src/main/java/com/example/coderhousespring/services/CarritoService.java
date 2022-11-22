package com.example.coderhousespring.services;

import com.example.coderhousespring.documents.Carrito;
import com.example.coderhousespring.documents.CarritoProductos;
import com.example.coderhousespring.documents.Producto;
import com.example.coderhousespring.models.request.CarritoRequest;
import com.example.coderhousespring.repositories.CarritoRepository;
import com.example.coderhousespring.repositories.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarritoService {

    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;

    public Carrito nuevoCarrito(CarritoRequest carritoRequest){
        Producto producto = productoRepository.findById(carritoRequest.getIdProducto())
            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        CarritoProductos carritoProductos = CarritoProductos.builder()
                .id(producto.getIdProducto().toString())
                .cantidad(producto.getStock())
                .build();

        Carrito carrito = carritoRepository.save(Carrito.builder()
                .idCarrito(carritoRequest.getIdCarrito())
                .fechaPedido(carritoRequest.getFechaPedido())
                .productos(List.of(carritoProductos))
                .direccion(carritoRequest.getDireccion())
                .build());

        return carrito;
    }

    public Carrito cargarProducto(CarritoRequest carritoRequest){
        Carrito carrito = carritoRepository.findById(carritoRequest.getIdCarrito())
                .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));

        Producto producto = productoRepository.findById(carritoRequest.getIdProducto())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        CarritoProductos carritoProductos = CarritoProductos.builder()
                .id(producto.getIdProducto().toString())
                .cantidad(producto.getStock())
                .build();

        CarritoProductos existente = existeEnCarrito(carritoRequest.getIdProducto(),
                carrito.getProductos());

        if (existente != null){
            existente.setCantidad(existente.getCantidad() + carritoProductos.getCantidad());
        } else {
            carrito.getProductos().add(carritoProductos);
        }


        carrito.getProductos().add(carritoProductos);

        return carrito;
    }

    private CarritoProductos existeEnCarrito(String idProducto, List<CarritoProductos> productos){
        for (CarritoProductos carritoProductos : productos){
            if (carritoProductos.getId().equals(idProducto)){
                return carritoProductos;
            }
        }
        return null;
    }

    public void limpiarCarrito(String idCarrito){
        carritoRepository.deleteById(idCarrito);

    }


}
