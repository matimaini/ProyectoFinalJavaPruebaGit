package com.example.coderhousespring.models.request;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRequest {
    private String usuario;
    private String nombre;
    private String celular;
    private String email;
    private String password;



}
