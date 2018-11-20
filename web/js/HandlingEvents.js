
// Agregar automaticamente alumnos
function eventHandlingPaste() {
    // Capturar el contenido del recuadro
    var nocontrol = document.getElementsById("input-nocontrol");
    
    // Hacer la operacion de inserción
        // solicitar la inserción
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // Append el resultado exitoso a un div  de mensajes
            document.getElementById("demo").innerHTML = this.responseText;
        }else{
            // Si no se inserta, Appen el mensaje de error en el mismo div
        }
        
    };
    xhttp.open("POST", "ServletCoordinacion", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("name");


    // Borrar el contenido del recuado
}