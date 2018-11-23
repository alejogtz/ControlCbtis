/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author carlosA
 */
public class Email {
    
    //public boolean enviarCorreo(String de, String clave, String[] para, String mensaje, String asunto){
    public String enviarCorreo(String de, String clave, String para, String mensaje, String asunto){
        //boolean enviado = false;
            try{
            
                String host = "smtp.gmail.com";
                //String host = "smtp-mail.outlook.com";
                Properties prop = System.getProperties();
                
                prop.put("mail.smtp.starttls.enable","true");
                prop.put("mail.smtp.host", host);
                prop.put("mail.smtp.user",de);
                prop.put("mail.smtp.password", clave);
                prop.put("mail.smtp.port",587);
                prop.put("mail.smtp.auth","true");
                
                Session sesion = Session.getDefaultInstance(prop);
                
                MimeMessage message = new MimeMessage(sesion);
                
                message.setFrom(new InternetAddress(de));
                
              
                
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
                
                message.setSubject(asunto);
                message.setText(mensaje);
                
                Transport transport = sesion.getTransport("smtp");
                
                transport.connect(host,de,clave);
                
                transport.sendMessage(message, message.getAllRecipients());
                
                transport.close();
                
                return "CORREO ELECTRONICO CORRECTAMENTE ENVIADO";
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        return "CORREO ELECTRONICO NO ENVIADO";
    }
    /*
    public static void main(String[] args) {
        Email email = new Email();
        System.out.println(
        email.enviarCorreo("restaurarcontrasena123@gmail.com", "ejhmrxbmzbjayssf", "carlos_19alber@hotmail.com", "asad", "asdasd"));
    }*/
    
}
