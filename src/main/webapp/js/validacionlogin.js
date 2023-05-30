// Codigo JavaScript para validar entrada del formulario
//
function validateForm() {
    //Captura de usuario y contraseña
    var usuario = document.forms["userForm"]["nombreUsuario"].value;
    var passw = document.forms["userForm"]["passw"].value;

    //verificamos que usuario solo contenga alfabeticos y menor de 10 caracteres
    var userRegex = /^[a-zA-Z]{1,10}$/; 
    //Verificacion  Obligacion minima de 1 Mayuscula , 1 num, 1 caracter especial
    var passRegex = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    if (!userRegex.test(usuario)) {
        alert("El nombre de usuario solo puede contener caracteres alfabéticos y tener hasta 10 caracteres");
        return false;
    }

    if (!passRegex.test(passw)) {
        alert("La contraseña debe contener al menos una mayúscula, un número y un carácter especial");
        return false;
    }

    return true;
}

