var formularioPost = document.getElementById("registrar-asistencia");
formularioPost.addEventListener("submit", _post);


function _post(event) {
    // Anular la redireccion de la pagina
    event.preventDefault();
    
    var nocontrol = document.getElementById("input-nocontrol").value;
    var params = "nocontrol=" + nocontrol;    
    var xhr = new XMLHttpRequest();
	
    xhr.open('POST', 'ServletPortero', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');    
    xhr.onload = function () {
        var mensaje = document.getElementById("status-registro");        
        if (this.status === 200 ){        
            mensaje.style.backgroundColor = 'green';
            mensaje.innerHTML = "Alumno con numero de control: " + nocontrol + " ingresado correctamente;"            
        }else{ 
            mensaje.style.backgroundColor = 'red';
            mensaje.innerHTML = "Alumno con numero de control: " + nocontrol + " No fue agregado;"
        }
        document.getElementById("input-nocontrol").focus();
        document.getElementById("input-nocontrol").value = '';
    };
    xhr.onerror = function () {
        document.getElementById("div-advertir-registro").style.backgroundColor = 'red';
        
        mensaje.innerHTMLS = "Alumno con numero de control: " + nocontrol + " No fue agregado;<br><br>" + this.responseText;
    };
    xhr.send(params);
};


var isValid = function (nocontrol) {
    if (typeof nocontrol === 'Number') {
        return true;
    } else {
        return false;
    }
};