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
        <%-- 
            // Aque se muestra el menu de opciones para el portero
            // Como cerrar sesion
            // Las funciones a las que puede acceder que es 
            //  Cambiar contraseña y 
        
            // #Agregar Regla de que se necesita Firefox o navegador que soporte JS y el elemento Button
        --%>
        <div class="menu-navegacion">
             <%-- 
                # Navegando encontre lo siguiente:  
                // En HTML5 fue introducido un nuevo mecanismo para poder separar los elementos de 
                // formulario (buttons, inputs, etc) del formulario. El atributo form asocia un control con un <form>:
            --%>
            <form action="/Logout" id="form-cerrar-sesion">
                <button type="submit"  name="btn-cerrar-sesion">Cerrar sesion</button>
            </form>
        </div>
            
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
                    <input type="text"  onpaste="alert(this)" value="Alejo" name="input-name" />
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

