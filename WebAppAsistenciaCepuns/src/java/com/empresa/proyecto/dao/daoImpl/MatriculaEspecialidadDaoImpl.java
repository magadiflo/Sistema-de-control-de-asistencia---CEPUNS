/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.MatriculaEspecialidadDao;
import com.empresa.proyecto.entidad.MatriculaEspecialidadBE;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public class MatriculaEspecialidadDaoImpl implements MatriculaEspecialidadDao{

    private static final String QUERY_OBTENER = "select id_matricula_especialidad ,id_matricula,id_especialidad from matricula_especialidad me";
    private static final String QUERY_REGISTRAR = "insert into matricula_especialidad\n"
            + "(id_matricula,id_especialidad) \n"
            + "values\n"
            + "(?,?)";
    private static final String QUERY_ACTUALIZAR = "update matricula_especialidad\n"
            + "set\n"
            + ",id_matricula = IFNULL(?, id_matricula)\n"
            + ",id_especialidad = IFNULL(?,id_especialidad)\n"
            + "where id_matricula_especialidad = ?";
    private MySQLConexion mysqlConexion = new MySQLConexion();
    private static final String ID_MATRICULA_ESPECIALIDAD = "id_matricula_especialidad";
    private static final String ID_MATRICULA = "id_matricula";
    private static final String ID_ESPECIALIDAD = "id_especialidad";

    public MatriculaEspecialidadDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    public List<MatriculaEspecialidadBE> obtener(MatriculaEspecialidadBE matriculaEspecialidad) {
        List<MatriculaEspecialidadBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MatriculaEspecialidadBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            //TODO: Faltan pasar parametros
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new MatriculaEspecialidadBE();
                item.setIdentMatriculaEspecialidad(rs.getInt(ID_MATRICULA_ESPECIALIDAD));
                item.getMatricula().setIdentMatricula(rs.getInt(ID_MATRICULA));
                item.getEspecialidad().setIdentEspecialidad(rs.getInt(ID_ESPECIALIDAD));
                lista.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO: Cerrar recursos
            return lista;
        }

    }

    public int registrar(MatriculaEspecialidadBE matriculaEspecialidad) {
        int idMatriculaEspecialidad = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, matriculaEspecialidad.getMatricula().getIdentMatricula());
            ps.setInt(2, matriculaEspecialidad.getEspecialidad().getIdentEspecialidad());
            System.out.println("********************id especialidad = " + matriculaEspecialidad.getEspecialidad().getIdentEspecialidad());
            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idMatriculaEspecialidad = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO:Cerrar recursos
            System.out.println("***REGISTRO MATRICULA ESPECIALIDAD ***");
            return idMatriculaEspecialidad;
        }
    }

    public boolean actualizar(MatriculaEspecialidadBE matriculaEspecialidad) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);
            ps.setObject(1, Util.obtenerValorParametro(matriculaEspecialidad.getMatricula().getIdentMatricula()));
            ps.setObject(2, Util.obtenerValorParametro(matriculaEspecialidad.getEspecialidad().getIdentEspecialidad()));
            ps.setObject(3, Util.obtenerValorParametro(matriculaEspecialidad.getIdentMatriculaEspecialidad()));

            actualizo = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO:Cerrar recursos
            return actualizo;
        }
    }
}
