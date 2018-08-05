/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.ParametroDao;
import com.empresa.proyecto.entidad.ParametroBE;
import com.empresa.proyecto.util.conexion.MySQLConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JOSDY
 */
public class ParametroDaoImpl implements ParametroDao{
    
     private static final String QUERY_OBTENER = "select id_parametro ,id_parametro_tipo,descripcion from parametro p";
     
     private MySQLConexion mysqlConexion = new MySQLConexion();
    private static final String ID_PARAMETRO = "id_parametro";
    private static final String ID_PARAMETRO_TIPO = "id_parametro_tipo";
    private static final String DESCRIPCION = "descripcion";

    public ParametroDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    public List<ParametroBE> obtener(ParametroBE parametro) {
        List<ParametroBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
         ParametroBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            //TODO: Faltan pasar parametros
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new ParametroBE();
                item.setIdentParametro(rs.getInt(ID_PARAMETRO));
                item.getParametroTipo().setIdentParametroTipo(rs.getInt(ID_PARAMETRO_TIPO));
                item.setDescripcion(rs.getString(DESCRIPCION));
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

}
