package com.dsi.reservart.models;

public class Usuario {
    String nombre;
    String clave;
    Boolean habilitado;
    PersonalCientifico personalCientifico;

    public Usuario(String nom, String con, PersonalCientifico cientifico) {
        this.nombre = nom;
        this.clave = con;
        this.habilitado = true;
        this.personalCientifico = cientifico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esClave(String claveInput) {
        return this.clave.equals(claveInput);
    }

    public boolean esHabilitado() { return this.habilitado; }

    public PersonalCientifico getCientifico() {
        return this.personalCientifico;
    }
}
