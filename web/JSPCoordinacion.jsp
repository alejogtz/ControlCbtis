<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.proyectoCbtis.java.Modelo.Validacion" %>
<%@ page import="org.proyectoCbtis.java.Util.Parser.DeObject"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- SECTION:    -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="img/icono.png" rel="icon" type="image/png" />
        <title>Bienvenido</title>        
        <!-- Agregar Icono de pagina-->
    </head>
    <body>
        <% 
            //<!-- Verificar que la sesión este activa--> 
            //<!-- La validacion del usuario correcto se realiza en el login--> 
            HttpSession sesion = request.getSession(false);
            boolean sesionActiva = sesion!=null;
            String user = DeObject.aString(  sesion.getAttribute("user")  );
            
            if (sesionActiva && Validacion.existSesion(user)){
                
            }else {
                
                response.getWriter().println(" <a href=\"Login.jsp\" ><h3> Login </h3> " );
                //response.sendRedirect("login.jsp");
            }
            //<!-- Verificar que la sesión este activa--> 
            
        %>
        
        
        
        
        
    </body>
</html>
