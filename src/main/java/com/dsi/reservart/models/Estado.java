package com.dsi.reservart.models;

public class Estado {
    String nombre;
    String descripcion;
    String ambito;
    Boolean esReservable;
    Boolean esCancelable;

    public Estado(String nom) {
        this.nombre = nom;
    }
}
