package org.ZonaBarber.webapp.models.repositories;

import org.ZonaBarber.webapp.models.beans.Clientes;
import org.ZonaBarber.webapp.models.beans.Trabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidacionesRepocitoryLoginRegister {

    private Connection conn;
    public ValidacionesRepocitoryLoginRegister(Connection conn) {
        this.conn = conn;
    }
    public int existeCliente(Clientes cliente) throws SQLException {
        int existe = 0;
        String sql = "SELECT COUNT(*) FROM tbclientes WHERE ClientesCorreo=? or Clientesidentificacion=?";

        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, cliente.getClientesCorreo());
            stm.setString(2, cliente.getClientesIdentificacion());


            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    existe = 1;
                }
            }
        }

        return existe;
    }
    public int existeEmpleado(Trabajador trabajador) throws SQLException {
        int existe = 0;
        String sql = "SELECT COUNT(*) FROM tbempleados WHERE EmpleCorreo=? or EmpleNumIdent=?";

        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, trabajador.getEmplCorreo());
            stm.setString(2, trabajador.getEmplNumIdent());


            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    existe = 1;
                }
            }
        }

        return existe;
    }
    public int existeCorreo(Clientes cliente) throws SQLException {
        int existe = 0;
        String sql = "SELECT COUNT(*) FROM tbclientes WHERE ClientesCorreo=?";

        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, cliente.getClientesCorreo());

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    existe = 1;
                }
            }
        }

        return existe;
    }
    public int existeCorreoEmple(Trabajador trabajador) throws SQLException {
        int ex = 0;
        String sql = "SELECT COUNT(EmpleId) FROM tbempleados WHERE EmpleCorreo=?";

        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, trabajador.getEmplCorreo());

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    ex = 1;
                }
            }
        }

        return ex;
    }

    public int ValAdmin(Trabajador trabajador) throws SQLException
    {
        int tipo = 0;
        String sql = "SELECT EmpleTipoEmpl FROM tbempleados WHERE EmpleCorreo = ?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, trabajador.getEmplCorreo());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                tipo = rs.getInt("EmpleTipoEmpl");
            }
        }
        return tipo;
    }

    public String Decrip(Clientes clientes) throws SQLException
    {
        String contrasena = null;
        String sql = "SELECT convert( aes_decrypt(unhex(ClientesContrasena),'clave')using utf8) AS contrdesc from tbclientes where ClientesCorreo = ?";

        try (PreparedStatement stm = conn.prepareStatement(sql);){

            stm.setString(1, clientes.getClientesCorreo());
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                String contra= rs.getString("contrdesc");
                contrasena = contra;
            }


        }
        return contrasena;
    }

    public String DecripEm(Trabajador trabajador) throws SQLException
    {
        String contrasena = null;
        String sql = "SELECT convert( aes_decrypt(unhex(EmpleContrasena),'clave')using utf8) AS contrdesc from tbempleados where EmpleCorreo = ?";

        try (PreparedStatement stm = conn.prepareStatement(sql);){

            stm.setString(1, trabajador.getEmplCorreo());
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                String contra= rs.getString("contrdesc");
                contrasena = contra;
            }

            System.out.println("Contraseña obtenida de la base de datos: " + contrasena);
        }

        return contrasena;
    }

    public String MostrarNomC(Clientes clientes) throws SQLException
    {
        String Nombre = null;
        String Apellido = null;
        String Foto = null;
        String sql = "SELECT ClientesNombre, ClientesApellido, ClientesFoto FROM tbclientes where ClientesCorreo = ?";

        try (PreparedStatement stm = conn.prepareStatement(sql);){

            stm.setString(1, clientes.getClientesCorreo());
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                String n= rs.getString("ClientesNombre");
                String a= rs.getString("ClientesApellido");
                String f= rs.getString("ClientesFoto");
                Nombre = n;
                Apellido = a;
                Foto = f;

            }

        }
        return (Nombre +" "+ Apellido);

    }


    public byte[] MostrarFotoCl(Clientes clientes) throws SQLException
    {

        String Foto = null;
        String sql = "SELECT ClientesFoto FROM tbclientes where ClientesCorreo = ?";

        try (PreparedStatement stm = conn.prepareStatement(sql);){

            stm.setString(1, clientes.getClientesCorreo());
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                String f= rs.getString("ClientesFoto");
                Foto = f;
                System.out.println(Foto);
            }

        }
        return null;

    }
    public String MostrarEmpl(Trabajador trabajador) throws SQLException
    {
        String Nombre = null;
        String Apellido = null;
        String sql = "SELECT EmpleNombre, EmpleApellido  FROM tbempleados where EmpleCorreo = ?";

        try (PreparedStatement stm = conn.prepareStatement(sql);){

            stm.setString(1, trabajador.getEmplCorreo());
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                String n= rs.getString("EmpleNombre");
                String a= rs.getString("EmpleApellido");
                Nombre = n;
                Apellido = a;

            }


        }
        return (Nombre +" "+ Apellido);

    }

}
