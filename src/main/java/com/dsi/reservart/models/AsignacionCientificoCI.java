package com.dsi.reservart.models;

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
}
