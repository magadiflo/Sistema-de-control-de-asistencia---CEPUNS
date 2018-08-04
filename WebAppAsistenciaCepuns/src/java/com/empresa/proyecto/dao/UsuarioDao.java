/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.UsuarioBE;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public interface UsuarioDao {
public List<UsuarioBE> obtener(UsuarioBE usuario);
    public int registrar(UsuarioBE usuario);
    public boolean actualizar(UsuarioBE usuario);       
}
