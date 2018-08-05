/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.util;

import com.empresa.proyecto.entidad.ParametroBE;
import com.empresa.proyecto.util.constante.Constante;
import com.empresa.proyecto.util.constante.ParametroConstante;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 *
 * @author VICTOR
 */
public class Util {
    public static Properties propiedadesBaseDatos = null;
    
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
    
    public static boolean esMismoDia(Calendar c1, Calendar c2){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return (sdf.format(c1.getTime()).equals(sdf.format(c2.getTime())));
    }
    
    public static int diaSemanaToIdDia(int diaSemana){
        switch(diaSemana){
            case 0:
                return ParametroConstante.DOMINGO;
            case 1:
                return ParametroConstante.LUNES;
            case 2:
                return ParametroConstante.MARTES;
            case 3:
                return ParametroConstante.MIERCOLES;
            case 4:
                return ParametroConstante.JUEVES;
            case 5:
                return ParametroConstante.VIERNES;
            case 6:
                return ParametroConstante.SABADO;
            default:
                return 0;
        }
    }
    
    public static boolean diaEnListaDias(int diaSemana, List<ParametroBE> listaDias){
        return listaDias.stream().filter(x -> x.getIdentParametro() == diaSemanaToIdDia(diaSemana)).collect(Collectors.toList()).size() > 0;
    }
    
}
