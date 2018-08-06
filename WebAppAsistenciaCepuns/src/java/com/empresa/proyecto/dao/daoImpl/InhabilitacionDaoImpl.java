package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.InhabilitacionDao;
import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.entidad.InhabilitacionBE;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InhabilitacionDaoImpl implements InhabilitacionDao {

    private static final String QUERY_OBTENER = "select id_inhabilitacion, id_alumno, id_008_razon, observaciones, id_003_estado from inhabilitacion i";
    private static final String QUERY_REGISTRAR = "insert into inhablitacion\n"
            + "(id_alumno, id_008_razon, observaciones, id_003_estado)\n"
            + "values\n"
            + "(?,?,?,?)";
    private static final String QUERY_ACTUALIZAR = "update inhabilitacion set\n"
            + "id_alumno = IFNULL(?, id_alumno),\n"
            + "id_008_razon = IFNULL(?, id_008_razon),\n"
            + "observaciones = IFNULL(?, observaciones),\n"
            + "id_003_estado = IFNULL(?, id_003_estado)\n"
            + "where id_inhabilitacion = ?";

    private MySQLConexion mysqlConexion = new MySQLConexion();

    private static final String ID_INHABILITACION = "inhabilitacion";
    private static final String ID_ALUMNO = "id_alumno";
    private static final String ID_008_RAZON = "id_008_observacion";
    private static final String OBSERVACIONES = "observaciones";
    private static final String ID_003_ESTADO = "id_003_estado";

    public InhabilitacionDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    @Override
    public List<InhabilitacionBE> obtener(InhabilitacionBE inhabilitacion) {
        List<InhabilitacionBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InhabilitacionBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            //TODO: Faltan pasar parametros
            rs = ps.executeQuery();
            lista = new ArrayList<InhabilitacionBE>();
            while (rs.next()) {
                item = new InhabilitacionBE();
                item.setIdentInhabilitacion(rs.getInt(ID_INHABILITACION));
                item.getAlumno().setIdentAlumno(rs.getInt(ID_ALUMNO));
                item.getRazon().setIdentParametro(rs.getInt(ID_008_RAZON));
                item.setObservaciones(rs.getString(OBSERVACIONES));
                item.getEstado().setIdentParametro(rs.getInt(ID_003_ESTADO));
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

    @Override
    public int registrar(InhabilitacionBE inhabilitacion) {
        int idInhabilitacion = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inhabilitacion.getAlumno().getIdentAlumno());
            ps.setInt(2, inhabilitacion.getRazon().getIdentParametro());
            ps.setString(3, inhabilitacion.getObservaciones());
            ps.setInt(4, inhabilitacion.getEstado().getIdentParametro());
            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idInhabilitacion = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO:Cerrar recursos
            return idInhabilitacion;
        }
    }

    @Override
    public boolean actualizar(InhabilitacionBE inhabilitacion) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);

            ps.setObject(1, Util.obtenerValorParametro(inhabilitacion.getAlumno().getIdentAlumno()));
            ps.setObject(2, Util.obtenerValorParametro(inhabilitacion.getRazon().getIdentParametro()));
            ps.setObject(3, inhabilitacion.getObservaciones());
            ps.setObject(2, Util.obtenerValorParametro(inhabilitacion.getEstado().getIdentParametro()));
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
