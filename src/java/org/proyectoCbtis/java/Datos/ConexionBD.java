package org.proyectoCbtis.java.Datos;

import java.sql.Connection;

public class ConexionBD {
    // Datos para la conexion

    private String USER = "";
    private String PASSWD = "";
    private String DATABASE = "cbtis";
    private String HOST = "localhost";
    private String PORT = "8080";

    // Code here:
    private Connection conexion = null;

    public ConexionBD() {
        // Load drriver
        // Load conexion variable
    }

    public Connection getConexion(){
        return conexion;
    }
    
    public void setUSER(String USER) {
        this.USER = USER;
    }

    public void setPASSWD(String PASSWD) {
        this.PASSWD = PASSWD;
    }

    public void setDATABASE(String DATABASE) {
        this.DATABASE = DATABASE;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
    }

}
