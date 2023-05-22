/*

$(document).ready(function() {
    $('#getUsersButton').click(function() {
        $.ajax({
            url: 'http://localhost:8080/DaedalusManager/ConsultarUserWeb',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                console.log(data);
                var $resultado = $('#userList');
                $resultado.empty(); 

                // Añade la fila de encabezado a la tabla
                $resultado.append('<tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Nombre de Usuario</th><th>Contraseña</th><th>Correo</th><th>Foto</th><th>Admin</th><th>Empresa</th><th>Departamento</th></tr>');

                // recorre cada usuario en el JSON y añade una fila a la tabla para cada uno
                $.each(data, function(index, usuario) {
                    $resultado.append(
                        '<tr>' + 
                        '<td>' + usuario.campos.IdUsuario + '</td>' +
                        '<td>' + usuario.campos.name + '</td>' +
                        '<td>' + usuario.campos.surname + '</td>' +
                        '<td>' + usuario.campos.nameUsuario + '</td>' +
                        '<td>' + usuario.campos.contra + '</td>' +
                        '<td>' + usuario.campos.correo + '</td>' +
                        '<td>' + usuario.campos.picture + '</td>' +
                        '<td>' + usuario.campos.admin + '</td>' +
                        '<td>' + usuario.campos.nameCompany + '</td>' +
                        '<td>' + usuario.campos.nameDepartament + '</td>' +
                        '</tr>');
                });
            },
            error: function() {
                alert('Error obteniendo usuarios');
            }
        });
    });
});
*/
/*
$(document).ready(function() {
    $('#getUsersButton').click(function() {
        $.ajax({
            url: 'http://localhost:8080/DaedalusManager/ConsultarUserWeb',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                console.log(data);
                var $resultado = $('#userList');
                $resultado.empty();

                // Añade la fila de encabezado a la tabla
                $resultado.append('<tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Nombre de Usuario</th><th>Correo</th><th>Admin</th><th>Empresa</th><th>Departamento</th></tr>');

                // Recorre cada usuario en el JSON y añade una fila a la tabla para cada uno
                $.each(data, function(index, usuario) {
                    $resultado.append(
                        '<tr>' + 
                        '<td>' + usuario.campos.IdUsuario + '</td>' +
                        '<td>' + usuario.campos.name + '</td>' +
                        '<td>' + usuario.campos.surname + '</td>' +
                        '<td>' + usuario.campos.nameUsuario + '</td>' +
                        '<td>' + usuario.campos.correo + '</td>' +
                        '<td>' + usuario.campos.admin + '</td>' +
                        '<td>' + usuario.campos.nameCompany + '</td>' +
                        '<td>' + usuario.campos.nameDepartament + '</td>' +
                        '</tr>');
                });
            },
            error: function() {
                alert('Error obteniendo usuarios');
            }
        });
    });
});
*/

$(document).ready(function() {
    $('#getUsersButton').click(function() {
        $.ajax({
            url: 'http://localhost:8080/DaedalusManager/ConsultarUserWeb',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                console.log(data);
                var $resultado = $('#userList');
                $resultado.empty();

                // Añade la tabla al div
                $resultado.append('<table></table>');
                var $tabla = $('#userList table');

                // Añade la fila de encabezado a la tabla
                $tabla.append('<tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Nombre de Usuario</th><th>Correo</th><th>Admin</th><th>Empresa</th><th>Departamento</th></tr>');

                // Recorre cada usuario en el JSON y añade una fila a la tabla para cada uno
                $.each(data, function(index, usuario) {
                    $tabla.append(
                        '<tr>' + 
                        '<td>' + usuario.campos.IdUsuario + '</td>' +
                        '<td>' + usuario.campos.name + '</td>' +
                        '<td>' + usuario.campos.surname + '</td>' +
                        '<td>' + usuario.campos.nameUsuario + '</td>' +
                        '<td>' + usuario.campos.correo + '</td>' +
                        '<td>' + usuario.campos.admin + '</td>' +
                        '<td>' + usuario.campos.nameCompany + '</td>' +
                        '<td>' + usuario.campos.nameDepartament + '</td>' +
                        '</tr>');
                });
            },
            error: function() {
                alert('Error obteniendo usuarios');
            }
        });
    });
});

