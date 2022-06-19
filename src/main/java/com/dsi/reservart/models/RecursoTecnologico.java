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

    public RecursoTecnologico(
            int num,
            TipoRecursoTecnologico tipoRT,
            Modelo model,
            ArrayList<CambioEstadoRT> cambiosERT,
            ArrayList<Turno> turnos
    ) {
        this.numeroRT = num;
        this.tipoRecursoTecnologico = tipoRT;
        this.modelo = model;
        this.cambiosEstadoRT = cambiosERT;
        this.turnos = turnos;
    }

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
        CambioEstadoRT ultimoCambioEstado = this.cambiosEstadoRT.get(this.cambiosEstadoRT.size() - 1);
        return ultimoCambioEstado.estado.equals(estadoActivo);
    }



    public String getNombreEstado() {
        return this.cambiosEstadoRT.get(this.cambiosEstadoRT.size() - 1).getEstado().getNombre();
    }


    public ArrayList<Turno> getTurnos() {
        return this.turnos;
    }

    public void registrarReserva(Turno turnoselec, Estado estadoReservado, PersonalCientifico cientificoEnSesion) {
        turnoselec.reservarTurno(estadoReservado);
        centroDeInvestigacion.asignarNuevoTurno(turnoselec,cientificoEnSesion);
    }
}
