package com.dsi.reservart.models;

public class Modelo {
    private String nombre;

    public Modelo(String nombreModelo) {
        this.nombre = nombreModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
