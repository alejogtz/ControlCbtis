<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    try {
        HttpSession objsesion = request.getSession(false);
        String usuario = (String) objsesion.getAttribute("usuario");

        if (usuario.equals("")) {
            response.sendRedirect("iniciar");
        }
    } catch (NullPointerException e) {
        response.sendRedirect("index.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <title>Portero - Menu</title>
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/Normalize.css">
        <meta charset="UTF-8">
        
        <meta http-equiv="Cache-Control" content="no-store;no-cache">
        <meta http-equiv="Expires" content="0" >
        <meta http-equiv="Pragma" content="no-cache" >
        
        <script src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
            if (history.forward(1)) {
                location.replace(history.forward(1));
            }
        </script>
    </head>



    <body id="body">

        <img id="logo"  src="img/page_1.jpg">

        <div id="contenedor">

            <!--
            <div id="cerrar_sesion">
                <button  id="button-salir" name="button-salir" value="boton SALIR">Cerrar Sesión</button>
            </div>-->
            <a href="CerrarSesion">Logout</a>


            <h2 id="h2">REGISTRO DE ASISTENCIAS</h2>	

           
            <form id="registrar-asistencia">
                <div id="no_control">
                    <label for="input-nocontrol">Numero de Control: </label>
                    <input type="number" id="input-nocontrol" name="input-nocontrol" 
                           value="" placeholder="Esperando Numero..." />
                    <input type="submit" id="button-registrar" name="button-registrar" value="Registrar"/>
                </div>
            </form>
            


            <div id="botonsubmit">
                <button type="button" id="button-manual" name="button-Manual" value="boton Manual">Manual</button>
            </div>


            <div id="div-advertir-registro" ><!--style="background-color: green;"-->
                <p id="status-registro">

                <p>
            </div>
            
            

            <div id="contenedor_buscar">
                <div id="buscar_por_nombre">
                    <label for="input-text">Ingrese Nombre a Buscar</label>
                    <input type="text" id="input-text" name="nombre" value="" placeholder="Ingresa nombre completo" />
                </div>


                <div id="botonbuscar">
                    <button  id="button-buscar" name="button-buscar" value="boton BUSCAR">Buscar</button>
                </div>


                <div id="tabla"></div>

                <script type="text/javascript">
                    document.getElementById('button-buscar').addEventListener('click', cargarAlumno);


                    var cargarAlumno = function () {
                        var xhr = new XMLHttpRequest();
                        var nocontrol = document.getElementById("input-nocontrol").value;
                        var params = "nocontrol=" + nocontrol;
                        if (isValid(nocontrol) && event.KeyCode === 13) {
                            xhr.open('POST', 'ServletPortero', true);
                            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                            xhr.onload = function () {
                                console.log(this.responseText);
                            };
                            xhr.onerror = function () {
                                console.log('Request Error...');
                            };
                            xhr.send(params);
                        }
                    };
                </script>
            </div>

            <script type="text/javascript">
                console.log("Ejecutando...");
                var div_buscar_oculto = true;
                document.getElementById("button-manual").addEventListener('click', mostrarDivBusqueda, false);
                document.getElementById('contenedor_buscar').style.display = 'none';

                function mostrarDivBusqueda() {
                    console.log("..........");
                    if (div_buscar_oculto) {
                        document.getElementById('contenedor_buscar').style.display = 'block';
                        console.log("Mostrar");
                    } else {
                        document.getElementById('contenedor_buscar').style.display = 'none';
                        console.log("Ocultar");
                    }
                    div_buscar_oculto = !div_buscar_oculto;
                }
                ;


                document.getElementById("button-buscar").addEventListener('click', cargarInformacion);

                function cargarInformacion() {
                    console.log("Buscando......");
                    var _get = new XMLHttpRequest();
                    var nombre = document.getElementById("input-text").value;
                    _get.open('GET', "ServletPortero?nombre=" + nombre + "&nrs=" + Math.random(), true);
                    _get.onload = function () {
                        console.log(this.responseText);
                        if (this.status == 200) {
                            document.getElementById("tabla").innerHTML = this.responseText;
                        }
                    };
                    _get.send();

                }
                ;

            </script>

        </div>

        <!-- Load Script Files --> 
        <script src="js/RequestAsistencias.js"></script>

    </body>
</html>