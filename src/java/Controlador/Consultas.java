package Controlador;

import Correo.Email;
import Utilidades.md5;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas extends Conexion{

    public Consultas() throws com.mysql.jdbc.exceptions.jdbc4.CommunicationsException{}
    
    public static void main(String [] args){
       
        
    }
    
    
    public boolean autenticacion(String usuario, String contrasena) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select NombreSesion,password from sesion where NombreSesion = ? and password = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }
            
            
        } catch (SQLException e) {
            
            
            System.err.println("ERROR:" + e);
            
            
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR:" + e);
            }
        }

        return false;
    }

    
    public boolean registar(String usuario, String contrasena, String email) {
        PreparedStatement pst = null;

        try {
            
            
            String consulta = "insert into sesion(NoRegistro, NombreSesion, Password, EMail) values(?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, 0);
            pst.setString(2, usuario);
            pst.setString(3, contrasena);
            pst.setString(4, email);

            if (pst.executeUpdate() == 1) {
                return true;
            }

            
        } catch (Exception ex) {
            System.err.println("ERROR:" + ex);
            
            
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR:" + e);
            }
        }

        return false;
    }

    
    public String restaurarcorreo(String correo) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select Password from sesion where NombreSesion = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, correo);

            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return rs.getString("Password");
            }
        } catch (Exception ex) {
            System.err.println("ERROR:" + ex);
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR:" + e);
            }
        }

        return null;
    }

    
    public void enviar() throws Exception {
        Email email = new Email();
        //Consultas consulta = new Consultas();

        // String recuperarpassword = md5.Desencriptar(consulta.restaurarcorreo("carlos_19alber@hotmail.com"));
        //String resultado = " ";
        //out.print(resultado);
        String de = "restaurarcontrasena123@gmail.com";
        String clave = "ejhmrxbmzbjayssf";
        //String para = request.getParameter("correo");
        String para = "carlos_19alber@hotmail.com";
        String mensaje = "Esta es tu contraseña: " + md5.Desencriptar(restaurarcorreo("coordinador"));
        String asunto = "RESTAURAR CONTRASEÑA";
        //out.print(resultado);

        //recuperarpassword = consulta.restaurarcorreo(request.getParameter("correo"));
        email.enviarCorreo(de, clave, para, mensaje, asunto);
        //out.print(resultado);
    }

    
    public boolean CambiarContrasena(String Nuevacontrasena, String user) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String usuario = "Coordinador";
        //boolean bandera = false;
        try {
            
            if (user.equals("vigilante")){usuario="Vigilante";}
            
            String consulta = "UPDATE sesion SET Password = ?  WHERE NombreSesion = ?";//'Coordinador'";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, Nuevacontrasena);
            pst.setString(2, usuario);
            //pst.executeUpdate();

            if (pst.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            System.err.println("ERROR:" + e);
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR:" + e);
            }
        }

        return false;
    }
    // ///////////////////////////////

    
    public boolean comprobar(int id) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select e.NoControl, e.Nombre, e.ApPaterno, e.ApMaterno, e.Semestre, e.Especialidad, e.Grupo, e.Turno, a.Fecha, a.Hora from Estudiante e inner join Asistencia a on e.NoControl = a.NoControl where e.NoControl = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR:" + ex);
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR:" + e);
            }
        }

        return false;
    }
}
