/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.PersonaDao;
import com.empresa.proyecto.entidad.PersonaBE;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author VICTOR
 */
public class PersonaDaoImpl implements PersonaDao{

    private static String QUERY_REGISTRAR = "insert into persona (id_001_tipo_documento,documento,nombres,paterno,materno,fechaNacimiento,direccion,telefono,email) values (?,?,?,?,?,?,?,?,?)";
    private static String QUERY_ACTUALIZAR = "update persona set"
            + "id_001_tipo_documento = IFNULL(?,id_001_tipo_documento)"
            + ",documento = IFNULL(?,documento)"
            + ",nombres = IFNULL(?,nombres)"
            + ",paterno = IFNULL(?,paterno)"
            + ",materno = IFNULL(?,materno)"
            + ",fechaNacimiento = IFNULL(?,fechaNacimiento)"
            + ",direccion = IFNULL(?,direccion)"
            + ",telefono = IFNULL(?,telefono)"
            + ",email = IFNULL(?,email)"
            + "where id_persona = ?";
    private static String ID_PERSONA = "id_persona";
    private static String ID_001_TIPO_DOCUMENTO = "id_001_tipo_documento";
    private static String DOCUMENTO = "documento";
    private static String NOMBRES = "nombres";
    private static String PATERNO = "paterno";
    private static String FECHANACIMIENTO = "fechaNacimiento";
    private static String DIRECCION = "direccion";
    private static String TELEFONO = "telefono";
    private static String EMAIL = "email";
    private MySQLConexion mysqlConexion = new  MySQLConexion();
    
    
    public PersonaDaoImpl(){
        if(!mysqlConexion.isConnect()){
            mysqlConexion.conectar();
        }
    }
    
    @Override
    public int registrar(PersonaBE persona) {
        int idPersona = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, persona.getTipoDocumento().getIdentParametroTipo());
            ps.setString(2, persona.getDocumento());
            ps.setString(3, persona.getNombres());
            ps.setString(4, persona.getPaterno());
            ps.setString(5, persona.getMaterno());
            ps.setDate(6, persona.getFechaNacimiento());
            ps.setString(7, persona.getDireccion());
            ps.setString(8, persona.getTelefono());
            ps.setString(9, persona.getEmail());
            
            if(ps.executeUpdate() == 0){
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                idPersona = rs.getInt(1);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally{
            //TODO:Cerrar recursos
            return idPersona;
        }
    }

    @Override
    public boolean actualizar(PersonaBE persona) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);
            
            ps.setObject(1, Util.obtenerValorParametro(persona.getTipoDocumento().getIdentParametroTipo()));
            ps.setObject(2, Util.obtenerValorParametro(persona.getDocumento()));
            ps.setObject(3, Util.obtenerValorParametro(persona.getNombres()));
            ps.setObject(4, Util.obtenerValorParametro(persona.getPaterno()));
            ps.setObject(5, Util.obtenerValorParametro(persona.getMaterno()));
            ps.setObject(6, persona.getFechaNacimiento());
            ps.setObject(7, Util.obtenerValorParametro(persona.getDireccion()));
            ps.setObject(8, Util.obtenerValorParametro(persona.getTelefono()));
            ps.setObject(9, Util.obtenerValorParametro(persona.getEmail()));
            ps.setObject(10, Util.obtenerValorParametro(persona.getIdentPersona()));
            
            actualizo = ps.executeUpdate() > 0;
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally{
            //TODO:Cerrar recursos
            return actualizo;
        }
    }
    
}
