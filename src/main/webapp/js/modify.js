
$(document).ready(function(){

    // Llamada AJAX que llena el select
    $.ajax({
        url: 'ModificarUserWeb',
        type: 'get',
        dataType: 'json',
        success: function(response){
            var select = $('#select-user-modify');
            $.each(response, function(i, user){
                var opt = $('<option>');
                opt.val(user.campos.nameUsuario);
                opt.text(user.campos.nameUsuario);
                select.append(opt);
            });
            console.log(response);
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.log(textStatus, errorThrown);
        }
    });

    // Cuando se selecciona un usuario, actualiza el valor del input
   $('#select-user-modify').change(function() {
    var selectedUser = $(this).val();
    $('#input-selected-user').val(selectedUser);
    console.log($('#input-selected-user').val()); // Debería mostrar el valor seleccionado en la consola del navegador
});


    // Llamada AJAX para enviar el formulario
    $('#formularioUsuario2').submit(function(event){
        event.preventDefault(); // Evita la recarga de la página
        var url = $(this).attr('action'); // Obtiene la URL del formulario

        // Obtiene los datos del formulario
        var formData = $(this).serialize();

        // Envía los datos mediante AJAX
        $.post(url, formData, function(response){
            // Aquí puedes manejar la respuesta del servidor
            console.log(response);
        });
    });
});

