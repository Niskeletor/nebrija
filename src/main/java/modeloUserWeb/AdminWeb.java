package modeloUserWeb;

import java.sql.SQLException;

import dao.DaoUserWeb;

public class AdminWeb extends UserWeb{
	
	private String filename;

	
	//constructor vacio
	public AdminWeb() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	public AdminWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto,
			String departamento,Boolean administrador, String empresa, int id, String filename) {
		super(nombre, apellidos, nombreUsuario, passw, email, foto, administrador, departamento, empresa, id);		
		// TODO Auto-generated constructor stub
		this.setFilename(filename);
	}


	public AdminWeb(String filename) {
		
		this.setFilename(filename);
	}

	
	//Constructor completo sin id
	
	public AdminWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto,
			Boolean administrador, String departamento, String empresa) {
		super(nombre, apellidos, nombreUsuario, passw, email, foto, administrador, departamento, empresa);
		// TODO Auto-generated constructor stub
	}



	//Constructor completo
	
	
	public AdminWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto,
			Boolean administrador, String departamento, String empresa, int id) {
		super(nombre, apellidos, nombreUsuario, passw, email, foto, administrador, departamento, empresa, id);
		// TODO Auto-generated constructor stub
	}


	//Constructor con nombreUsuario , contraseña y mail	

	public AdminWeb(String nombreUsuario, String passw, String email) {
		super(nombreUsuario, passw, email);
		// TODO Auto-generated constructor stub
	}


	

	//Constructor solo con nombreUsuario y contraseña
		
	public AdminWeb(String nombreUsuario, String passw) {
		super(nombreUsuario, passw);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	//Contructor completo sin id ni foto
	
	public AdminWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email,
			String departamento, String empresa, Boolean admin) {
		super(nombre, apellidos, nombreUsuario, passw, email, departamento, empresa, admin);
		// TODO Auto-generated constructor stub

	}
	// Getter and setters
	


	public String getFilename() {
		return filename;
	}




	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	
	//metodo insertar 
	
	 public void insertar() throws SQLException {
			
			DaoUserWeb daol1 = new DaoUserWeb();
			//daol1.insertar(this);
			daol1.insertarAdminCompleto(this);
			
		}




	 
	 
	

	
	

}
