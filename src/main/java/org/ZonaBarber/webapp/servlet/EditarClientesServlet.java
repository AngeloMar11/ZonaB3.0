package org.ZonaBarber.webapp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ZonaBarber.webapp.models.beans.Trabajador;
import org.ZonaBarber.webapp.models.repositories.EmpleadosRepositoryJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/editarEmpl")
public class EditarClientesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");
        EmpleadosRepositoryJdbcImpl trabajadorli = new EmpleadosRepositoryJdbcImpl(conn);
        Trabajador trabajador = new Trabajador();
        String BtonBuscar = req.getParameter("btnbuscar");
        String BtonMostrarT = req.getParameter("btnmostrart");
        String BtonAplicar = req.getParameter("btnaplicar");
        String BtonEliminarE = req.getParameter("btneliminar");

        if (BtonBuscar != null) {
            String EmplNumIdent = req.getParameter("NumDocument");
            trabajador.setEmplNumIdent(EmplNumIdent);
            try {
                List<Trabajador> trabajadores = trabajadorli.porNumDocument(trabajador);
                req.setAttribute("trabajadores", trabajadores);
                RequestDispatcher dispatcher = req.getRequestDispatcher("Vistas/EditarAdmin.jsp");
                dispatcher.forward(req, resp);
                for (Trabajador t : trabajadores) {
                    System.out.println(t.getEmplNombre() + " " + t.getEmplApellido());
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else if(BtonMostrarT != null) {
            try {
                List<Trabajador> trabajadores = trabajadorli.listar();
                req.setAttribute("trabajadores", trabajadores);
                RequestDispatcher dispatcher = req.getRequestDispatcher("Vistas/EditarAdmin.jsp");
                dispatcher.forward(req, resp);
                for (Trabajador t : trabajadores) {
                    System.out.println(t.getEmplNombre() + " " + t.getEmplApellido());
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(BtonAplicar != null) {
            String EmplNumIdent = req.getParameter("EmplNumIdent");
            String EmplCorreo = req.getParameter("Emplacorreo");
            String EmplTipoEmpl = req.getParameter("EmpltipoUsuario");
            String EmplTel = req.getParameter("EmpltelefonoE");

            trabajador.setEmplCorreo(EmplCorreo);
            trabajador.setEmplNumIdent(EmplNumIdent);
            trabajador.setEmplTipoEmpl(Integer.parseInt(EmplTipoEmpl));
            trabajador.setEmplNumeroTel(EmplTel);
            try {
                if (trabajadorli.actualizar(trabajador) == 1) {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("Vistas/EditarAdmin.jsp");
                    dispatcher.forward(req, resp);
                    ;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
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


        }
    }
}

