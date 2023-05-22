  /* $(document).ready(function() {
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
                      //$resultado.append('<li>' + usuario.nombreUsuario + ': ' + usuario.passw + '</li>');
                      $resultado.append('<li>' + usuario.nameUsuario + ': ' + usuario.nameCompany + ', ' + usuario.nameDepartament + '</li>');
                  });
              },
              error: function() {
                  alert('Error obteniendo usuarios');
              }
          });
      });
  });
*/


//ver 2
/*
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
                        'ID: ' + usuario.IdUsuario + ', ' +
                        'Nombre: ' + usuario.name + ', ' +
                        'Apellidos: ' + usuario.surname + ', ' +
                        'Nombre de Usuario: ' + usuario.nameUsuario + ', ' +
                        'Contraseña: ' + usuario.contra + ', ' +
                        'Correo: ' + usuario.correo + ', ' +
                        'Foto: ' + usuario.picture + ', ' +
                        'Admin: ' + usuario.admin + ', ' +
                        'Empresa: ' + usuario.nameCompany + ', ' +
                        'Departamento: ' + usuario.nameDepartament + 
                        '</li>');
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
            url: 'http://localhost:8080/DaedalusManager/ConsultarUserWeb', // actualiza esto con la ruta a tu servlet
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                console.log(data);
                var $resultado = $('#userList');
                $resultado.empty(); // limpia el div

                // recorre cada usuario en el JSON y añade un elemento de lista para cada uno
                $.each(data, function(index, usuario) {
                    var id = usuario.campos && usuario.campos.IdUsuario ? usuario.campos.IdUsuario : "N/A";
                    var name = usuario.campos && usuario.campos.name ? usuario.campos.name : "N/A";
                    var surname = usuario.campos && usuario.campos.surname ? usuario.campos.surname : "N/A";
                    // Añade las comprobaciones restantes para los demás campos aquí...

                    $resultado.append(
                        '<li>' + 
                        'ID: ' + id + ', ' +
                        'Nombre: ' + name + ', ' +
                        'Apellidos: ' + surname +
                        // Añade los campos restantes aquí...
                        '</li>');
                });
            },
            error: function() {
                alert('Error obteniendo usuarios');
            }
        });
    });
});

*/

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