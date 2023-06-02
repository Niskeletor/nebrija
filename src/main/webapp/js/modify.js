
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
