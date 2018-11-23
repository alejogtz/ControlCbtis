/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* --------------------------------------- REGISTRO------------------------------------------------------------------ */
window.onload = iniciar;


function iniciar(){
   
    document.getElementById("btnregistrar").addEventListener('click',
    validar,false);
    

}

function validarUsuario(){
    var elemento = document.getElementById("txtuserreg").value;
    if (!elemento.checkValidity()){
        if(elemento.validity.valueMissing){
            error2(elemento,"Debe introducir un usuario");
        }
        if(elemento.validity.patternMismatch){
            error2(elemento,"El usuario debe tener entre 8 y 16 \n\
            caracteres");
        }
        
        return false;
    }
    return true;
}

function validarContrasena(){
    var elemento = document.getElementById("txtpassreg").value;
    if (!elemento.checkValidity()){
        if(elemento.validity.valueMissing){
            error2(elemento,"Debe introducir una contraseña");
        }
        if(elemento.validity.patternMismatch){
            error2(elemento,"El nombre debe tener entre 8 y 16 \n\
            caracteres");
        }
       
        return false;
    }
    return true;
}

function validarEmail(){
    var elemento = document.getElementById("txtemailreg").value;
    if (!elemento.checkValidity()){
        
        if(elemento.validity.patternMismatch){
            error2(elemento,"Ingresa un correo, por favor");
        }
        
        return false;
    }
    return true;
}


function validar(e){
    borrarError();
    if(validarUsuario() && validarContrasena() && validarEmail() ){
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
    document.getElementById("mensajeError").innerHTML = mensaje;
    elemento.className = "error";
    elemento.focus();
}

function borrarError(){
    var formulario = document.getElementById("formregistro");
    for(var i=0; i<formulario.elements.length;i++)
        formulario.elements[i].className="";
}

/* --------------------------------------------------------------------------------------------------------- */
/* ---------------------------------------LOGIN------------------------------------------------------------------ */
window.onload = iniciarlogin;


function iniciarlogin(){
   
    document.getElementById("btniniciar").addEventListener('click',
    validarlogin,false);
    

}

function validarUsuariologin(){
    var elemento = document.getElementById("txtusuario").value;
    if (!elemento.checkValidity()){
        if(elemento.validity.valueMissing){
            error2(elemento,"Debe introducir un usuario");
        }
        if(elemento.validity.patternMismatch){
            error2(elemento,"El usuario debe tener entre 8 y 16 \n\
            caracteres");
        }
        
        return false;
    }
    return true;
}

function validarContrasenalogin(){
    var elemento = document.getElementById("txtpass").value;
    if (!elemento.checkValidity()){
        if(elemento.validity.valueMissing){
            error2(elemento,"Debe introducir una contraseña");
        }
        if(elemento.validity.patternMismatch){
            error2(elemento,"El nombre debe tener entre 8 y 16 \n\
            caracteres");
        }
       
        return false;
    }
    return true;
}

function validarlogin(e){
    borrarErrorlogin();
    if(validarUsuariologin() && validarContrasenalogin() ){
            return true;
            }else{
                e.preventDefault();
                return false;
            }
    
}
function borrarErrorlogin(){
    var formulario = document.getElementById("forminicio");
    for(var i=0; i<formulario.elements.length;i++)
        formulario.elements[i].className="";
}


/* --------------------------------------------------------------------------------------------------------- */

/* ---------------------------------------CORREO------------------------------------------------------------------ */


function iniciarlogincorreo(){
   
    document.getElementById("btncorreo").addEventListener('click',
    validarlogincorreo,false);
    

}

function validarEmailenvio(){
    var elemento = document.getElementById("txtrescorreo").value;
    if (!elemento.checkValidity()){
        
        if(elemento.validity.patternMismatch){
            error2(elemento,"Ingresa un correo, por favor");
        }
        
        return false;
    }
    return true;
}

function validarlogincorreo(e){
    borrarErrorlogin();
    if(validarEmailenvio() ){
            return true;
            }else{
                e.preventDefault();
                return false;
            }
    
}
function borrarErrorlogincorreo(){
    var formulario = document.getElementById("oculto");
    for(var i=0; i<formulario.elements.length;i++)
        formulario.elements[i].className="";
}



