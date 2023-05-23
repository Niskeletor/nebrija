function validateForm() {
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

    // Validación de los campos
    if (!nombreRegex.test(nombre)) {
        errores++;
        mensaje += "El nombre solo puede contener caracteres alfabéticos y tener hasta 25 caracteres.\n";
    }

    if (!apellidoRegex.test(apellido)) {
        errores++;
        mensaje += "Los apellidos solo pueden contener caracteres alfabéticos y tener hasta 45 caracteres.\n";
    }

    if (!usuarioRegex.test(usuario)) {
        errores++;
        mensaje += "El nombre de usuario solo puede contener caracteres alfabéticos y tener hasta 10 caracteres.\n";
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

    if (errores > 0) {
        alert(mensaje);
        return false;
    }

    return true;
}
