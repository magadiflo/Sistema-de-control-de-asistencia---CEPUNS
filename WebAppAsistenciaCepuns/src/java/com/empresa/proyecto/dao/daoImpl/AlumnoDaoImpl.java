/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.AlumnoDao;
import com.empresa.proyecto.entidad.AlumnoBE;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author VICTOR
 */
public class AlumnoDaoImpl implements AlumnoDao{

    private static final String QUERY_OBTENER = "select id_alumno ,id_persona ,codigo, id_matricula_especialidad,id_002_estado_habilitado,apoderado,telefono_contacto,id_003_estado from alumno a";
    private static final String QUERY_REGISTRAR = "insert into alumno\n" +
"(id_persona,codigo,id_matricula_especialidad,id_002_estado_habilitado,apoderado,telefono_contacto,id_003_estado) \n" +
"values\n" +
"(?,?,?,?,?,?,?)";
    private static final String QUERY_ACTUALIZAR = "update alumno\n" +
"set\n" +
"id_persona = IFNULL(?,id_persona)\n" +
",codigo = IFNULL(?, codigo)\n" +
",id_matricula_especialidad = IFNULL(?,id_matricula_especialidad)\n" +
",id_002_estado_habilitado = IFNULL(?, id_002_estado_habilitado)\n" +
",apoderado = IFNULL(?,apoderado)\n" +
",telefono_contacto = IFNULL(?, telefono_contacto)\n" +
",id_003_estado = IFNULL(?,id_003_estado)\n" +
"where id_alumno = ?";
    private MySQLConexion mysqlConexion = new  MySQLConexion();
    
    private static final String ID_ALUMNO = "id_alumno";
    private static final String ID_PERSONA = "id_persona";
    private static final String CODIGO = "codigo";
    private static final String ID_MATRICULA_ESPECIALIDAD = "id_matricula_especialidad";
    private static final String ID_002_ESTADO_HABILITADO = "id_002_estado_habilitado";
    private static final String APODERADO = "apoderado";
    private static final String TELEFONO_CONTACTO = "telefono_contacto";
    private static final String ID_003_ESTADO = "id_003_estado";
    
    public AlumnoDaoImpl(){
        if(!mysqlConexion.isConnect()){
            mysqlConexion.conectar();
        }
    }
    
    @Override
    public List<AlumnoBE> obtener(AlumnoBE alumno) {
        List<AlumnoBE> lista = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        AlumnoBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            //TODO: Faltan pasar parametros
            rs = ps.executeQuery();
            
            while(rs.next()){
                item = new AlumnoBE();
                item.setIdentAlumno(rs.getInt(ID_ALUMNO));
                item.getPersona().setIdentPersona(rs.getInt(ID_PERSONA));
                item.setCodigo(rs.getString(CODIGO));
                item.getMatriculaEspecialidad().setIdentMatriculaEspecialidad(rs.getInt(ID_MATRICULA_ESPECIALIDAD));
                item.getEstadoHabilitado().setIdentParametro(rs.getInt(ID_002_ESTADO_HABILITADO));
                item.setApoderado(rs.getString(APODERADO));
                item.setTelefonoContacto(rs.getString(TELEFONO_CONTACTO));
                item.getEstado().setIdentParametro(rs.getInt(ID_003_ESTADO));
                
                lista.add(item);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            //TODO: Cerrar recursos
            return lista;
        }
        
    }

    @Override
    public int registrar(AlumnoBE alumno) {
        int idAlumno = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getPersona().getIdentPersona());
            ps.setString(2, alumno.getCodigo());
            ps.setInt(3, alumno.getMatriculaEspecialidad().getIdentMatriculaEspecialidad());
            ps.setInt(4, alumno.getEstadoHabilitado().getIdentParametro());
            ps.setString(5, alumno.getApoderado());
            ps.setString(6, alumno.getTelefonoContacto());
            ps.setInt(7, alumno.getEstado().getIdentParametro());
            
            if(ps.executeUpdate() == 0){
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                idAlumno = rs.getInt(1);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally{
            //TODO:Cerrar recursos
            return idAlumno;
        }
    }

    @Override
    public boolean actualizar(AlumnoBE alumno) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);
            
            ps.setObject(1, Util.obtenerValorParametro(alumno.getPersona().getIdentPersona()));
            ps.setObject(2, Util.obtenerValorParametro(alumno.getCodigo()));
            ps.setObject(3, Util.obtenerValorParametro(alumno.getMatriculaEspecialidad().getIdentMatriculaEspecialidad()));
            ps.setObject(4, Util.obtenerValorParametro(alumno.getEstadoHabilitado().getIdentParametro()));
            ps.setObject(5, Util.obtenerValorParametro(alumno.getApoderado()));
            ps.setObject(6, Util.obtenerValorParametro(alumno.getTelefonoContacto()));
            ps.setObject(7, Util.obtenerValorParametro(alumno.getEstado().getIdentParametro()));
            ps.setObject(8, Util.obtenerValorParametro(alumno.getIdentAlumno()));
            
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
