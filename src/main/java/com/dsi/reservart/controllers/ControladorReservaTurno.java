package com.dsi.reservart.controllers;

import com.dsi.reservart.models.*;
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

    public ArrayList<RecursoTecnologico> buscarRTDisponible(ArrayList<CentroDeInvestigacion> centrosDeInvestigacion, Estado estadoActivo) {
        ArrayList<RecursoTecnologico> rtDisponibles = new ArrayList<>();
        centrosDeInvestigacion.forEach((centroI) -> {
            centroI.recursosTecnologicos.forEach((recurso) -> {
                if (recurso.esDeTipo(this.tipoRTSeleccionado) && recurso.esActivo(estadoActivo)) {
                    rtDisponibles.add(recurso);//Aca vos los estabas añadiendo al Array de recursosTecnologicos, y creo que seria a rtDisponibles no?
                }
            });
        });

        return rtDisponibles;

    }

}
