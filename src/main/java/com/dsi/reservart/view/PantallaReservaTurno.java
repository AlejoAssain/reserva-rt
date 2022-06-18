package com.dsi.reservart.view;

import com.dsi.reservart.controllers.ControladorReservaTurno;
import com.dsi.reservart.models.CentroDeInvestigacion;
import com.dsi.reservart.models.Estado;
import com.dsi.reservart.models.RecursoTecnologico;
import com.dsi.reservart.models.TipoRecursoTecnologico;

import java.util.ArrayList;
import java.util.Scanner;

public class PantallaReservaTurno {
    Scanner scanner;
    public PantallaReservaTurno (){
        this.scanner = new Scanner(System.in);
    }
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
        int seleccion;

        System.out.println("\nSELECCIONE UN TIPO DE RECURSO TECNOLOGICO");
        seleccion = this.scanner.nextInt();


        controlador.tipoRTSeleccionado(tiposRT.get(seleccion - 1));

    }


//    public void tipoRTSeleccionado(
//            ControladorReservaTurno controlador,
//            ArrayList<CentroDeInvestigacion> centrosDeInvestigacion,
//            Estado estadoActivo
//    ) {
//        controlador.buscarRTDisponible(centrosDeInvestigacion, estadoActivo);
//    }

    public RecursoTecnologico solicitarSeleccionarRT(ArrayList<CentroDeInvestigacion> centrosDeInvestigacion) {
        for (int i = 0; i < centrosDeInvestigacion.size(); i++) {
            CentroDeInvestigacion ci = centrosDeInvestigacion.get(i);
            System.out.println("\nCI nro " + (i + 1) + "- " + ci.getNombre() + ":");
            for (int j = 0; j < ci.getRecursosTecnologicos().size(); j++) {
                RecursoTecnologico rt = ci.getRecursosTecnologicos().get(j);
                System.out.println("\n  RT nro " + (j + 1));
                System.out.println("    Numero de inventario: " + rt.getNumeroRT());
//                System.out.println(rt.getMarca());
                System.out.println("    Modelo: " + rt.getModelo().getNombre());
                System.out.println("    Estado: " + rt.getNombreEstado());
            };
        };

        int seleccionCI;
        int seleccionRT;

        System.out.println("\nSELECCIONE UN CENTRO DE INVESTIGACION");
        seleccionCI = this.scanner.nextInt();

        System.out.println("\nSELECCIONE UN RT");
        seleccionRT = this.scanner.nextInt();


        int indiceCI = seleccionCI - 1;
        int indiceRT = seleccionRT - 1;

        return centrosDeInvestigacion.get(indiceCI).getRecursosTecnologicos().get(indiceRT);
    }
}
