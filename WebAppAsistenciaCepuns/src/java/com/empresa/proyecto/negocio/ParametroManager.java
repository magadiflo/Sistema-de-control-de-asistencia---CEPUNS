/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.negocio;

import com.empresa.proyecto.dao.ParametroDao;
import com.empresa.proyecto.dao.daoImpl.ParametroDaoImpl;
import com.empresa.proyecto.entidad.ParametroBE;
import java.util.List;

/**
 *
 * @author VICTOR
 */
public class ParametroManager {
    private ParametroDao parametroDao = null;
    
    public ParametroManager(){
        parametroDao = new ParametroDaoImpl();
    }
    
    public List<ParametroBE> obtener(ParametroBE parametro){
        return parametroDao.obtener(parametro);
    }
    
}
