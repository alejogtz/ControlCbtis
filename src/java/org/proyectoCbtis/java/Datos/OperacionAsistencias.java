package org.proyectoCbtis.java.Datos;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionAsistencias {

    public OperacionAsistencias() {}

    public boolean insertarAsistencia(int nocontrol){
        Connection con = new Conexion().getConexion();
        
        String query = "INSERT INTO asistencia\n"
                + "values ( 0, ?, CURRENT_DATE, CURRENT_TIME, 'Ninguno')";
        
        PreparedStatement execQuery = null;
        try { 
            execQuery = con.prepareStatement(query);
            execQuery.setInt(1, nocontrol);
            int sucess = execQuery.executeUpdate();
            execQuery.close();
            System.out.println("org.proyectoCbtis.java.Datos.OperacionAsistencias.insertarAsistencia(): " +sucess);
            return sucess == 1;
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(OperacionAsistencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

