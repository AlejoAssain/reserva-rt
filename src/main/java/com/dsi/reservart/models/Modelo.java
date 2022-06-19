package com.dsi.reservart.models;

public class Modelo {
    private String nombre;
    public Marca marca;

    public Modelo(String nombreModelo) {
        this.nombre = nombreModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
