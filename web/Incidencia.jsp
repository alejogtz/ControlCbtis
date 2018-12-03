<%-- 
    Document   : Incidencia
    Created on : 2/12/2018, 03:26:50 PM
    Author     : carlosA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Incidencia</title>
     <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/main3.css">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <!-- <script src="js/validacionCoordinadora.js"></script> -->
  
</head>

<body id="body">
    <div>
    <img id="logo"   src="images/page_1.jpg">
    </div>
    
    <nav  class="navbar navbar-expand-lg navbar-dark " style="width:80% ;margin-bottom: 0%; left:10%; background-color: #1A5276">
            <a class="navbar-brand" href="Coordinadora.jsp">Principal</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
             <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
             <ul class="navbar-nav">
                 <li class="nav-item active">
                    <a class="nav-link" class="active" href="#">Incidencias <span class="sr-only">(current)</span></a>
                 </li>
                 <li class="nav-item">
                 <a class="nav-link" href="NuevaContrasena.jsp">Cambiar Contraseña</a>
                 </li>
                <li class="nav-item">
                    <a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
                 </li>
                </ul>
            </div>
            </nav>
    <div id="contenedor">


        

        
        
<%@page import="java.sql.*" %>
        <%

Class.forName("com.mysql.jdbc.Driver");
Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbetis123", "root", "");

Statement Estamento = conexion.createStatement();
ResultSet rs = Estamento.executeQuery(""
        + "select e.NoControl, e.Nombre, e.ApPaterno, e.ApMaterno, a.Fecha from Estudiante e inner join Asistencia a on e.NoControl = a.NoControl where a.incidencia = 1");%>
        

        <h2 id="h2">Tabla de Incidencias</h2>
        <div class="container">
            <input style="width:94%" maxlength="20" class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
  <table style="width:94%" class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>No. De Control</th>
        <th>Nombre</th>
        <th>Apellido Paterno</th>
        <th>Apellido Materno</th>
        <th>Fecha de Incidencia</th>
      </tr>
    </thead>
    <tbody id="myTable">
        <% while (rs.next()) { 
            out.println("<tr>");

            out.println("<td>");

            out.println(rs.getInt("e.NoControl"));

            out.println("</td><td>");
            
            out.println(rs.getString("e.Nombre"));

            out.println("</td><td>");
            
            out.println(rs.getString("e.ApPaterno"));
            
            out.println("</td><td>");
            
            out.println(rs.getString("e.ApMaterno"));
            
            out.println("</td><td>");

            out.println(rs.getDate("a.Fecha"));

            out.println("</td>");

            out.println("</tr>");
        }%>
     
    </tbody>
  </table>
  
</div>
        
    </div>
        
        
        
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

</body>

</html>
