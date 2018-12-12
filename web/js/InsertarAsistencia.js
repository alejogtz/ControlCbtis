var bloqueAvisoRegistro = document.getElementById("div-advertir-registro");
var inputName = document.getElementById("input-nocontrol");
var formularioPost = document.getElementById("registrar-asistencia");
var opcionRadio = "0";

//formularioPost.addEventListener("submit", noEnviarSiCampoVacio);
formularioPost.addEventListener("submit", post);

function noEnviarSiCampoVacio(event) {
    var campoEstrictoNoVacio = document.getElementById("input-nocontrol");

    if (campoEstrictoNoVacio.validity.valueMissing) {
        var mensaje = document.getElementById("aviso");
        mensaje.style.display = "block";
        mensaje.className = "alert alert-danger";
        mensaje.innerHTML = "<strong>Campo Vacio:</strong> Complete el campo de Número de Control";
        console.log("Line: 18 - InsertarAsistencia.js -> Antes de anular la acción");
        event.preventDefault();
    } else
        post(event);
}
;

function post(event) {
    // Anular la redireccion de la pagina
    event.preventDefault();

    var nocontrol = document.getElementById("input-nocontrol").value;
    var incidencia = document.getElementsByName("modo-entrada").value;


    var params = "nocontrol=" + nocontrol + "&incidencia=" + opcionRadio;


    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'ServletPortero', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');


    xhr.onload = function () {
        var mensaje = document.getElementById("aviso");
        var imagen = document.getElementById("img-alumno-img");
        
        
        console.log(this.status);
         mensaje.style.display = "block";
        if (this.status === 200) {

            mensaje.className = "alert alert-success";
            mensaje.innerHTML = "<strong>Exito: </strong>  Asistencia para el número de control:<strong>" + nocontrol + "</strong> registrado correctamente";
            imagen.style.display = "block";
            imagen.src = this.responseText;


        }else if (this.status === 404) {
            
            mensaje.className = "alert alert-danger";
            mensaje.innerHTML = "El alumno con Número de Control:<strong>" + nocontrol + "</strong> No existe en la base de datos. <br> Se ha enviado una notificación a la Coordinación";
            imagen.style.display = "block";
            imagen.src = "images/fotosalumno/default.jpg";

        }else if (this.status === 300) {
            
            mensaje.className = "alert alert-warning";
            mensaje.innerHTML = "<strong>Advertencia</strong> La asistencia para el alumno con Número de Control: <strong> " + nocontrol + "</strong> ya está registrada";
            imagen.style.display = "block";
            imagen.src = "images/fotosalumno/default.jpg";

        }else if (this.status === 700) {
            
            mensaje.className = "alert alert-warning";
            mensaje.innerHTML = "<strong>Advertencia</strong> Lo sentimos, No podemos registrar asistencias, No es dia habil <br> Si es día habil, revise la fecha de su computadora";
            imagen.style.display = "block";
            imagen.src = "images/fotosalumno/default.jpg";

        }else if (this.status === 500) {
            
            mensaje.className = "alert alert-danger";
            mensaje.innerHTML = "<strong>Fatal</strong> No se pudo establecer la conexión con la Base de datos X_X";
            imagen.style.display = "block";
            imagen.src = "images/fotosalumno/default.jpg";
            
        } else {
            mensaje.className = "alert alert-danger";
            mensaje.innerHTML = "<strong>Error</strong> Alumno con numero de control:<strong>" + nocontrol + "</strong> No fue registrado;";
            imagen.style.display = "block";
            imagen.src = "images/fotosalumno/default.jpg";
        }
        inputName.focus();
        inputName.value = '';
    };


    xhr.onerror = function () {
        bloqueAvisoRegistro.style.backgroundColor = 'red';
        mensaje.innerHTMLS = "Alumno con numero de control: " + nocontrol + " No fue agregado;<br><br>" + this.responseText;
    };


    xhr.send(params);
}
;

function loadValueFromRadio(entrada) {
    console.log("........", entrada, ".................");
    opcionRadio = entrada;
}