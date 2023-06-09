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

@WebServlet("/loginC")
public class LoginClientesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");

        String correo = req.getParameter("correo");
        String contrasena = req.getParameter("contrasena");


        Clientes clientes = new Clientes();
        Trabajador trabajador = new Trabajador();

        clientes.setClientesCorreo(correo);
        clientes.setClientesContrasena(contrasena);

        //
        trabajador.setEmplCorreo(correo);
        trabajador.setEmplContrasena(contrasena);


        ValidacionesRepocitoryLoginRegister validacionR = new ValidacionesRepocitoryLoginRegister(conn);
        boolean v = true;
        try {
            if(validacionR.existeCorreoEmple(trabajador) > 0) {
                if(validacionR.ValAdmin(trabajador) == 1)
                {
                    if(Objects.equals(validacionR.DecripEm(trabajador), contrasena))
                    {
                        String Nombre = validacionR.MostrarEmpl(trabajador);
                        req.setAttribute("nombreCliente", Nombre);
                        req.getRequestDispatcher("Vistas/AdminPage.jsp").forward(req, resp);

                    }
                    else {
                        req.setAttribute("mensajeErrorContr", "La contraseña o el correo son incorrectos");

                        // Vuelve a cargar la página de inicio de sesión
                        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                        dispatcher.forward(req, resp);

                    }

                } else if (validacionR.ValAdmin(trabajador) == 2) {
                    if(Objects.equals(validacionR.DecripEm(trabajador), contrasena))
                    {
                        String Nombre = validacionR.MostrarEmpl(trabajador);
                        req.setAttribute("nombreCliente", Nombre);
                        req.getRequestDispatcher("inicioEmpl.jsp").forward(req, resp);
                    }
                    else {
                        req.setAttribute("mensajeErrorContr", "La contraseña o el correo son incorrectos");

                        // Vuelve a cargar la página de inicio de sesión
                        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                        dispatcher.forward(req, resp);
                    }

                } else {
                    resp.sendRedirect("ErrorC.jsp");
                }
            }else if (validacionR.existeCorreo(clientes) > 0) {


                    if(Objects.equals(validacionR.Decrip(clientes), contrasena))
                    {

                        String Nombre = validacionR.MostrarNomC(clientes);
                        byte[] Foto = validacionR.MostrarFotoCl(clientes);
                        String base64Foto = Base64.getEncoder().encodeToString(Foto); // convertir imagen a base64
                        req.setAttribute("fotoCliente", base64Foto); // agregar imagen como atributo de solicitud
                        req.setAttribute("nombreCliente", Nombre);
                        req.getRequestDispatcher("Vistas/ClientePage.jsp").forward(req, resp);
                    }
                else {
                    req.setAttribute("mensajeErrorContr", "La contraseña o el correo son incorrectos");

                    // Vuelve a cargar la página de inicio de sesión
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(req, resp);
                }
            }
            else{
                req.setAttribute("mensajeErrorCorre", "El usuario no se encuentra registrado");

                // Vuelve a cargar la página de inicio de sesión
                RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
