package com.dsi.reservart.models;

public class Modelo {
    private String nombre;

    public Modelo(String nombreModelo) {
        this.nombre = nombreModelo;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
