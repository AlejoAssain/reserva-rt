package com.dsi.reservart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;

public class Pruebas {
    public static void main(String args[]){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fecha = dtf.format(LocalDateTime.now());
        System.out.println(fecha);

    }
}
