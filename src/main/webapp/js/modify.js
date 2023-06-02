
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
