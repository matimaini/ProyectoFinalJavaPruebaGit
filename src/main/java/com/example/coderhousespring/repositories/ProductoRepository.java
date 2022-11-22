package com.example.coderhousespring.repositories;

import com.example.coderhousespring.documents.Producto;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends MongoRepository<Producto,String> {



}

