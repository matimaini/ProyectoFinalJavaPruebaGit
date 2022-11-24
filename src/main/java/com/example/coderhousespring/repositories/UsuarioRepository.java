package com.example.coderhousespring.repositories;

import com.example.coderhousespring.documents.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
Optional<Usuario> findByUsuario(String username);
Boolean existsByUsuarioBoolean(String username);
Boolean existsByEmail(String email);

}

