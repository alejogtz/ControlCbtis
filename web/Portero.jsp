<%@page import="Controlador.OperacionAsistencias"%>
<%@page import="Utilidades.Parser.DeString"%>
<%@page import="Controlador.Busqueda"%>
<%@page import="Utilidades.Console"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Portero - Registrar Asistencia</title>
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/Normalize.css">
        <meta charset="UTF-8">


        <script>
            window.addEventListener("pageshow", function (event) {
                var historyTraversal = event.persisted ||
                        (typeof window.performance != "undefined" &&
                                window.performance.navigation.type === 2);
                if (historyTraversal) {
                    // Handle page restore.                    
                    window.location.reload();
                }
            });
        </script>


    </head>


    <body id="body">
        <img id="logo"  src="img/page_1.jpg">


        <div id="contenedor">
            <a href="CerrarSesion">Logout</a>
            <h2 id="h2">REGISTRO DE ASISTENCIAS</h2>


            <form id="registrar-asistencia" method="post">
                <div id="no_control">
                    <label for="input-nocontrol">Numero de Control: </label>
                    <input type="number" id="input-nocontrol" name="input-nocontrol" 
                           value="" placeholder="Esperando Numero..." />

                    <fieldset>
                        <legend>Tipo de entrada</legend>
                        <label><input type="radio" name="modo-entrada" value="normal" checked="checked">Normal</label>
                        <label><input type="radio" name="modo-entrada" value="incidencia">Incidencia</label>
                    </fieldset>

                    <input type="submit" id="button-registrar" name="submit-button" value="Registrar"/>
                </div>
            </form>


            <div id="img-alumno"> </div>



            <div id="botonsubmit">
                <button type="button" id="button-manual" name="button-Manual" value="boton Manual">Manual</button>
            </div>


            <div id="div-advertir-registro" >
                <p id="status-registro"><p>
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
                var div_buscar_oculto = true;


                document.getElementById("button-manual").addEventListener('click', mostrarDivBusqueda, false);
                document.getElementById('contenedor_buscar').style.display = 'none';


                function mostrarDivBusqueda() {
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
                    var nombre = document.getElementById("input-text").value;


                    var _get = new XMLHttpRequest();
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
        <script src="js/InsertarAsistencia.js"></script> 

    </body>
</html>