package com.dsi.reservart.controllers;

import com.dsi.reservart.models.Estado;
import com.dsi.reservart.models.RecursoTecnologico;
import com.dsi.reservart.models.Sesion;
import com.dsi.reservart.models.TipoRecursoTecnologico;
import com.dsi.reservart.view.PantallaReservaTurno;

import java.util.ArrayList;

public class ControladorReservaTurno {
    Sesion activaSesion;
    TipoRecursoTecnologico tipoRTSeleccionado;

    public ControladorReservaTurno() {
        activaSesion = new Sesion();
    }

    public void nuevaReservaDeTurno(PantallaReservaTurno pantalla, ArrayList<TipoRecursoTecnologico> tiposRT) {
        pantalla.solicitarSeleccionarTipoRT(this, tiposRT);
    }

    public void tipoRTSeleccionado(TipoRecursoTecnologico tipoRT) {
        this.tipoRTSeleccionado = tipoRT;
    }

    public String obtenerNombreUsuarioActivo() {
        return this.activaSesion.getNombreUsuarioActivo();
    }

    public void buscarRTDisponible(ArrayList<RecursoTecnologico> recursosTecnologicos, Estado estadoActivo) {
        ArrayList<RecursoTecnologico> rtDisponibles = new ArrayList<>();
        recursosTecnologicos.forEach((recurso) -> {
            if (recurso.esDeTipo(this.tipoRTSeleccionado) && recurso.esActivo(estadoActivo)) {
                rtDisponibles.add(recurso);//Aca vos los estabas añadiendo al Array de recursosTecnologicos, y creo que seria a rtDisponibles no?
            }
        });
    }

}
