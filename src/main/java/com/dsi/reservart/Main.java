package com.dsi.reservart;

import com.dsi.reservart.controllers.ControladorReservaTurno;
import com.dsi.reservart.models.*;
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

        ArrayList<Modelo> modelos1 = new ArrayList<>(Arrays.asList(
                new Modelo("TXB622L"),
                new Modelo("LBAL-20 / BALP-001")
        ));

        ArrayList<Modelo> modelos2 = new ArrayList<>(Arrays.asList(
                new Modelo("MM-400/800"),
                new Modelo("TXB622L")
        ));

        ArrayList<Marca> marcas = new ArrayList<>(Arrays.asList(
                new Marca(modelos1,"Shidmazu"),
                new Marca(modelos2,"Nikon")
        ));
        ArrayList<RecursoTecnologico> recursosTecnologicos1 = new ArrayList<>(Arrays.asList(
                new RecursoTecnologico(1,tiposRT.get(0),modelos1.get(0)),
                new RecursoTecnologico(2,tiposRT.get(0),modelos1.get(1))
        ));

        ArrayList<RecursoTecnologico> recursosTecnologicos2 = new ArrayList<>(Arrays.asList(
                new RecursoTecnologico(3,tiposRT.get(1),modelos1.get(2)),
                new RecursoTecnologico(4,tiposRT.get(1),modelos1.get(3))
        ));

        ArrayList<PersonalCientifico> cientificos1 = new ArrayList<>(Arrays.asList(
                new PersonalCientifico(),
                new PersonalCientifico()
        ));

        ArrayList<PersonalCientifico> cientificos2 = new ArrayList<>(Arrays.asList(
                new PersonalCientifico(),
                new PersonalCientifico()
        ));

        ArrayList<AsignacionCientificoCI> AsignacionesCientificos1 = new ArrayList<>(Arrays.asList(
                new AsignacionCientificoCI(cientificos1.get(0)),
                new AsignacionCientificoCI(cientificos1.get(1))

        ));

        ArrayList<AsignacionCientificoCI> AsignacionesCientificos2 = new ArrayList<>(Arrays.asList(
                new AsignacionCientificoCI(cientificos2.get(0)),
                new AsignacionCientificoCI(cientificos2.get(1))

        ));

        ArrayList<CentroDeInvestigacion> centrosDeInvestigacion = new ArrayList<>(Arrays.asList(
                new CentroDeInvestigacion(AsignacionesCientificos1,recursosTecnologicos1),
                new CentroDeInvestigacion(AsignacionesCientificos2,recursosTecnologicos2)
        ));






        pantallaRT.mostrarUsuarioActivo(controladorRT);

        pantallaRT.opReservaTurno(controladorRT, tiposRT);
    }
}
