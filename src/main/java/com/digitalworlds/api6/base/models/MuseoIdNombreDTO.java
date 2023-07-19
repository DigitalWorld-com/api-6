package com.digitalworlds.api6.base.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MuseoIdNombreDTO {
    private List<MuseoListIdNombre> results;
}
