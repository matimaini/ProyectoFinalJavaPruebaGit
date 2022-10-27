package com.example.coderhousespring.services;

import com.example.coderhousespring.entities.Usuario;
import com.example.coderhousespring.models.request.UsuarioRequest;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> getUsuarioById(final Long id);
    Usuario postNewUsuario(final UsuarioRequest usuarioRequest);

}
