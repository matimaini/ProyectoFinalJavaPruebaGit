package com.example.coderhousespring.repositories;

import com.example.coderhousespring.documents.Carrito;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoRepository extends MongoRepository<Carrito, String> {

}

