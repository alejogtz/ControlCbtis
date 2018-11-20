<%@page contentType="text/html"%>
<%@ page import="org.proyectoCbtis.java.Modelo.Validacion" %>
<%@ page import="org.proyectoCbtis.java.Util.Parser.DeObject"%>
<%@ page import="org.proyectoCbtis.java.Util.Parser.DeString"%>


<div class = "busqueda" >
    <% 
        // Capturar el no de control
        int nocontrol = DeString.aInt(  request.getParameter("nocontrol")  );
        // Busqueda en la Base de datos
        String nombre = "Hugo";
        
    %>
    
    <fieldset>
        <label for="out-nocontrol">Numero de control</label>
        
           
        <input type="text" readonly name="out-nocontrol" id="out-nocontrol" placeholder="000000"><%=nocontrol%>
        
        <label for="out-nombre">Nombre</label>
        <input type="text" readonly name="out-nombre" id="out-nocontrol" placeholder="Name"><%=nombre%>
        
    </fieldset>
        
</div>