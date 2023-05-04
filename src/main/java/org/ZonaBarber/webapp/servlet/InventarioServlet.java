package org.ZonaBarber.webapp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ZonaBarber.webapp.models.beans.Productos;
import org.ZonaBarber.webapp.models.repositories.InventarioRepositoryJdcbImpl;


import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/inventarioBarber")
public class InventarioServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");
        InventarioRepositoryJdcbImpl inventario = new InventarioRepositoryJdcbImpl(conn);

        Productos productos = new Productos();
        String BtonMostrarT = req.getParameter("btnmostrart");
        String BtonBuscar = req.getParameter("btnbuscarI");
        String Btnagregar = req.getParameter("btnagregar");

        if(BtonMostrarT != null) {
            List<Productos> productosList;
            try {
                productosList = inventario.listar();
                for (Productos producto : productosList) {
                    Blob blob = producto.getProFoto();
                    if (blob != null) {
                        byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                        producto.setImageBytes(imageBytes);
                    }
                }
                req.setAttribute("productos", productosList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("Vistas/AdminInventario.jsp");
                dispatcher.forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
            if (BtonBuscar != null) {
            String ProNombre = req.getParameter("ProNombre");
            productos.setProNombre(ProNombre);
            try {
                List<Productos> productosList = inventario.porNombre(productos);
                req.setAttribute("productos", productosList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("Vistas/AdminInventario.jsp");
                dispatcher.forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(Btnagregar != null) {
            String Proid = req.getParameter("ProId");
            String ProNombre = req.getParameter("ProNombre");
            String ProValor = req.getParameter("ProValor");
            String ProCantidad = req.getParameter("ProCantidad");
            //String ProFoto = req.getParameter("ProFoto");

            productos.setProId(Integer.parseInt(Proid));
            productos.setProNombre(ProNombre);
            productos.setProvalor(Integer.parseInt(ProValor));
            productos.setProCantidad(Integer.parseInt(ProCantidad));
            //productos.setProFoto();
            try {
                if (inventario.guardar(productos) == 1) {
                    System.out.println("ACA NO");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("Vistas/AdminInventario.jsp");
                    dispatcher.forward(req, resp);

                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
        /*
        if(BtonEliminarE != null)
        {

            String EmplNumIdent = req.getParameter("EmplNumIdent");
            trabajador.setEmplNumIdent(EmplNumIdent);

            try {
                if (trabajadorli.eliminarC(trabajador) == 1){
                    RequestDispatcher dispatcher = req.getRequestDispatcher("Vistas/EditarAdmin.jsp");
                    dispatcher.forward(req,resp);
                    System.out.println(trabajador.getEmplNumIdent());
                }
                else
                {
                    System.out.println(trabajador.getEmplNumIdent());
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

*/
        }
    }


