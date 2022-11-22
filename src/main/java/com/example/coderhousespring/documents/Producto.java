package com.example.coderhousespring.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor


@Builder
@Document(collection = "producto")
public class Producto {
    @Id
    private Long idProducto;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String categoria;
    

}
