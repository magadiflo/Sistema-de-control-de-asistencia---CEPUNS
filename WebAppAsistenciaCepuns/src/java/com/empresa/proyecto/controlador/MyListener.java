/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.controlador;

import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import com.empresa.proyecto.util.constante.Constante;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author VICTOR
 */
@WebListener
public class MyListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        
        Properties properties = new Properties();
        properties.setProperty(Constante.PARAM_SERVER, ctx.getInitParameter(Constante.PARAM_SERVER));
        properties.setProperty(Constante.PARAM_DATABASE, ctx.getInitParameter(Constante.PARAM_DATABASE));
        properties.setProperty(Constante.PARAM_USER, ctx.getInitParameter(Constante.PARAM_USER));
        properties.setProperty(Constante.PARAM_PASSWORD, ctx.getInitParameter(Constante.PARAM_PASSWORD));
        
        Util.propiedadesBaseDatos = properties;
        
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
