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
         <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/main3.css">
        <script src="js/validacionCoordinadora.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
        <script src="js/app-ajax.js" type="text/javascript"></script>
    </head>
    <body id="body">
        <div>
        <img id="logo"  src="images/page_1.jpg">
        </div>
        
        <nav  class="navbar navbar-expand-lg navbar-dark " style="width:80% ;margin-bottom: 0%; left:10%; background-color: #1A5276">
            <a class="navbar-brand" href="Coordinadora.jsp"  >Principal</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
             <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
             <ul class="navbar-nav">
                 <li class="nav-item active">
                    <a class="nav-link" href="Incidencia.jsp">Incidencias <span class="sr-only">(current)</span></a>
                 </li>
                 <li class="nav-item">
                 <a class="nav-link" class="active" >Cambiar Contraseña</a>
                 </li>
                <li class="nav-item">
                    <a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
                 </li>
                </ul>
            </div>
            </nav>
        
        
        
        <div id="contenedor">
           
            <h2 id="h2">Cambiar Contraseña</h2>
            <br><br><hr>
            <form name="Cambiar" method="post" action="CambiarContrasena">
                <div id="cont_buscar">
                    <div id="no_co">
                        <label style="margin-left: 13%" for="input-number">Ingrese Nueva Contraseña: </label>
                        <input type="password" id="input-number" name="txtpass" 
                               value=""  placeholder="Esperando contraseña..." />
                        
                        <label style="margin-left: 5%" for="input-Vpassword">Verificar Nueva Contraseña: </label>
                        <input type="password" id="input-Vpassword" name="txtVpass" 
                               value=""  placeholder="Esperando contraseña..." />
                        <input type="hidden" value=<%= request.getSession().getAttribute("usuario")%> name="SesionActiva" id="SesionActiva"/>
                    </div>

                </div>

                <div id="data">

                </div> 


                <div style="margin-left: 40%; margin-top: 7%; margin-right: 40%" id="botsubmit">
                    <input class="btn btn-primary btn-block" type="submit" id="button-submit-cambiar" value="Cambiar Contraseña " name="btnPass"  />

                </div>
            </form>
        </div>
    </body>
</html>
