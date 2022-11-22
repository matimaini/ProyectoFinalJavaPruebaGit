package com.example.coderhousespring.models.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ProductoRequest {

    private String descripcion;
    private Double precio;
    private Integer stock;
    private String categoria;


}
