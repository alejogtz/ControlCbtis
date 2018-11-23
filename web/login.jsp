<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body id="body">
        <img id="logo"  src="images/page_1.jpg">


        <div id="contenedor">		
            <h2 id="h2">INICIAR SESION</h2>	
            <div id="usuario">
                <label for="select-Usuario">Usuario: </label>
                <select name="Usuario" id="select-Usuario">
                    <option selected>Vigilancia</option>
                    <option>Coordinación</option>
                </select>
            </div>
            <div id="password">
                <label for=input-password>Contraseña</label>
                <input type="password" id=input-password name=input-password value="" placeholder="Ingresa contraseña..." />
                <!-- <input type="password" pattern=".{6,}"> Esta es para tener 6 o mas caracteres-->
            </div>
            <div id="botonsubmit">
                <button type="submit" id="button-submit" name="button-submit" value="boton SUBMIT">Acceder</button>
            </div>
            <div id="botonrecuperar">
                <button  id="button-recuperar" name="button-recuperar" value="boton RECUPERAR">Recuperar Contrasena</button>
            </div>
        </div>
    </body>
</html>