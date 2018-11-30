package org.proyectoCbtis.java.Datos;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionAsistencias {

    public OperacionAsistencias() {}

    public boolean insertarAsistencia(int nocontrol, boolean incidencia){
        String query = "INSERT INTO asistencia values ( 0, ?, CURRENT_DATE, CURRENT_TIME, 'Ninguno', ?)";        
        
        
        Connection con = new Conexion().getConexion();        
        PreparedStatement execQuery = null;
        
        
        try { 
            execQuery = con.prepareStatement(query);
            execQuery.setInt    (1, nocontrol);
            execQuery.setBoolean(2, incidencia);
            int sucess = execQuery.executeUpdate();
            execQuery.close();
            
            
            return sucess == 1;
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(OperacionAsistencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }
    
    public static void main(String [] ar){
        new OperacionAsistencias().insertarAsistencia(15161306, false);
    }

}

