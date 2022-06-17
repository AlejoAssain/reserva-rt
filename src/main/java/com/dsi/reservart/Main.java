package com.dsi.reservart;

import com.dsi.reservart.controllers.ControladorReservaTurno;
import com.dsi.reservart.models.CentroDeInvestigacion;
import com.dsi.reservart.models.RecursoTecnologico;
import com.dsi.reservart.models.TipoRecursoTecnologico;
import com.dsi.reservart.view.PantallaReservaTurno;

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

        ArrayList<RecursoTecnologico> recursosTecnologicos = new ArrayList<>(Arrays.asList(
                // agregar recursos tecnologicos
        ));

        ArrayList<CentroDeInvestigacion> centrosDeInvestigacion = new ArrayList<>(Arrays.asList(
                // agregar centros de investigacion
        ));






        pantallaRT.mostrarUsuarioActivo(controladorRT);

        pantallaRT.opReservaTurno(controladorRT, tiposRT);
    }
}
