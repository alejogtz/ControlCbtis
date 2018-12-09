package Servlet;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.Conexion;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        //OutputStream out = response.getOutputStream();  
        OutputStream out = null;
        PrintWriter outs = null;
        //Aquí colocas tu objeto tipo Date
        Date myDate = new Date();
        String Nombre = null;
        int id = Integer.parseInt(request.getParameter("txtId"));
        String fecha_generada = "Fecha de Generación: " + new SimpleDateFormat("dd-MM-yyyy").format(myDate);

        try {
            //>>>>>>>>---------------------- Pero antes.... Verificar si este alumno cuenta con asistencias registradas -------------------------
            if (!existeEsteAlumno(id)){throw new Exception("El alumno con No. control: " + id + " No existe");}
            if (!tieneAsistenciasRegistradas(id)) {throw new Exception("No se puede generar un reporte vacío");}

            // Else --------------- Visualziar un msje de Advertencia que indique que No se han registrado asistencias de este alumno ---------
            //>>>>>>>> -------------------------End logica -----------------------------------------------------
            Conexion con = new Conexion();
            PreparedStatement pst = null;
            ResultSet rs = null;

            String consulta = "select e.NoControl, e.Nombre, e.ApPaterno, e.ApMaterno, e.Semestre, e.Especialidad, e.Grupo, e.Turno, a.Fecha, a.Hora from Estudiante e inner join Asistencia a on e.NoControl = a.NoControl where e.NoControl = ?";
            // String consulta = "select * from Estudiante where NoControl = ?";                  
            pst = con.getConexion().prepareStatement(consulta);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            Document documento = new Document();
            out = response.getOutputStream();
            PdfWriter.getInstance(documento, out);
            documento.open();
            if (rs.absolute(1)) {
                Nombre = "Nombre del Alumno: " + rs.getString("Nombre") + " " + rs.getString("ApPaterno") + " " + rs.getString("ApMaterno");
                System.out.println(Nombre);
                String NoControl = "Número de Control: " + rs.getString(1);
                String Semestre = "Semestre:" + rs.getString(5);
                String Especialidad = "Especialidad: " + rs.getString(6);
                String Grupo = "Grupo: " + rs.getString(7);
                String Turno = "Turno: " + rs.getString(8);

                try {
                    Image imagenes = Image.getInstance("C:\\Users\\Alessio\\Desktop\\ControlCbtis\\web\\images\\page_1.jpg");
                    imagenes.setAlignment(Element.ALIGN_CENTER);
                    imagenes.scaleToFit(550, 100);

                    documento.add(imagenes);
                } catch (BadElementException ex) {
                    System.out.println("Image BadElementException" + ex);
                } catch (IOException ex) {
                    System.out.println("Image IOException " + ex);
                }

                Paragraph par1 = new Paragraph();
                Font fonttitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase("REPORTE DE ASISTENCIA", fonttitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);

                Paragraph par2 = new Paragraph();
                Font fontdescrip = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
                par2.add(new Phrase(fecha_generada, fontdescrip));
                par2.setAlignment(Element.ALIGN_RIGHT);
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);

                Paragraph parnombre = new Paragraph();
                Font fontnombre = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
                parnombre.add(new Phrase(Nombre, fontnombre));

                parnombre.setAlignment(Element.ALIGN_JUSTIFIED);
                parnombre.add(new Phrase(Chunk.NEWLINE));
                documento.add(parnombre);

                Paragraph parcontrol = new Paragraph();
                Font fontcontrol = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
                parcontrol.add(new Phrase(NoControl, fontcontrol));
                parcontrol.setAlignment(Element.ALIGN_JUSTIFIED);
                parcontrol.add(new Phrase(Chunk.NEWLINE));
                documento.add(parcontrol);

                Paragraph parsemestre = new Paragraph();
                Font fontsemestre = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
                parsemestre.add(new Phrase(Semestre, fontsemestre));
                parsemestre.setAlignment(Element.ALIGN_JUSTIFIED);
                parsemestre.add(new Phrase(Chunk.NEWLINE));
                documento.add(parsemestre);

                Paragraph parespecialidad = new Paragraph();
                Font fontespecialidad = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
                parespecialidad.add(new Phrase(Especialidad, fontespecialidad));
                parespecialidad.setAlignment(Element.ALIGN_JUSTIFIED);
                parespecialidad.add(new Phrase(Chunk.NEWLINE));
                documento.add(parespecialidad);

                Paragraph pargrupo = new Paragraph();
                Font fontgrupo = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
                pargrupo.add(new Phrase(Grupo, fontgrupo));
                pargrupo.setAlignment(Element.ALIGN_JUSTIFIED);
                pargrupo.add(new Phrase(Chunk.NEWLINE));
                documento.add(pargrupo);

                Paragraph parturno = new Paragraph();
                Font fontturno = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
                parturno.add(new Phrase(Turno, fontturno));
                parturno.setAlignment(Element.ALIGN_JUSTIFIED);
                parturno.add(new Phrase(Chunk.NEWLINE));
                parturno.add(new Phrase(Chunk.NEWLINE));
                parturno.add(new Phrase(Chunk.NEWLINE));
                documento.add(parturno);
            }
            PdfPTable tabla = new PdfPTable(2);

            PdfPCell celda3 = new PdfPCell(new Paragraph("Fecha", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("Hora de Entrada", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

            tabla.addCell(celda3);
            tabla.addCell(celda4);
            while (rs.next()) {
                tabla.addCell(rs.getString(9));
                tabla.addCell(rs.getString(10));
            }
            documento.add(tabla);

            documento.close();

        } catch (DocumentException ex) {
            response.setContentType("text/html;charset=UTF-8"); 
            if (out ==null)
                outs = new PrintWriter(response.getWriter());
            else outs = new PrintWriter(out);
            outs = response.getWriter();
             outs.print(" <div class=\"alert alert-warning alert-dismissable\" role=\"alert\"> "
                    + "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>"
                    + "<strong>Alerta!</strong> La contraseña es incorrecta."
                    + "</div> ");

            RequestDispatcher rd = request.getRequestDispatcher("/Coordinadora.jsp");
            rd.include(request, response);
        } catch (SQLException e) {
            response.setContentType("text/html;charset=UTF-8");
            outs = response.getWriter();
            outs.print(" <div class=\"alert alert-warning alert-dismissable\" role=\"alert\"> "
                    + "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>"
                    + "<strong>Alerta!</strong> La contraseña es incorrecta."
                    + "</div> ");
            RequestDispatcher rd = request.getRequestDispatcher("/Coordinadora.jsp");
            rd.include(request, response);
        } catch (Exception ex) {
            response.setContentType("text/html;charset=UTF-8");
            outs = response.getWriter();
            outs.print(" <div class=\"alert alert-warning alert-dismissable\" role=\"alert\"> "
                    + "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>"
                    + "<strong>Advertencia! </strong>" + ex.getMessage() + "</div> ");
            RequestDispatcher rd = request.getRequestDispatcher("/Coordinadora.jsp");
            rd.include(request, response);
        } finally {
            if (out!=null)
                out.close();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public boolean tieneAsistenciasRegistradas(int nocontrol) {
        Conexion conexion = null;
        Connection con = null;
        PreparedStatement execQuery = null;

        try {

            conexion = new Conexion();
            if (conexion == null) {
                throw new NullPointerException("Conexion is Null");
            }
            con = conexion.getConexion();

            execQuery = con.prepareStatement("SELECT cuantasAsistenciasTiene(?) as ASISTENCIAS");
            execQuery.setInt(1, nocontrol);
            ResultSet rs = execQuery.executeQuery();
            rs.next();
            if (rs.getInt("ASISTENCIAS") < 1) {
                SQLException raise_error = new SQLException();
                throw raise_error;
            }

            execQuery.close();
            rs.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean existeEsteAlumno(int noControl){
        Conexion conexion = null;
        Connection con = null;
        PreparedStatement execQuery = null;

        try {

            conexion = new Conexion();
            if (conexion == null) {
                throw new NullPointerException("Conexion is Null");
            }
            con = conexion.getConexion();

            execQuery = con.prepareStatement("SELECT existeEsteAlumno(?) as EXISTE");
            execQuery.setInt(1, noControl);
            ResultSet rs = execQuery.executeQuery();
            rs.next();
            
            boolean siExiste = rs.getBoolean("EXISTE");

            execQuery.close();
            rs.close();
            return siExiste;
        } catch (SQLException ex) {
            return false;
        }
    }

}
