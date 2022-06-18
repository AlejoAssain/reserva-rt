package com.dsi.reservart.models;

public class CambioEstadoRT {
    String fechaHoraDesde;
    String fechaHoraHasta;
    Estado estado;

    public CambioEstadoRT(String fhDesde, String fhHasta, Estado estado) {
        this.fechaHoraDesde = fhDesde;
        this.fechaHoraHasta = fhHasta;
        this.estado = estado;
    }
}
