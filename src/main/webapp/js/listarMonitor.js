
/*
//PARA HACER UN LISTADO COMPLETO
$(document).ready(function() {
    $('#getUsersButton').click(function() {
        $.ajax({
            url: 'http://localhost:8080/DaedalusManager/ConsultarUserWeb',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                // Tu código existente para listar todos los usuarios

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
//PARA HACER LISTADO CON FILTRO
    $('#userForm').on('submit', function(event) {
        event.preventDefault(); // para evitar que el formulario se envíe de la manera tradicional
        var form_data = $(this).serialize(); // recopila la información del formulario
        $.ajax({
            url: 'http://localhost:8080/DaedalusManager/ConsultaUserWebFiltro',
            type: 'POST',  // cambiamos el método a POST
            data: form_data, // envía los datos del formulario al servidor
            dataType: 'json',
            success: function(data) {
                // Tu código para mostrar los resultados filtrados

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
*/

$(document).ready(function() {
    $('#formQueryMonitor').on('submit', function(event) {
        event.preventDefault(); // para evitar que el formulario se envíe de la manera tradicional
        var form_data = $(this).serialize(); // recopila la información del formulario
        $.ajax({
            url: 'http://localhost:8080/DaedalusManager/SvConsultaMonitorFiltro',
            type: 'POST',  // cambiamos el método a POST
            data: form_data, // envía los datos del formulario al servidor
            dataType: 'json',
            success: function(data) {
                // Tu código para mostrar los resultados filtrados

                console.log(data);
                var $resultado = $('#monitorList');
                $resultado.empty();

                // Añade la tabla al div
                $resultado.append('<table></table>');
                var $tabla = $('#monitorList table');

                // Añade la fila de encabezado a la tabla
                $tabla.append('<tr><th>ID</th><th>Marca</th><th>Modelo</th><th>Número de Serie</th><th>Notas</th><th>Estado</th><th>Empresa</th><th>Usuario</th><th>Identificador</th></tr>');

                // Recorre cada monitor en el JSON y añade una fila a la tabla para cada uno
                $.each(data, function(index, monitor) {
                    $tabla.append(
                        '<tr>' + 
                        '<td>' + monitor.id + '</td>' +
                        '<td>' + monitor.marca + '</td>' +
                        '<td>' + monitor.modelo + '</td>' +
                        '<td>' + monitor.numSerie + '</td>' +
                        '<td>' + monitor.notas + '</td>' +
                        '<td>' + monitor.estado + '</td>' +
                        '<td>' + monitor.empresa + '</td>' +
                        '<td>' + monitor.usuario + '</td>' +
                        '<td>' + monitor.identificador + '</td>' +
                        '</tr>');
                });
            },
            error: function() {
                alert('Error obteniendo monitores');
            }
        });
    });
});
