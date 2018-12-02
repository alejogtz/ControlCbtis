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
import javax.servlet.http.HttpSession;

@WebServlet(name = "IniciarSesion", urlPatterns = {"/Iniciar"})
public class InicioSesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            
            String usuario = request.getParameter("usuario");
            String encriptado = request.getParameter("contrasena");
            String contrasena = md5.Encriptar(encriptado);
            
            
            Consultas co = new Consultas();
            
            if (co.autenticacion(usuario, contrasena)) {
                if ("coordinador".equals(usuario)) {
                    HttpSession objsesion = request.getSession(true);
                    objsesion.setAttribute("usuario", usuario);
                    objsesion.setAttribute("relativeIndex", "Coordinadora.jsp");                    
                    response.sendRedirect("Coordinadora.jsp");
                } else {
                    HttpSession objsesion = request.getSession(true);
                    objsesion.setAttribute("usuario", usuario);
                    objsesion.setAttribute("relativeIndex", "Portero.jsp");
                    response.sendRedirect("Portero.jsp");
                }
            } else {
                out.println("Invalid password <a href='index.jsp'>try again</a>");
            }
        } catch (CommunicationsException ex) {
            response.sendRedirect("ErrorPages/ErrorDeConexionBD.html");
        }

    }
}
