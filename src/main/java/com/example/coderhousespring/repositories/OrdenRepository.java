package com.example.coderhousespring.repositories;

import com.example.coderhousespring.documents.Orden;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends MongoRepository<Orden,String> {

}

