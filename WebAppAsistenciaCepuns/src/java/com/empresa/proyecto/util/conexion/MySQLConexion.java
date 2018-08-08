/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.util.conexion;

import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.constante.Constante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VICTOR
 */
public class MySQLConexion {

    private Connection cn = null;
    private String url = "";
    private String user = "";
    private String pass = "";
    private String jdbc = "jdbc:mysql://";
    private String driver = "com.mysql.jdbc.Driver";

    public void conectar() {
        url = jdbc + Util.propiedadesBaseDatos.getProperty(Constante.PARAM_SERVER) + "/"
                + Util.propiedadesBaseDatos.getProperty(Constante.PARAM_DATABASE);
        user = Util.propiedadesBaseDatos.getProperty(Constante.PARAM_USER);
        pass = Util.propiedadesBaseDatos.getProperty(Constante.PARAM_PASSWORD);

        System.out.println("url: " + url);
        System.out.println("user: " + user);
        System.out.println("pass: " + pass);

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MySQLConexion.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

    public void cerrarRecursos(PreparedStatement ps, ResultSet rs) {
        try {
            if (cn != null) {
                cn.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() throws SQLException {
        if(cn != null)
            if(cn.isClosed())
                conectar();
        return cn;
    }

    public boolean isConnect() {
        return cn != null;
    }

}
