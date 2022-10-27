package com.example.coderhousespring.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private String categoria;
    private String precio;
    private String stock;
    private String imagen;


}
