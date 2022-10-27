package com.example.coderhousespring.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioRequest {
    private String usuario;
    private String nombre;
    private String telefono;
    private String password;
    private String email;


}
