package com.digitalworlds.api6.base.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api6")
public class greeting {
    @GetMapping("/greeting")
public String saludo(){
    return "Los demás grupos sin saludo.";
}

}
