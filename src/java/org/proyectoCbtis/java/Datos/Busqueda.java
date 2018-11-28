package org.proyectoCbtis.java.Datos;

import Controlador.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Busqueda {

    public String buscarAlumno(String nombre) {
        StringBuffer tabla = new StringBuffer();
        String elem = null;        
        
        tabla.append("<table>");
        tabla.append("<tr> <th>Nombre</th> <th>NoControl</th> </tr>");      

        // Busqueda
        try {
            PreparedStatement pst
                    = new Conexion().getConexion().prepareStatement("select *  from estudiante where upper(estudiante.nombre) = upper(?)");
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.err.println(rs.getInt(1));

                elem = "<tr> <td>" + rs.getString("Nombre") + " "
                        + "</td> <td>" + rs.getString("NoControl") + "</td> </tr>";                
                tabla.append(elem);
            }
            tabla.append("</table>");
        } catch (SQLException ex) {

        }
        
        return tabla.toString();
    }

    public static void main(String[] args) {
        System.err.println(
                new Busqueda().buscarAlumno("Alejo")
                );
    }

}
