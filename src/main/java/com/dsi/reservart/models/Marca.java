package com.dsi.reservart.models;

import java.util.ArrayList;

public class Marca {
    ArrayList<Modelo> modelos;
    String nombre;

    public Marca(ArrayList<Modelo> modelos, String nombre) {
        this.modelos = modelos;
        this.nombre = nombre;
    }

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<Modelo> modelos) {
        this.modelos = modelos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
