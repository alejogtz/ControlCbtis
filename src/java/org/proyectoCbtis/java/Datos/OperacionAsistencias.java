package org.proyectoCbtis.java.Datos;

import java.sql.Connection;
import java.util.Date;

public class OperacionAsistencias {
    Connection con = null;
    public OperacionAsistencias() {
         con = new ConexionBD().getConexion();
    }
    
    public static boolean insertarAsistencia( int nocontrol, String hora_fecha ){
        // Consulta e insercion
        
        return true;
    }
    
    public static boolean insertarAsistencia( int nocontrol, Date hora_fecha ){
        // Consulta e insercion
        
        return true;
    }
    
}
