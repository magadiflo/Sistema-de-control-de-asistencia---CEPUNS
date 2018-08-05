/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.TurnoDao;
import com.empresa.proyecto.entidad.TurnoBE;
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
public class TurnoDaoImpl implements TurnoDao{
        private static final String QUERY_OBTENER = "select id_turno ,id_matricula,hora_inicio,hora_fin from turno t";
    private static final String QUERY_REGISTRAR = "insert into turno\n"
            + "(id_matricula,hora_inicio,hora_fin) \n"
            + "values\n"
            + "(?,?,?)";
    private static final String QUERY_ACTUALIZAR = "update turno\n"
            + "set\n"
            + ",id_matricula = IFNULL(?, id_matricula)\n"
            + ",hora_inicio = IFNULL(?,hora_inicio)\n"
            + ",hora_fin = IFNULL(?,hora_fin)\n"
            + "where id_turno = ?";
    private MySQLConexion mysqlConexion = new MySQLConexion();
    private static final String ID_TURNO = "id_turno";
    private static final String ID_MATRICULA = "id_matricula";
    private static final String HORA_INICIO = "hora_inicio";
    private static final String HORA_FIN = "hora_FIN";

    public TurnoDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    public List<TurnoBE> obtener(TurnoBE turno) {
        List<TurnoBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TurnoBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            //TODO: Faltan pasar parametros
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new TurnoBE();
                item.setIdentTurno(rs.getInt(ID_TURNO));
                item.getMatricula().setIdentMatricula(rs.getInt(ID_MATRICULA));
                item.setHoraInicio(rs.getString(HORA_INICIO));
                item.setHoraFin(rs.getString(HORA_FIN));
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

    public int registrar(TurnoBE turno) {
        int idTurno = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, turno.getMatricula().getIdentMatricula());
            ps.setString(2, turno.getHoraInicio());
            ps.setString(3, turno.getHoraFin());
            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idTurno = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO:Cerrar recursos
            System.out.println("***REGISTRO TURNOS***");
            return idTurno;
        }
    }

    public boolean actualizar(TurnoBE turno) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);
            ps.setObject(1, Util.obtenerValorParametro(turno.getMatricula().getIdentMatricula()));
            ps.setObject(2, Util.obtenerValorParametro(turno.getHoraInicio()));
            ps.setObject(3, Util.obtenerValorParametro(turno.getHoraFin()));
            ps.setObject(4, Util.obtenerValorParametro(turno.getIdentTurno()));

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
