package com.example.coderhousespring.repositories;

import com.example.coderhousespring.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}

