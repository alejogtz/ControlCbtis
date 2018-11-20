package org.proyectoCbtis.java.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.proyectoCbtis.java.Datos.OperacionAsistencias;
import org.proyectoCbtis.java.Datos.requestExistDB;
import org.proyectoCbtis.java.Util.Parser;

@WebServlet(name = "Coordinacion", urlPatterns = {"/Coordinacion"})
public class Coordinacion extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Logica para presentar 
        // O redirigir a una pagina en particualar
                
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ocurre cuando del formulario de Coordinacion se solicita insertar una nueva asistencia
        // Ya sea automaticamente o manual
        // Se supone que las validacion de sesion no es necesaria porque la operacion post solo la puede hacer el formulario
        
        // Verifica si la manera de solicitar        
        // Obtener los parametros del formulario, no de control
        int nocontrol   = Parser.DeString.aInt( request.getParameter("input-name") );        
        // insertar fecha sin formato, leer con formato que se quiera
        java.util.Date fecha_actual = new java.util.Date();
        // Validacion de datos de entrada
        // Si los parametros no son vacios y existe el alumno y la fecha es valida
        boolean doAction = requestExistDB.existAlumno(nocontrol);
        
        // Operacion de insertar
        if (doAction){
            OperacionAsistencias.insertarAsistencia(nocontrol, fecha_actual);
        }
        
        // Devuelve o redigige con mensaje de informacion de la operacion
        // Codigo de un div con
        PrintWriter out = response.getWriter();
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
