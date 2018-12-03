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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CerrarSesion", urlPatterns = {"/CambiarContrasena"})
public class CambiarContrasena extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //response.setContentType("text/plain");

        String contrasena = request.getParameter("txtpass");
        String verificarcontrasena = request.getParameter("txtVpass");
        if (contrasena.equals(verificarcontrasena)) {
            try {
                Consultas co = new Consultas();
                if (co.CambiarContrasena(md5.Encriptar(contrasena))) {
                    response.sendRedirect("Coordinadora.jsp");
                    //response.sendRedirect("NuevaContrasena.jsp");
                    //response.getWriter().print("exito");
                    //out.print("exito");
                } else {
                    response.sendRedirect("NuevaContrasena.jsp");

                }
            } catch (CommunicationsException ex) {
                 response.sendRedirect("ErrorPages/ErrorDeConexionBD.html");
            }

        } else {
            out.println("Invalid password <a href='NuevaContrasena.jsp'>try again</a>");
        }
    }
}
