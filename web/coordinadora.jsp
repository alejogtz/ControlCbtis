<%-- 
    Document   : coordinadora
    Created on : 21/11/2018, 03:24:49 AM
    Author     : carlosA
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
    try{
    HttpSession objsesion = request.getSession(false);
    String usuario = (String)objsesion.getAttribute("usuario");
    
      if(usuario.equals("")){
       response.sendRedirect("index.jsp");
      }
    }catch(NullPointerException e){
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
	</head>
	<body id="body">
	<img id="logo"  src="images/page_1.jpg">
	<div id="contenedor">
		<div id="cerrar_sesion">
		<ul>
		  <li><a href="#contact">Reestablecer Contraseña</a></li>
		  <li><a href="CerrarSesion">Logout</a></li>
		</ul>
		</div>
		<h2 id="h2">Bienvenida coordinadora</h2>
                <form name="reporte" method="get" action="/Cbetis/pdf">
		<div id="cont_buscar">
			<div id="no_co">
				<label for="input-number">Numero de Control: </label>
				<input type="number" id="input-number" name="txtId" 
                                       value=""  maxlength="14" minlength="14" placeholder="Esperando Numero..." />
			</div>
                        <%--<div id="buscar_por_nombre">
				<label for="input-text">Nombre del Alumno</label>
				<input type="text" id="input-text" pattern="[A-Za-z]" name="input-text" value="" placeholder="Ingresa nombre completo" />
			</div> --%>
		</div>
                <p type="text" id="mensajeError2" name="mensajeError" value=""/>
			<div id="botsubmit">
                            <input type="submit" id="button-submit" value="Generar Reporte" name="btnver" />
			
		</div>
                    </form>
	</div>
	</body>
</html>