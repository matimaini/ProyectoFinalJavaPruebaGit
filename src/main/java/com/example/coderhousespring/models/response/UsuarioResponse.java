package com.example.coderhousespring.models.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioResponse {

    private Long idUsuario;
    private String usuario;
    private String nombre;
    private Integer celular;
    private String email;
    private String password;


}
