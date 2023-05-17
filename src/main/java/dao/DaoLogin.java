package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;


import modelo.Login;





public class DaoLogin {
	
	private Connection con = null;
	
	public DaoLogin() throws SQLException {
		
		con = DBConexion.getConnection(0);
		//conectar base de datos Importante elegir el numero de las opciones
		//el 0 elegiremos la base de datos de useradmin 
		// se pueden ver en DBCOnexion
	}
	/**
	 * 
	 * @param l con este parametro se podrá elegir la base datos a conectar
	 * @throws SQLException
	 */
	public void insertar (Login l) throws SQLException {
	
	// Codigo para poder insertar un permiso
	//Antes de hacer un Insert tengo que conectarme
	
	//Paso 1 preparar la query - para insertar
	
	//PreparedStatement ps = con.prepareStatement("INSERT INTO acceso VALUES (ruta,usuario,tipopermiso)");
	PreparedStatement ps = con.prepareStatement("INSERT INTO useradmin (name,contra) VALUES (?,?)");
	
	ps.setString(1, l.getName());
	ps.setString(2, l.getContra());
	
	ps.executeUpdate();
	ps.close();
	
	}

	public void modificar (Login l) throws SQLException {
	
	PreparedStatement ps = con.prepareStatement("ALTER TABLE useradmin (contra) VALUES (?)");
	ps.setString(0, l.getContra());
	
	ps.executeUpdate();
	ps.close();		
	
	}
	
	public void eliminar (Login l) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("ALTER TABLE useradmin (name) VALUES (?)");
		ps.setString(0, l.getName());
		ps.close();
		
	}
	
	public void listar (Login l) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("SELECT name FROM useradmin ");
		ps.setString(0,l.getName());
		ps.close();
		
	}
	
	public ArrayList<Login> obtener() throws SQLException{
		
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM useradmin");
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Login> result = null;
		
		while (rs.next()) {
			
			if (result == null) {
				result = new ArrayList<>();
				
			}
			
			result.add(new Login(  rs.getString("name"),rs.getString("contra"),rs.getInt("iduseradmin"))  );
			//public Login(String name, String contra, int id)
			
			
		}
		
		return result;
	}
	
	//Metodo que llama a otro metodo para solicitar informacion a la BBDD
	// y convertirlo en JSON
	// el otro metodo que lo complementa es obtener()
	
	public String obtenerenJSON() throws SQLException {
		
		String jsonFinal ="";
		
		Gson gsonFinal = new Gson();
		jsonFinal = gsonFinal.toJson(this.obtener());
		
		
		return jsonFinal;
	}
	
	
	// improvisación de filtro
	
	public ArrayList<Login> obtenerFiltro(String name) throws SQLException{
		//importante crear una variable q	ue le tendremos que pasar para identificar lo que queremos filtrar
		PreparedStatement ps = con.prepareStatement("SELECT * FROM useradmin WHERE name=?");
		ps.setString(1,name);
		//aqui realizamos el prepared statement para  mandarle la Query a la BBDD
		
		ArrayList<Login> result = null;
		return result;
	}


}