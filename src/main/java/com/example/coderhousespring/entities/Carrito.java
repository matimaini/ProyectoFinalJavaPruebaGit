package com.example.coderhousespring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {
@Id @Column(name = "idCarrito")
private Long idCarrito;

@Column(name = "productos")
private List<Producto> productos;

@Column(name = "direccion")
private String direccion;


}
