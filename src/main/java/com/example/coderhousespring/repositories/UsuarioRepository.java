package com.example.coderhousespring.repositories;

import com.example.coderhousespring.documents.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long> {
Optional<Usuario> findByUsername(String username);
Boolean existsByUsername(String username);
Boolean existsByEmail(String email);

}

