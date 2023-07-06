package com.digitalworlds.api6.base.controllers;

import com.digitalworlds.api6.base.models.MuseoObjectDTO;
import com.digitalworlds.api6.base.services.MyApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    }

