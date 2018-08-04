/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.ProgramacionHorarioBE;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public interface ProgramacionHorarioDao {
    public List<ProgramacionHorarioBE> obtener(ProgramacionHorarioBE programacionHorario);
    public int registrar(ProgramacionHorarioBE programacionHorario);
    public boolean actualizar(ProgramacionHorarioBE programacionHorario);   
}
