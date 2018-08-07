package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.AsistenciaDao;
import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDaoImpl implements AsistenciaDao {

    private static final String QUERY_OBTENER = "select id_asistencia, a.id_programacion_horario, fecha, numero_semana, id_005_dia, id_turno, p.descripcion dia_descripcion, m.anio, p3.descripcion ciclo, ph.unidad from asistencia a join parametro p on p.id_parametro = a.id_005_dia join programacion_horario ph on ph.id_programacion_horario = a.id_programacion_horario join matricula m on m.id_matricula = ph.id_matricula join parametro p3 on p3.id_parametro = m.id_004_ciclo where (? is null or ? = 0 or a.id_asistencia = ?) and (? is null or ? = 0 or m.id_matricula = ?) ";
    private static final String QUERY_REGISTRAR = "insert into asistencia\n"
            + "(id_programacion_horario, fecha, numero_semana, id_005_dia, id_turno)\n"
            + "values\n"
            + "(?,?,?,?,?)";
    private static final String QUERY_ACTUALIZAR = "update asistencia set\n"
            + "id_programacion_horario = IFNULL(?, id_programacion_horario),\n"
            + "fecha = IFNULL(?, fecha),\n"
            + "numero_semana = IFNULL(?, numero_semana),\n"
            + "id_005_dia = IFNULL(?, id_005_dia),\n"
            + "id_turno = IFNULL(?, id_turno)\n"
            + "where id_asistencia = ?";

    private static final String QUERY_OBTENER_ASISTENCIA_POR_FECHA = "select\n" +
"a.id_asistencia\n" +
"from asistencia a \n" +
"join programacion_horario p on a.id_programacion_horario = p.id_programacion_horario\n" +
"where a.fecha = ?";
    
    private MySQLConexion mysqlConexion = new MySQLConexion();

    private static final String ID_ASISTENCIA = "id_asistencia";
    private static final String ID_PROGRAMACION_HORARIO = "id_programacion_horario";
    private static final String FECHA = "fecha";
    private static final String NUMERO_SEMANA = "numero_semana";
    private static final String ID_005_DIA = "id_005_dia";
    private static final String ID_TURNO = "id_turno";

    public AsistenciaDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    @Override
    public List<AsistenciaBE> obtener(AsistenciaBE asistencia) {
        List<AsistenciaBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AsistenciaBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            ps.setInt(1, asistencia.getIdentAsistencia());
            ps.setInt(2, asistencia.getIdentAsistencia());
            ps.setInt(3, asistencia.getIdentAsistencia());
            ps.setInt(4, asistencia.getProgramacionHorario().getMatricula().getIdentMatricula());
            ps.setInt(5, asistencia.getProgramacionHorario().getMatricula().getIdentMatricula());
            ps.setInt(6, asistencia.getProgramacionHorario().getMatricula().getIdentMatricula());
            rs = ps.executeQuery();
            
            lista = new ArrayList<AsistenciaBE>();
            while (rs.next()) {
                item = new AsistenciaBE();
                item.setIdentAsistencia(rs.getInt(ID_ASISTENCIA));
                item.getProgramacionHorario().setIdentProgramacionHorario(rs.getInt(ID_PROGRAMACION_HORARIO));
                item.getProgramacionHorario().setUnidad(rs.getInt("unidad"));
                item.setFecha(rs.getDate(FECHA));
                item.setNumeroSemana(rs.getInt(NUMERO_SEMANA));
                item.getDia().setIdentParametro(rs.getInt(ID_005_DIA));
                item.getDia().setDescripcion(rs.getString("dia_descripcion"));
                item.getTurno().setIdentTurno(rs.getInt(ID_TURNO));
                item.getProgramacionHorario().getMatricula().getCiclo().setDescripcion(rs.getString("ciclo"));
                item.getProgramacionHorario().getMatricula().setAnio(rs.getInt("anio"));
                lista.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConexion.cerrarRecursos(ps, rs);
            System.out.println("***registro asistencia***");
            return lista;
        }

    }

    @Override
    public int registrar(AsistenciaBE asistencia) {
        int idAsistencia = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, asistencia.getProgramacionHorario().getIdentProgramacionHorario());
            ps.setDate(2, asistencia.getFecha());
            ps.setInt(3, asistencia.getNumeroSemana());
            ps.setInt(4, asistencia.getDia().getIdentParametro());
            ps.setInt(5, asistencia.getTurno().getIdentTurno());
            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idAsistencia = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConexion.cerrarRecursos(ps, rs);
            return idAsistencia;
        }
    }

    @Override
    public boolean actualizar(AsistenciaBE asistencia) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);

            ps.setObject(1, Util.obtenerValorParametro(asistencia.getProgramacionHorario().getIdentProgramacionHorario()));
            ps.setObject(2, asistencia.getFecha());
            ps.setObject(3, Util.obtenerValorParametro(asistencia.getNumeroSemana()));
            ps.setObject(4, asistencia.getDia());
            ps.setObject(5, Util.obtenerValorParametro(asistencia.getTurno().getIdentTurno()));
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
    public int obtenerIdAsistenciaPorFecha(String fecha) {
        int idAsistencia = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER_ASISTENCIA_POR_FECHA);
            ps.setString(1, fecha);
            rs = ps.executeQuery();
            
            if(rs.next()){
                idAsistencia = rs.getInt("id_asistencia");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConexion.cerrarRecursos(ps, rs);
            return idAsistencia;
        }
    }

}
