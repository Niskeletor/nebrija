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
