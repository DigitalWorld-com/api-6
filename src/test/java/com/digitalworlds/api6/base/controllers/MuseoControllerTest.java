package com.digitalworlds.api6.base.controllers;

import com.digitalworlds.api6.base.entities.MuseoEntity;
import com.digitalworlds.api6.base.models.MuseoDTO;
import com.digitalworlds.api6.base.models.MuseoIdNombreDTO;
import com.digitalworlds.api6.base.models.MuseoList;
import com.digitalworlds.api6.base.models.MuseoListIdNombre;
import com.digitalworlds.api6.base.services.MuseoService;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MuseoController.class)
class MuseoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MuseoService mockedMuseoService;

    @Test
    void getData() throws Exception{

    }

    @Test
    void getDataFromTable() throws Exception {
        Long museoId = 1L;
        String museoName = "Fruit";

        MuseoListIdNombre museoList = new MuseoListIdNombre(museoId,museoName);


    }

    @Test
    void postMuseos() {
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