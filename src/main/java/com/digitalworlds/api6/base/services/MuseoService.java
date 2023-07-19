package com.digitalworlds.api6.base.services;

import com.digitalworlds.api6.base.entities.MuseoEntity;
import com.digitalworlds.api6.base.models.*;
import com.digitalworlds.api6.base.repositories.iMuseoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MuseoService implements iMuseoService {

    private iMuseoRepository museoRepository;
    private ModelMapper modeloMapeado;

    public MuseoService(final iMuseoRepository museoRepository,
                        final ModelMapper modeloMapeado) {
        this.museoRepository = museoRepository;
        this.modeloMapeado = modeloMapeado;
    }

    public List<MuseoListIdNombre> obtenerMuseosDeApi() throws JsonProcessingException {
        RestTemplate apiMuseo = new RestTemplate();
        Museo respuesta = apiMuseo.getForObject("https://www.cultura.gob.ar/api/v2.0/museos/", Museo.class);

        List<MuseoListIdNombre> museosIdNombre = new ArrayList<>();

        for (MuseoList museo : respuesta.getResults()) {
            MuseoListIdNombre museoIdNombre = new MuseoListIdNombre(museo.getId(), museo.getNombre());
            museosIdNombre.add(museoIdNombre);
        }

        return museosIdNombre;
    }

    @Override
    public List<MuseoListIdNombre> procesarLlamadaApi() throws JsonProcessingException {
        RestTemplate apiMuseo = new RestTemplate();
        Museo respuesta = apiMuseo.getForObject("https://www.cultura.gob.ar/api/v2.0/museos/", Museo.class);

        List<MuseoListIdNombre> museosIdNombre = new ArrayList<>();

        for (MuseoList museo : respuesta.getResults()) {
            MuseoListIdNombre museoIdNombre = new MuseoListIdNombre(museo.getId(), museo.getNombre());
            museosIdNombre.add(museoIdNombre);
        }

        return museosIdNombre;
    }
    /*public MuseoDTO procesarLlamadaApi() throws JsonProcessingException {
        RestTemplate apiMuseo = new RestTemplate();
        Museo respuesta = apiMuseo.getForObject("https://www.cultura.gob.ar/api/v2.0/museos/", Museo.class);

        /*MuseoObjeto museoObjeto =new MuseoObjeto();
        museoObjeto.setResults(respuesta.getResults());
        return museoObjeto;
        MuseoDTO museoDTO = new MuseoDTO();
        museoDTO.setResults(List.of(respuesta.getResults()));

        return museoDTO;
    }**/

    @Override
    public List<MuseoDTO> getObjects() {
        List<MuseoDTO> museoDTOS = new ArrayList<>();
        return modeloMapeado.map(museoRepository.findAll(), museoDTOS.getClass());
    }

    public MuseoEntity getMuseoById(Long id) throws JsonProcessingException {
        MuseoEntity museoEntity=null;
        if(!museoRepository.findById(id).isEmpty()){
            museoEntity=museoRepository.findById(id).get();
                Long ingresosActuales = museoEntity.getIngresos();
                if (ingresosActuales != null) {
                    museoEntity.setIngresos(ingresosActuales + 1);
                } else {
                    museoEntity.setIngresos(1L);
                }
                museoRepository.save(museoEntity);
        };
        return museoEntity;

    }
}
