/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.test;

import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.entidad.AsistenciaDetalleBE;
import com.empresa.proyecto.negocio.AsistenciaDetalleManager;
import com.empresa.proyecto.util.constante.ParametroConstante;

/**
 *
 * @author VICTOR
 */
public class TestAsistencia {
    
    public static void test() {
        int idAsistenciaDetalle = 0;
        AsistenciaBE asistencia = new AsistenciaBE();
        AsistenciaDetalleBE asistenciaDetalle1 = new AsistenciaDetalleBE();
        AsistenciaDetalleBE asistenciaDetalle2 = new AsistenciaDetalleBE();
        
        //En la vista se muestra la fecha y turno, internamente sabemos el id de la asistencia
        asistencia.setIdentAsistencia(890); 
        
        //Primer alumno
        asistenciaDetalle1.getAlumno().setIdentAlumno(17);
        asistenciaDetalle1.getEstadoAsistencia().setIdentParametro(ParametroConstante.ASISTIO);
        asistenciaDetalle1.setObservacion("");
        
        //Segundo alumno
        asistenciaDetalle2.getAlumno().setIdentAlumno(18);
        asistenciaDetalle2.getEstadoAsistencia().setIdentParametro(ParametroConstante.FALTA);
        asistenciaDetalle2.setObservacion("");
        
        asistencia.addAsistenciaDetalle(asistenciaDetalle1);
        asistencia.addAsistenciaDetalle(asistenciaDetalle2);
        
        idAsistenciaDetalle = new AsistenciaDetalleManager().registrar(asistencia);
        
        System.out.println("************TERMINO ASISTENCIA DETALLE ******");
        
    }
    
}
