package com.example.coderhousespring.services;

import com.example.coderhousespring.documents.Usuario;
import com.example.coderhousespring.models.request.UsuarioRequest;
import com.example.coderhousespring.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UsuarioService  {
    private final UsuarioRepository usuarioRepository;

    public Usuario save(UsuarioRequest usuarioRequest);

    public List<Usuario> findAll();

    default Usuario postNewUsuario(final UsuarioRequest usuarioRequest){
        final Usuario createdUser = new Usuario();
        createdUser.setEmail(usuarioRequest.getEmail());
        createdUser.setNombre(usuarioRequest.getNombre());
        createdUser.setUsuario(usuarioRequest.getUsuario());
        createdUser.setCelular(usuarioRequest.getCelular());
        usuarioRepository.save(createdUser);
        return createdUser;
    }


    


    }

