package com.dsi.reservart.models;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursoTecnologico {
    int numeroRT;
    ArrayList<Turno> turnos;
    ArrayList<HorarioRT> disponibilidad;
    TipoRecursoTecnologico tipoRecursoTecnologico;
    ArrayList<CambioEstadoRT> cambiosEstadoRT;
    String periodicidadMantenimientoPrev;
    int duracionMantenimientoPrev;
    int fraccionHorarioTurno;
    ArrayList<Mantenimiento> manteniminetos;
    ArrayList<CaracteristicaRecurso> caracteristicasRecursos;
    String fechaAlta;
    CentroDeInvestigacion centroDeInvestigacion;
    Modelo modelo;

    public RecursoTecnologico(
            int num,
            TipoRecursoTecnologico tipoRT,
            Modelo modelo
    ) {
        this.numeroRT = num;
        this.tipoRecursoTecnologico = tipoRT;
        this.cambiosEstadoRT = new ArrayList<>(Arrays.asList(

        ));


    }

    public void generarTurnos() {
        
    }
}
