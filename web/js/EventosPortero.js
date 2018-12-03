/*  Eventos para ocultar el div de busqueda manual*/

var div_buscar_oculto = true;


document.getElementById("button-manual").addEventListener('click', mostrarDivBusqueda, false);
document.getElementById('contenedor_buscar').style.display = 'none';


function mostrarDivBusqueda() {
    if (div_buscar_oculto) {
        document.getElementById('contenedor_buscar').style.display = 'block';
    } else {
        document.getElementById('contenedor_buscar').style.display = 'none';
    }
    div_buscar_oculto = !div_buscar_oculto;
}
;

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