package com.digitalworlds.api6.base.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MuseoList {
    private Long id;
    private String url;
    private String link;
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;
    private String email;
    private String provincia;
    private String depende_de;
    private String autoridad;
}
