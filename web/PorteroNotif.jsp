<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Cache-Control" content="no-store">
        <title>Login</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body id="body">
        <img id="logo"  src="images/page_1.jpg">
        <div id="contenedor">	
            <div id="cerrar_sesion">
                <button  id="button-salir" name="button-salir" value="boton SALIR">Cerrar Sesión</button>
            </div>
            <h2 id="h2">REGISTRO DE ASISTENCIAS</h2>			
            <div id="no_control">
                <label for="input-number">Numero de Control: </label>
                <input type="number" id="input-number" name="input-number" 
                       value="" placeholder="Esperando Numero..." />
            </div>
            <div id="notificacion">
                <h4 id="h4">Advertencia...!!</h4>
                <h5 id="h5">Cuentas con 3 inasistencias</h5>

                <div id="tabla">
                    <table id="tabla_nombres" border="1">
                        <tr>
                            <th scope="col">Nombre del Alumno </th>
                            <th scope="col">Fecha de inasistencia</th>
                        </tr>
                        <tr>
                            <td>Nombre1</td>
                            <td>fecha1</td>
                        </tr>

                        <tr>
                            <td>Nombre1</td>
                            <td>fecha2</td>
                        </tr>
                    </table>
                </div>
            </div>

            <div id="botonsubmit">
                <button type="submit" id="button-submit" name="button-submit" value="boton SUBMIT">Manual</button>
            </div>

            <div id="contenedor_buscar">
                <div id="buscar_por_nombre">
                    <label for="input-text">Ingrese Nombre a Buscar</label>
                    <input type="text" id="input-text" name="input-text" value="" placeholder="Ingresa nombre completo" />
                </div>
                <div id="botonbuscar">
                    <button  id="button-buscar" name="button-buscar" value="boton BUSCAR">Buscar</button>
                </div>
                <div id="tabla">
                    <table id="tabla_nombres" border="1">
                        <tr>
                            <th scope="col">Nombre del Alumno </th>
                            <th scope="col">Numero de Control</th>
                        </tr>
                        <tr>
                            <td>Nombre1</td>
                            <td>n_control1</td>
                        </tr>

                        <tr>
                            <td>Nombre2</td>
                            <td>n_control2</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

