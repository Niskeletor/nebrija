
//ver final

$(document).ready(function() {
    $('#getUsersButton').click(function() {
        $.ajax({
            url: 'http://localhost:8080/DaedalusManager/ConsultarUserWeb', // actualiza esto con la ruta a tu servlet
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                console.log(data);
                var $resultado = $('#userList');
                $resultado.empty(); // limpia el div

                // recorre cada usuario en el JSON y añade un elemento de lista para cada uno
                $.each(data, function(index, usuario) {
                    $resultado.append(
                        '<li>' + 
                        'ID: ' + usuario.campos.IdUsuario + ', ' +
                        'Nombre: ' + usuario.campos.name + ', ' +
                        'Apellidos: ' + usuario.campos.surname + ', ' +
                        'Nombre de Usuario: ' + usuario.campos.nameUsuario + ', ' +
                        'Contraseña: ' + usuario.campos.contra + ', ' +
                        'Correo: ' + usuario.campos.correo + ', ' +
                        'Foto: ' + usuario.campos.picture + ', ' +
                        'Admin: ' + usuario.campos.admin + ', ' +
                        'Empresa: ' + usuario.campos.nameCompany + ', ' +
                        'Departamento: ' + usuario.campos.nameDepartament + 
                        '</li>');
                });
            },
            error: function() {
                alert('Error obteniendo usuarios');
            }
        });
    });
});