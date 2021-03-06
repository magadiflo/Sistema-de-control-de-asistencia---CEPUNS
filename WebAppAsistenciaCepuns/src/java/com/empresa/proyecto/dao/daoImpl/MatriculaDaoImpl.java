/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.MatriculaDao;
import com.empresa.proyecto.entidad.MatriculaBE;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public class MatriculaDaoImpl implements MatriculaDao{

    private static final String QUERY_OBTENER = "select id_matricula ,anio,id_004_ciclo, id_006_estado_matricula,limite_faltas_porcentaje,fecha_inicio,fecha_fin,asignar_primer_turno_defecto,id_003_estado, p.descripcion ciclo, p2.descripcion estado_matricula from matricula m join parametro p on p.id_parametro = m.id_004_ciclo join parametro p2 on p2.id_parametro = m.id_006_estado_matricula ";
    private static final String QUERY_REGISTRAR = "insert into matricula\n"
            + "(anio,id_004_ciclo, id_006_estado_matricula,limite_faltas_porcentaje,fecha_inicio,fecha_fin,asignar_primer_turno_defecto,id_003_estado) \n"
            + "values\n"
            + "(?,?,?,?,?,?,?,?)";
    private static final String QUERY_ACTUALIZAR = "update matricula\n"
            + "set\n"
            + ",anio = IFNULL(?, anio)\n"
            + ",id_004_ciclo = IFNULL(?,id_004_ciclo)\n"
            + ",id_002_estado_habilitado = IFNULL(?, id_002_estado_habilitado)\n"
            + ",id_006_estado_matricula = IFNULL(?,id_006_estado_matricula)\n"
            + ",limite_faltas_porcentaje = IFNULL(?, limite_faltas_porcentaje)\n"
            + ",fecha_inicio = IFNULL(?, fecha_inicio)\n"
            + ",fecha_fin = IFNULL(?, fecha_fin)\n"
            + ",asignar_primer_turno_defecto = IFNULL(?, asignar_primer_turno_defecto)\n"
            + ",id_003_estado = IFNULL(?,id_003_estado)\n"
            + "where id_matricula = ?";
    
    private static final String QUERY_OBTENER_CICLO_ABIERTO = "select \n" +
"id_matricula\n" +
", anio\n" +
", m.id_004_ciclo\n" +
", m.id_006_estado_matricula\n" +
", limite_faltas_porcentaje\n" +
", fecha_inicio\n" +
", fecha_fin\n" +
", asignar_primer_turno_defecto\n" +
", id_003_estado\n" +
", p1.descripcion ciclo\n" +
", p2.descripcion estado_matricula\n" +
", p3.descripcion estado\n" +
"from matricula m\n" +
"join parametro p1 on p1.id_parametro = m.id_004_ciclo\n" +
"join parametro p2 on p2.id_parametro = m.id_006_estado_matricula\n" +
"join parametro p3 on p3.id_parametro = m.id_003_estado\n" +
"where m.id_006_estado_matricula = 19";
    
    private MySQLConexion mysqlConexion = new MySQLConexion();

    private static final String ID_MATRICULA = "id_matricula";
    private static final String ANIO = "anio";
    private static final String ID_004_CICLO = "id_004_ciclo";
    private static final String ID_006_ESTADO_MATRICULA = "id_006_estado_matricula";
    private static final String LIMITE_FALTAS_PORCENTAJE = "limite_faltas_porcentaje";
    private static final String FECHA_INICIO = "fecha_inicio";
    private static final String FECHA_FIN = "fecha_fin";
    private static final String ASIGNAR_PRIMER_TURNO_DEFECTO = "asignar_primer_turno_defecto";
    private static final String ID_003_ESTADO = "id_003_estado";

    public MatriculaDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    public List<MatriculaBE> obtener(MatriculaBE matricula) {
        List<MatriculaBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MatriculaBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            //TODO: Faltan pasar parametros
            rs = ps.executeQuery();
            lista = new ArrayList<MatriculaBE>();
            while (rs.next()) {
                item = new MatriculaBE();
                item.setIdentMatricula(rs.getInt(ID_MATRICULA));
                item.setAnio(rs.getInt(ANIO));
                item.getCiclo().setIdentParametro(rs.getInt(ID_004_CICLO));
                item.getEstadoMatricula().setIdentParametro(rs.getInt(ID_006_ESTADO_MATRICULA));
                item.setLimiteFaltasPorcentaje(rs.getInt(LIMITE_FALTAS_PORCENTAJE));
                item.setFechaInicio(rs.getDate(FECHA_INICIO));
                item.setFechaFin(rs.getDate(FECHA_FIN));
                item.setAsignarPrimerTurnoDefecto(rs.getBoolean(ASIGNAR_PRIMER_TURNO_DEFECTO));
                item.getEstado().setIdentParametro(rs.getInt(ID_003_ESTADO));
                item.getCiclo().setDescripcion(rs.getString("ciclo"));
                item.getEstadoMatricula().setDescripcion(rs.getString("estado_matricula"));
                
                lista.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConexion.cerrarRecursos(ps, rs);
            return lista;
        }

    }

    public int registrar(MatriculaBE matricula) {
        int idMatricula = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, matricula.getAnio());
            ps.setInt(2, matricula.getCiclo().getIdentParametro());
            ps.setInt(3, matricula.getEstadoMatricula().getIdentParametro());
            ps.setInt(4, matricula.getLimiteFaltasPorcentaje());
            ps.setDate(5, matricula.getFechaInicio());
            ps.setDate(6, matricula.getFechaFin());
            ps.setBoolean(7, matricula.isAsignarPrimerTurnoDefecto());
            ps.setInt(8, matricula.getEstado().getIdentParametro());

            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idMatricula = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConexion.cerrarRecursos(ps, rs);
            System.out.println("***Registro MATRICULA***");
            return idMatricula;
        }
    }

    public boolean actualizar(MatriculaBE matricula) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);
            ps.setObject(1, Util.obtenerValorParametro(matricula.getAnio()));
            ps.setObject(2, Util.obtenerValorParametro(matricula.getCiclo().getIdentParametro()));
            ps.setObject(3, Util.obtenerValorParametro(matricula.getEstadoMatricula().getIdentParametro()));
            ps.setObject(4, Util.obtenerValorParametro(matricula.getLimiteFaltasPorcentaje()));
            ps.setObject(5, matricula.getFechaInicio());
            ps.setObject(6, matricula.getFechaFin());
            ps.setObject(7, matricula.isAsignarPrimerTurnoDefecto());
            ps.setObject(8, Util.obtenerValorParametro( matricula.getEstado().getIdentParametro()));
            ps.setObject(9, Util.obtenerValorParametro(matricula.getIdentMatricula()));

            actualizo = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConexion.cerrarRecursos(ps, rs);
            return actualizo;
        }
    }

    @Override
    public MatriculaBE obtenerCicloActual() {
        MatriculaBE matricula = new MatriculaBE();
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER_CICLO_ABIERTO);
            rs = ps.executeQuery();
            
            if(rs.next()){
                matricula.setIdentMatricula(rs.getInt("id_matricula"));
                matricula.setAnio(rs.getInt("anio"));
                matricula.getCiclo().setIdentParametro(rs.getInt("id_004_ciclo"));
                matricula.getEstadoMatricula().setIdentParametro(rs.getInt("id_006_estado_matricula"));
                matricula.setLimiteFaltasPorcentaje(rs.getInt("limite_faltas_porcentaje"));
                matricula.setFechaInicio(rs.getDate("fecha_inicio"));
                matricula.setFechaFin(rs.getDate("fecha_fin"));
                matricula.setAsignarPrimerTurnoDefecto(rs.getBoolean("asignar_primer_turno_defecto"));
                matricula.getEstado().setIdentParametro(rs.getInt("id_003_estado"));
                matricula.getCiclo().setDescripcion(rs.getString("ciclo"));
                matricula.getEstadoMatricula().setDescripcion(rs.getString("estado_matricula"));
                matricula.getEstado().setDescripcion(rs.getString("estado"));
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally{
            mysqlConexion.cerrarRecursos(ps, rs);
            return matricula;
        }
        
    }

}
