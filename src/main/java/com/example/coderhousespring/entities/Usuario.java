package com.example.coderhousespring.entities;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String celular;
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_nac")
    private LocalDate fechaNac;
    @Column(name = "password")
    private String password;

}
