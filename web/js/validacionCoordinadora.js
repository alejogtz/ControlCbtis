/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = iniciarMatricula;


function iniciarMatricula(){
   
    document.getElementById("button-submit").addEventListener('click',
            validarMatriculaOP,false);
    

}

function validarMatricula(){
    var elemento = document.getElementById("input-number").value;
    if (!elemento.checkValidity()){
        if(elemento.validity.valueMissing){
            error2(elemento,"Debe introducir un número de control");
        }
        if(elemento.validity.patternMismatch){
            error2(elemento,"El número de control debe de se de 14 \n\
            caracteres");
        }
        
        return false;
    }
    return true;
}

function validarMatriculaOP(e){
    borrarError();
    if(validarMatricula()){
            return true;
            }else{
                e.preventDefault();
                return false;
            }
    
}

function error(elemento){
    document.getElementById("mensajeError").innerHTML =
            elemento.validationMessage;
    elemento.className="error";
    elemento.focus();
}

function error2(elemento,mensaje){
    document.getElementById("mensajeError2").innerHTML = mensaje;
    elemento.className = "error";
    elemento.focus();
}

function borrarError(){
    var formulario = document.getElementById("formregistro");
    for(var i=0; i<formulario.elements.length;i++)
        formulario.elements[i].className="";
}

function solonumeros(e){
    var key = e.charCode;
    if (
            (key >= 48 && key <= 57 ) ||
             key === 0 ) {}
    else {e.preventDefault();}
    /*key=e.keyCode || e.which;
    teclado = String.fromCharCode(key);
    numero="0123456789";
    especiales="8-37-38-46-0";
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


