/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.util;

import com.empresa.proyecto.entidad.ParametroBE;
import com.empresa.proyecto.util.constante.Constante;
import com.empresa.proyecto.util.constante.ParametroConstante;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VICTOR
 */
public class Util {
    public static Properties propiedadesBaseDatos = null;
    
    public static int obtenerValorEntero(String valor){
        if(esVacio(valor)){
            return 0;
        }
        return Integer.parseInt(valor);
    }
    
    public static boolean esVacio(String text){
        return text == null || Constante.VACIO.equals(text);
    }
    
    public static Integer obtenerValorParametro(int valor){
        return valor == 0? null : valor;
    }
    
    public static String obtenerValorParametro(String valor){
        return esVacio(valor)? null : valor;
    }
    
    public static Calendar dateToCalendar(Date date){
        if(date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    
    public static Date calendarToDate(Calendar calendar){
        if(calendar == null){
            return null;
        }
        return new Date(calendar.getTimeInMillis());
    }
    
    public static boolean esMismoDia(Calendar c1, Calendar c2){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return (sdf.format(c1.getTime()).equals(sdf.format(c2.getTime())));
    }
    
    public static int diaSemanaToIdDia(int diaSemana){
        switch(diaSemana){
            case 1:
                return ParametroConstante.DOMINGO;
            case 2:
                return ParametroConstante.LUNES;
            case 3:
                return ParametroConstante.MARTES;
            case 4:
                return ParametroConstante.MIERCOLES;
            case 5:
                return ParametroConstante.JUEVES;
            case 6:
                return ParametroConstante.VIERNES;
            case 7:
                return ParametroConstante.SABADO;
            default:
                return 0;
        }
    }
    
    public static boolean diaEnListaDias(int diaSemana, List<ParametroBE> listaDias){
        return listaDias.stream().filter(x -> x.getIdentParametro() == diaSemanaToIdDia(diaSemana)).collect(Collectors.toList()).size() > 0;
    }
    
    public static Date obtenerDate(int dia, int mes, int anio){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, anio);
        
        return calendarToDate(calendar);
    }
    
    public static void retornarJson(Object object, HttpServletRequest request, HttpServletResponse response) throws IOException{
        Gson gson = new Gson();
            String jsonString = gson.toJson(object);
            response.setContentType("application/json");
            response.getWriter().write(jsonString);
    }
    
}
