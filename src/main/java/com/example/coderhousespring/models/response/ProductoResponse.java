package com.example.coderhousespring.models.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoResponse {

    private String idProducto;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String categoria;

}
