/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.PersonaBE;

/**
 *
 * @author VICTOR
 */
public interface PersonaDao {
    public int registrar(PersonaBE persona);
    public boolean actualizar(PersonaBE persona);
}
