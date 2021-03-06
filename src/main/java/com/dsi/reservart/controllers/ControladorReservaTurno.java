package com.dsi.reservart.controllers;

import com.dsi.reservart.models.*;
import com.dsi.reservart.view.PantallaReservaTurno;

import java.util.ArrayList;

public class ControladorReservaTurno {
    Sesion activaSesion;
    TipoRecursoTecnologico tipoRTSeleccionado;
    ArrayList<CentroDeInvestigacion> ciConRTDisponibles;
    RecursoTecnologico recursoTecnologicoSeleccionado;
    Turno turnoSeleccionado;

    PantallaReservaTurno pantalla;

    // getrer y setter inicio
    public ControladorReservaTurno(Sesion activaSesion, PantallaReservaTurno pantalla) {
        this.activaSesion = activaSesion;
        this.pantalla = pantalla;
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
        return this.ciConRTDisponibles;
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

    public Turno getTurnoSeleccionado() {
        return turnoSeleccionado;
    }

    public void setTurnoSeleccionado(Turno turnoSeleccionado) {
        this.turnoSeleccionado = turnoSeleccionado;
    }

    public PantallaReservaTurno getPantalla() {
        return pantalla;
    }

    public void setPantalla(PantallaReservaTurno pantalla) {
        this.pantalla = pantalla;
    }

    public void nuevaReservaDeTurno(PantallaReservaTurno pantalla, ArrayList<TipoRecursoTecnologico> tiposRT) {
        TipoRecursoTecnologico tRTSeleccionado = pantalla.solicitarSeleccionarTipoRT(tiposRT);
        this.setTipoRTSeleccionado(tRTSeleccionado);
    }

    public String obtenerNombreUsuarioActivo() {
        return this.activaSesion.getNombreUsuarioActivo();
    }

    public void buscarRTDisponible(ArrayList<CentroDeInvestigacion> centrosDeInvestigacion, Estado estadoActivo) {
        ArrayList<CentroDeInvestigacion> ciConRTDisp = new ArrayList<>();

        for (int i = 0; i < centrosDeInvestigacion.size(); i++) {
//            System.out.println("\nbuscando RT disponible de centro de investigacion " + centrosDeInvestigacion.get(i).getNombre());

            ArrayList<RecursoTecnologico> recursoTecnologicosDisponibles = new ArrayList<>();
            RecursoTecnologico recurso = null;

            for (int j = 0; j < centrosDeInvestigacion.get(i).getRecursosTecnologicos().size(); j++) {
                recurso = centrosDeInvestigacion.get(i).getRecursosTecnologicos().get(j);
//                System.out.println("tipo seleccionado: " + this.getTipoRTSeleccionado().getNombre());
//                System.out.println(recurso.esDeTipo(this.getTipoRTSeleccionado()));
//                System.out.println(recurso.esDeTipo(this.tipoRTSeleccionado));
//                System.out.println(recurso.getModelo().getNombre());
                if (recurso.esDeTipo(this.tipoRTSeleccionado) && recurso.esActivo(estadoActivo)) {
                    recursoTecnologicosDisponibles.add(recurso);
                }
            }

            if (recursoTecnologicosDisponibles.size() > 0) {
                CentroDeInvestigacion copiaCIConRTsDisponibles = new CentroDeInvestigacion(
                        centrosDeInvestigacion.get(i).getNombre(),
                        centrosDeInvestigacion.get(i).getCientificos()
                );
                copiaCIConRTsDisponibles.setRecursosTecnologicos(recursoTecnologicosDisponibles);
                ciConRTDisp.add(copiaCIConRTsDisponibles);
            }
        }

        this.ciConRTDisponibles = ciConRTDisp;
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

    public Turno solicitarSeleccionTurno() {
         return this.pantalla.solicitarSeleccionarTurno(this.recursoTecnologicoSeleccionado.getTurnos());
    }

    public int[] presentarDatosAConfirmar(){
        int[] opciones = new int[2];
        opciones[0] = this.pantalla.solicitarFormaNotificacion();
        opciones[1] = this.pantalla.solicitarConfirmacionReserva(this.recursoTecnologicoSeleccionado,this.turnoSeleccionado);
        return opciones;
    }

    public void reservarTurno(ArrayList<Estado> estados) {
        int indiceEstado = obtenerEstadoReservado(estados);
        if (indiceEstado != -1){
            Estado estadoReservado = estados.get(indiceEstado);
            this.recursoTecnologicoSeleccionado.registrarReserva(this.turnoSeleccionado, estadoReservado, this.activaSesion.getCientificoEnSesion());
            this.pantalla.msg("Turno reservado con ??xito");
        }else {
            this.pantalla.error("No se encontr?? el Estado Reservado para Turno");
            System.exit(0);
        }
    }

    private int obtenerEstadoReservado(ArrayList<Estado> estados) {
        for (int i = 0; i < estados.size(); i++) {
            Boolean ambitoTurno = estados.get(i).esAmbitoTurno(1);
            Boolean estadoReservado = estados.get(i).esReservado("Reservado");
            if(ambitoTurno && estadoReservado){
                return i;
            }
        }
        return -1;
    }

    public void generarEmail(InterfazEmail interfazEmail){
        if(interfazEmail.enviarMail(this.activaSesion.getCientificoEnSesion().getCorreoElectronicoPersonal(),
                this.activaSesion.getCientificoEnSesion().getCorreoElectronicoInstitucional(),
                "Usted tiene una nueva reserva.")){
            this.pantalla.msg("Notificaciones via mail enviadas");
        }else{
            this.pantalla.error("Notificaciones via mail no pudieron ser enviadas");
        }
    }
}
