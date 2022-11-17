package com.example.coderhousespring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orden {
    @Id @Column(name = "idOrden")
    private Long idOrden;

    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "productos")
    private List<Producto> productos;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "fechaDeCompra")
    private LocalDate fechaDeCompra;

}