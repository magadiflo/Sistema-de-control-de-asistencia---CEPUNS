package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.EntidadDao;
import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.entidad.EntidadBE;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntidadDaoImpl implements EntidadDao {

    private static final String QUERY_OBTENER = "select id_entidad, descripcion, url, url_icono from entidad e";
//    private static final String QUERY_REGISTRAR = "insert into entidad\n"
//            + "(descripcion, url, url_icono)\n"
//            + "values\n"
//            + "(?,?,?)";
//    private static final String QUERY_ACTUALIZAR = "update entidad set\n"
//            + "descripcion = IFNULL(?, descripcion),\n"
//            + "url = IFNULL(?, url),\n"
//            + "url_icono = IFNULL(?, url_icono)\n"
//            + "where id_entidad = ?";

    private MySQLConexion mysqlConexion = new MySQLConexion();

    private static final String ID_ENTIDAD = "id_entidad";
    private static final String DESCRIPCION = "descripcion";
    private static final String URL = "url";
    private static final String URL_ICONO = "url_icono";

    public EntidadDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    @Override
    public List<EntidadBE> obtener(EntidadBE entidad) {
        List<EntidadBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        EntidadBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            rs = ps.executeQuery();
            lista = new ArrayList<EntidadBE>();
            while (rs.next()) {
                item = new EntidadBE();
                item.setIdentEntidad(rs.getInt(ID_ENTIDAD));
                item.setDescripcion(rs.getString(DESCRIPCION));
                item.setUrl(rs.getString(URL));
                item.setUrlIcono(rs.getString(URL_ICONO));
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
}
