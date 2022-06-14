package com.dsi.reservart.models;

public class Sesion {
    Usuario activoUsuario;
    public Sesion() {
        this.activoUsuario = new Usuario("admin", "admin");
    }

    public String getNombreUsuarioActivo() {
        return this.activoUsuario.getNombre();
    }
}
