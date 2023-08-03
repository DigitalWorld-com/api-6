package com.digitalworlds.api6.base.controllers;

import com.digitalworlds.api6.base.entities.MuseoEntity;
import com.digitalworlds.api6.base.models.MuseoDTO;
import com.digitalworlds.api6.base.models.MuseoIdNombreDTO;
import com.digitalworlds.api6.base.models.MuseoList;
import com.digitalworlds.api6.base.models.MuseoListIdNombre;
import com.digitalworlds.api6.base.services.MuseoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MuseoController.class)
class MuseoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MuseoService mockedMuseoService;
    private static ObjectMapper mapper = new ObjectMapper();
    @Test
    void getData() throws Exception{

    }

    @Test
    void getDataFromTable() throws Exception {
        Long museoId = 1L;
        String museoName = "Fruit";

        MuseoListIdNombre museoList = new MuseoListIdNombre(museoId,museoName);


    }

    @SneakyThrows
    @Test
    void postMuseos() {
        MuseoListIdNombre museoLid = new MuseoListIdNombre(1L, "Hola");

        mockMvc.perform(post("/api6/museos_completos", museoLid)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(museoLid)))
                .andDo(print())
                //.andExpect(content().json(jsonPath("$.greeting", "hola")))
                .andExpect(status().isCreated());

        verify(mockedMuseoService, times(1)).crearMuseo(1L,"Hola");
        verify(mockedMuseoService, times(0)).getMuseoById(1L);
    }

    @Test
    void getByPVId() {
    }

    @Test
    void museoInsertar() {
    }

    @Test
    void getByRMId() {
    }
}