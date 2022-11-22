package com.example.coderhousespring.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="usuario")

public class Orden {
    @Id
    private String idOrden;
    private Long idUsuario;
    private List<Producto> productos;
    private Double monto;
    private LocalDate fechaDeCompra;

}