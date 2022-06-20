package com.dsi.reservart.models;

import java.util.ArrayList;

public class Turno {
    private String fechaGeneracion;
    private String diaSemana;
    private String fechaHoraInicio;
    private String fechaHoraFin;
    public ArrayList<CambioEstadoTurno> cambiosEstadoTurno;

    public Turno(String fechaGeneracion, String diaSemana, String fechaHoraInicio, String fechaHoraFin, ArrayList<CambioEstadoTurno> cambioEstadoTurno) {
        this.fechaGeneracion = fechaGeneracion;
        this.diaSemana = diaSemana;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.cambiosEstadoTurno = cambioEstadoTurno;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(String fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public ArrayList<CambioEstadoTurno> getCambioEstadoTurno() {
        return cambiosEstadoTurno;
    }

    public void setCambioEstadoTurno(ArrayList<CambioEstadoTurno> cambioEstadoTurno) {
        this.cambiosEstadoTurno = cambioEstadoTurno;
    }

    public void reservarTurno(Estado estadoReservado){
        ManejadorFechas manejadorFechas = new ManejadorFechas();
        cambiosEstadoTurno.forEach((estadoTurno) -> {
            esActual(estadoTurno);
        });
        cambiosEstadoTurno.add(new CambioEstadoTurno(manejadorFechas.actualDateTimeToString(),estadoReservado));
    }

    public void esActual(CambioEstadoTurno cambioEstado){
        if (cambioEstado.getFechaHoraHasta()==null){
            cambioEstado.finalizar();
        }
    }

    public String getNombreEstadoActual() {
        return cambiosEstadoTurno.get(this.cambiosEstadoTurno.size() - 1).getNombreEstado();
    }
}
