package com.example.coderhousespring.models;

import org.springframework.web.bind.annotation.GetMapping;

public class Animal {
    private final String nombre;
    private final String raza;
    private final boolean vacunado;

    public Animal(String nombre, String raza, Boolean vacunado) {
        this.nombre = nombre;
        this.raza = raza;
        this.vacunado = vacunado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public boolean isVacunado() {
        return vacunado;
    }


}
