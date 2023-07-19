package com.digitalworlds.api6.base.services;

import com.digitalworlds.api6.base.models.MuseoDTO;
import com.digitalworlds.api6.base.models.MuseoListIdNombre;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface iMuseoService {
    List<MuseoListIdNombre> procesarLlamadaApi() throws JsonProcessingException;

    List<MuseoDTO> getObjects();

}
