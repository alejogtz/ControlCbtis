/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Consultas;
import Correo.Email;
import Utilidades.md5;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlosA
 */
@WebServlet(name = "Enviarcorreo", urlPatterns = {"/Enviarcorreo"})
public class Enviarcorreo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String aviso = null;
        response.setContentType("text/html;charset=UTF-8");
        try {
            Email email = new Email();
            Consultas consulta = new Consultas();

            Consultas consulta1 = new Consultas();
            String resultado = " ";
            String de = "restaurarcontrasena123@gmail.com";
            String clave = "ejhmrxbmzbjayssf";

            String para = "carlos_19alber@hotmail.com";
            String mensaje = "Estimado usuario (Coordinador).\n "
                    + "Su contraseña de acceso es: " + md5.Desencriptar(consulta.restaurarcorreo("Coordinador") + "\n"
                            + "No la comparta por su seguridad.");
            String asunto = "RECORDAR CONTRASEÑA";

            resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);

            String para1 = "alessio_combo1@hotmail.com";
            String mensaje1 = "Estimado usuario (Vigilante).\n "
                    + "Su contraseña de acceso es: " + md5.Desencriptar(consulta1.restaurarcorreo("Vigilante") + "\n"
                            + "No la comparta por su seguridad.");

            resultado = email.enviarCorreo(de, clave, para1, mensaje1, asunto);

            aviso = " <center><div class=\"alert alert-success alert-dismissable\" role=\"alert\"> "
                    + "<strong>Exito!</strong> Revise su correo electrónico, ha recibido un mensaje con su contraseña."
                    + "</div></center> ";
            request.setAttribute("Info-correo", aviso);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

            rd.include(request, response);
        } catch (AddressException ex) {
            aviso = " <center><div class=\"alert alert-danger alert-dismissable\" role=\"alert\"> "
                    + "<strong>Error!</strong> Ha ocurrido un error con su dirección de Correo Electrónico. Por favor, contacte con el administrador."
                    + "</div></center> ";
            request.setAttribute("Info-correo", aviso);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

            rd.include(request, response);

        } catch (MessagingException e) {
             aviso = " <center><div class=\"alert alert-danger alert-dismissable\" role=\"alert\"> "
                    + "<strong>Error!</strong> Ha ocurrido un error con el envío de su contraseña. Por favor, corrobore que tenga acceso a Internet o llame a su proveedor ISP"
                    + "</div></center> ";
            request.setAttribute("Info-correo", aviso);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

            rd.include(request, response);
        } catch (Exception ex) {
            aviso = " <center><div class=\"alert alert-success alert-dismissable\" role=\"alert\"> "
                    + "<strong>Error Fatal!</strong> X_X Error Desconocido. Si esto vuelve a suceder contacte con el administrador"
                    + "</div></center> ";
            request.setAttribute("Info-correo", aviso);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

            rd.include(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
