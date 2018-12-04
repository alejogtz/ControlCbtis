package Servlet;

import Controlador.Conexion;
import Controlador.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controlador.Busqueda;
import Controlador.OperacionAsistencias;
import Utilidades.Console;
import Utilidades.Parser.DeString;

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

        int nocontrol = DeString.aInt(request.getParameter("nocontrol"));
        boolean incidencia = DeString.aBoolean(request.getParameter("incidencia"));

        OperacionAsistencias ObjectAsistencias = new OperacionAsistencias();
        int sql_state = ObjectAsistencias.insertarAsistencia(nocontrol, incidencia);

        switch (sql_state) {
            case 1:
                
                response.setStatus(200);
                String img = ObjectAsistencias.getUrlImg(nocontrol);
                out.println("images/fotosalumno/" + img);
                break;
                
            case 404:
                
                response.sendError(404, "El alumno no existe en la Base de datos");
                break;
                
            case 300:
                
                response.sendError(300, "Este Alumno ya fue ingresado en este día");
                break;
                
            case 500:
                
                response.sendError(500, "No se pude establece la conexión con la Base de Datos");
                break;
                
            default:
                break;
        }

    }

}
