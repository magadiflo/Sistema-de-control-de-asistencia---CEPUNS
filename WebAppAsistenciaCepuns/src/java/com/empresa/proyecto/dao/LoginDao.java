/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.UsuarioBE;

/**
 *
 * @author VICTOR
 */
public interface LoginDao {
    
    public UsuarioBE validarLogin(UsuarioBE usuario);
    
}
