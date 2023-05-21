package modeloUserWeb;

import java.sql.SQLException;

import dao.DaoUserWeb;

public class ConsultorWeb extends UserWeb{

	
		//constructor vacio
	public ConsultorWeb() {
		super();
		// TODO Auto-generated constructor stub
	}

		//constructor completo
	
	


	//COnstructor Solo con usuario y contraseña 
	public ConsultorWeb(String nombreUsuario, String passw) {
		super(nombreUsuario, passw);
		// TODO Auto-generated constructor stub
	}

	public void insertar() throws SQLException {
		
		DaoUserWeb daol1 = new DaoUserWeb();
		//daol1.insertar(this);
		daol1.insertarConsultor(this);
		
	}
	
			
	

}
