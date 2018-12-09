/*  Eventos para ocultar el div de busqueda manual*/

var div_buscar_oculto = true;


document.getElementById("button-manual").addEventListener('click', mostrarDivBusqueda, false);
document.getElementById('contenedor_buscar').style.display = 'none';

//document.getElementById("input-nocontrol").addEventListener("keypress", soloNumeros, false);


function mostrarDivBusqueda() {
    if (div_buscar_oculto) {
        document.getElementById('contenedor_buscar').style.display = 'block';
    } else {
        document.getElementById('contenedor_buscar').style.display = 'none';
    }
    div_buscar_oculto = !div_buscar_oculto;
}
;

function soloNumerosAqui(e) {

    var key = e.charCode;
    if (
            (key >= 48 && key <= 57 ) ||
             key === 0 || key === 13 ) {}
    else {e.preventDefault();}
    /*key=e.keyCode || e.which;
     teclado = String.fromCharCode(key);
     numero="0123456789";
     especiales="8-37-38-46";
     teclado_especial=false;
     
     for(var i in especiales){
     if(key === especiales[i]){
     teclado_especial=true;
     }
     }
     
     if(numero.indexOf(teclado) === -1 && !teclado_especial){
     return false;
     
     }*/
}

/*
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
 */