/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.negocio;

import com.empresa.proyecto.dao.EspecialidadDao;
import com.empresa.proyecto.dao.daoImpl.EspecialidadDaoImpl;
import com.empresa.proyecto.entidad.EspecialidadBE;
import java.util.List;

/**
 *
 * @author VICTOR
 */
public class EspecialidadManager {
    private EspecialidadDao especialidadDao = null;
    
    public EspecialidadManager(){
        especialidadDao = new EspecialidadDaoImpl();
    }
    
    public List<EspecialidadBE> obtener(EspecialidadBE especialidad){
        return especialidadDao.obtener(especialidad);
    }
    
}
