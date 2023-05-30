/*
$(document).ready(function() {
            $("#formularioUsuario").on('submit', function(e) {
                e.preventDefault(); // Evitar que el formulario se envíe de la forma predeterminada
                $.ajax({
                    url: 'http://localhost:8080/DaedalusManager/AltaUserWeb', // La URL del servlet
                    type: 'post', // El método de envío
                    data: $('#formularioUsuario').serialize(), // Los datos del formulario
                    success: function(response) {
                        // Limpiar los campos del formulario
                        $('#formularioUsuario')[0].reset();
                        // Mostrar la alerta de éxito
                        Swal.fire({
                            title: '¡Éxito!',
                            text: 'Datos insertados correctamente',
                            icon: 'success',
                            confirmButtonText: 'Ok'
                        });
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        var message;
                        switch (jqXHR.status) {
                            case 409: message = 'Datos ya existen'; break;
                            case 500: message = 'Error de Servidor'; break;
                            default: message = 'Error desconocido'; break;
                        }
                        Swal.fire({
                            title: '¡Error!',
                            text: message,
                            icon: 'error',
                            confirmButtonText: 'Ok'
                        });
                    }
                });
            });
        });
        */
	   /*
	   $(document).ready(function() {
            $("#formularioUsuario").on('submit', function(e) {
                e.preventDefault(); // Evitar que el formulario se envíe de la forma predeterminada
                $.ajax({
                    url: 'http://localhost:8080/DaedalusManager/AltaUserWeb', // La URL del servlet
                    type: 'post', // El método de envío
                    data: $('#formularioUsuario').serialize(), // Los datos del formulario
                    success: function(response) {
                        // Limpiar los campos del formulario
                        $('#formularioUsuario')[0].reset();
                        // Mostrar la alerta de éxito
                        Swal.fire({
                            title: '¡Éxito!',
                            text: 'Datos insertados correctamente',
                            icon: 'success',
                            confirmButtonText: 'Ok'
                        });
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        var message;
                        switch (jqXHR.status) {
                            case 409: message = 'Datos ya existen'; break;
                            case 500: message = 'Error de Servidor'; break;
                            default: message = 'Error desconocido'; break;
                        }
                        Swal.fire({
                            title: '¡Error!',
                            text: message,
                            icon: 'error',
                            confirmButtonText: 'Ok'
                        });
                    }
                });
            });
        });
        */
/*	   
	   $(document).ready(function() {
    $("#formularioUsuario").on('submit', function(e) {
        e.preventDefault();
        
        var formData = new FormData(this);  // Crea un nuevo objeto FormData

        $.ajax({
            url: 'http://localhost:8080/DaedalusManager/AltaUserWeb',
            type: 'post',
            data: formData,  // Envía el objeto FormData
            contentType: false,  // Importante para que jQuery no modifique el contentType
            processData: false,  // Impide que jQuery transforme los datos en una cadena de consulta
            success: function(response) {
                $('#formularioUsuario')[0].reset();
                Swal.fire({
                    title: '¡Éxito!',
                    text: 'Datos insertados correctamente',
                    icon: 'success',
                    confirmButtonText: 'Ok'
                });
            },
            error: function(jqXHR, textStatus, errorThrown) {
        	var message;
       		switch (jqXHR.status) {
            case 409: 
                message = 'Datos ya existen'; 
                break;
            case 500: 
                message = jqXHR.responseText ? jqXHR.responseText : 'Error de Servidor'; 
                break;
            default: 
                message = 'Error desconocido'; 
                break;
       			 }
                Swal.fire({
                    title: '¡Error!',
                    text: message,
                    icon: 'error',
                    confirmButtonText: 'Ok'
                });
            }
        });
    });
});
*/
// VALIDAR CAMPOS DE REGISTRO DE ALTA

$(document).ready(function() {
    $("#formularioUsuario").on('submit', function(e) {
        // Previene que se lance el formulario html de manera predeterminada
        e.preventDefault();

        // Aquí se realizan validaciones
        var name = $("#input-user-name").val();
        var surname = $("#input-user-surname").val();
        var username = $("#input-system-username").val();
        var email = $("#input-Email").val();
        var department = parseInt($("#select-departament").val());
		var company = parseInt($("#select-company").val());
		var password = $("#input-Password").val();
        var alphaRegex = /^[a-zA-Z\s]*$/; // Solo caracteres alfabéticos y espacios
        var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // Verifica si es un email válido
        var passRegex = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/; // Verificación de la contraseña

        if (!alphaRegex.test(name) || !alphaRegex.test(surname) || !alphaRegex.test(username)) {
            Swal.fire({
                title: '¡Error!',
                text: 'Solo se admiten caracteres alfabéticos para nombre, apellidos y usuario',
                icon: 'error',
                confirmButtonText: 'Ok'
            });
            return;
        }
        
        if (username == "") {
            Swal.fire({
                title: '¡Error!',
                text: 'Ei el usuario no puede estar vacío',
                icon: 'error',
                confirmButtonText: 'Ok'
            });
            return;
        }
        
        if (!emailRegex.test(email)) {
            Swal.fire({
                title: '¡Error!',
                text: 'Email no válido',
                icon: 'error',
                confirmButtonText: 'Ok'
            });
            return;
        }
        
         if (!passRegex.test(password)) {
            Swal.fire({
                title: '¡Error!',
                text: 'Solo se admiten contraseñas que contengan al menos 1 mayúscula, 1 número y un caracter especial',
                icon: 'error',
                confirmButtonText: 'Ok'
            });
            return;
        }
        
        if (department < 1 || department > 5) {
            Swal.fire({
                title: '¡Error!',
                text: 'No has elegido ningún departamento',
                icon: 'error',
                confirmButtonText: 'Ok'
            });
            return;
        }

        if (company < 1 || company > 3) {
            Swal.fire({
                title: '¡Error!',
                text: 'No has elegido ninguna empresa',
                icon: 'error',
                confirmButtonText: 'Ok'
            });
            return;
        }
        
        console.log("Department: " + department);
		console.log("Company: " + company);

        var formData = new FormData(this);

        $.ajax({
            url: 'http://localhost:8080/DaedalusManager/AltaUserWeb',
            type: 'post',
            data: formData,
            contentType: false,
            processData: false,
            success: function(response) {
                $('#formularioUsuario')[0].reset();
                Swal.fire({
                    title: '¡Éxito!',
                    text: 'Datos insertados correctamente',
                    icon: 'success',
                    confirmButtonText: 'Ok'
                });
            },
            error: function(jqXHR, textStatus, errorThrown) {
                var message;
                switch (jqXHR.status) {
                    case 409: 
                        message = 'Datos ya existen'; 
                        break;
                    case 500: 
                        message = jqXHR.responseText ? jqXHR.responseText : 'Error de Servidor'; 
                        break;
                    default: 
                        message = 'Error desconocido'; 
                        break;
                }
                Swal.fire({
                    title: '¡Error!',
                    text: message,
                    icon: 'error',
                    confirmButtonText: 'Ok'
                });
            }
        });
    });
});


