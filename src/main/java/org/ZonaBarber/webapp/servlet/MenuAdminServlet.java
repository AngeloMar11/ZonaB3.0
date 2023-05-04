package org.ZonaBarber.webapp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ZonaBarber.webapp.models.beans.Clientes;
import org.ZonaBarber.webapp.models.beans.Trabajador;
import org.ZonaBarber.webapp.models.repositories.ClientesRepositoryJdbcImpl;
import org.ZonaBarber.webapp.models.repositories.ValidacionesRepocitoryLoginRegister;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;


@WebServlet("/adminMenu")
public class MenuAdminServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String crearU = req.getParameter("crearu");
        String editarU = req.getParameter("editaru");
        String invent = req.getParameter("invent");
        if (crearU != null)
        {
            req.getRequestDispatcher("Vistas/AdminCrear.jsp").forward(req,resp);
        }
        else if (editarU != null)
        {
            req.getRequestDispatcher("Vistas/EditarAdmin.jsp").forward(req,resp);
        }
        else if(invent != null)
        {
            req.getRequestDispatcher("Vistas/AdminInventario.jsp").forward(req,resp);
        }


    }
}
