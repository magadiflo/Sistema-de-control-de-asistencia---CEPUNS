/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.dao.daoImpl;

import com.empresa.proyecto.dao.UsuarioDao;
import com.empresa.proyecto.entidad.UsuarioBE;
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
public class UsuarioDaoImpl implements UsuarioDao{

    private static final String QUERY_OBTENER = "select id_usuario ,id_persona,id_rol, cuenta,password,id_003_estado from usuario u";
    private static final String QUERY_REGISTRAR = "insert into usuario\n"
            + "(id_persona,id_rol, cuenta,password,id_003_estado) \n"
            + "values\n"
            + "(?,?,?,?,?)";
    private static final String QUERY_ACTUALIZAR = "update usuario\n"
            + "set\n"
            + ",id_persona = IFNULL(?, id_persona)\n"
            + ",id_rol = IFNULL(?,id_rol)\n"
            + ",cuenta = IFNULL(?, cuenta)\n"
            + ",password = IFNULL(?,password)\n"
            + ",id_003_estado = IFNULL(?, id_003_estado)\n"
            + "where id_usuario = ?";
    private MySQLConexion mysqlConexion = new MySQLConexion();

    private static final String ID_USUARIO = "id_usuario";
    private static final String ID_PERSONA = "id_persona";
    private static final String ID_ROL = "id_rol";
    private static final String CUENTA = "cuenta";
    private static final String PASSWORD = "password";
    private static final String ID_003_ESTADO = "id_003_estado";

    public UsuarioDaoImpl() {
        if (!mysqlConexion.isConnect()) {
            mysqlConexion.conectar();
        }
    }

    public List<UsuarioBE> obtener(UsuarioBE usuario) {
        List<UsuarioBE> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UsuarioBE item = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_OBTENER);
            //TODO: Faltan pasar parametros
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new UsuarioBE();
                item.setIdentUsuario(rs.getInt(ID_USUARIO));
                item.getPersona().setIdentPersona(rs.getInt(ID_PERSONA));
                item.getRol().setIdentRol(rs.getInt(ID_ROL));
                item.setCuenta(rs.getString(CUENTA));
                item.setPassword(rs.getString(PASSWORD));
                item.getEstado().setIdentParametro(rs.getInt(ID_003_ESTADO));

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

    public int registrar(UsuarioBE usuario) {
        int idUsuario = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareStatement(QUERY_REGISTRAR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, usuario.getPersona().getIdentPersona());
            ps.setInt(2, usuario.getRol().getIdentRol());
            ps.setString(3, usuario.getCuenta());
            ps.setString(4, usuario.getPassword());
            ps.setInt(5, usuario.getEstado().getIdentParametro());

            if (ps.executeUpdate() == 0) {
                throw new Exception("Error al registrar");
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConexion.cerrarRecursos(ps, rs);
            return idUsuario;
        }
    }

    public boolean actualizar(UsuarioBE usuario) {
        boolean actualizo = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = mysqlConexion.getConnection().prepareCall(QUERY_ACTUALIZAR);
            ps.setObject(1, Util.obtenerValorParametro(usuario.getPersona().getIdentPersona()));
            ps.setObject(2, Util.obtenerValorParametro(usuario.getRol().getIdentRol()));
            ps.setObject(3, Util.obtenerValorParametro(usuario.getCuenta()));
            ps.setObject(4, Util.obtenerValorParametro(usuario.getPassword()));
            ps.setObject(8, Util.obtenerValorParametro(usuario.getEstado().getIdentParametro()));
            ps.setObject(9, Util.obtenerValorParametro(usuario.getIdentUsuario()));

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
