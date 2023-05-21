package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;

import modelo.Login;
import modeloUserWeb.*;


public class DaoUserWeb {
	
private Connection con = null;
	
	public DaoUserWeb() throws SQLException {
		
		con = DBConexion.getConnection(0);
		//conectar base de datos Importante elegir el numero de las opciones
		//el 0 elegiremos la base de datos de useradmin 
		// se pueden ver en DBCOnexion
	}
	/**
	 * Método para crear un usuario en la base de datos
	 * @param a
	 * @throws SQLException
	 */
	public void insertarAdmin (AdminWeb a) throws SQLException {
	
	// Codigo para poder insertar un permiso
	//Antes de hacer un Insert tengo que conectarme
	
	//Paso 1 preparar la query - para insertar
	
	//PreparedStatement ps = con.prepareStatement("INSERT INTO acceso VALUES (ruta,usuario,tipopermiso)");
	PreparedStatement ps = con.prepareStatement("INSERT INTO user_web (nombreUsuario,passw) VALUES (?,?)");
	
	ps.setString(1, a.getNombreUsuario());
	ps.setString(2, a.getPassw());
	
	ps.executeUpdate();
	ps.close();
	
	}

	 public void insertarAdminCompleto (AdminWeb a) throws SQLException {
	
		// Codigo para poder insertar un permiso
		//Antes de hacer un Insert tengo que conectarme
		
		//Paso 1 preparar la query - para insertar
		
		//PreparedStatement ps = con.prepareStatement("INSERT INTO acceso VALUES (ruta,usuario,tipopermiso)");
		PreparedStatement ps = con.prepareStatement("INSERT INTO Usuario (nameUsuario,contra, name, surname, correo, picture, idDepartament, idCompany) VALUES (?,?,?,?,?,?,?,?)");
		
		ps.setString(1, a.getNombreUsuario());
		ps.setString(2, a.getPassw());
		ps.setString(3, a.getNombre());
		ps.setString(4, a.getApellidos());
		ps.setString(5, a.getEmail());
		ps.setString(6, a.getFoto());
		ps.setString(7, a.getDepartamento());
		ps.setString(8, a.getEmpresa());
		
		
		
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
	
	
	
	public ArrayList<ConsultorWeb> obtener() throws SQLException{
		
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM user_web");
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<ConsultorWeb> result = null;
		
		while (rs.next()) {
			
			if (result == null) {
				result = new ArrayList<>();
				
			}
			
			result.add(new ConsultorWeb(  rs.getString("nombreUsuario"),rs.getString("passw"))  );
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
