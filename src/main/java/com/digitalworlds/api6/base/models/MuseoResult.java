package com.digitalworlds.api6.base.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MuseoResult {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;
    private String email;
    private String provincia;
    private String depende_de;
    private String autoridad;
}

