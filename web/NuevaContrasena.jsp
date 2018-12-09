<%-- 
    Document   : NuevaContrasena
    Created on : 30/11/2018, 03:21:40 PM
    Author     : Alessio
--%>

<%
    try {
        HttpSession objsesion = request.getSession(false);
        String usuario = (String) objsesion.getAttribute("usuario");

        if (usuario.equals("")) {
            response.sendRedirect("index.jsp");
        }
    } catch (NullPointerException e) {
        response.sendRedirect("index.jsp");
    }
    //    //

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Coordinacion</title>
         <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/main3.css">
        <script src="js/validacionCoordinadora.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
        <script src="js/app-ajax.js" type="text/javascript"></script>
        <style>
/* Style all input fields */


/* The message box is shown when the user clicks on the password field */
#message {
    display:none;
    background: #f1f1f1;
    color: #000;
    position: relative;
    padding: 20px;
    margin-top: 10px;
}

#message p {
    padding: 10px 35px;
    font-size: 18px;
}

/* Add a green text color and a checkmark when the requirements are right */
.valid {
    color: green;
}

.valid:before {
    position: relative;
    left: -35px;
    content: "+";
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
    color: red;
}

.invalid:before {
    position: relative;
    left: -35px;
    content: "-";
}
</style>
    </head>
    <body id="body">
        <div>
        <img id="logo"  src="images/page_1.jpg">
        </div>
        
        <nav  class="navbar navbar-expand-lg navbar-dark " style="width:80% ;margin-bottom: 0%; left:10%; background-color: #1A5276">
            <a class="navbar-brand" href="Coordinadora.jsp"  >Principal</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
             <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
             <ul class="navbar-nav">
                 <li class="nav-item active">
                    <a class="nav-link" href="Incidencia.jsp">Incidencias <span class="sr-only">(current)</span></a>
                 </li>
                 <li class="nav-item">
                 <a class="nav-link" class="active" >Cambiar Contraseña</a>
                 </li>
                <li class="nav-item">
                    <a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
                 </li>
                </ul>
            </div>
            </nav>
        
        
        
        <div id="contenedor">
           
            <h2 id="h2">Cambiar Contraseña</h2>
            <br><br><hr>
            <form name="Cambiar" method="post" action="CambiarContrasena">
                <div id="cont_buscar">
                    <div id="no_co">
                        <label style="margin-left: 13%" for="input-number">Ingrese Nueva Contraseña: </label>
                        <input type="password" id="input-number" name="txtpass" 
                                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                                       title="Must contain at least one number and one uppercase and 
                                       lowercase letter, and at least 8 or more characters"
                                       Maxlength ="16" minlength="2"
                               value=""  placeholder="Esperando contraseña..." />
                        
                        <label style="margin-left: 5%" for="input-Vpassword">Verificar Nueva Contraseña: </label>
                        <input type="password" id="input-Vpassword" name="txtVpass" 
                               pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                                       title="Must contain at least one number and one uppercase and 
                                       lowercase letter, and at least 8 or more characters"
                                       Maxlength ="16" minlength="2"
                               value=""  placeholder="Esperando contraseña..." />
                        <input type="hidden" value=<%= request.getSession().getAttribute("usuario")%> name="SesionActiva" id="SesionActiva"/>
                    </div>

                </div>

                <div id="data">

                </div> 


                <div style="margin-left: 40%; margin-top: 7%; margin-right: 40%" id="botsubmit">
                    <input class="btn btn-primary btn-block" type="submit" id="button-submit-cambiar" value="Cambiar Contraseña " name="btnPass"  />

                </div>
            </form>
                    <div id="message">
                    <h3>Password must contain the following:</h3>
                    <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
                    <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
                    <p id="number" class="invalid">A <b>number</b></p>
                    <p id="length" class="invalid">Minimum <b>8 characters</b></p>
                    </div>
        </div>
                    <script>
var myInput = document.getElementById("input-number");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
    document.getElementById("message").style.display = "block";
};

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
    document.getElementById("message").style.display = "none";
};

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
};
</script>
    </body>
</html>
