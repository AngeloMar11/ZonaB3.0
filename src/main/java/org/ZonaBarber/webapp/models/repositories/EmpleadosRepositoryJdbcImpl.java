package org.ZonaBarber.webapp.models.repositories;

import org.ZonaBarber.webapp.models.beans.Trabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosRepositoryJdbcImpl implements Repository<Trabajador>{

    private Connection conn;
    public EmpleadosRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<Trabajador> listar() throws SQLException {
        List<Trabajador> trabajadores = new ArrayList<>();
        String sql;
        sql = "SELECT EmpleNombre, EmpleApellido, EmpleCorreo, EmpleNumIdent,EmpleTipoEmpl, EmpleNumeroTel FROM tbempleados";
        try (PreparedStatement stm = conn.prepareStatement(sql))
        {

            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                Trabajador trabajador = new Trabajador();
                trabajador.setEmplNombre(rs.getString("EmpleNombre"));
                trabajador.setEmplApellido(rs.getString("EmpleApellido"));
                trabajador.setEmplCorreo(rs.getString("EmpleCorreo"));
                trabajador.setEmplNumIdent(rs.getString("EmpleNumIdent"));
                trabajador.setEmplTipoEmpl(rs.getInt("EmpleTipoEmpl"));
                trabajador.setEmplNumeroTel(rs.getString("EmpleNumeroTel"));



                trabajadores.add(trabajador);

            }
        }
        return trabajadores;

    }

    @Override
    public Trabajador porId(int id) throws SQLException {
        return null;
    }

    public List<Trabajador> porNumDocument(Trabajador trabajador) throws SQLException {
        List<Trabajador> trabajadores = new ArrayList<>();
        String sql = "SELECT EmpleNombre, EmpleApellido, EmpleCorreo, EmpleNumIdent, EmpleTipoEmpl, EmpleNumeroTel FROM tbempleados WHERE EmpleNumIdent = ?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, trabajador.getEmplNumIdent());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                trabajador.setEmplNombre(rs.getString("EmpleNombre"));
                trabajador.setEmplApellido(rs.getString("EmpleApellido"));
                trabajador.setEmplCorreo(rs.getString("EmpleCorreo"));
                trabajador.setEmplNumIdent(rs.getString("EmpleNumIdent"));
                trabajador.setEmplTipoEmpl(rs.getInt("EmpleTipoEmpl"));
                trabajador.setEmplNumeroTel(rs.getString("EmpleNumeroTel"));
                trabajadores.add(trabajador);
            }
        }
        return trabajadores;
    }



    @Override
    public Integer guardar(Trabajador trabajador) throws SQLException {
        String sql ="INSERT INTO `zonbar`.`tbempleados` (`EmpleNombre`, `EmpleApellido`, `EmpleCorreo`, `EmpleContrasena`, `EmpleGenero`, `EmpleTipoEmpl`, `EmpleTipoIdent`, `EmpleNumIdent`) " +
                    "VALUES (UPPER(?), UPPER(?), UPPER(?), hex(aes_encrypt(?,'clave')), UPPER(?),?, UPPER(?), UPPER(?));";
        int filas;
        try (PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, trabajador.getEmplNombre());
            stm.setString(2, trabajador.getEmplApellido());
            stm.setString(3, trabajador.getEmplCorreo());
            stm.setString(4, trabajador.getEmplContrasena());
            stm.setString(5, trabajador.getEmplGenero());
            stm.setInt(6, Integer.parseInt(trabajador.getEmplTipoEmpl()));
            stm.setString(7, trabajador.getEmplTipoIdent());
            stm.setString(8, trabajador.getEmplNumIdent());
            filas = stm.executeUpdate();
        }
        return filas;

    }

    @Override
    public Integer eliminar(int id) throws SQLException {
        return null;
    }

    public Integer actualizar(Trabajador trabajador) throws SQLException {
        String sql = null;
        if (trabajador.getEmplTipoEmpl() != null) {
            sql = "UPDATE tbempleados set  EmpleCorreo=?, EmpleTipoEmpl=?, EmpleNumeroTel=? WHERE EmpleNumIdent=?";
        }
        int filas;
        try (PreparedStatement stm = conn.prepareStatement(sql)) {


            stm.setString(1, trabajador.getEmplCorreo());
            stm.setInt(2, Integer.parseInt(trabajador.getEmplTipoEmpl()));
            stm.setString(3, trabajador.getEmplNumeroTel());
            stm.setString(4, trabajador.getEmplNumIdent());


            filas = stm.executeUpdate();

        }
        return filas;

    }

    public Integer eliminarC(Trabajador trabajador) throws SQLException {
        String sql = null;
        if (trabajador.getEmplNumIdent() != null) {
            sql = "DELETE FROM tbempleados WHERE EmpleNumIdent=?";
        }
        int filas;
        try (PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, trabajador.getEmplNumIdent());
            filas = stm.executeUpdate();

        }
        return filas;
    }

    @Override
    public Trabajador createObj(ResultSet rs) throws SQLException {
       return null;
    }
}
