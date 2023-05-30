package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;

import modelo.Login;
import modeloUserWeb.*;
import modeloListador.*;



public class DaoUserWeb {
	
private Connection con = null;
	
	public DaoUserWeb() throws SQLException {
		
		con = DBConexion.getConnection(0);
		//conectar base de datos Importante elegir el numero de las opciones
		//el 0 elegiremos la base de datos de useradmin 
		// se pueden ver en DBCOnexion
	}
	/**
	 * Método para realizar búsquedas utilizando formularios como filtro
	 * si hay algun campo o varios rellenado buscará coincidencias
	 * @param b
	 * @throws SQLException
	 */
	
	
	public ArrayList<ListadorUserWebMapper> buscarPorFiltro (BuscadorUserWeb b) throws SQLException{
		
		//comienzo con la creacion de una consulta básica, si no se ha eligido ningun campo devolverá una consulta completa
		StringBuilder sql = new StringBuilder("SELECT * FROM Usuario WHERE 1=1");
		int index =1;
		
		//si tiene el campo de nombre relleno lo añadirá a la consulta
		if (b.getNombre()!=null) {
			sql.append(" AND name LIKE ?" );
		}
		if (b.getApellidos()!=null){
			sql.append(" AND surname LIKE ?");
		}

		if (b.getNombreUsuario()!=null){
			sql.append(" AND username LIKE ?");
		}
		if (b.getDepartamento()!=null){
			sql.append(" AND idDepartament LIKE ?");
		}
		if (b.getempresa()!=null){
			sql.append(" AND idCompany LIKE ?");
		}



		
		System.out.println(sql.toString());
		
		//preparo la consulta y a continación le paso las querys que no son null
		
		PreparedStatement ps = con.prepareStatement (sql.toString());
		
		if (b.getNombre()!=null) {
			ps.setString(index++, b.getNombre());
		}
		if (b.getApellidos()!=null) {
			ps.setString(index++, b.getApellidos());
		}
		if (b.getNombreUsuario()!=null) {
			ps.setString(index++, b.getNombreUsuario());
		}
		if (b.getDepartamento()!=null) {
			ps.setInt(index++, b.getDepartamento());
		}
		if (b.getempresa()!=null) {
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
	        mapper.setCampo("idCompany", rs.getString("idCompany"));
	        mapper.setCampo("idDepartament", rs.getString("idDepartament"));
	        result.add(mapper);
	        
	        System.out.println(mapper.toString());
	    }

	    System.out.println(result.toString());
	    return result;
		
	}
	
	
	/**
	 * Método para crear un usuario en la base de datos
	 * @param a
	 * @throws SQLException
	 */

	 public void insertarAdminCompleto (AdminWeb a) throws SQLException {
	
		// Codigo para poder insertar un permiso
		//Antes de hacer un Insert tengo que conectarme
		
		//Paso 1 preparar la query - para insertar
		
		//PreparedStatement ps = con.prepareStatement("INSERT INTO acceso VALUES (ruta,usuario,tipopermiso)");
		//PreparedStatement ps = con.prepareStatement("INSERT INTO Usuario (nameUsuario,contra, name, surname, correo, picture, idDepartament, idCompany, admin) VALUES (?,?,?,?,?,?,?,?, ?)");
		 PreparedStatement ps = con.prepareStatement("INSERT INTO Usuario (name,surname, nameUsuario, contra, correo, picture, admin, idDepartament, idCompany) VALUES (?,?,?,?,?,?,?,?,?)");
		
		 
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
		 * Metodo para crear consultor Web
		 * @param c
		 * @throws SQLException
		 */
	
	public void insertarConsultor (ConsultorWeb c) throws SQLException {
		
		// Codigo para poder insertar un permiso
		//Antes de hacer un Insert tengo que conectarme
		
		//Paso 1 preparar la query - para insertar
		
		//PreparedStatement ps = con.prepareStatement("INSERT INTO acceso VALUES (ruta,usuario,tipopermiso)");
		PreparedStatement ps = con.prepareStatement("INSERT INTO web (nombreUsuario,passw) VALUES (?,?)");
		
		ps.setString(1, c.getNombreUsuario());
		ps.setString(2, c.getPassw());
		
		ps.executeUpdate();
		ps.close();
		
		}


		/**
		 * Metodo para cambiar contraseña
		 * @param a
		 * @throws SQLException
		 */
	public void cambioPass (AdminWeb a) throws SQLException {
	
	PreparedStatement ps = con.prepareStatement("ALTER TABLE useradmin (passw) VALUES (?)");
	ps.setString(0, a.getPassw());
	
	ps.executeUpdate();
	ps.close();		
	
	}
	
	
	public ArrayList<ListadorUserWebMapper> obtener() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("SELECT  Usuario.IdUsuario, Usuario.name, Usuario.surname,  Usuario.nameUsuario,  Usuario.contra,  Usuario.correo, Usuario.picture, Usuario.admin, Company.nameCompany, Departament.nameDepartament FROM  Usuario  LEFT JOIN  Company ON Usuario.idCompany = Company.idCompany  LEFT JOIN  Departament ON Usuario.idDepartament = Departament.idDepartament;");

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

	public String obtenerenJSON() throws SQLException {
	    Gson gsonFinal = new Gson();
	    String jsonFinal = gsonFinal.toJson(this.obtener());
	    System.out.println(jsonFinal);
	    
	    return jsonFinal;
	}
	
	public String obtenerenJSONFiltro(BuscadorUserWeb b) throws SQLException {
	    Gson gsonFinal = new Gson();
	    String jsonFinal = gsonFinal.toJson(this.buscarPorFiltro(b));
	    System.out.println(jsonFinal);
	    
	    return jsonFinal;
	}

	
	/*
	///AQUI APARECE EL LISTADO PARA DAEDALUS
	public ArrayList<ListaladorWebMapper> obtener() throws SQLException{
		
		
		//PreparedStatement ps = con.prepareStatement("SELECT  Usuario.IdUsuario, Usuario.name, Usuario.surname,  Usuario.nameUsuario,  Usuario.contra,  Usuario.correo, Usuario.picture, Usuario.admin, Company.nameCompany, Departament.nameDepartament FROM  Usuario  LEFT JOIN  Company ON Usuario.idCompany = Company.idCompany  LEFT JOIN  Departament ON Usuario.idDepartament = Departament.idDepartament;");
		//PreparedStatement ps = con.prepareStatement("SELECT  Usuario.IdUsuario, Usuario.name, Usuario.surname,  Usuario.nameUsuario,  Usuario.contra,  Usuario.correo, Usuario.picture, Usuario.admin, Company.nameCompany, Departament.nameDepartament FROM  Usuario  LEFT JOIN  Company ON Usuario.idCompany = Company.idCompany  LEFT JOIN  Departament ON Usuario.idDepartament = Departament.idDepartament");
		
		PreparedStatement ps = con.prepareStatement("SELECT name, surname FROM Usuario ");
		
		
		ResultSet rs = ps.executeQuery();
		
		//ArrayList<ConsultorWeb> result = null;
		ArrayList<ListaladorWebMapper> result = null;
		while (rs.next()) {
			
			if (result == null) {
				result = new ArrayList<>();
				
			}
			//result.add(new ListaladorWebMapper (rs.getString("name"), (rs.getString("surname"), (rs.getString("nameUsuario"), (rs.getString("contra"), (rs.getString("correo"), (rs.getString("picture"), (rs.getString("admin"), (rs.getString("nameCompany"),(rs.getString("nameDepartament"));
			//result.add(new ListaladorWebMapper (  rs.getString("name"), rs.getString("surname"), rs.getString("nameUsuario"), rs.getString("contra"), rs.getString("correo"), rs.getString("picture"), rs.getString("admin"), rs.getString("nameCompany"),rs.getString("nameDepartament")          ));
			
			result.add(new ListaladorWebMapper (  rs.getString("name"), rs.getString("surname")  ));
			
			
			//result.add(new ConsultorWeb(  rs.getString("nameUsuario"),rs.getString("contra"))  );
			System.out.println(result.toString());
			//public Login(String name, String contra, int id)
			
			
		}
		 
		System.out.println(result.toString());
		return result;
	}
	
	//Metodo que llama a otro metodo para solicitar informacion a la BBDD
	// y convertirlo en JSON
	// el otro metodo que lo complementa es obtener()
	
	public String obtenerenJSON() throws SQLException {
		
		String jsonFinal ="";
		
		Gson gsonFinal = new Gson();
		jsonFinal = gsonFinal.toJson(this.obtener());
		System.out.println(jsonFinal); 
		
		return jsonFinal;
	}
	
	----------------------- */
	
	
	// improvisación de filtro
	
	public ArrayList<Login> obtenerFiltro(String name) throws SQLException{
		//importante crear una variable q	ue le tendremos que pasar para identificar lo que queremos filtrar
		PreparedStatement ps = con.prepareStatement("SELECT * FROM useradmin WHERE name=?");
		ps.setString(1,name);
		//aqui realizamos el prepared statement para  mandarle la Query a la BBDD
		
		ArrayList<Login> result = null;
		return result;
	}

	//Ejemplobasico de listar
	public ArrayList<ConsultorWeb> listar() throws SQLException {
		
		ArrayList <ConsultorWeb> movidas = null;
		PreparedStatement ps = con.prepareStatement("SELECT * from user_admin");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			if (movidas==null) {
				
				movidas= new ArrayList<>();
			}
			movidas.add(new ConsultorWeb(rs.getString("nombreUsuario"), rs.getString("passw")    ));
		}
		
		
		
		
		return movidas;
	}


}
