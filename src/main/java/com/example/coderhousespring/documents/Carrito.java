package com.example.coderhousespring.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "carrito")
public class Carrito {

@Id
private String idCarrito;
private List<CarritoProductos> productos;
private LocalDateTime fechaPedido;
private String direccion;

}
