<%@page import="javax.swing.JOptionPane"%>
<%@page import="Utilidades.md5"%>
<%@page import="Controlador.Consultas"%>
<%@page import="Correo.Email"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
        <script src="js/main.js"></script>
        <script src="js/md5.js"></script>
    </head>
    
    
    <body id="body">
        <img id="logo"  src="images/page_1.jpg">
        
        
        <div id="contenedor">
            <h2 id="h2">INICIAR SESION</h2>	
            
            
            <form action="Iniciar" method="post" id="forminicio">
                <div id="usuario">
                    <label for="txtusuario">Usuario: </label>
                    <select name="usuario" id="txtusuario" >
                        <option value="coordinador" selected>Coordinador</option>
                        <option value="vigilante">Vigilante</option>
                    </select>
                </div>
                <div id="password">
                    <label for="txtpass" >Contraseña:</label>

                    <input type="password" name="contrasena" id="txtpass" maxlength="16" required/>
                </div>         
                <div id="botonsubmit">
                    <input type="button"    value="Iniciar Sesion" id="btniniciar"/>
                </div>
            </form>
            
            
            <div id="botonrecuperar">
                <form action="Enviarcorreo" method="post" >
                    <input type="submit" value="Recuperar contraseña" id="btncorreo" />
                </form>
            </div>
            

        </div>
    </body>
</html>




