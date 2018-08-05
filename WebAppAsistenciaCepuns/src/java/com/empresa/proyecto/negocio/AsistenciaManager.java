/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.negocio;

import com.empresa.proyecto.dao.AsistenciaDao;
import com.empresa.proyecto.dao.daoImpl.AsistenciaDaoImpl;
import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.entidad.ParametroBE;
import com.empresa.proyecto.util.Util;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author VICTOR
 */
public class AsistenciaManager {
    
    private AsistenciaDao asistenciaDao = null;
    
    
    public AsistenciaManager(){
        asistenciaDao = new AsistenciaDaoImpl();
    }
    
    public int registrarPorFecha(Calendar fechaInicio, Calendar fechaFin, AsistenciaBE asistencia, List<ParametroBE> listaDias){
        int diaSemana = 0;
        for (Calendar c1 = fechaInicio; c1.compareTo(fechaFin) <= 0; c1.add(Calendar.DAY_OF_MONTH, 1)) {
            diaSemana = c1.get(Calendar.DAY_OF_WEEK);
            if(Util.diaEnListaDias(diaSemana, listaDias)){
                
            }
        }
        return 0;
    }
    
}
