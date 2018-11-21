/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author carlosA
 */
public class Consultas extends Conexion{
    
    public boolean autenticacion(String usuario, String contrasena){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        try {
            String consulta = "select NombreSesion,password from sesion where NombreSesion = ? and password = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
        } catch (Exception e) {
            System.err.println("ERROR:"+e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (Exception e) {
                 System.err.println("ERROR:"+e);
            }
        }
        
        return false;
    }
    
    
    public boolean registar(String usuario,String contrasena, String email){
        PreparedStatement pst = null;
        
        try {
            String consulta = "insert into sesion(NoRegistro, NombreSesion, Password, EMail) values(?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, 0);
            pst.setString(2, usuario);
            pst.setString(3, contrasena);
            pst.setString(4, email);
            
            if(pst.executeUpdate() == 1){
                return true;
            }
            
        } catch (Exception ex) {
             System.err.println("ERROR:"+ex);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                
            } catch (Exception e) {
                 System.err.println("ERROR:"+e);
            }
        }
        
        
        return false;
    }
    
    public String restaurarcorreo(String correo){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        try {
            String consulta = "select Password from sesion where EMail = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1,correo);
            
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return rs.getString("Password");
            }
        } catch (Exception ex) {
            System.err.println("ERROR:"+ex);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (Exception e) {
                 System.err.println("ERROR:"+e);
            }
        }
        
        return null;
    }
    
    
    
    public static void main(String[] args) {
        Consultas co = new Consultas();
        
        System.out.println(co.registar("cas", "7815696ecbf1c96e6894b779456d330e", "sda"));
    }
}
