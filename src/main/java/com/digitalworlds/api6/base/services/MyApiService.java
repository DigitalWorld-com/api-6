package com.digitalworlds.api6.base.services;

import com.digitalworlds.api6.base.models.Objeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyApiService {
    private final RestTemplate restTemplate;

    public MyApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    public Objeto consumirApi() {
        String apiUrl = "https://www.cultura.gob.ar/api/v2.0"; // Reemplaza con la URL de la API que deseas consumir
        String endpoint = ""; // Reemplaza con el endpoint específico de la API

        // Realiza una solicitud GET a la API y obtén la respuesta en forma de una Objeto
        Objeto response = restTemplate.getForObject(apiUrl + endpoint, Objeto.class);
        Objeto mus = new Objeto();
        mus.setTramites(response.getInstitutos());

        // Procesa la respuesta de la API
        // System.out.println(response);
        return mus;
    }
}