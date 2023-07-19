package com.digitalworlds.api6.base.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "Museos")
public class MuseoEntity<M> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk", nullable = false)
    private Long pk;
    private Long id;
    private String nombre;
    private Long ingresos;
}
