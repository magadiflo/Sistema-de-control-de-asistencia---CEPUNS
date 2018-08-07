package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.EspecialidadDao;
import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.entidad.EspecialidadBE;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadDaoImpl implements EspecialidadDao {

    private static final String QUERY_OBTENER = "select id_especialidad, es.descripcion especialidad, codigo, id_003_estado, es.id_facultad, f.descripcion facultad from especialidad es join facultad f on f.id_facultad = es.id_facultad";
    private static final String QUERY_REGISTRAR = "insert into especialidad\n"
            + "(descripcion, codigo, id_003_estado)\n"
            + "values\n"
            + "(?,?,?)";
    private static final String QUERY_ACTUALIZAR = "update especialidad set\n"
            + "descripcion = IFNULL(?, descripcion),\n"
            + "codigo = IFNULL(?, codigo),\n"
            + "id_003_estado = IFNULL(?, id_003_estado)\n"
            + "where id_especialidad = ?";

    private MySQLConexion mysqlConexion = new MySQLConexion();

    private static final String ID_ESPECIALIDAD = "id_especialidad";
    private static final String DESCRIPCION = "especialidad";
    private static final String CODIGO = "codigo";
    private static final String ID_003_ESTADO = "id_003_estado";

    public EspecialidadDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    @Override
    public List<EspecialidadBE> obtener(EspecialidadBE especialidad) {
        List<EspecialidadBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        EspecialidadBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            
            rs = ps.executeQuery();
            lista = new ArrayList<EspecialidadBE>();
            while (rs.next()) {
                item = new EspecialidadBE();
                item.setIdentEspecialidad(rs.getInt(ID_ESPECIALIDAD));
                item.setDescripcion(rs.getString(DESCRIPCION));
                item.setCodigo(rs.getString(CODIGO));
                item.getEstado().setIdentParametro(rs.getInt(ID_003_ESTADO));
                item.getFacultad().setIdentFacultad(rs.getInt("id_facultad"));
                item.getFacultad().setDescripcion(rs.getString("facultad"));
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

    @Override
    public int registrar(EspecialidadBE especialidad) {
        int idEspecialidad = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, especialidad.getDescripcion());
            ps.setString(2, especialidad.getCodigo());
            ps.setInt(3, especialidad.getEstado().getIdentParametro());
            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idEspecialidad = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConexion.cerrarRecursos(ps, rs);
            return idEspecialidad;
        }
    }

    @Override
    public boolean actualizar(EspecialidadBE especialidad) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);
            ps.setObject(1, especialidad.getDescripcion());
            ps.setObject(2, especialidad.getCodigo());
            ps.setObject(3, Util.obtenerValorParametro(especialidad.getEstado().getIdentParametro()));
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

}
