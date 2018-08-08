/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.util;

import com.empresa.proyecto.entidad.UsuarioBE;
import com.empresa.proyecto.util.constante.Constante;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VICTOR
 */
public class UtilSeguridad {
    
    public boolean estaLogueado(HttpServletRequest request, HttpServletResponse response) throws IOException{
        UsuarioBE usuario = (UsuarioBE) request.getSession().getAttribute(Constante.USUARIO_LOGUEADO);
        
        return usuario != null;
    }
    
    
}
