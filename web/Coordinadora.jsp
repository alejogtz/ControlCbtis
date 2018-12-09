<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>COORDINACION</title>
            <link rel="stylesheet" href="css/bootstrap.min.css">
	    <link rel="stylesheet" href="css/main.css">
	    <link rel="stylesheet" href="css/main3.css">           
            <script src="js/jquery.min.js"></script>
            <script src="js/popper.min.js"></script>
            <script src="js/bootstrap.min.js"></script> 
            <script src="js/validacionCoordinadora.js"></script>
	</head>
	<body id="body">
	<div>
		<img id="logo"  src="images/page_1.jpg">
	</div>	
            <nav  class="navbar navbar-expand-lg navbar-dark " style="width:80% ;margin-bottom: 0%; left:10%; background-color: #1A5276">
            <a class="navbar-brand"  class="active"  >Principal</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
             <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
             <ul class="navbar-nav">
                 <li class="nav-item active">
                    <a class="nav-link" href="Incidencia.jsp">Incidencias <span class="sr-only">(current)</span></a>
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
            <%
                    String aviso = (String)request.getAttribute("Mensaje");
                    if (aviso!=null){
                        out.println(aviso);                 
                        request.setAttribute("Mensaje", null);
                    }
                    aviso = (String)request.getAttribute("AvisoContrasena");
                    if (aviso!=null){
                        out.println(aviso);    
                        request.setAttribute("AvisoContrasena", null);
                    }
                %>
		<h2 id="h2-">Bienvenido Coordinador</h2>  		
		<form name="reporte" method="get" action="/WebProjectCbtis/pdf">
                    <div  class="escanear">
                    <div class="form" style="display:inline-block;padding-left: 20%">	
                    <label for="input-number" class="form-group" >Número de control: </label>	
                            <div  class="form-group" style="display:inline-block">                                
                                <input class="form-control" type="text" name="txtId" minlength="6" maxlength="8" required="required" placeholder="Esperando Numero..." onkeypress="return solonumeros(event)">
                            </div>
                    <div class="form-group aju"style="display:inline-block">
                        <button class="btn btn-dark btn-block" type="submit" id="button-submit" value="Generar Reporte" name="btnver">GENERAR REPORTE</button>
                    </div>
                    <br>
                    </div>
                        <p type="text" id="mensajeError2" name="mensajeError" value="" />
                    </div>	
                </form>
  	
    </div>
	</body>
	</html>
	