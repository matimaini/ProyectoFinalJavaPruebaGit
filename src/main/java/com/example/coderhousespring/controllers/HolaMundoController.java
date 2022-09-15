package com.example.coderhousespring.controllers;
import com.example.coderhousespring.models.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HolaMundoController {

    @GetMapping("/animal")
    public Animal animal() {
        System.out.println("Hola animal!");
        return new Animal("Firulais", "Pastor Aleman", false);
    }

    @GetMapping("/hola")
    public String greeting(){
        return "hola mundo";
    }
}
