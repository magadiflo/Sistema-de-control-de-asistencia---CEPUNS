/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.negocio;

import com.empresa.proyecto.dao.LoginDao;
import com.empresa.proyecto.dao.daoImpl.LoginDaoImpl;
import com.empresa.proyecto.entidad.UsuarioBE;

/**
 *
 * @author VICTOR
 */
public class LoginManager {
    
    private LoginDao loginDao = null;
    
    public LoginManager(){
        loginDao = new LoginDaoImpl();
    }
    
    public UsuarioBE validarLogin(UsuarioBE usuario){
        return loginDao.validarLogin(usuario);
    }
    
}
