$(document).ready(function() {
    // Obtén los usuarios cuando se carga la página
    $.ajax({
        url: 'http://localhost:8080/DaedalusManager/ConsultarUserWeb',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            console.log(data);
            var $select = $('#select-user-modify');
            // Limpiar cualquier opción existente
            $select.empty();
            // Agrega una opción predeterminada
            $select.append('<option selected>Elegir Usuario</option>');
            // Recorre cada usuario en el JSON y añade una opción al select para cada uno
            $.each(data, function(index, usuario) {
                $select.append('<option value="' + usuario.campos.IdUsuario + '">' + usuario.campos.nameUsuario + '</option>');
            });
        },
        error: function() {
            alert('Error obteniendo usuarios');
        }
    });

    // Tu código de click en botón aquí...
});
