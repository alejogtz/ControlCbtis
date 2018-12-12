/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Consultas;
import Utilidades.md5;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CambiarContrasena", urlPatterns = {"/CambiarContrasena"})
public class CambiarContrasena extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // vigilante
        String contrasena = request.getParameter("txtpass");
        String verificarcontrasena = request.getParameter("txtVpass");

        // ---------------------------------Obtener el usuario activo ------------------------------------------
        String user = request.getParameter("SesionActiva");
        System.err.println(user);

        if (contrasena.equals(verificarcontrasena)) {

            try {

                Consultas co = new Consultas();

                if (co.CambiarContrasena(md5.Encriptar(contrasena), user)) {
                    String aviso = " <center><div class=\"alert alert-success alert-dismissable\" role=\"alert\"> "                            
                            + "<strong>Exito!</strong> La contraseña fue cambiada correctamente"
                            + "</div></center> ";
                    request.setAttribute("Mensaje", aviso);
                    
                    redirection(request, response, user);
                } else {
                    String aviso = " <center><div class=\"alert alert-success alert-dismissable\" role=\"alert\"> "                            
                            + "<strong>Error!</strong> La contraseña no coincide"
                            + "</div></center> ";
                    request.setAttribute("Mensaje", aviso);
                    redirection(request, response, user);

                }

            } catch (CommunicationsException ex) {
                response.sendRedirect("ErrorPages/ErrorDeConexionBD.html");
            }

        } else {
            out.println("Invalid password <a href='NuevaContrasena.jsp'>try again</a>");
        }
    }

    public void redirection(HttpServletRequest request, HttpServletResponse response, String user) throws ServletException, IOException {
        /**
         * -------------------------------------------------------
         */
        if ("Coordinador".equals(user)) {
            RequestDispatcher rd = request.getRequestDispatcher("Coordinadora.jsp");
            rd.include(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("Portero.jsp");
            rd.include(request, response);
        }
        /**
         * -------------------------------------------------------
         */
    }
}
