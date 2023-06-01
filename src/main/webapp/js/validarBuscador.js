function validateForm() {

    //Evitar que la pagina se recargue
    event.preventDefault();

    // Captura de los valores de los campos del formulario
    var nombre = document.forms["userForm"]["nombre"].value;
    var apellido = document.forms["userForm"]["surname"].value;
    var usuario = document.forms["userForm"]["username"].value;
    var departamento = document.forms["userForm"]["departament"].value;
    var empresa = document.forms["userForm"]["company"].value;
    var administrador = document.forms["userForm"]["admin"].checked;

    // RegEx para validar el nombre, apellido y usuario
    var nombreRegex = /^[a-zA-Z]{1,25}$/;
    var apellidoRegex = /^[a-zA-Z]{1,45}$/;
    var usuarioRegex = /^[a-zA-Z]{1,10}$/;

    // RegEx para validar el departamento y la empresa
    var depEmpRegex = /^[1-4]$/;

    // Contador de errores
    var errores = 0;
    var mensaje = "";

    //comprobar que al menos un campo se haya rellenado 
    if (nombre === "" && apellido === "" && usuario === "" && departamento == "0" && empresa == "0" && !administrador) {
        errores++;
        mensaje += "Debe ingresar al menos un campo para realizar la búsqueda.\n";
    } else {

    // Validación de los campos
    if (!nombreRegex.test(nombre) && ( !(nombre === "") )) {
        errores++;
        mensaje += "El nombre solo puede contener caracteres alfabéticos y tener hasta 25 caracteres.\n";
        document.getElementById("nombreIcon").className = "fas fa-times-circle ";
    } else {
        document.getElementById("nombreIcon").className = "fas fa-check-circle";
    }

    if (!apellidoRegex.test(apellido) && ( !(apellido === "") )) {
        errores++;
        mensaje += "Los apellidos solo pueden contener caracteres alfabéticos y tener hasta 45 caracteres.\n";
        document.getElementById("apellidoIcon").className = "fas fa-times-circle ";
    } else {
        document.getElementById("apellidoIcon").className = "fas fa-check-circle";
    }

    if (!usuarioRegex.test(usuario) && ( !(usuario === "") ) ) {
        errores++;
        mensaje += "El nombre de usuario solo puede contener caracteres alfabéticos y tener hasta 10 caracteres.\n";
        document.getElementById("userIcon").className = "fas fa-times-circle ";
    } else {
        document.getElementById("userIcon").className = "fas fa-check-circle";
    }

    if (!depEmpRegex.test(departamento)) {
        errores++;
        mensaje += "El departamento seleccionado es inválido.\n";
    }

    if (!depEmpRegex.test(empresa)) {
        errores++;
        mensaje += "La empresa seleccionada es inválida.\n";
    }

    // Verificar que el administrador es un booleano
    if (typeof administrador !== "boolean") {
        errores++;
        mensaje += "El valor de administrador es inválido.\n";
    }
}

    if (errores > 0) {
        alert(mensaje);
        return false;
    }

    return true;
}
