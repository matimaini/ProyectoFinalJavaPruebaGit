package com.example.coderhousespring.documents;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarritoProductos {

    private String id;
    private Integer cantidad;

}
