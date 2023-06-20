package com.digitalworlds.api6.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyApiService {
    private final RestTemplate restTemplate;

    @Autowired
    public MyApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
@Bean
    public String consumirApi() {
        String apiUrl = "https://www.cultura.gob.ar/api/v2.0"; // Reemplaza con la URL de la API que deseas consumir
        String endpoint = "/museos/?limit=20"; // Reemplaza con el endpoint específico de la API

        // Realiza una solicitud GET a la API y obtén la respuesta en forma de una cadena (String)
        String response = restTemplate.getForObject(apiUrl + endpoint, String.class);

        // Procesa la respuesta de la API
       // System.out.println(response);
    return response;
}
}