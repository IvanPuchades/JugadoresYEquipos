package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class jugador {
    //Es como la clase Car del ejemplo de alfredo
    @Id
    private long id;
    private String nombre;
    private String apellido;
    private int canastas;
    private int asistencias;
    private String posicion;
    private int rebotes;
    private LocalDate cumpleaños;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCanastas() {
        return canastas;
    }

    public void setCanastas(int canastas) {
        this.canastas = canastas;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public LocalDate getCumpleaños() {
        return cumpleaños;
    }

    public void setCumpleaños(LocalDate cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    @Override
    public String toString() {
        return "Jugador{" + " Id: " + id + " nombre: "
                + nombre + " apellido: " + apellido +
                " canastas: " + canastas + " asistencias: "
                + asistencias + " posicion: " + asistencias +
                " rebotes: " + rebotes + " cumpleaños: " + cumpleaños +
                "}";
    }
}
