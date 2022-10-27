package com.example.coderhousespring.services;


import com.example.coderhousespring.models.request.ProductoRequest;

import java.util.Optional;

public interface ProductService {
    Optional getProductoById(final Long id);
    Optional postNewProducto(final ProductoRequest productoRequest);

}
