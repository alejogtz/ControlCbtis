<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>REGISTRO DE ASISTENCIA</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/main3.css">

    </head>

    <body id="body">
        <div>
            <img id="log"  src="images/page_1.jpg">
        </div>        
        <!-- *****************************************************< Begin Nav >***************************************************************** -->

        <nav  class="navbar navbar-expand-lg navbar-dark " style="width:80% ;margin-bottom: 0%; left:10%; background-color: #1A5276">
            <a class="navbar-brand" href="Portero.jsp">Principal</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">                        
                    <li class="nav-item">
                        <a class="nav-link" href="NuevaContrasena.jsp">Cambiar Contraseña</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- *****************************************************< End Nav >***************************************************************** -->

        <div id="contenedor">
            <!--<div class="cerrar">
               <div class="form-group aju"><button class="btn btn-info btn-block" type="submit">CERRAR SESIÓN</button></div><br>
           </div>-->
            <h2 id="h2-">Registro de asistencias</h2>     


            <div  class="escanear">
                <form  id="registrar-asistencia" method="POST">

                    <div class="form">
                        <label class="form-group">Número de control: </label>	
                        <div class="form-group">
                            <input class="form-control" type="text" id="input-nocontrol" name="nocontrol" placeholder="Esperando número de control. . .">
                            <button class="btn btn-black btn-block" type="submit">Registrar</button>
                        </div><br>
                        <div class="radio-group "> 
                            <input type="radio" id="option-one" value="0" onclick="loadValueFromRadio(this.value)" name="selector" class="form-group aju2"><label class="label" for="option-one">Normal</label>
                            <input type="radio" id="option-two" value="1" onclick="loadValueFromRadio(this.value)" name="selector" class="form-group aju2"><label class="label" for="option-two">Incidencia</label>
                        </div><br>
                    </div>
                </form>

                <!-- *******************************************Div de aviso ********************************************** -->
                <div class="alert alert-success" id="aviso" style="display: none">
                    <!--<strong>Success!</strong> Indicates a successful or positive action.-->
                </div>
                <!--
                <div class="alert alert-info" id="aviso-info" style="display: none">
                    <strong>Info!</strong> Indicates a neutral informative change or action
                </div>

                <div class="alert alert-warning" id="aviso-advertencia" style="display: none">
                    <strong>Warning!</strong> Indicates a warning that might need attention
                </div>

                <div class="alert alert-danger" id="aviso-error-grave" style="display: none">
                    <strong>Danger!</strong> Indicates a dangerous or potentially negative action
                </div>-->
                <!-- *******************************************Fin Avisos ********************************************** -->

                <div class="form">
                    <div class="form-group aju"><button class="btn btn-dark btn-block" type="submit" id="button-manual">MANUAL</button></div><br>
                    <div id="contenedor_buscar">
                        <label class="form-group">Ingrese nombre a buscar: </label>	
                        <div class="form-group"><input class="form-control" type="text" name="nombre" id="MyIdName" placeholder="Ingrese nombre completo"></div><br>
                        <!-- <div class="form-group aju"><button class="btn btn-info btn-block" id="button-buscar" type="submit">BUSCAR</button></div><br>-->

                        <div>
                            <%@page import="java.sql.*" %>
                            <%

                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbetis123", "root", "");

                                Statement Estamento = conexion.createStatement();
                                ResultSet rs = Estamento.executeQuery(""
                                        + "SELECT * "
                                        + "FROM estudiante");%>



                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Número de control</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Apellido Paterno</th>
                                        <th scope="col">Apellido Materno</th>
                                    </tr>
                                </thead>
                                <tbody id="myTable">
                                    <% while (rs.next()) {
                                            out.println("<tr>");

                                            out.println("<td>");

                                            out.println(rs.getInt("NoControl"));

                                            out.println("</td><td>");

                                            out.println(rs.getString("Nombre"));

                                            out.println("</td><td>");

                                            out.println(rs.getString("ApPaterno"));

                                            out.println("</td><td>");

                                            out.println(rs.getString("ApMaterno"));

                                            out.println("</td>");

                                            out.println("</tr>");
                                        }%>

                                </tbody>
                            </table>

                        </div>  
                    </div>


                </div>



            </div>
        </div>	
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/InsertarAsistencia.js"></script>
        <script src="js/EventosPortero.js"></script>


        <script>
                                $(document).ready(function () {
                                    $("#MyIdName").on("keyup", function () {
                                        var value = $(this).val().toLowerCase();
                                        $("#myTable tr").filter(function () {
                                            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                        });
                                    });
                                });
        </script>
    </body>
</html>
