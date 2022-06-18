package com.dsi.reservart.models;

import java.util.ArrayList;

public class CentroDeInvestigacion {
    private String nombre;
    private String sigla;
    private String direccion;
    private String edificio;
    private String piso;
    private String coordenadas;
    private String telefonosContacto;
    private String correoElectronico;
    private String numeroResolucionCreacion;
    private String fechaResolucionCreacion;
    private String reglamento;
    private String caracteristicasGenerales;
    private String fechaAlta;
    private String teimpoAntelacionReserva;
    private String fechaBaja;
    private String moticoBaja;
    public ArrayList<AsignacionCientificoCI> cientificos;
    public ArrayList<RecursoTecnologico> recursosTecnologicos;
    public ArrayList<AsignacionDirectorCI> directores;

    public CentroDeInvestigacion(String nom, ArrayList<AsignacionCientificoCI> cientificos) {
        this.nombre = nom;
        this.cientificos = cientificos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getTelefonosContacto() {
        return telefonosContacto;
    }

    public void setTelefonosContacto(String telefonosContacto) {
        this.telefonosContacto = telefonosContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroResolucionCreacion() {
        return numeroResolucionCreacion;
    }

    public void setNumeroResolucionCreacion(String numeroResolucionCreacion) {
        this.numeroResolucionCreacion = numeroResolucionCreacion;
    }

    public String getFechaResolucionCreacion() {
        return fechaResolucionCreacion;
    }

    public void setFechaResolucionCreacion(String fechaResolucionCreacion) {
        this.fechaResolucionCreacion = fechaResolucionCreacion;
    }

    public String getReglamento() {
        return reglamento;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
    }

    public String getCaracteristicasGenerales() {
        return caracteristicasGenerales;
    }

    public void setCaracteristicasGenerales(String caracteristicasGenerales) {
        this.caracteristicasGenerales = caracteristicasGenerales;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getTeimpoAntelacionReserva() {
        return teimpoAntelacionReserva;
    }

    public void setTeimpoAntelacionReserva(String teimpoAntelacionReserva) {
        this.teimpoAntelacionReserva = teimpoAntelacionReserva;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getMoticoBaja() {
        return moticoBaja;
    }

    public void setMoticoBaja(String moticoBaja) {
        this.moticoBaja = moticoBaja;
    }

    public ArrayList<AsignacionCientificoCI> getCientificos() {
        return cientificos;
    }

    public void setCientificos(ArrayList<AsignacionCientificoCI> cientificos) {
        this.cientificos = cientificos;
    }

    public ArrayList<RecursoTecnologico> getRecursosTecnologicos() {
        return recursosTecnologicos;
    }

    public void setRecursosTecnologicos(ArrayList<RecursoTecnologico> recursosTecnologicos) {
        this.recursosTecnologicos = recursosTecnologicos;
    }

    public ArrayList<AsignacionDirectorCI> getDirectores() {
        return directores;
    }

    public void setDirectores(ArrayList<AsignacionDirectorCI> directores) {
        this.directores = directores;
    }
}
