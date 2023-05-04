package org.ZonaBarber.webapp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ZonaBarber.webapp.models.beans.Trabajador;
import org.ZonaBarber.webapp.models.repositories.EmpleadosRepositoryJdbcImpl;
import org.ZonaBarber.webapp.models.repositories.ValidacionesRepocitoryLoginRegister;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/registroEmpleados")
public class CrearEmpleadosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");


        String EmplNombre = req.getParameter("Emplnombre");
        String EmplApellido = req.getParameter("EmplApellido");
        String EmplGenero = req.getParameter("EmplGenero");
        String EmplTipoIdent = req.getParameter("EmplTipoIdent");
        String EmplNumIdent = req.getParameter("EmplNumIdent");
        String EmplTipoEmpl = req.getParameter("EmplTipoEmpl");
        String EmplCorreo = req.getParameter("EmplCorreo");
        String EmplContrasena = req.getParameter("EmplContrasena");

        Trabajador trabajador = new Trabajador();

        trabajador.setEmplNombre(EmplNombre);
        trabajador.setEmplApellido(EmplApellido);
        trabajador.setEmplCorreo(EmplCorreo);
        trabajador.setEmplContrasena(EmplContrasena);
        trabajador.setEmplGenero(EmplGenero);
        trabajador.setEmplTipoEmpl(Integer.parseInt(EmplTipoEmpl));
        trabajador.setEmplTipoIdent(EmplTipoIdent);
        trabajador.setEmplNumIdent(EmplNumIdent);

        EmpleadosRepositoryJdbcImpl empleadosR = new EmpleadosRepositoryJdbcImpl(conn);
        ValidacionesRepocitoryLoginRegister validacionR = new ValidacionesRepocitoryLoginRegister(conn);

        String Nombre = null;
        try {
            Nombre = validacionR.MostrarEmpl(trabajador);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("nombreCliente", Nombre);

        try {
            if(validacionR.existeCorreoEmple(trabajador) > 0) {
                req.setAttribute("mensajeExistente", "El usuario que desea crear ya existe");
                RequestDispatcher dispatcher = req.getRequestDispatcher("Vistas/AdminCrear.jsp");
                dispatcher.forward(req, resp);
            }else if (empleadosR.guardar(trabajador) == 1) {
                req.setAttribute("empleadocreado", "Usuario creado correctamente");
                RequestDispatcher dispatcher = req.getRequestDispatcher("Vistas/AdminCrear.jsp");
                dispatcher.forward(req, resp);
            } else {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
