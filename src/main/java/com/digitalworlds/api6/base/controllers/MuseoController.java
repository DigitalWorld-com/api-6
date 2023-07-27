package com.digitalworlds.api6.base.controllers;

import com.digitalworlds.api6.base.entities.MuseoEntity;
import com.digitalworlds.api6.base.models.MuseoDTO;
import com.digitalworlds.api6.base.models.MuseoIdNombreDTO;
import com.digitalworlds.api6.base.models.MuseoListIdNombre;
import com.digitalworlds.api6.base.services.MuseoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/museos" +
            "esde_url")
    public ResponseEntity<List<MuseoListIdNombre>> getData() throws JsonProcessingException {
        List<MuseoListIdNombre> museosIdNombreList = museoService.procesarLlamadaApi();
        return ResponseEntity.ok(museosIdNombreList);
    }

    @GetMapping("/museos_desde_tabla")
    public List<MuseoListIdNombre> getDataFromTable() throws JsonProcessingException {
        return museoService.museosTabla();
    }

    @PostMapping("/museos_completos")
    public String postMuseos() {
        return "algo";
    }

    @GetMapping("/museo_por_pv/{id}")
        public ResponseEntity<MuseoEntity> getByPVId(@PathVariable Long id) throws JsonProcessingException {
        return ResponseEntity.ok(museoService.getMuseoById(id));
    }

    @PostMapping("/insertar/")
    public ResponseEntity museoInsertar(@RequestBody MuseoListIdNombre museoListIdNombre){
        museoService.crearMuseo(museoListIdNombre.getId(), museoListIdNombre.getNombre());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/museo_por/rm")
    public ResponseEntity<MuseoEntity> getByRMId(@RequestParam(defaultValue="1", name = "id") Long id) throws JsonProcessingException {
        return ResponseEntity.ok(museoService.getMuseoById(id));
    }
}
