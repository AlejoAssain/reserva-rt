package com.dsi.reservart.models;

public class CambioEstadoRT {
    String fechaHoraDesde;
    String fechaHoraHasta;
    Estado estado;

    public CambioEstadoRT(String fhDesde, Estado estado) {
        this.fechaHoraDesde = fhDesde;
        this.estado = estado;
    }

    public String getFechaHoraDesde() {
        return fechaHoraDesde;
    }

    public void setFechaHoraDesde(String fechaHoraDesde) {
        this.fechaHoraDesde = fechaHoraDesde;
    }

    public String getFechaHoraHasta() {
        return fechaHoraHasta;
    }

    public void setFechaHoraHasta(String fechaHoraHasta) {
        this.fechaHoraHasta = fechaHoraHasta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
