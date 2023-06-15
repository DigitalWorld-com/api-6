package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api6")
public class SaludoTeam6 {
    @GetMapping("/SaludoTeam6")
    public String saludo(){
        return "Bienvenidos al Grupo 6 Compuesto por: Germán y Paulo!";
    }
}
