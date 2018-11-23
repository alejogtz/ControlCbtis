package org.proyectoCbtis.java.Servlets;

import Controlador.Conexion;
import Controlador.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String tablahtml = buscarAlumno(name);
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

        boolean sucess = ObjectAsistencias.insertarAsistencia(nocontrol);
        if (sucess) {
            response.setStatus(200);
        } else {
            response.sendError(404, "Error en la insercion de la asistencia");
        }
    }

    public String buscarAlumno(String nombre) {
        StringBuffer tabla = new StringBuffer();

        tabla.append("<table>");
        tabla.append("<tr> <th>Nombre</th> <th>NoControl</th> </tr>");
        // Busqueda
        try {
            PreparedStatement pst
                    = new Conexion().getConexion().prepareStatement("select nombre, nocontrol from estudiante where upper(nombre) = upper('?')");
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();

            String elem = null;
            while (rs.next()) {
                elem = "<tr> <td>?</td> <td>?</td> </tr>";
                elem.replaceFirst("?", rs.getString("nombre"));
                elem.replaceFirst("?", rs.getString("nocontrol"));
                tabla.append(elem);
            }
            tabla.append("</table>");

        } catch (SQLException ex) {
            Logger.getLogger(ServletPortero.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        tabla.append("</table>");

        return tabla.toString();
    }


}
