package com.grupo6.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class SaludoTeam6 {
    @GetMapping("/saludos")
    public String saludos(){
        return "Hola Los saludan: Germán, Paulo y Kevin del Grupo 6!";
    }
}
