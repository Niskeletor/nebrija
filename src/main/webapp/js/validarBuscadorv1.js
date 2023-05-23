
function validateForm() {
    // Captura de los valores de los campos del formulario
    var nombre = document.getElementById("validationDefault01").value;
    var apellido = document.getElementById("validationDefault02").value;
    var usuario = document.getElementById("validationDefaultUsername").value;
    var departamento = document.getElementById("validationDefault04").value;
    var empresa = document.getElementById("validationDefault05").value;
    var administrador = document.getElementById("flexSwitchCheckDefault2").checked;

    // RegEx para validar el nombre, apellido y usuario
    var nombreRegex = /^[a-zA-Z]{1,25}$/;
    var apellidoRegex = /^[a-zA-Z]{1,45}$/;
    var usuarioRegex = /^[a-zA-Z]{1,10}$/;

    // RegEx para validar el departamento y la empresa
    var depEmpRegex = /^[1-4]$/;

    // Validación de los campos
    if (!nombreRegex.test(nombre)) {
        alert("El nombre solo puede contener caracteres alfabéticos y tener hasta 25 caracteres");
        return false;
    }

    if (!apellidoRegex.test(apellido)) {
        alert("Los apellidos solo pueden contener caracteres alfabéticos y tener hasta 45 caracteres");
        return false;
    }

    if (!usuarioRegex.test(usuario)) {
        alert("El nombre de usuario solo puede contener caracteres alfabéticos y tener hasta 10 caracteres");
        return false;
    }

    if (!depEmpRegex.test(departamento)) {
        alert("El departamento seleccionado es inválido");
        return false;
    }

    if (!depEmpRegex.test(empresa)) {
        alert("La empresa seleccionada es inválida");
        return false;
    }

    // Verificar que el administrador es un booleano
    if (typeof administrador !== "boolean") {
        alert("El valor de administrador es inválido");
        return false;
    }

    return true;
}


