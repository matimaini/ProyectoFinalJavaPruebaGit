package com.example.coderhousespring.documents;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.management.relation.Role;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document(collection = "usuario")
public class Usuario implements UserDetails {
    @Id
    private String idUsuario;
    @NotBlank(message = "El campo usuario es obligatorio")
    private String usuario;
    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;
    private String celular;
    @NotBlank(message = "El campo email es obligatorio")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message = "El correo no cumple con el formato")
    private String email;

    private Collection<Role> roles = new ArrayList<>();
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public Usuario(String idUsuario, String usuario, String email, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }


    public static Usuario build(Usuario user) {
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().toString()))
                .collect(Collectors.toList());

        return new Usuario(
                user.getIdUsuario(),
                user.getUsuario(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
