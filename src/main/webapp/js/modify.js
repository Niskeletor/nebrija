
/*
$(document).ready(function(){
    $.get('ModificarUserWeb', function(response){
        var select = $('#select-user-modify');
        $.each(response, function(i, user){
            var opt = $('<option>');
            opt.val(user.id);
            opt.text(user.nombreUsuario);
            select.append(opt);
        });
    });
});
*/

/* control de errores */
/*
$(document).ready(function(){
    $.ajax({
        url: 'ModificarUserWeb',
        type: 'get',
        dataType: 'json',
        success: function(response){
            var select = $('#select-user-modify');
            $.each(response, function(i, user){
                var opt = $('<option>');
                opt.val(user.id);
                opt.text(user.nameUsuario);
                select.append(opt);
            });
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.log(textStatus, errorThrown);
        }
    });
});
*/
/*
$(document).ready(function(){
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
});

$('#formularioUsuario2').on('submit', function(e) {
    e.preventDefault();  // Prevenir que la pagina se recargue
    var selectUserModify = $('#select-user-modify').val();  // Cargar usuario seleccionado
    var formData = $(this).serialize();  // Recopilas datos del segundo formulario


    formData += '&select-user-modify=' + encodeURIComponent(selectUserModify);

    // Enviar a traves de Ajax
    $.ajax({
        url: $(this).attr('http://localhost:8080/DaedalusManager/SvModificarUserWebApply'),  // Url
        type: 'POST',  // The HTTP method to use
        data: formData,  // The data to send
        success: function(response) {
            // Mostrar mensaje exito
            console.log(response);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });
});

*/

/*

$(document).ready(function(){
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
});

$('#formularioUsuario2').on('submit', function(e) {
    e.preventDefault();  
    var selectUserModify = $('#select-user-modify').val();  

    var formData = $(this).serialize() + '&select-user-modify=' + encodeURIComponent(selectUserModify);

    $.ajax({
        url: $(this).attr('action'),  
        type: 'POST',  
        data: formData,  
        success: function(response) {
            console.log(response);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });
});


*/

/*

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
  });
    // Llamada AJAX para enviar el formulario

$(document).ready(function(){
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

    $('#formularioUsuario-select').submit(function(event){
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


*/

/*

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

    // Llamada AJAX para enviar el formulario
    $('#formularioUsuario2').submit(function(event){
        event.preventDefault(); // Evita la recarga de la página
        var url = $(this).attr('action'); // Obtiene la URL del formulario

        // Obtiene los datos del primer formulario
        var formData1 = $('#formularioUsuario-select').serialize();
        // Obtiene los datos del segundo formulario
        var formData2 = $(this).serialize();

        // Combina los datos de ambos formularios
        var formData = formData1 + '&' + formData2;

        // Envía los datos mediante AJAX
        $.post(url, formData, function(response){
            // Aquí puedes manejar la respuesta del servidor
            console.log(response);
        });
    });
});
*/

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

