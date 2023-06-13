package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import modelo.Login;
import modeloUserWeb.*;
import modeloListador.*;

/**
 * Clase DaoUserWeb que interactúa con la base de datos para realizar
 * operaciones CRUD sobre los usuarios y administra las conexiones.
 * 
 * @author Pablo Alejandro Nistal del Rio
 */

public class DaoUserWeb {

	private Connection con = null;

	/**
	 * Constructor de la clase DaoUserWeb. Establece la conexión con la base de
	 * datos. Le pasamos el parámetro 0 para elegir la primera BBDD
	 * 
	 * @throws SQLException si ocurre un error al establecer la conexión con la base
	 *                      de datos.
	 */

	public DaoUserWeb() throws SQLException {

		con = DBConexion.getConnection(0);
		// conectar base de datos Importante elegir el numero de las opciones
		// el 0 elegiremos la base de datos de useradmin
		// se pueden ver en DBCOnexion
	}

	public List<BuscadorUserWeb> buscarParaSelect() throws SQLException {
		List<BuscadorUserWeb> usuarios = new ArrayList<>();

		String query = "SELECT * FROM Usuario"; // Consulta con SQL
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String nombre = rs.getString("name");
			String apellidos = rs.getString("surname");
			String nombreUsuario = rs.getString("nameUsuario");
			String passw = rs.getString("contra");
			String email = rs.getString("correo");
			String foto = rs.getString("picture");
			Boolean administrador = rs.getBoolean("admin");
			Integer departamento = rs.getInt("idDepartament");
			Integer empresa = rs.getInt("idCompany");
			int id = rs.getInt("id"); // Verificar el nombre de las columnas

			BuscadorUserWeb usuario = new BuscadorUserWeb(nombre, apellidos, nombreUsuario, passw, email, foto,
					administrador, departamento, empresa, id, null, null);
			usuarios.add(usuario);
		}

		rs.close();
		ps.close();

		return usuarios;
	}

	/**
	 * Método que busca usuarios según el filtro proporcionado. Devuelve un
	 * ArrayList de objetos ListadorUserWebMapper con la información de los usuarios
	 * encontrados.
	 * 
	 * @param b el objeto BuscadorUserWeb con los criterios de búsqueda.
	 * @return ArrayList de objetos ListadorUserWebMapper con la información de los
	 *         usuarios encontrados.
	 * @throws SQLException si ocurre un error al realizar la consulta en la base de
	 *                      datos.
	 */

	public ArrayList<ListadorUserWebMapper> buscarPorFiltro(BuscadorUserWeb b) throws SQLException {

		// comienzo con la creacion de una consulta básica, si no se ha eligido ningun
		// campo devolverá una consulta completa
		// StringBuilder sql = new StringBuilder("SELECT * FROM Usuario WHERE 1=1");
		StringBuilder sql = new StringBuilder("SELECT Usuario.*, Company.nameCompany, Departament.nameDepartament "
				+ "FROM Usuario " + "LEFT JOIN Company ON Usuario.idCompany = Company.idCompany "
				+ "LEFT JOIN Departament ON Usuario.idDepartament = Departament.idDepartament " + "WHERE 1=1");

		int index = 1;

		// si tiene el campo de nombre relleno lo añadirá a la consulta
		if (b.getNombre() != null) {
			sql.append(" AND Usuario.name LIKE ?");
		}
		if (b.getApellidos() != null) {
			sql.append(" AND Usuario.surname LIKE ?");
		}

		if (b.getNombreUsuario() != null) {
			sql.append(" AND Usuario.nameUsuario LIKE ?");
		}
		if (b.getDepartamento() != null) {
			sql.append(" AND Usuario.idDepartament =?");
		}
		if (b.getempresa() != null) {
			sql.append(" AND Usuario.idCompany =?");
		}

		System.out.println(b.getNombre().toString() + b.getApellidos().toString() + b.getNombreUsuario().toString());
		// + b.getempresa().toString() + b.getDepartamento()

		// compruebo por consola que se recojan los parametros
		System.out.println(sql.toString());

		// preparo la consulta y a continación le paso las querys que no son null

		PreparedStatement ps = con.prepareStatement(sql.toString());

		if (b.getNombre() != null) {
			ps.setString(index++, "%" + b.getNombre() + "%");
		}
		if (b.getApellidos() != null) {
			ps.setString(index++, "%" + b.getApellidos() + "%");
		}
		if (b.getNombreUsuario() != null) {
			ps.setString(index++, "%" + b.getNombreUsuario() + "%");
		}
		if (b.getDepartamento() != null) {
			ps.setInt(index++, b.getDepartamento());
		}
		if (b.getempresa() != null) {
			ps.setInt(index++, b.getempresa());
		}

		ResultSet rs = ps.executeQuery();

		ArrayList<ListadorUserWebMapper> result = new ArrayList<>();

		while (rs.next()) {
			ListadorUserWebMapper mapper = new ListadorUserWebMapper();
			mapper.setCampo("IdUsuario", rs.getString("IdUsuario"));
			mapper.setCampo("name", rs.getString("name"));
			mapper.setCampo("surname", rs.getString("surname"));
			mapper.setCampo("nameUsuario", rs.getString("nameUsuario"));
			mapper.setCampo("contra", rs.getString("contra"));
			mapper.setCampo("correo", rs.getString("correo"));
			mapper.setCampo("picture", rs.getString("picture"));
			mapper.setCampo("admin", rs.getString("admin"));
			mapper.setCampo("nameCompany", rs.getString("nameCompany"));
			mapper.setCampo("nameDepartament", rs.getString("nameDepartament"));
			result.add(mapper);

			System.out.println(mapper.toString());
		}

		System.out.println(result.toString());
		ps.close();
		return result;

	}

	public void ModificarUser(AdminWeb a) throws SQLException {

		String updateSql = "UPDATE Usuario SET";
		ArrayList<String> updateParts = new ArrayList<>();
		ArrayList<Object> parameters = new ArrayList<>();

		// compruebo que los campos que se reciben de modificar no esten vacios
		// si se ha rellenado info se tendra en cuenta para agregarlo a la sentencia de
		// la Query
		if (a.getNombre() != null) {
			updateParts.add(" name = ?");
			parameters.add(a.getNombre());
			System.out.println("he detectado nombre : " + a.getNombre().toString());

		}

		if (a.getPassw() != null) {
			updateParts.add(" contra = ?");
			parameters.add(a.getPassw());
			System.out.println("he detectado passwd : " + a.getEmail().toString());
		}
		System.out.println("he detectado nombre :");

		if (a.getEmail() != null) {
			updateParts.add(" correo = ?");
			parameters.add(a.getEmail());
			System.out.println("he detectado email : " + a.getEmail().toString());
		}

		updateSql += String.join(",", updateParts) + " WHERE nameUsuario = ?";
		parameters.add(a.getNombreUsuario());
		System.out.println("he detectado nombre : " + a.getNombreUsuario().toString());

		PreparedStatement ps = con.prepareStatement(updateSql);
		for (int i = 0; i < parameters.size(); i++) {
			ps.setObject(i + 1, parameters.get(i));
		}

		ps.executeUpdate();
		ps.close();

	}

	/**
	 * Método que inserta un nuevo administrador para el portal Web en la base de
	 * datos.
	 * 
	 * @param a el objeto AdminWeb con la información del administrador a insertar.
	 * @throws SQLException si ocurre un error al insertar la información en la base
	 *                      de datos.
	 */

	public void insertarAdminCompleto(AdminWeb a) throws SQLException {

		// Codigo para poder insertar un permiso
		// Antes de hacer un Insert tengo que conectarme

		// Paso 1 preparar la query - para insertar

		// PreparedStatement ps = con.prepareStatement("INSERT INTO acceso VALUES
		// (ruta,usuario,tipopermiso)");
		// PreparedStatement ps = con.prepareStatement("INSERT INTO Usuario
		// (nameUsuario,contra, name, surname, correo, picture, idDepartament,
		// idCompany, admin) VALUES (?,?,?,?,?,?,?,?, ?)");
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO Usuario (name,surname, nameUsuario, contra, correo, picture, admin, idDepartament, idCompany) VALUES (?,?,?,?,?,?,?,?,?)");

		ps.setString(1, a.getNombre());
		ps.setString(2, a.getApellidos());
		ps.setString(3, a.getNombreUsuario());
		ps.setString(4, a.getPassw());
		ps.setString(5, a.getEmail());
		ps.setString(6, a.getFoto());
		ps.setBoolean(7, a.getAdministrador());
		ps.setInt(8, a.getempresa());
		ps.setInt(9, a.getDepartamento());

		ps.executeUpdate();
		ps.close();

	}

	/**
	 * Método que inserta un nuevo consultor, el objetio sería un Trabajador o
	 * responsable de algún departamento en la base de datos.
	 * 
	 * @param c el objeto ConsultorWeb con la información del consultor a insertar.
	 * @throws SQLException si ocurre un error al insertar la información en la base
	 *                      de datos.
	 */

	public void insertarConsultor(ConsultorWeb c) throws SQLException {

		// Codigo para poder insertar un permiso
		// Antes de hacer un Insert tengo que conectarme

		// Paso 1 preparar la query - para insertar

		// PreparedStatement ps = con.prepareStatement("INSERT INTO acceso VALUES
		// (ruta,usuario,tipopermiso)");
		PreparedStatement ps = con.prepareStatement("INSERT INTO web (nombreUsuario,passw) VALUES (?,?)");

		ps.setString(1, c.getNombreUsuario());
		ps.setString(2, c.getPassw());

		ps.executeUpdate();
		ps.close();

	}

	/**
	 * Método que cambia la contraseña de un administrador Web.
	 * 
	 * @param a el objeto AdminWeb con la información del administrador.
	 * @throws SQLException si ocurre un error al actualizar la información en la
	 *                      base de datos.
	 */
	public void cambioPass(AdminWeb a) throws SQLException {

		PreparedStatement ps = con.prepareStatement("ALTER TABLE useradmin (passw) VALUES (?)");
		ps.setString(0, a.getPassw());

		ps.executeUpdate();
		ps.close();

	}

	public ArrayList<ListadorUserWebMapper> obtener() throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"SELECT  Usuario.IdUsuario, Usuario.name, Usuario.surname,  Usuario.nameUsuario,  Usuario.contra,  Usuario.correo, Usuario.picture, Usuario.admin, Company.nameCompany, Departament.nameDepartament FROM  Usuario  LEFT JOIN  Company ON Usuario.idCompany = Company.idCompany  LEFT JOIN  Departament ON Usuario.idDepartament = Departament.idDepartament;");

		ResultSet rs = ps.executeQuery();

		ArrayList<ListadorUserWebMapper> result = new ArrayList<>();

		while (rs.next()) {
			ListadorUserWebMapper mapper = new ListadorUserWebMapper();
			mapper.setCampo("IdUsuario", rs.getString("IdUsuario"));
			mapper.setCampo("name", rs.getString("name"));
			mapper.setCampo("surname", rs.getString("surname"));
			mapper.setCampo("nameUsuario", rs.getString("nameUsuario"));
			mapper.setCampo("contra", rs.getString("contra"));
			mapper.setCampo("correo", rs.getString("correo"));
			mapper.setCampo("picture", rs.getString("picture"));
			mapper.setCampo("admin", rs.getString("admin"));
			mapper.setCampo("nameCompany", rs.getString("nameCompany"));
			mapper.setCampo("nameDepartament", rs.getString("nameDepartament"));
			result.add(mapper);

			System.out.println(mapper.toString());
		}

		System.out.println(result.toString());
		return result;
	}

	/**
	 * Obtiene una lista de todos los usuarios y la retorna en formato JSON.
	 * 
	 * @return String en formato JSON que representa a todos los usuarios
	 * @throws SQLException si ocurre un error al obtener la lista de usuarios
	 */

	public String obtenerenJSON() throws SQLException {
		Gson gsonFinal = new Gson();
		String jsonFinal = gsonFinal.toJson(this.obtener());
		System.out.println(jsonFinal);

		return jsonFinal;
	}

	/**
	 * Obtiene una lista filtrada de usuarios y la retorna en formato JSON.
	 * 
	 * @param b objeto BuscadorUserWeb que contiene los filtros de búsqueda
	 * @return String en formato JSON que representa a los usuarios filtrados
	 * @throws SQLException si ocurre un error al obtener la lista filtrada de
	 *                      usuarios
	 */

	public String obtenerenJSONFiltro(BuscadorUserWeb b) throws SQLException {
		Gson gsonFinal = new Gson();
		String jsonFinal = gsonFinal.toJson(this.buscarPorFiltro(b));
		System.out.println(jsonFinal);

		return jsonFinal;
	}

	// improvisación de filtro

	public ArrayList<Login> obtenerFiltro(String name) throws SQLException {
		// importante crear una variable q ue le tendremos que pasar para identificar lo
		// que queremos filtrar
		PreparedStatement ps = con.prepareStatement("SELECT * FROM useradmin WHERE name=?");
		ps.setString(1, name);
		// aqui realizamos el prepared statement para mandarle la Query a la BBDD

		ArrayList<Login> result = null;
		return result;
	}

	// Ejemplobasico de listar
	public ArrayList<ConsultorWeb> listar() throws SQLException {

		ArrayList<ConsultorWeb> movidas = null;
		PreparedStatement ps = con.prepareStatement("SELECT * from user_admin");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			if (movidas == null) {

				movidas = new ArrayList<>();
			}
			movidas.add(new ConsultorWeb(rs.getString("nombreUsuario"), rs.getString("passw")));
		}

		return movidas;
	}

}
