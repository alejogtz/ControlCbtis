/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carlosA
 */
@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {

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
        response.setContentType("application/pdf");
       OutputStream out = response.getOutputStream();
       
       int id = Integer.parseInt(request.getParameter("txtId"));
           
           try{
               
                    try{
                   Conexion con = new Conexion();
                   PreparedStatement pst = null;
                   ResultSet rs = null;
                   
                   String consulta = "select NoRegistro,NoControl,Fecha,Hora from asistencia where NoControl = ?";
                   pst = con.getConexion().prepareStatement(consulta);
                   pst.setInt(1,id);
                   rs = pst.executeQuery();
                   
                   if(con!=null){
                   try{
                        Document documento = new Document();
                        PdfWriter.getInstance(documento, out);
                        documento.open();
               
                        Paragraph par1 = new Paragraph();
               
                        Font fonttitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);
                        par1.add(new Phrase("REPORTE DE ASISTENCIA",fonttitulo));
                        par1.setAlignment(Element.ALIGN_CENTER);
                        par1.add(new Phrase(Chunk.NEWLINE));
                        par1.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par1);
               
                        Paragraph par2 = new Paragraph();
                        Font fontdescrip = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK);
                        par2.add(new Phrase("Informacion de la asistencia del alumno",fontdescrip));
                        par2.setAlignment(Element.ALIGN_JUSTIFIED);
                        par2.add(new Phrase(Chunk.NEWLINE));
                        par2.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par2);
                        
                        
                        
                        PdfPTable tabla = new PdfPTable(4);
               
                        PdfPCell celda1 = new PdfPCell(new Paragraph("NoRegistro", FontFactory.getFont("Arial", 12, Font.BOLD,BaseColor.BLACK)));
                        PdfPCell celda2 = new PdfPCell(new Paragraph("NoControl", FontFactory.getFont("Arial", 12, Font.BOLD,BaseColor.BLACK)));
                        PdfPCell celda3 = new PdfPCell(new Paragraph("Fecha", FontFactory.getFont("Arial", 12, Font.BOLD,BaseColor.BLACK)));
                        PdfPCell celda4 = new PdfPCell(new Paragraph("Hora de Entrada", FontFactory.getFont("Arial", 12, Font.BOLD,BaseColor.BLACK)));
                        
                        tabla.addCell(celda1);
                        tabla.addCell(celda2);
                        tabla.addCell(celda3);
                        tabla.addCell(celda4);
                        
                        
                        while(rs.next()){
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        }
                        
                        documento.add(tabla);
                        documento.close();
                   
                   }catch(DocumentException ex  ){
                          ex.getMessage();
                        }
                   
                   }
                    }catch(SQLException e){
                        e.getMessage();
                    }
                   
                   
                   
                   
                   
                   
               
           }finally{
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

}
