package org.proyectoCbtis.java.Servlets;

import Controlador.Conexion;
import Controlador.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.proyectoCbtis.java.Datos.Busqueda;
import org.proyectoCbtis.java.Util.Parser.DeString;

@WebServlet(name = "ServletPortero", urlPatterns = {"/ServletPortero"})
public class ServletPortero extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // input del nombre a buscar
        String name = DeString.aString(request.getParameter("nombre"));
        String tablahtml = new Busqueda().buscarAlumno(name);

        response.setStatus(200);
        out.println(tablahtml);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // Registrar Asistencia
        // Primero capturamo el valor del no de control
        org.proyectoCbtis.java.Datos.OperacionAsistencias ObjectAsistencias = new org.proyectoCbtis.java.Datos.OperacionAsistencias();

        int nocontrol = DeString.aInt(request.getParameter("nocontrol"));

        boolean sucess = ObjectAsistencias.insertarAsistencia(nocontrol, false);
        if (sucess) {
            response.setStatus(200);
        } else {
            response.sendError(404, "Error en la insercion de la asistencia");
        }
    }

}
