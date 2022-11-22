package com.example.coderhousespring.models.response;


import com.example.coderhousespring.documents.CarritoProductos;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarritoResponse {

    private String idCarrito;
    private String idUsuario;
    private List<CarritoProductos> idProducto;
    private String direccion;



}
