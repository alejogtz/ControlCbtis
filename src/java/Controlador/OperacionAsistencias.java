package Controlador;

import Controlador.Conexion;
import Utilidades.Console;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionAsistencias {

    public boolean tieneConexion() {
        try {
            return new Conexion().getConexion() != null;
        } catch (CommunicationsException ex) {

        }
        return false;
    }

    public OperacionAsistencias() {
    }

    /**
     *
     * @param nocontrol
     * @param incidencia
     * @return 1 sucess 
     * 404 Alumno no encontrado o no existe en la base de datos
     * 500 No se pudo establecer conexion con la base de datos 
     * 300 Alumno ya fue
     * insertado el día de hoy
     * @throws CommunicationsException
     */
    public int insertarAsistencia(int nocontrol, boolean incidencia){
        String query = "INSERT INTO asistencia VALUES ( 0, ?, CURRENT_DATE, CURRENT_TIME, 'Ninguno', ?)";
        
        Conexion    conexion = null;
        Connection  con = null;
        PreparedStatement execQuery = null;
        
        try {
            
            conexion = new Conexion();
            if (conexion == null) throw new NullPointerException("Conexion is Null");
            
            con = conexion.getConexion();
            
            //------ Pero antes.... Verificar si en este día ya fue registrado ---------------
            execQuery =  con.prepareStatement("SELECT isAlreadyRegistered(?) AS EXISTE");
            execQuery.setInt(1, nocontrol);            
            ResultSet rs = execQuery.executeQuery();
            rs.next();
            if (rs.getInt("EXISTE")==1) {
                SQLException raise_error = new SQLException("El Alumno ya fue Registrado el día del hoy", "300");
                throw raise_error;
            }            
            // ---------------------- <End Verificacion>----------------------------
            execQuery = con.prepareStatement(query);
            
            execQuery.setInt(1, nocontrol);
            execQuery.setBoolean(2, incidencia);
            
            int sucess = execQuery.executeUpdate();
            
            if (sucess != 1) throw new SQLException();

            Console.println("[40]Operacion Asistencia - exe", sucess + "");

            return sucess;
        } catch (CommunicationsException ex) {
            return 500;
        } catch (NullPointerException ex) {
            return 500;
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("300")) return 300;
            else return 404;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (execQuery != null) {
                    execQuery.close();
                }
            } catch (Exception e) {}
        }
    }

    public String getUrlImg(int NoControl) {
        String query = "SELECT foto FROM estudiante WHERE nocontrol = ?";
        String urlimagen = "default.jpg";

        try {
            Connection con = new Conexion().getConexion();
            PreparedStatement pst = new Conexion().getConexion().prepareStatement(query);

            pst.setInt(1, NoControl);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                urlimagen = rs.getString("foto");
            }

            Console.println("Operacion Asistencia", urlimagen);

        } catch (SQLException | NullPointerException ex) {
            Console.println("[67] Exception: Operacion Asistencia", ex.getMessage());
        }

        return urlimagen;
    }

    public static void main(String[] ar) {
        new OperacionAsistencias().getUrlImg(15161306);
    }

}
