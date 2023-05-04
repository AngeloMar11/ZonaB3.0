package org.ZonaBarber.webapp.models.repositories;

import org.ZonaBarber.webapp.models.beans.Clientes;

import java.sql.*;
import java.util.List;

public class ClientesRepositoryJdbcImpl implements Repository<Clientes> {

    private Connection conn;
    public ClientesRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<Clientes> listar() throws SQLException {
        return null;
    }

    @Override
    public Clientes porId(int id) throws SQLException {

        return null;
    }


    @Override
    public Integer guardar(Clientes clientes) throws SQLException {
        String sql;
        if (clientes.getClientesId() > 0) {
            sql = "update tblclientes set nombre=?, precio=?, sku=?, categoria_id=? where id=?";
        }else {
            sql = "INSERT INTO `zonbar`.`tbclientes` (`ClientesNombre`, `ClientesApellido`, `ClientesDireccion`, `ClientesIdentificacion`, `ClienteTipoIdent`, `ClientesCelular`, `ClientesCorreo`, `ClientesContrasena`) VALUES" +
                    "(UPPER(?),UPPER(?),UPPER(?),?,UPPER(?),?,UPPER(?), hex(aes_encrypt(?,'clave')));";
        }
        int filas;
        try (PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, clientes.getClientesNombre());
            stm.setString(2, clientes.getClientesApellido());
            stm.setString(3, clientes.getClientesDireccion());
            stm.setString(4, clientes.getClientesIdentificacion());
            stm.setString(5, clientes.getClientesTipoIdent());
            stm.setString(6, clientes.getClientesCelular());
            stm.setString(7, clientes.getClientesCorreo());
            stm.setString(8, clientes.getClientesContrasena());



            filas = stm.executeUpdate();
        }
        return filas;

    }



    @Override
    public Integer eliminar(int id) throws SQLException {
    return null;
    }

    @Override
    public Clientes createObj(ResultSet rs) throws SQLException {
        Clientes c = new Clientes();
        c.setClientesNombre(rs.getString("Nombre"));
        c.setClientesApellido(rs.getString("Apellido"));
        c.setClientesDireccion(rs.getString("Direccion"));
        c.setClientesIdentificacion(rs.getString("identifiacion"));
        c.setClientesTipoIdent(rs.getString( "tipo_identifiacion"));
        c.setClientesCelular(rs.getString("Celular"));
        c.setClientesCorreo(rs.getString("Correo"));
        c.setClientesCorreo(rs.getString("Contraseña"));

        return c;
    }



}
