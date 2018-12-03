var bloqueAvisoRegistro = document.getElementById("div-advertir-registro");
var inputName = document.getElementById("input-nocontrol");
var formularioPost = document.getElementById("registrar-asistencia");
var opcionRadio = "0";

formularioPost.addEventListener("submit", post);


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
        
        mensaje.style.display = "block";
        if (this.status === 200) {            
            mensaje.className = "alert alert-success";
            mensaje.innerHTML = "Alumno con numero de control: " + nocontrol + " ingresado correctamente;"
            imagen.style.display = "block";
            imagen.src = this.responseText;


        } else {
            mensaje.className = "alert alert-danger";
            mensaje.innerHTML = "Alumno con numero de control: " + nocontrol + " No fue agregado;"
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
};

function loadValueFromRadio(entrada){
    console.log("........", entrada, ".................");
    opcionRadio = entrada;
}