/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.AlumnoBE;
import java.util.List;

/**
 *
 * @author VICTOR
 */
public interface AlumnoDao {
    
    public List<AlumnoBE> obtener(AlumnoBE alumno);
    public int registrar(AlumnoBE alumno);
    public boolean actualizar(AlumnoBE alumno);
    
}
