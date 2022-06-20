package com.dsi.reservart;

import com.dsi.reservart.controllers.ControladorReservaTurno;
import com.dsi.reservart.models.*;
import com.dsi.reservart.view.PantallaReservaTurno;
import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        PersonalCientifico activoCientifico = new PersonalCientifico("víctormendizabal@gmail.com","víctormendizabal@unc.edu.ar");
        Usuario activoUsuario = new Usuario("admin", "admin", activoCientifico);
        Sesion activaSesion = new Sesion(activoUsuario);
        InterfazEmail interfazEmail = new InterfazEmail();


        PantallaReservaTurno pantallaRT = new PantallaReservaTurno();
        ControladorReservaTurno controladorRT = new ControladorReservaTurno(activaSesion,pantallaRT);

        ArrayList<TipoRecursoTecnologico> tiposRT = new ArrayList<>(Arrays.asList(
                new TipoRecursoTecnologico("Balanza de precision"),
                new TipoRecursoTecnologico("Microscopio de medicion")
        ));

        ArrayList<Modelo> modelos = new ArrayList<>(Arrays.asList(
                new Modelo("TXB622L"),
                new Modelo("LBAL-20 / BALP-001"),
                new Modelo("MM-400/800"),
                new Modelo("TXB622L"),
                new Modelo("YZ-002"),
                new Modelo("RM-231")
        ));

        ArrayList<Marca> marcas = new ArrayList<>(Arrays.asList(
                new Marca(
                        new ArrayList<Modelo>(modelos.subList(0,3)),
                        "Shidmazu"),
                new Marca(
                        new ArrayList<Modelo>(modelos.subList(3,6))
                        ,"Nikon")
        ));

        modelos.get(0).setMarca(marcas.get(0));
        modelos.get(1).setMarca(marcas.get(0));
        modelos.get(2).setMarca(marcas.get(0));
        modelos.get(3).setMarca(marcas.get(1));
        modelos.get(4).setMarca(marcas.get(1));
        modelos.get(5).setMarca(marcas.get(1));

        ArrayList<Estado> estados = new ArrayList<>(Arrays.asList(
                new Estado("Activo",0),//RT
                new Estado("Baja técnica",0),//RT
                new Estado("Baja definitiva",0),//RT
                new Estado("Disponible",1),//turno
                new Estado("Reservado",1)//turno

        ));

        ArrayList<CambioEstadoRT> cambiosEstadoRT = new ArrayList<>(Arrays.asList(
                new CambioEstadoRT("18/06/2022 11:00:00",estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:01:00",estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:02:00",estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:03:00",estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:04:00",estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:05:00",estados.get(0))
        ));

        ArrayList<CambioEstadoTurno> cambiosEstadoTurnos = new ArrayList<>(Arrays.asList(
                new CambioEstadoTurno("18/06/2022 11:00:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:00:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:00:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:00:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:01:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:01:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:01:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:01:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:02:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:02:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:02:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:02:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:03:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:03:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:03:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:03:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:04:00",estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:05:00",estados.get(3))
        ));

        ArrayList<Turno> turnos = new ArrayList<>(Arrays.asList(
                new Turno("18/06/2022 11:00:00","Martes","21/06/2022 16:00:00","21/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(0)))),//rt0
                new Turno("18/06/2022 11:01:00","Martes","21/06/2022 16:00:00","21/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(1)))),//rt1
                new Turno("18/06/2022 11:02:00","Martes","21/06/2022 16:00:00","21/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(2)))),//rt2
                new Turno("18/06/2022 11:03:00","Martes","21/06/2022 16:00:00","21/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(3)))),//rt3
                new Turno("18/06/2022 11:00:00","Martes","21/06/2022 18:00:00","21/06/2022 20:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(4)))),//rt0
                new Turno("18/06/2022 11:01:00","Martes","21/06/2022 18:00:00","21/06/2022 20:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(5)))),//rt1
                new Turno("18/06/2022 11:02:00","Martes","21/06/2022 18:00:00","21/06/2022 20:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(6)))),//rt2
                new Turno("18/06/2022 11:03:00","Martes","21/06/2022 18:00:00","21/06/2022 20:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(7)))),//rt3
                new Turno("18/06/2022 11:00:00","Miércoles","22/06/2022 16:00:00","22/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(8)))),//rt0
                new Turno("18/06/2022 11:01:00","Miércoles","22/06/2022 16:00:00","22/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(9)))),//rt1
                new Turno("18/06/2022 11:02:00","Miércoles","22/06/2022 16:00:00","22/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(10)))),//rt2
                new Turno("18/06/2022 11:03:00","Miércoles","22/06/2022 16:00:00","22/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(11)))),//rt3
                new Turno("18/06/2022 11:00:00","Miércoles","22/06/2022 18:00:00","22/06/2022 20:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(12)))),//rt0
                new Turno("18/06/2022 11:01:00","Miércoles","22/06/2022 18:00:00","22/06/2022 20:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(13)))),//rt1
                new Turno("18/06/2022 11:02:00","Miércoles","22/06/2022 18:00:00","22/06/2022 20:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(14)))),//rt2
                new Turno("18/06/2022 11:03:00","Miércoles","22/06/2022 18:00:00","22/06/2022 20:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(15)))),//rt3
                new Turno("18/06/2022 11:04:00","Martes","21/06/2022 16:00:00","21/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(16)))),//rt4
                new Turno("18/06/2022 11:05:00","Martes","21/06/2022 16:00:00","21/06/2022 18:00:00",new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(17))))//rt5
        ));


        // Aca le agregue al constructor la lista con cambiosEstadoRT. Rodrigo
        ArrayList<RecursoTecnologico> recursosTecnologicos = new ArrayList<>(Arrays.asList(
                new RecursoTecnologico(1, tiposRT.get(0), modelos.get(0), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(0))), new ArrayList<Turno>(Arrays.asList(turnos.get(0),turnos.get(4),turnos.get(8),turnos.get(12)))),
                new RecursoTecnologico(2, tiposRT.get(0), modelos.get(1), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(1))), new ArrayList<Turno>(Arrays.asList(turnos.get(1),turnos.get(5),turnos.get(9),turnos.get(13)))),
                new RecursoTecnologico(3, tiposRT.get(1), modelos.get(2), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(2))), new ArrayList<Turno>(Arrays.asList(turnos.get(2),turnos.get(6),turnos.get(10),turnos.get(14)))),
                new RecursoTecnologico(4, tiposRT.get(1), modelos.get(3), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(3))), new ArrayList<Turno>(Arrays.asList(turnos.get(3),turnos.get(7),turnos.get(11),turnos.get(15)))),
                new RecursoTecnologico(5, tiposRT.get(0), modelos.get(4), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(4))), new ArrayList<Turno>(Arrays.asList(turnos.get(16)))),
                new RecursoTecnologico(6, tiposRT.get(1), modelos.get(5), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(4))), new ArrayList<Turno>(Arrays.asList(turnos.get(17))))
        ));

        ArrayList<PersonalCientifico> cientificos = new ArrayList<>(Arrays.asList(
                activoCientifico,
                new PersonalCientifico("pepitamontserrat@gmail.com","pepitamontserrat@unc.edu.ar"),
                new PersonalCientifico("clarisalobo@gmail.com","clarisalobo@unc.edu.ar"),
                new PersonalCientifico("rafaelrocamora@gmail.com","rafaelrocamora@unc.edu.ar")
        ));

        ArrayList<AsignacionCientificoCI> asignacionesCientificos = new ArrayList<>(Arrays.asList(
                new AsignacionCientificoCI(cientificos.get(0)),
                new AsignacionCientificoCI(cientificos.get(1)),
                new AsignacionCientificoCI(cientificos.get(2)),
                new AsignacionCientificoCI(cientificos.get(3))
        ));


        CentroDeInvestigacion ci1 = new CentroDeInvestigacion(
                "Facultad Cs. Quimicas",
                new ArrayList<AsignacionCientificoCI>(asignacionesCientificos.subList(0, 2))
        );

        // asigno recursos tecnologicos a centro de investigacion 1
        ci1.setRecursosTecnologicos(recursosTecnologicos);
        recursosTecnologicos.forEach((rt) -> {
            rt.setCentroDeInvestigacion(ci1);
        });

        // asigno recursos tecnologicos a centro de investigacion 2


        CentroDeInvestigacion ci2 = new CentroDeInvestigacion(
                "Facultad de Cs. Exactas",
                new ArrayList<AsignacionCientificoCI>(asignacionesCientificos.subList(2, 4))
        );

        ArrayList<CentroDeInvestigacion> centrosDeInvestigacion = new ArrayList<>(Arrays.asList(
                ci1,
                ci2
        ));





        pantallaRT.mostrarUsuarioActivo(controladorRT);

        Integer seleccionMenu = pantallaRT.solicitarOpcionContinuar();

        while (seleccionMenu == 1) {
            pantallaRT.opReservaTurno(controladorRT, tiposRT);
            // en este punto ya tenemos al controlador con el tipoRTSeleccionado

            // va a dejar en clase controlador a los centros de investigacion con RTs disponibles
            controladorRT.buscarRTDisponible(centrosDeInvestigacion, estados.get(0));

            RecursoTecnologico rtSeleccionadoPorPantalla = pantallaRT.solicitarSeleccionarRT(controladorRT.getCiConRTDisponibles());

            // define rt seleccionado como atributo de controlador
            controladorRT.rtSeleccionado(rtSeleccionadoPorPantalla);

            Boolean comparacion = controladorRT.verificarCIDeCientificoYRT();

            if (!comparacion) {
                pantallaRT.error("Ustedes no pertenece al mismo centro de investigacion que el recurso tecnologico...");
            } else {

                //Paso 9

                //SON EJEMPLOS. ELIMINAR APENAS SE TERMINE DE UTILIZAR
                //controladorRT.setRecursoTecnologicoSeleccionado(recursosTecnologicos.get(0));
                //controladorRT.setTurnoSeleccionado(turnos.get(0));

                // solicitar seleccion de turno

                Turno turnoSeleccionado = controladorRT.solicitarSeleccionTurno();

                if (turnoSeleccionado.esDisponible()) {

                    controladorRT.setTurnoSeleccionado(turnoSeleccionado);

                    int[] opsConfirmacion = controladorRT.presentarDatosAConfirmar();
                    //System.out.println(opcionesConfirmacion[0]);
                    if (opsConfirmacion[1] == 1) {
                        controladorRT.reservarTurno(estados);
                        if (opsConfirmacion[0] == 0) {
                            controladorRT.generarEmail(interfazEmail);
                        } else if (opsConfirmacion[0] == 1) {

                        } else if (opsConfirmacion[0] == 2) {
                            controladorRT.generarEmail(interfazEmail);
                        }
                    }

                    // asignar el nuevo rt al ci del main

                    centrosDeInvestigacion.forEach((ci) -> {
                        ci.setRecursoTecnologicoModificado(controladorRT.getRecursoTecnologicoSeleccionado());
                    });
                } else {
                    pantallaRT.error("\n\nEL TURNO SELECCIONADO NO ES UN TURNO DISPONIBLE");
                }
            }

            seleccionMenu = pantallaRT.solicitarOpcionContinuar();
        }
    }
}
