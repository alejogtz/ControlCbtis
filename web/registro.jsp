<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link rel="stylesheet" href="css/main.css" type="text/css"/>

        <meta http-equiv="Cache-Control" content="no-store;no-cache">
        <meta http-equiv="Expires" content="0" />
        <meta http-equiv="Pragma" content="no-cache" />
        
        <script src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
            if (history.forward(1)) {
                location.replace(history.forward(1));
            }
        </script>
        
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
