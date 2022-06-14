package com.dsi.reservart.controllers;

import com.dsi.reservart.models.Sesion;
import com.dsi.reservart.models.Usuario;
import com.dsi.reservart.view.PantallaReservaTurno;

public class ControladorReservaTurno {
    Sesion activaSesion;

    public ControladorReservaTurno() {
        activaSesion = new Sesion();
    }

    public String obtenerNombreUsuarioActivo() {
        return this.activaSesion.getNombreUsuarioActivo();
    }



}
