<%@page import="javax.swing.JOptionPane"%>
<%@page import="Utilidades.md5"%>
<%@page import="Controlador.Consultas"%>
<%@page import="Correo.Email"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>LOGIN</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/main3.css">
        <script src="js/main.js"></script>
        <script src="js/md5.js"></script>
    </head>

    <body id="body">


        <div>
            <img id="logo"  src="images/page_1.jpg">
        </div>

        <div id="contenedor">	
            <h2 id="h2">INICIAR SESIÓN</h2>	
            <div>
                <img id="log" src="images/a.png" class="img-rounded" > 
            </div>

            <%
                String aviso = (String) request.getAttribute("Mensaje");
                if (aviso != null) {
                    out.println(aviso);
                    request.setAttribute("Mensaje", "");
                }
            %>

            <div class="login-dark " style="margin-top: 22%; margin-bottom: 22%">
                <div class="form">
                    <form action="Iniciar" method="post" id="forminicio">
                        <div class="form-group">
                            <select class="form-control" name="usuario" id="txtusuario" style="background-color: white">
                                <option value="coordinador" selected>Coordinador</option>
                                <option value="vigilante">Vigilante</option>
                            </select>
                        </div>  

                        <div class="form-group" style="background-color: white">
                            <input class="form-control" id="txtpass" type="password" name="contrasena" placeholder="Contraseña" maxlength="16"  >
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-block" type="submit" value="Iniciar Sesion" id="btniniciar">ACCEDER</button>
                        </div>
                    </form>

                    <div class="form-group ">
                        <form action="Enviarcorreo" method="post" >
                            <input  class="btn btn-primary btn-block" type="submit" value="Recuperar contraseña" id="btncorreo" />
                        </form>
                        <br>
                        <%
                            String correo_aviso = (String) request.getAttribute("Info-correo");
                            if (correo_aviso != null) {
                                out.println(correo_aviso);
                                request.setAttribute("Info-correo", "");
                            }
                        %>
                    </div>

                </div>
            </div>




        </div> 

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>



    </body>
</html>
