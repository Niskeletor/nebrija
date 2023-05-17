package modeloUserWeb;

public class AdminWeb extends UserWeb{

	
	//constructor vacio
	public AdminWeb() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Constructor completo
	public AdminWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto,
			String departamento, String empresa, int id) {
		super(nombre, apellidos, nombreUsuario, passw, email, foto, departamento, empresa, id);
		// TODO Auto-generated constructor stub
	}

	//Constructor sin id ni foto
	public AdminWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email,
			String departamento, String empresa) {
		super(nombre, apellidos, nombreUsuario, passw, email, departamento, empresa);
		// TODO Auto-generated constructor stub
	}

	public AdminWeb(String nombreUsuario, String passw) {
		super(nombreUsuario, passw);
		// TODO Auto-generated constructor stub
	}
	
	//Constructor solo con nombreUsuario y contraseña
	
	

	
	

}
