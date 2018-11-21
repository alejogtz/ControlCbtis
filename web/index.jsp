<%@page import="javax.swing.JOptionPane"%>
<%@page import="Utilidades.md5"%>
<%@page import="Controlador.Consultas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Correo.Email"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesion Cbetis</title>
        <link rel="stylesheet" href="CSS/main.css" type="text/css"/>
        <script src="js/main.js"></script>
        <script src="js/md5.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="Iniciar" method="post" id="forminicio">
           <table>  
               <tr>
                   <td>
                    <label>Usuario:</label>
                    </td>
                    <td>
                    <input type="text" name="usuario" id="txtusuario" maxlength="16" required/>
                    </td>
               </tr>
               <tr>
                   <td>
                    <label>Contraseña:</label>
                    </td>
                    <td>
                    <input type="password" name="contrasena" id="txtpass" maxlength="16" required/>
                    </td>
               </tr>
            </table>
            <p>
            <input type="button"    value="Iniciar Sesion" id="btniniciar"/>
            </p>
          
        </form>
         
        <form action="nuevousuario" method="post" >
            <p>
            <button value="Registrar" href="registro.jsp">Registrarme</button>
            </p>
        </form>
        
        <input type="button" value="Recuperar Contraseña" onclick="mostrar()">
        
        <div id='oculto'>
            <form action="index.jsp" method="post">
                <p>
                <label>Correo:</label>
           
                <input type="text" name="correo" id="txtrescorreo"  pattern="([^.@]+)(\.[^.@]+)*@([^.@]+\.)+([^.@]+)" required/>
                </p>
                <p>
                <input type="submit" value="ENVIAR CORREO ELECTRONICO" id="btncorreo"/>
               </p>
            </form>
        </div> 
        
        
        
        
        
        <%
            
            Email email = new Email();
            Consultas consulta = new Consultas();
            
            //String recuperarpassword = null;
            String resultado = " ";
             out.print(resultado);
            String de = "restaurarcontrasena123@gmail.com";
            String clave = "ejhmrxbmzbjayssf";
            String para = request.getParameter("correo");
            String mensaje = "Esta es tu contraseña: " + md5.Desencriptar(
                                                        consulta.restaurarcorreo(request.getParameter("correo")));
            String asunto = "RESTAURAR CONTRASEÑA";
            //out.print(resultado);
            
            
            //recuperarpassword = consulta.restaurarcorreo(request.getParameter("correo"));
            resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
            
            /*if(resultado){
                //out.print("CORREO ELECTRONICO CORRECTAMENTE ENVIADO.....");
                 //JOptionPane.showMessageDialog(null, "CORREO ELECTRONICO ENVIADO.....");
                
            }else{
                //out.print("CORREO ELECTRONICO NO ENVIADO....."); 
                //JOptionPane.showMessageDialog(null, "CORREO ELECTRONICO NO ENVIADO.....");
            }*/
            
        %>
        
    </body>
</html>
