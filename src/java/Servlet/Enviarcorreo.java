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
       
            
        try {
            Email email = new Email();
            Consultas consulta = new Consultas();
            
            // String recuperarpassword = md5.Desencriptar(consulta.restaurarcorreo("carlos_19alber@hotmail.com"));
            String resultado = " ";
            //out.print(resultado);
            String de = "restaurarcontrasena123@gmail.com";
            String clave = "ejhmrxbmzbjayssf";
            //String para = request.getParameter("correo");
            String para = "carlos_19alber@hotmail.com";
            String mensaje = "Esta es tu contraseña: " + md5.Desencriptar(consulta.restaurarcorreo("coordinador"));
            String asunto = "RESTAURAR CONTRASEÑA";
            //out.print(resultado);
            
            
            //recuperarpassword = consulta.restaurarcorreo(request.getParameter("correo"));
            resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
            
            response.sendRedirect("index.jsp");
            //out.print(resultado);
            
            /*if(resultado){
            //out.print("CORREO ELECTRONICO CORRECTAMENTE ENVIADO.....");
            //JOptionPane.showMessageDialog(null, "CORREO ELECTRONICO ENVIADO.....");
                
            }else{
            //out.print("CORREO ELECTRONICO NO ENVIADO.....");
            //JOptionPane.showMessageDialog(null, "CORREO ELECTRONICO NO ENVIADO.....");
            }*/
        } catch (Exception ex) {
            Logger.getLogger(Enviarcorreo.class.getName()).log(Level.SEVERE, null, ex);
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
