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

    public int getAmbito() {
        return ambito;
    }

    public void setAmbito(int ambito) {
        this.ambito = ambito;
    }

    public Boolean getEsReservable() {
        return esReservable;
    }

    public void setEsReservable(Boolean esReservable) {
        this.esReservable = esReservable;
    }

    public Boolean getEsCancelable() {
        return esCancelable;
    }

    public void setEsCancelable(Boolean esCancelable) {
        this.esCancelable = esCancelable;
    }

    public Boolean esReservado(String nom) {
        if(nom == nombre){
            return true;
        }
        return false;
    }

    public Boolean esAmbitoTurno(int amb) {
        if(amb == ambito){
            return true;
        }
        return false;
    }

}
