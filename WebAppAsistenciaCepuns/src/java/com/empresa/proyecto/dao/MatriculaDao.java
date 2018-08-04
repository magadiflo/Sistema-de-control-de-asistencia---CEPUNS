/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.MatriculaBE;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public interface MatriculaDao {
    
    public List<MatriculaBE> obtener(MatriculaBE matricula);
    public int registrar(MatriculaBE matricula);
    public boolean actualizar(MatriculaBE matricula);
}