/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.ParametroBE;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public interface ParametroDao {
    public List<ParametroBE> obtener(ParametroBE parametro);
}
