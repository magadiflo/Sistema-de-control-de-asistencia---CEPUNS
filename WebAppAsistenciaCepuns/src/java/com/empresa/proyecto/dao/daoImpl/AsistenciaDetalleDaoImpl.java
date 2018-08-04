package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.AsistenciaDetalleDao;
import com.empresa.proyecto.entidad.AsistenciaDetalleBE;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AsistenciaDetalleDaoImpl implements AsistenciaDetalleDao {

//    private static final String QUERY_OBTENER = "select id_asistencia_detalle, id_asistencia, id_alumno, id_007_estado_asistencia, observacion from asistencia_detalle ad";
    private static final String QUERY_REGISTRAR = "insert into asistencia_detalle\n"
            + "(id_asistencia, id_alumno, id_007_estado_asistencia, observacion)\n"
            + "values\n"
            + "(?,?,?,?)";
//    private static final String QUERY_ACTUALIZAR = "update asistencia_detalle set\n"
//            + "id_asistencia = IFNULL(?, id_asistencia),\n"
//            + "id_alumno = IFNULL(?, id_alumno),\n"
//            + "id_007_estado_asistencia = IFNULL(?, id_007_estado_asistencia),\n"
//            + "observacion = IFNULL(?, observacion)\n"
//            + "where id_asistencia_detalle = ?";

    private MySQLConexion mysqlConexion = new MySQLConexion();

//    private static final String ID_ASISTENCIA_DETALLE = "id_asistencia_detalle";
//    private static final String ID_ASISTENCIA = "id_asistencia";
//    private static final String ID_ALUMNO = "id_alumno";
//    private static final String ID_007_ESTADO_ASISTENCIA = "id_007_estado_asistencia";
//    private static final String OBSERVACION = "observacion";
    public AsistenciaDetalleDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    @Override
    public int registrar(AsistenciaDetalleBE asistenciaDetalle) {
        int idAsistenciaDetalle = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, asistenciaDetalle.getAsistencia().getIdentAsistencia());
            ps.setInt(2, asistenciaDetalle.getAlumno().getIdentAlumno());
            ps.setInt(3, asistenciaDetalle.getEstadoAsistencia().getIdentParametro());
            ps.setString(4, asistenciaDetalle.getObservacion());
            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idAsistenciaDetalle = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO:Cerrar recursos
            return idAsistenciaDetalle;
        }
    }

}
