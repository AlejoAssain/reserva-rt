package com.dsi.reservart.models;

import java.util.ArrayList;

public class TipoRecursoTecnologico {
    private String nombre;
    private String descripcion;
    public ArrayList<Caracteristica> caracteristicas;


    public TipoRecursoTecnologico(String nom) {
        this.nombre = nom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
