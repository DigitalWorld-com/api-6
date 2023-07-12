package com.digitalworlds.api6.base.controllers;

import com.digitalworlds.api6.base.entities.MuseoEntity;
import com.digitalworlds.api6.base.models.MuseoObjectDTO;
import com.digitalworlds.api6.base.models.MuseoResultDTO;
import com.digitalworlds.api6.base.models.MuseoResultList;
import com.digitalworlds.api6.base.repositories.Api6Repository;
import com.digitalworlds.api6.base.services.MyApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api6")

public class MyApiController {
    private final MyApiService myApiService;

    @Autowired
    public MyApiController(MyApiService myApiService) {
        this.myApiService = myApiService;
    }

      @GetMapping("/museo")
    public ResponseEntity<MuseoObjectDTO> getExternalData() throws JsonProcessingException {
        return ResponseEntity.ok(myApiService.consumirApi());
    }

    @GetMapping("/museos")
    public ResponseEntity<?> getMuseos() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MuseoResultList> response = restTemplate.getForEntity(
                "https://www.cultura.gob.ar/api/v2.0/museos/",
                MuseoResultList.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            MuseoResultList apiResponse = response.getBody();
            if (apiResponse != null && apiResponse.getResults() != null) {
                List<MuseoResultDTO> museos = apiResponse.getResults();
                Api6Repository.saveAll(museos);
                return ResponseEntity.ok(apiResponse.getResults());
            }
        }

        return ResponseEntity.status(response.getStatusCode()).body("Error al obtener los datos");
    }

    }

