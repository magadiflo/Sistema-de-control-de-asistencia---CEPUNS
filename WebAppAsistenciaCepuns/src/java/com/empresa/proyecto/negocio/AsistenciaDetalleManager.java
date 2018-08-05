/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.negocio;

import com.empresa.proyecto.dao.AsistenciaDetalleDao;
import com.empresa.proyecto.dao.daoImpl.AsistenciaDetalleDaoImpl;
import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.entidad.AsistenciaDetalleBE;

/**
 *
 * @author VICTOR
 */
public class AsistenciaDetalleManager {
    
    private AsistenciaDetalleDao asistenciaDetalleDao = null;
    
    public AsistenciaDetalleManager(){
        asistenciaDetalleDao = new AsistenciaDetalleDaoImpl();
    }
    
    public int registrar(AsistenciaBE asistencia){
        int idAsistenciaDetalle = 0;
        
        for(AsistenciaDetalleBE detalle : asistencia.getListAsistenciaDetalle()){
            idAsistenciaDetalle = asistenciaDetalleDao.registrar(detalle);
            //TODO: VALIDAR ROLLBACK
        }
        
        return idAsistenciaDetalle;
    }
    
}
