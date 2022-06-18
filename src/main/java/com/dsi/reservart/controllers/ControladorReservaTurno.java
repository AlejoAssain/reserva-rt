package com.dsi.reservart.controllers;

import com.dsi.reservart.models.*;
import com.dsi.reservart.view.PantallaReservaTurno;

import java.util.ArrayList;

public class ControladorReservaTurno {
    Sesion activaSesion;
    TipoRecursoTecnologico tipoRTSeleccionado;
    ArrayList<CentroDeInvestigacion> ciConRTDisponibles;
    RecursoTecnologico recursoTecnologicoSeleccionado;

    public ControladorReservaTurno(Sesion sesion) {
        activaSesion = sesion;
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

    public Boolean buscarRTDisponible(ArrayList<CentroDeInvestigacion> centrosDeInvestigacion, Estado estadoActivo) {
        ArrayList<CentroDeInvestigacion> ciConRTDisponibles = new ArrayList<>();
//        ArrayList<RecursoTecnologico> rtDisponibles = new ArrayList<>();

        centrosDeInvestigacion.forEach((centroI) -> {
            ArrayList<RecursoTecnologico> recursoTecnologicosDisponibles = new ArrayList<>();

            centroI.recursosTecnologicos.forEach((recurso) -> {
                if (recurso.esDeTipo(this.tipoRTSeleccionado) && recurso.esActivo(estadoActivo)) {
                    recursoTecnologicosDisponibles.add(recurso);//Aca vos los estabas añadiendo al Array de recursosTecnologicos, y creo que seria a rtDisponibles no?
                }
            });
            if (recursoTecnologicosDisponibles.size() > 0) {
                centroI.setRecursosTecnologicos(recursoTecnologicosDisponibles);
                ciConRTDisponibles.add(centroI);
            }
        });

        this.ciConRTDisponibles = ciConRTDisponibles;


        if (this.ciConRTDisponibles.size() > 0) {
            return true;
        }

        return false;
    }

    public Sesion getActivaSesion() {
        return activaSesion;
    }

    public void setActivaSesion(Sesion activaSesion) {
        this.activaSesion = activaSesion;
    }

    public TipoRecursoTecnologico getTipoRTSeleccionado() {
        return tipoRTSeleccionado;
    }

    public void setTipoRTSeleccionado(TipoRecursoTecnologico tipoRTSeleccionado) {
        this.tipoRTSeleccionado = tipoRTSeleccionado;
    }

    public ArrayList<CentroDeInvestigacion> getCiConRTDisponibles() {
        return ciConRTDisponibles;
    }

    public void setCiConRTDisponibles(ArrayList<CentroDeInvestigacion> ciConRTDisponibles) {
        this.ciConRTDisponibles = ciConRTDisponibles;
    }

    public RecursoTecnologico getRecursoTecnologicoSeleccionado() {
        return recursoTecnologicoSeleccionado;
    }

    public void setRecursoTecnologicoSeleccionado(RecursoTecnologico recursoTecnologicoSeleccionado) {
        this.recursoTecnologicoSeleccionado = recursoTecnologicoSeleccionado;
    }

    public void rtSeleccionado(RecursoTecnologico rt) {
        this.recursoTecnologicoSeleccionado = rt;
    }

    public Boolean verificarCIDeCientificoYRT() {
        String nombreCIDeRT = this.recursoTecnologicoSeleccionado.getNombreCI();
        PersonalCientifico cientificoActivo = this.activaSesion.getCientificoEnSesion();

        String nombreCICientifico = "";
        for (int i = 0; i < this.ciConRTDisponibles.size(); i++) {
            CentroDeInvestigacion ci = this.ciConRTDisponibles.get(i);

            for (int j = 0; j < ci.cientificos.size(); j++) {
                AsignacionCientificoCI asignacionCientifico = ci.cientificos.get(j);
                if (asignacionCientifico.getPersonalCientifico().equals(cientificoActivo) && asignacionCientifico.esCientificoActivoDelCI()) {
                    nombreCICientifico = ci.getNombre();
                }

            }
        }

        if (nombreCICientifico != "") {;
            if (nombreCIDeRT.equals(nombreCICientifico)) {
                return true;
            }
        }

        return false;

    }
}
