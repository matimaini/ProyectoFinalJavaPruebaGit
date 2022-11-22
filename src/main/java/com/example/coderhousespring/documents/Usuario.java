package com.example.coderhousespring.documents;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "usuario")
public class Usuario {
    @Id
    private String idUsuario;
    private String usuario;
    private String nombre;
    private String celular;
    private String email;
    private String password;

}
