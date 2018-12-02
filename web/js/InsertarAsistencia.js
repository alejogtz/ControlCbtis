var bloqueAvisoRegistro = document.getElementById("div-advertir-registro");
var inputName           = document.getElementById("input-nocontrol");
var formularioPost      = document.getElementById("registrar-asistencia");


formularioPost.addEventListener("submit", post);


function post(event) {
    // Anular la redireccion de la pagina
    event.preventDefault(); 
    
    var nocontrol = document.getElementById("input-nocontrol").value;
    var params = "nocontrol=" + nocontrol;
    
    
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'ServletPortero', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    
    
    xhr.onload = function () {
        var mensaje = document.getElementById("status-registro");
        var imagen = document.getElementById("img-alumno-img");
        
        if (this.status === 200 ){
            mensaje.style.backgroundColor = 'green';
            mensaje.innerHTML = "Alumno con numero de control: " + nocontrol + " ingresado correctamente;"
            imagen.src = this.responseText;
            
            
        }else{ 
            mensaje.style.backgroundColor = 'red';
            mensaje.innerHTML = "Alumno con numero de control: " + nocontrol + " No fue agregado;"
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