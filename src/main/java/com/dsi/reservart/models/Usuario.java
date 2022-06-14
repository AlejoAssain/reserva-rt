package com.dsi.reservart.models;

public class Usuario {
    String nombre;
    String contrasena;

    public Usuario(String nom, String con) {
        this.nombre = nom;
        this.contrasena = con;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esContrasena(String contrasenaInput) {
        return this.contrasena.equals(contrasenaInput);
    }
}
