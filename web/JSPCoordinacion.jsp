<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.proyectoCbtis.java.Modelo.Validacion" %>
<%@ page import="org.proyectoCbtis.java.Util.Parser.DeObject"%>
<%@ page import="java.util.Date"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- SECTION:    -->        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="img/icono.png" rel="icon" type="image/png" />
        <link href="css/Normalize.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script src="js/HandlingEvents.js" type="text/javascript" charset="utf-8"></script>
        <title>Coordinacion</title>        
    </head>

    <body>       
        <div class=""
            
        <%--
            // Menu de navegacion 
        --%>
        <div class="nav-info">
            <%! String mes[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};%>
            <h1>fecha: <%= mes[new Date().getMonth()]%>  <%=new Date().getDay()%>, <%=new Date().getYear() + 1900 %> </h1>
        </div>
        <%--
            // Div para mostrar la infor de hora y cosas de ese tipo
            // Recomendable cargar file para cargarlo  a todos las paginas
        --%>

        <%-- // Formulario --%>
        <div id="form-registrar-asistencia">


            <form action="ServletCoordinacion" method="POST">
                <legend> Datos del alumno </legend>
                <fielset> 
                    <label for="input-name">Nombre</label>
                    <input type="text"  onpaste="insertarAlumno()" value="Alejo" name="input-name" />
                    <button type="submit"  name="btn-submit-busqueda">Enviar</button>

                    <label for="input-nocontrol">No. de control</label>
                    <input type="number" value="15161306" name="input-nocontrol"/>
                    <button type="submit" onkeypress="" name="btn-submit">Enviar</button>
                    
                    
                    <button type="submit" onkeypress="" name="btn-submit">Enviar</button>
                </fielset>

            </form>
        </div>




        <%--
            /* */
            //<!-- Verificar que la sesión este activa--> 
            //<!-- La validacion del usuario correcto se realiza en el login--> 
            HttpSession sesion = request.getSession(false);
            boolean sesionActiva = sesion != null;
            String user = DeObject.aString(sesion.getAttribute("user"));
            System.out.println(sesion);
            if (sesionActiva && Validacion.existSesion(user)) {
                response.sendRedirect("login.jsp");
            } else {

                response.getWriter().println(" <a href=\"Login.jsp\" ><h3> Login </h3> ");
                //response.sendRedirect("login.jsp");
            }
            //<!-- Verificar que la sesión este activa--> 

        --%>





    </body>
</html>

