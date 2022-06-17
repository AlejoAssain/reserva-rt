package com.dsi.reservart.view;

import com.dsi.reservart.controllers.ControladorReservaTurno;
import com.dsi.reservart.models.TipoRecursoTecnologico;

import java.util.ArrayList;
import java.util.Scanner;

public class PantallaReservaTurno {
    public void mostrarUsuarioActivo(ControladorReservaTurno controlador) {
        System.out.println("  -- Sesion activa de usuario: " + controlador.obtenerNombreUsuarioActivo() + " --\n");
    }

    public void opReservaTurno(ControladorReservaTurno controlador, ArrayList<TipoRecursoTecnologico> tiposRT) {
        controlador.nuevaReservaDeTurno(this, tiposRT);
    }

    public void solicitarSeleccionarTipoRT(ControladorReservaTurno controlador, ArrayList<TipoRecursoTecnologico> tiposRT) {
        for (int i = 0; i < tiposRT.size(); i++) {
            System.out.println((i + 1) + "- " + tiposRT.get(i).getNombre());
        }

        Scanner input = new Scanner(System.in);
        int seleccion;
        try {
            System.out.println("\nSELECCIONE UN TIPO DE RECURSO TECNOLOGICO");
            seleccion = input.nextInt();
        } finally {
            input.close();
        }

        controlador.tipoRTSeleccionado(tiposRT.get(seleccion - 1));

    }
}
