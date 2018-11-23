<%-- 
    Document   : registro
    Created on : 18/11/2018, 12:31:02 AM
    Author     : carlosA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link rel="stylesheet" href="CSS/main.css" type="text/css"/>
        
        <script src="js/validacion.js"></script>
    </head>
    <body>
        <h1>Formulario de registro</h1>
        
        <form action="nuevousuario" method="post" id="formregistro">
            <table>
                <tr>
                    <td>
                    <label>Usuario:</label>
                    </td>
                    <td>
                    <input type="text" name="usuario" minlength="6" maxlength="16" id="txtuserreg" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                    <label>Contraseña:</label>
                    </td>
                    <td>
                    <input type="password" name="contrasena" id="txtpassreg" minlength="8" maxlength="16" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                    <label>Email:</label>
                    </td>
                    <td>
                    <input type="text" name="Email" id="txtemailreg"  
                   pattern="([^.@]+)(\.[^.@]+)*@([^.@]+\.)+([^.@]+)" required />
                    </td>
                </tr>
                
            </table>
            <p id="mensajeError"></p>
            
            <p>
            <input type="submit"    value="Registrar"   id="btnregistrar"/>
            </p>
        </form>
        
    </body>
</html>
