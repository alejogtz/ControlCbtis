<%-- 
    Document   : NuevaContrasena
    Created on : 30/11/2018, 03:21:40 PM
    Author     : Alessio
--%>

<%
    try {
        HttpSession objsesion = request.getSession(false);
        String usuario = (String) objsesion.getAttribute("usuario");

        if (usuario.equals("")) {
            response.sendRedirect("index.jsp");
        }
    } catch (NullPointerException e) {
        response.sendRedirect("index.jsp");
    }
    //    //

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Coordinacion</title>
        <link rel="stylesheet" href="css/main.css">
        <script src="js/validacionCoordinadora.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
        <script src="js/app-ajax.js" type="text/javascript"></script>
    </head>
    <body id="body">
        <img id="logo"  src="images/page_1.jpg">
        <div id="contenedor">
            <div id="cerrar_sesion">
                <ul>
                    <li class="selected" ><a href="./NuevaContrasena.jsp">Cambiar Contraseña</a></li>
                    <li><a href="CerrarSesion">Logout</a></li>
                </ul>
            </div>
            <h2 id="h2">Bienvenida coordinadora</h2>
            <form name="Cambiar" method="post" action="CambiarContrasena">
                <div id="cont_buscar">
                    <div id="no_co">
                        <label for="input-number">Ingrese Nueva Contraseña: </label>
                        <input type="password" id="input-number" name="txtpass" 
                               value=""  placeholder="Esperando contraseña..." />
                        <label for="input-Vpassword">Verificar Nueva Contraseña: </label>
                        <input type="password" id="input-Vpassword" name="txtVpass" 
                               value=""  placeholder="Esperando contraseña..." />
                    </div>

                </div>

                <div id="data">

                </div> 


                <div id="botsubmit">
                    <input type="submit" id="button-submit-cambiar" value="ChangePassword" name="btnPass"  />

                </div>
            </form>
        </div>
    </body>
</html>
