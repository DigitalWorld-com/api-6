package com.digitalworlds.api6.base.services;

import com.digitalworlds.api6.base.models.MuseoObjectDTO;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class  MyApiService {
    private final RestTemplate restTemplate;

    public MyApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    public MuseoObjectDTO consumirApi() {
        String apiUrl = "https://www.cultura.gob.ar/api/v2.0/museos/"; // Reemplaza con la URL de la API que deseas consumir
        String endpoint = "27";



        // Realiza una solicitud GET a la API y obtén la respuesta en forma de una Objeto

        //REVISAR PORQuE NO ME FUNCIONO CON @BUILDER()
        MuseoObjectDTO response = restTemplate.getForObject(apiUrl + endpoint, MuseoObjectDTO.class);
        MuseoObjectDTO mus = new MuseoObjectDTO();
        //MuseoObjectDTO mus = MuseoObjectDTO.builder().nombre(response.getNombre()).build();
        mus.setNombre(response.getNombre());
        mus.setDepende_de(response.getDepende_de());

        // Procesa la respuesta de la API
        // System.out.println(response);
        return mus;
    }
}