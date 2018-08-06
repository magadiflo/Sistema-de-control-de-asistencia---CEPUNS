/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.negocio;

import com.empresa.proyecto.dao.daoImpl.MatriculaEspecialidadDaoImpl;
import com.empresa.proyecto.dao.MatriculaEspecialidadDao;
import com.empresa.proyecto.entidad.MatriculaEspecialidadBE;
import java.util.List;

/**
 *
 * @author VICTOR
 */
public class MatriculaEspecialidadManager {
    
    private MatriculaEspecialidadDao matriculaEspecialidadDao = null;
    
    public MatriculaEspecialidadManager(){
        matriculaEspecialidadDao = new MatriculaEspecialidadDaoImpl();
    }
    
    public List<MatriculaEspecialidadBE> obtener(MatriculaEspecialidadBE matriculaEspecialidad){
        return matriculaEspecialidadDao.obtener(matriculaEspecialidad);
    }
    
}
