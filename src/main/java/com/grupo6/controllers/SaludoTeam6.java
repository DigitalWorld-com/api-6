package com.grupo6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaludoTeam6 {
    @GetMapping("/greeting")
    public String saludo(){
        return "Bienvenidos al Grupo 6 Compuesto por: Germán, Paulo y Kevin !";
    }
}
