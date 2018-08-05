/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.MatriculaDiasDao;
import com.empresa.proyecto.entidad.MatriculaDiasBE;
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
public class MatriculaDiasDaoImpl implements MatriculaDiasDao{

    private static final String QUERY_OBTENER = "select id_matricula_dias ,id_matricula,id_005_dia from matricula_dias md";
    private static final String QUERY_REGISTRAR = "insert into matricula_dias\n"
            + "(id_matricula,id_005_dia) \n"
            + "values\n"
            + "(?,?)";
    private static final String QUERY_ACTUALIZAR = "update matricula_dias\n"
            + "set\n"
            + ",id_matricula = IFNULL(?, id_matricula)\n"
            + ",id_005_dia = IFNULL(?,id_005_dia)\n"
            + "where id_matricula_dias = ?";
    private MySQLConexion mysqlConexion = new MySQLConexion();
    private static final String ID_MATRICULA_DIAS = "id_matricula_dias";
    private static final String ID_MATRICULA = "id_matricula";
    private static final String ID_005_DIA = "id_005_dia";

    public MatriculaDiasDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    public List<MatriculaDiasBE> obtener(MatriculaDiasBE matriculaDias) {
        List<MatriculaDiasBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MatriculaDiasBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            //TODO: Faltan pasar parametros
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new MatriculaDiasBE();
                item.setIdentMatriculaDias(rs.getInt(ID_MATRICULA_DIAS));
                item.getMatricula().setIdentMatricula(rs.getInt(ID_MATRICULA));
                item.getDia().setIdentParametro(rs.getInt(ID_005_DIA));
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

    public int registrar(MatriculaDiasBE matriculaDias) {
        int idMatriculaDias = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, matriculaDias.getMatricula().getIdentMatricula());
            ps.setInt(2, matriculaDias.getDia().getIdentParametro());
            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idMatriculaDias = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO:Cerrar recursos
            return idMatriculaDias;
        }
    }

    public boolean actualizar(MatriculaDiasBE matriculaDias) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);
            ps.setObject(1, Util.obtenerValorParametro(matriculaDias.getMatricula().getIdentMatricula()));
            ps.setObject(2, Util.obtenerValorParametro(matriculaDias.getDia().getIdentParametro()));
            ps.setObject(3, Util.obtenerValorParametro(matriculaDias.getIdentMatriculaDias()));

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
