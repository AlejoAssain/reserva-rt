package com.dsi.reservart;

import com.dsi.reservart.controllers.ControladorReservaTurno;
import com.dsi.reservart.models.*;
import com.dsi.reservart.view.PantallaReservaTurno;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String [] args) {
        ControladorReservaTurno controladorRT = new ControladorReservaTurno();
        PantallaReservaTurno pantallaRT = new PantallaReservaTurno();

        ArrayList<TipoRecursoTecnologico> tiposRT = new ArrayList<>(Arrays.asList(
                new TipoRecursoTecnologico("Balanza de precision"),
                new TipoRecursoTecnologico("Microscopio de medicion")
        ));

        ArrayList<Modelo> modelos = new ArrayList<>(Arrays.asList(
                new Modelo("TXB622L"),
                new Modelo("LBAL-20 / BALP-001"),
                new Modelo("MM-400/800"),
                new Modelo("TXB622L")
        ));

        ArrayList<Marca> marcas = new ArrayList<>(Arrays.asList(
                new Marca(
                        new ArrayList<Modelo>(modelos.subList(0,2)),
                        "Shidmazu"),
                new Marca(
                        new ArrayList<Modelo>(modelos.subList(2,4))
                        ,"Nikon")
        ));
        // Cree los estados. Rodrigo
        ArrayList<Estado> estados = new ArrayList<>(Arrays.asList(
                new Estado("Activo",0),//RT
                new Estado("Baja técnica",0),//RT
                new Estado("Baja definitiva",0),//RT
                new Estado("Disponible",1),//turno
                new Estado("Reservado",1)//turno

        ));

        // Cree los cambiosEstadoRT. Rodrigo
        ArrayList<CambioEstadoRT> cambiosEstadoRT = new ArrayList<>(Arrays.asList(
                new CambioEstadoRT("18/06/2022 11:00:00",estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:01:00",estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:02:00",estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:03:00",estados.get(0))
        ));

        // Aca le agregue al constructor la lista con cambiosEstadoRT. Rodrigo
        ArrayList<RecursoTecnologico> recursosTecnologicos = new ArrayList<>(Arrays.asList(
                new RecursoTecnologico(1, tiposRT.get(0), modelos.get(0), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(0)))),
                new RecursoTecnologico(2, tiposRT.get(0), modelos.get(1), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(1)))),
                new RecursoTecnologico(3, tiposRT.get(1), modelos.get(2), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(2)))),
                new RecursoTecnologico(4, tiposRT.get(1), modelos.get(3), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(3))))
        ));

        ArrayList<PersonalCientifico> cientificos = new ArrayList<>(Arrays.asList(
                new PersonalCientifico(),
                new PersonalCientifico(),
                new PersonalCientifico(),
                new PersonalCientifico()
        ));

        ArrayList<AsignacionCientificoCI> asignacionesCientificos = new ArrayList<>(Arrays.asList(
                new AsignacionCientificoCI(cientificos.get(0)),
                new AsignacionCientificoCI(cientificos.get(1)),
                new AsignacionCientificoCI(cientificos.get(2)),
                new AsignacionCientificoCI(cientificos.get(3))
        ));

        ArrayList<CentroDeInvestigacion> centrosDeInvestigacion = new ArrayList<>(Arrays.asList(
                new CentroDeInvestigacion(
                        "centroInvestigacion1",
                        new ArrayList<AsignacionCientificoCI>(asignacionesCientificos.subList(0, 2))

        )));

        centrosDeInvestigacion.get(0).setRecursosTecnologicos(recursosTecnologicos);
        recursosTecnologicos.forEach((rt) -> {
            rt.setCentroDeInvestigacion(centrosDeInvestigacion.get(0));
        });

        pantallaRT.mostrarUsuarioActivo(controladorRT);

        pantallaRT.opReservaTurno(controladorRT, tiposRT);
        // en este punto ya tenemos al controlador con el tipoRTSeleccionado

        controladorRT.buscarRTDisponible(recursosTecnologicos, estados.get(0) );

    }
}
