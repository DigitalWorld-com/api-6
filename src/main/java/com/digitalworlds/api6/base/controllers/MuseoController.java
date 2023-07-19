package com.digitalworlds.api6.base.controllers;

import com.digitalworlds.api6.base.entities.MuseoEntity;
import com.digitalworlds.api6.base.models.MuseoDTO;
import com.digitalworlds.api6.base.models.MuseoListIdNombre;
import com.digitalworlds.api6.base.services.MuseoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api6")
public class MuseoController {

    @Autowired
    MuseoService museoService;

    @GetMapping("/hello")
    public List<MuseoDTO> hello1() {
        return museoService.getObjects();
    }

    @PostMapping("/hello")
    public void postHello1() {
    }

    @GetMapping("/museos_completos")
    public ResponseEntity<List<MuseoListIdNombre>> getData() throws JsonProcessingException {
        List<MuseoListIdNombre> museosIdNombreList = museoService.procesarLlamadaApi();
        return ResponseEntity.ok(museosIdNombreList);
    }
    /*@GetMapping("/museos")
    public ResponseEntity<MuseoIdNombreDTO> getData() throws JsonProcessingException {
        return ResponseEntity.ok((MuseoIdNombreDTO) museoService.procesarLlamadaApi());
    }**/

    @PostMapping("/museos_completos")
    public String postMuseos() {
        return "algo";
    }

    @GetMapping("/museo_por_pv/{id}")
        public ResponseEntity<MuseoEntity> getByPVId(@PathVariable Long id) throws JsonProcessingException {
        return ResponseEntity.ok(museoService.getMuseoById(id));
    }

    @GetMapping("/museo_por/rm")
    public ResponseEntity<MuseoEntity> getByRMId(@RequestParam(defaultValue="1", name = "id") Long id) throws JsonProcessingException {
        return ResponseEntity.ok(museoService.getMuseoById(id));
    }
}
