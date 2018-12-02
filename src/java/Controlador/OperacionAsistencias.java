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
        } catch ( CommunicationsException ex){
            
        }
        return false;
    }

    

    public OperacionAsistencias() {
    }

    public boolean insertarAsistencia(int nocontrol, boolean incidencia) {
        String query = "INSERT INTO asistencia values ( 0, ?, CURRENT_DATE, CURRENT_TIME, 'Ninguno', ?)";

        try {
            Connection con = new Conexion().getConexion();
            PreparedStatement execQuery = null;
            execQuery = con.prepareStatement(query);
            execQuery.setInt(1, nocontrol);
            execQuery.setBoolean(2, incidencia);
            int sucess = execQuery.executeUpdate();
            execQuery.close();

            return sucess == 1;
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(OperacionAsistencias.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
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
            Console.println("Operacion Asistencia", ex.getMessage());
        }

        return urlimagen;
    }

    public static void main(String[] ar) {
        new OperacionAsistencias().getUrlImg(15161306);
    }

}
