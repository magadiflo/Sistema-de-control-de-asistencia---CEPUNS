package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.AsistenciaDetalleDao;
import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.entidad.AsistenciaDetalleBE;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDetalleDaoImpl implements AsistenciaDetalleDao {

//    private static final String QUERY_OBTENER = "select id_asistencia_detalle, id_asistencia, id_alumno, id_007_estado_asistencia, observacion from asistencia_detalle ad";
    private static final String QUERY_REGISTRAR = "insert into asistencia_detalle\n"
            + "(id_asistencia, id_alumno, id_007_estado_asistencia, observacion)\n"
            + "values\n"
            + "(?,?,?,?)";

    private MySQLConexion mysqlConexion = new MySQLConexion();

    private static final String QUERY_OBTENER = "select\n" +
"d.id_asistencia_detalle\n" +
",d.id_asistencia\n" +
",d.id_alumno\n" +
",d.id_007_estado_asistencia\n" +
",ifnull(d.observacion,'') as observacion\n" +
",p.nombres \n" +
",p.paterno\n" +
",p.materno\n" +
",pa.id_parametro\n" +
",pa.descripcion estado_asistencia\n" +
",a.codigo "+
"from asistencia_detalle d\n" +
"join alumno a on a.id_alumno = d.id_alumno\n" +
"join persona p on p.id_persona = a.id_persona\n" +
"join parametro pa on pa.id_parametro = d.id_007_estado_asistencia "+
"where d.id_asistencia = ? ";
//"where d.id_asistencia = ? or ph.id_matricula = ?";
    
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
            mysqlConexion.cerrarRecursos(ps, rs);
            System.out.println("**********REGISTRO ASISTENCIA DETALLE ****");
            return idAsistenciaDetalle;
        }
    }

    @Override
    public List<AsistenciaDetalleBE> obtener(AsistenciaBE asistencia) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AsistenciaDetalleBE> listDetalle = null;
        AsistenciaDetalleBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            ps.setInt(1, asistencia.getIdentAsistencia());
            
            
            rs = ps.executeQuery();
            listDetalle = new ArrayList<AsistenciaDetalleBE>();
            while(rs.next()){
                item = new AsistenciaDetalleBE();
                item.setIdentAsistenciaDetalle(rs.getInt("id_asistencia_detalle"));
                item.getAsistencia().setIdentAsistencia(rs.getInt("id_asistencia"));
                item.getAlumno().setIdentAlumno(rs.getInt("id_alumno"));
                item.getEstadoAsistencia().setIdentParametro(rs.getInt("id_007_estado_asistencia"));
                item.setObservacion(rs.getString("observacion"));
                item.getAlumno().getPersona().setNombres(rs.getString("nombres"));
                item.getAlumno().setCodigo(rs.getString("codigo"));
                item.getAlumno().getPersona().setPaterno(rs.getString("paterno"));
                item.getAlumno().getPersona().setMaterno(rs.getString("materno"));
                item.getEstadoAsistencia().setDescripcion(rs.getString("estado_asistencia"));
                listDetalle.add(item);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally{
            mysqlConexion.cerrarRecursos(ps, rs);
            return listDetalle;
        }
    }

}
