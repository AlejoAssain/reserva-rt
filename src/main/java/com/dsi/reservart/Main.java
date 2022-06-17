package com.dsi.reservart;

import com.dsi.reservart.controllers.ControladorReservaTurno;
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

        pantallaRT.mostrarUsuarioActivo(controladorRT);

        pantallaRT.opReservaTurno(controladorRT, tiposRT);
    }
}
