/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.MatriculaEspecialidadBE;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public interface MatriculaEspecialidadDao {
    public List<MatriculaEspecialidadBE> obtener(MatriculaEspecialidadBE matriculaEspecialidad);
    public int registrar(MatriculaEspecialidadBE matriculaEspecialidad);
    public boolean actualizar(MatriculaEspecialidadBE matriculaEspecialidad);   
}
