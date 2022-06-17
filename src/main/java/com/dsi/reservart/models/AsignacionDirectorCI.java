package com.dsi.reservart.models;

public class AsignacionDirectorCI 
{
   private String fechaDesde;
   private String fechaHasta;
   public PersonalCientifico thePersonalCientifico;

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setThePersonalCientifico(PersonalCientifico thePersonalCientifico) {
        this.thePersonalCientifico = thePersonalCientifico;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public PersonalCientifico getThePersonalCientifico() {
        return thePersonalCientifico;
    }
   
   public void esActual() 
   {
    
   }
}

