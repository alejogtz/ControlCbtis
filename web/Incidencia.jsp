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
    <link rel="stylesheet" href="css/main.css">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <!-- <script src="js/validacionCoordinadora.js"></script> -->
</head>

<body id="body">
    <img id="logo" src="images/page_1.jpg">
    <div id="contenedor">


        <div id="cerrar_sesion">
            <ul>
                <li><a href="/NuevaContrasena.jsp">Cambiar Contraseña</a></li>
                <li><a href="/Incidencia.jsp">Incidencia</a></li>
                <li><a href="CerrarSesion">Logout</a></li>
            </ul>
        </div>


        <h2 id="h2">Tabla de Incidencias</h2>
        <div class="container">
  <h2>Filterable Table</h2>
  <p>Type something in the input field to search the table for first names, last names or emails:</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody id="myTable">
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@mail.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@greatstuff.com</td>
      </tr>
      <tr>
        <td>Anja</td>
        <td>Ravendale</td>
        <td>a_r@test.com</td>
      </tr>
    </tbody>
  </table>
  

        
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
