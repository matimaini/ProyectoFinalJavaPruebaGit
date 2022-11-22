package com.example.coderhousespring.models.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CarritoRequest {

    private String idCarrito;
    private String idUsuario;
    private LocalDateTime fechaPedido;
    private String idProducto;
    private String direccion;


}
