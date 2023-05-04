package org.ZonaBarber.webapp.models.repositories;

import org.ZonaBarber.webapp.models.beans.Productos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventarioRepositoryJdcbImpl implements Repository<Productos>{

    private Connection conn;
    public InventarioRepositoryJdcbImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Productos> listar() throws SQLException {
        List<Productos> productosList = new ArrayList<>();
        String sql = "SELECT ProducId, ProductoNombre, ProductoValor, ProductoCantidad, ProductoFoto FROM tbproductosinv";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Productos productos = new Productos();
                productos.setProId(rs.getInt("ProducId"));
                productos.setProNombre(rs.getString("ProductoNombre"));
                productos.setProvalor(rs.getInt("ProductoValor"));
                productos.setProCantidad(rs.getInt("ProductoCantidad"));
                productos.setProFoto(rs.getBlob("ProductoFoto"));
                productosList.add(productos);
            }
        }
        return productosList;
    }




    public List<Productos> porNombre(Productos productos) throws SQLException {
        List<Productos> productosList = new ArrayList<>();
        String sql = "SELECT ProducId, ProductoNombre, ProductoValor, ProductoCantidad, ProductoFoto FROM tbproductosinv WHERE ProductoNombre = ?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, productos.getProNombre());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                productos.setProId(rs.getInt("ProducId"));
                productos.setProNombre(rs.getString("ProductoNombre"));
                productos.setProvalor(rs.getInt("ProductoValor"));
                productos.setProCantidad(rs.getInt("ProductoCantidad"));
                //productos.setProFoto(rs.getBlob("ProductoFoto"));;
                productosList.add(productos);
            }
        }
        return productosList;
    }

    @Override
    public Productos porId(int id) throws SQLException {
        return null;
    }

    @Override
    public Integer guardar(Productos productos) throws SQLException {
        String sql = "INSERT INTO `zonbar`.`tbproductosinv` (`ProducId`, `ProductoNombre`, `ProductoValor`, `ProductoCantidad`) VALUES (?, UPPER(?), ?, ?);";
        int filas = 0;
        try (PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, productos.getProId());
            stm.setString(2,productos.getProNombre());
            stm.setInt(3, productos.getProvalor());
            stm.setInt(4, productos.getProCantidad());
            filas = stm.executeUpdate();
            System.out.println("entrooooo");
        }
        return filas;
    }

    @Override
    public Integer eliminar(int id) throws SQLException {
        return null;
    }

    @Override
    public Productos createObj(ResultSet rs) throws SQLException {
        return null;
    }
}
