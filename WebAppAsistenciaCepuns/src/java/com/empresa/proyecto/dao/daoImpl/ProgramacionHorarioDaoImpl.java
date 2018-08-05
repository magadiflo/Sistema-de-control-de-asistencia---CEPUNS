/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.ProgramacionHorarioDao;
import com.empresa.proyecto.entidad.ProgramacionHorarioBE;
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
public class ProgramacionHorarioDaoImpl implements ProgramacionHorarioDao{

    private static final String QUERY_OBTENER = "select id_programacion_horario ,id_matricula,unidad, id_006_estado_unidad,fecha_inicio,fecha_fin from programacion_horario ph";
    private static final String QUERY_REGISTRAR = "insert into programacion_horario\n"
            + "(id_matricula,unidad, id_006_estado_unidad,fecha_inicio,fecha_fin) \n"
            + "values\n"
            + "(?,?,?,?,?)";
    private static final String QUERY_ACTUALIZAR = "update programacion_horario\n"
            + "set\n"
            + ",id_matricula = IFNULL(?, id_matricula)\n"
            + ",unidad = IFNULL(?,unidad)\n"
            + ",id_006_estado_unidad = IFNULL(?, id_006_estado_unidad)\n"
            + ",fecha_inicio = IFNULL(?, fecha_inicio)\n"
            + ",fecha_fin = IFNULL(?, fecha_fin)\n"
            + "where id_matricula = ?";
    private MySQLConexion mysqlConexion = new MySQLConexion();

    private static final String ID_PROGRAMACION_HORARIO = "id_programacion_horario";
    private static final String ID_MATRICULA = "id_matricula";
    private static final String UNIDAD = "unidad";
    private static final String ID_006_ESTADO_UNIDAD = "id_006_estado_unidad";
    private static final String FECHA_INICIO = "fecha_inicio";
    private static final String FECHA_FIN = "fecha_fin";

    public ProgramacionHorarioDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    public List<ProgramacionHorarioBE> obtener(ProgramacionHorarioBE programacionHorario) {
        List<ProgramacionHorarioBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProgramacionHorarioBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            //TODO: Faltan pasar parametros
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new ProgramacionHorarioBE();
                item.setIdentProgramacionHorario(rs.getInt(ID_PROGRAMACION_HORARIO));
                item.getMatricula().setIdentMatricula(rs.getInt(ID_MATRICULA));
                item.setUnidad(rs.getInt(UNIDAD));
                item.getEstadoUnidad().setIdentParametro(rs.getInt(ID_006_ESTADO_UNIDAD));
                item.setFechaInicio(rs.getDate(FECHA_INICIO));
                item.setFechaFin(rs.getDate(FECHA_FIN));

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

    public int registrar(ProgramacionHorarioBE programacionHorario) {
        int idProgramacionHorario = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, programacionHorario.getMatricula().getIdentMatricula());
            ps.setInt(2, programacionHorario.getUnidad());
            ps.setInt(3, programacionHorario.getEstadoUnidad().getIdentParametro());
            ps.setDate(4, programacionHorario.getFechaInicio());
            ps.setDate(5, programacionHorario.getFechaFin());

            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idProgramacionHorario = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO:Cerrar recursos
            System.out.println("***REGISTRO UNIDADES****");
            return idProgramacionHorario;
        }
    }

    public boolean actualizar(ProgramacionHorarioBE programacionHorario) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);
            ps.setObject(1, Util.obtenerValorParametro(programacionHorario.getMatricula().getIdentMatricula()));
            ps.setObject(2, Util.obtenerValorParametro(programacionHorario.getUnidad()));
            ps.setObject(3, Util.obtenerValorParametro(programacionHorario.getEstadoUnidad().getIdentParametro()));
            ps.setObject(4, programacionHorario.getFechaInicio());
            ps.setObject(5, programacionHorario.getFechaFin());
            ps.setObject(6, Util.obtenerValorParametro(programacionHorario.getIdentProgramacionHorario()));

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
