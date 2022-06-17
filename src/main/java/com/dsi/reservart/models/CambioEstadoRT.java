package com.dsi.reservart.models;

public class CambioEstadoRT {
    String fechaHoraDesde;
    String fechaHoraHasta;
    Estado estado;

    public CambioEstadoRT() {
        this.fechaHoraDesde = "17-06-2022 10:30";
        this.estado = new Estado("disponible");
    }
}
