package com.dsi.reservart.models;

import java.util.ArrayList;

public class RecursoTecnologico {
    int numeroRT;
    ArrayList<Turno> turnos;
    ArrayList<HorarioRT> disponibilidad;
    TipoRecursoTecnologico tipoRecursoTecnologico;
    ArrayList<CambioEstadoRT> cambiosEstadoRT;
    String periodicidadMantenimientoPrev;
    int duracionMantenimientoPrev;
    int fraccionHorarioTurno;
    ArrayList<Mantenimiento> manteniminetos;
    ArrayList<CaracteristicaRecurso> caracteristicasRecursos;
    String fechaAlta;
    CentroDeInvestigacion centroDeInvestigacion;
    Modelo modelo;

    public int getNumeroRT() {
        return numeroRT;
    }

    public void setNumeroRT(int numeroRT) {
        this.numeroRT = numeroRT;
    }

    public ArrayList<CambioEstadoRT> getCambiosEstadoRT() {
        return cambiosEstadoRT;
    }

    public void setCambiosEstadoRT(ArrayList<CambioEstadoRT> cambiosEstadoRT) {
        this.cambiosEstadoRT = cambiosEstadoRT;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public RecursoTecnologico(
            int num,
            TipoRecursoTecnologico tipoRT,
            Modelo model,
          ArrayList<CambioEstadoRT> cambiosERT
    ) {
        this.numeroRT = num;
        this.tipoRecursoTecnologico = tipoRT;
        this.modelo = model;
        this.cambiosEstadoRT = cambiosERT;
    }

    public void generarTurnos() {
        
    }

    public void setCentroDeInvestigacion(CentroDeInvestigacion ci) {
        this.centroDeInvestigacion = ci;
    }

    public String getNombreCI() {
        return this.centroDeInvestigacion.getNombre();
    }

    public Boolean esDeTipo(TipoRecursoTecnologico tipoRT) {
        return this.tipoRecursoTecnologico.equals(tipoRT);
    }

    public Boolean esActivo(Estado estadoActivo) {
        CambioEstadoRT ultimoCambioEstado = this.cambiosEstadoRT.get(this.cambiosEstadoRT.size()-1);
        return ultimoCambioEstado.estado.equals(estadoActivo);
    }

}
