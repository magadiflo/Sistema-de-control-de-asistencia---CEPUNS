/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.TurnoBE;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public interface TurnoDao {
    public List<TurnoBE> obtener(TurnoBE turno);
    public int registrar(TurnoBE turno);
    public boolean actualizar(TurnoBE turno);   
}
