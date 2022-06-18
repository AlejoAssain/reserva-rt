package com.dsi.reservart.models;

public class Estado {
    String nombre;
    String descripcion;
    int ambito;// 0 - RT, 1 - Turno
    Boolean esReservable;
    Boolean esCancelable;

    public Estado(String nom, int ambit) {
        this.nombre = nom;
        this.ambito = ambit;
    }
}
