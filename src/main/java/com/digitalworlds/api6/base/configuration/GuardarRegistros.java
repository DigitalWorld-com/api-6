package com.digitalworlds.api6.base.configuration;

import com.digitalworlds.api6.base.entities.MuseoEntity;
import com.digitalworlds.api6.base.models.MuseoListIdNombre;
import com.digitalworlds.api6.base.repositories.iMuseoRepository;
import com.digitalworlds.api6.base.services.MuseoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GuardarRegistros implements ApplicationRunner {

    private final MuseoService museoService;
    private final iMuseoRepository museoRepository;

    @Autowired
    public GuardarRegistros(MuseoService museoService, iMuseoRepository museoRepository) {
        this.museoService = museoService;
        this.museoRepository = museoRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<MuseoListIdNombre> museosIdNombreList = museoService.obtenerMuseosDeApi();
        for (MuseoListIdNombre museoListIdNombre : museosIdNombreList) {
            MuseoEntity museoEntity = new MuseoEntity();
            museoEntity.setId(museoListIdNombre.getId());
            museoEntity.setNombre(museoListIdNombre.getNombre());
            museoRepository.save(museoEntity);
        }
    }
}