package com.dsi.reservart;

import com.dsi.reservart.controllers.ControladorReservaTurno;
import com.dsi.reservart.view.PantallaReservaTurno;

public class Main {
    public static void main(String [] args) {
        ControladorReservaTurno controladorRT = new ControladorReservaTurno();
        PantallaReservaTurno pantallaRT = new PantallaReservaTurno();

        pantallaRT.mostrarUsuarioActivo(controladorRT.obtenerNombreUsuarioActivo());
    }
}
