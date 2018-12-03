package Controlador;

import Utilidades.Console;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String USERNAME = "root";
    private String PASSWORD = "chivas1958";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "cbetis123";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private Connection con;

    public Conexion() throws CommunicationsException {
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR" + e);
        } catch(com.mysql.jdbc.exceptions.jdbc4.CommunicationsException ex){
             throw ex;
        } catch (SQLException e) {
            System.err.println("ERROR:" + e);
        }
        
    }

    public Connection getConexion() {
        return con;
    }

}
