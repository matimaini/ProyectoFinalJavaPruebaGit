package com.example.coderhousespring.services;

import com.example.coderhousespring.documents.Usuario;
import com.example.coderhousespring.exceptions.UserExistsException;
import com.example.coderhousespring.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Usuario> usuario = usuarioRepository.findByUsuario(username);
        if(usuario.isEmpty()) {
            log.error("El usuario no existe " + LocalDate.now());
            throw new UsernameNotFoundException("Usuario no encontrado en la base de datos");
        } else {
            log.info("Usuario encontrado" + LocalDate.now());
        }

        return Usuario.build(usuario.get());
    }

    public void borrarUsuario(final String idUsuario){
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

        if (usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
        } else {
            log.error("No existe el usuario " + idUsuario + " - " + LocalDate.now());
            throw new UserExistsException("No existe el usuario " + idUsuario);
        }
    }

    public Optional<Usuario> getUserById(final String id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            log.info("Usuario existente" + LocalDate.now());
            return usuario;
        } else {
            log.error("No existe el usuario " + id + " - " + LocalDate.now());
            throw new UserExistsException("No existe el usuario " + id);
        }
    }

    public Optional<Usuario> getUserByUsuario(final String user){
        Optional<Usuario> usuario = usuarioRepository.findByUsuario(user);
        if(usuario.isPresent()){
            log.info("Usuario existente" + LocalDate.now());
            return usuario;
        } else {
            log.error("No existe el usuario " + user + " - " + LocalDate.now());
            throw new UserExistsException("No existe el usuario " + user);
        }
    }

    public List<Usuario> getUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario modificarUsuario(final Usuario usuario, final String idUsuario){
        Optional<Usuario> cambioUsuario = usuarioRepository.findById(idUsuario);

        if (cambioUsuario.isPresent()){
            cambioUsuario.get().setUsuario(usuario.getUsuario());
            cambioUsuario.get().setNombre(usuario.getNombre());
            cambioUsuario.get().setEmail(usuario.getEmail());
            cambioUsuario.get().setPassword(usuario.getPassword());
            usuarioRepository.save(cambioUsuario.get());

            return cambioUsuario.get();
        } else {
            log.error("No existe el usuario " + idUsuario + " - " + LocalDate.now());
            throw new UserExistsException("No existe el usuario " + idUsuario);
        }

    }



}

