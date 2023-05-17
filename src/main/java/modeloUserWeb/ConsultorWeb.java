package modeloUserWeb;

public class ConsultorWeb extends UserWeb{

	
		//constructor vacio
	public ConsultorWeb() {
		super();
		// TODO Auto-generated constructor stub
	}

		//constructor completo
	public ConsultorWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto,
			String departamento, String empresa, int id) {
		super(nombre, apellidos, nombreUsuario, passw, email, foto, departamento, empresa, id);
		// TODO Auto-generated constructor stub
	}

		//constructor sin id ni foto
	public ConsultorWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email,
			String departamento, String empresa) {
		super(nombre, apellidos, nombreUsuario, passw, email, departamento, empresa);
		// TODO Auto-generated constructor stub
	}

	

}
