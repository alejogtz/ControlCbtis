var sad = document.getElementById("registrar-asistencia");
sad.addEventListener("submit", function () {
    console.log("Submit.....");
    var xhr = new XMLHttpRequest();
    var nocontrol = document.getElementById("input-nocontrol").value;
    var params = "nocontrol=" + nocontrol;
    xhr.open('POST', 'ServletPortero', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.onload = function () {
        console.log(this.responseText);
    };
    xhr.onerror = function () {
        console.log('Request Error...');
    };
    xhr.send(params);
});


var isValid = function (nocontrol) {
    if (typeof nocontrol === 'Number') {
        return true;
    } else {
        return false;
    }
};