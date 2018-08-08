/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.LoginDao;
import com.empresa.proyecto.entidad.UsuarioBE;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.lang.reflect.Parameter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author VICTOR
 */
public class LoginDaoImpl implements LoginDao{
    
    private MySQLConexion mysqlConexion = null;
    private static final String QUERY_VALIDAR_LOGIN = "{call USP_LOGIN_VALIDAR(?,?)}";
    
    public LoginDaoImpl(){
        mysqlConexion = new MySQLConexion();
        if(!mysqlConexion.isConnect()){
            mysqlConexion.conectar();
        }
    }
    
    
    @Override
    public UsuarioBE validarLogin(UsuarioBE usuario) {
        CallableStatement cs = null;
        ResultSet rs = null;
        UsuarioBE usuarioRetorno = null;
        try {
            
            cs = mysqlConexion.getConnection().prepareCall(QUERY_VALIDAR_LOGIN);
            cs.setString(1, usuario.getCuenta());
            cs.setString(2, usuario.getPassword());
            
            rs = cs.executeQuery();
            
            usuarioRetorno = new UsuarioBE();
            
            while(rs.next()){
                usuarioRetorno.setIdentUsuario(rs.getInt("id_usuario"));
                usuarioRetorno.getPersona().setIdentPersona(rs.getInt("id_persona"));
                usuarioRetorno.getRol().setIdentRol(rs.getInt("id_rol"));
                usuarioRetorno.setCuenta(rs.getString("cuenta"));
                usuarioRetorno.getEstado().setIdentParametro(rs.getInt("id_003_estado"));
                usuarioRetorno.getPersona().setNombres(rs.getString("nombres"));
                usuarioRetorno.getPersona().setPaterno(rs.getString("paterno"));
                usuarioRetorno.getPersona().setMaterno(rs.getString("materno"));
                usuarioRetorno.getRol().setDescripcion(rs.getString("rol"));
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            mysqlConexion.cerrarRecursos(cs, rs);
            return usuarioRetorno;
        }
        
    }
    
}
