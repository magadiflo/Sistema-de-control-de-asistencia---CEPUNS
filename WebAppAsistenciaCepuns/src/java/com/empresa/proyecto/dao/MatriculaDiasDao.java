/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.MatriculaDiasBE;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public interface MatriculaDiasDao {
  public List<MatriculaDiasBE> obtener(MatriculaDiasBE matriculaDias);
    public int registrar(MatriculaDiasBE matriculaDias);
    public boolean actualizar(MatriculaDiasBE matriculaDias);   
}
