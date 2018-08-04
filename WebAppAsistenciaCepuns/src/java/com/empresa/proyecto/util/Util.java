/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.util;

import com.empresa.proyecto.util.constante.Constante;
import java.util.Properties;

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
    
}
