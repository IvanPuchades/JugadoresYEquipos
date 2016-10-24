package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class equipo {
    @Id
    private long id;
    private String nombre;
    private String localidad;
    private LocalDate creacion;
}
