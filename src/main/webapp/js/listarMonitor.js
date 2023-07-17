

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
                        '<td class="notas" data-toggle="modal">' + monitor.notas + '</td>' +
                        '<td class="estado" data-toggle="modal">' + monitor.estado + '</td>' +
                        '<td>' + monitor.nombreEmpresa + '</td>' +
                        '<td>' + monitor.usuario + '</td>' +
                        '<td>' + monitor.identificador + '</td>' +
                        '</tr>');
                        console.log(monitor.usuario);

                    });
                            // Datos con exito procesos
                        $('.notas, .estado').on('click', function() {
                            $('#modalContent').text($(this).text());
                            $('#myModal').modal('show');
                            //Datos con exito procesos
                });
                                
            },
            error: function() {
                alert('Error obteniendo monitores');
            }
        });
    });
});
