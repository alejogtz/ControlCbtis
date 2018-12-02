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

        if (nocontrol != 0) {
            boolean sucess = ObjectAsistencias.insertarAsistencia(nocontrol, incidencia);

            if (sucess) {
                response.setStatus(200);
                
                String img = ObjectAsistencias.getUrlImg(nocontrol);
                out.println("images/fotosalumno/" + img);
                
                Console.println("Servlet Portero - Inagen", img);

            } else {
                response.sendError(404, "Error en la insercion de la asistencia");
            }

            Console.println("Servlet Portero - Insertar Alumno", sucess + "");
        }

    }

}
