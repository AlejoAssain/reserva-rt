package com.dsi.reservart.models;

import java.util.ArrayList;

public class AsignacionCientificoCI
{
   private String fechaDesde;
   private String fechaHasta;
   public PersonalCientifico personalCientifico;



    public AsignacionCientificoCI(PersonalCientifico thePersonalCientifico) {
        this.personalCientifico = thePersonalCientifico;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setPersonalCientifico(PersonalCientifico personalCientifico) {
        this.personalCientifico = personalCientifico;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public PersonalCientifico getPersonalCientifico() {
        return personalCientifico;
    }
   

   public Boolean esCientificoActivoDelCI() {
        return this.fechaHasta == null;
   }
   

   public void misTurnos() {
    
   }

    public Boolean asignarNuevoTurnoACientifico(Turno turno) {
        if(personalCientifico.turnos.add(turno)){
            return true;
        }
        return false;
    }
}
