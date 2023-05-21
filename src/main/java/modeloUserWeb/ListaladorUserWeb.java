package modeloUserWeb;

public class ListaladorUserWeb extends UserWeb{
	
	private String nombreEmpresa;
	private String nombreDepartamento;
	
	
	//constructor vacio
	public ListaladorUserWeb() {
		super();
		// TODO Auto-generated constructor stub
	}

	//constructor padre UserWeb
	public ListaladorUserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email,
			String foto, Boolean administrador, Integer departamento, Integer empresa, int id) {
		super(nombre, apellidos, nombreUsuario, passw, email, foto, administrador, departamento, empresa, id);
		// TODO Auto-generated constructor stub
	}

	//constructor completo
		public ListaladorUserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email,
				String foto, Boolean administrador, Integer departamento, Integer empresa, int id, String nombreEmpresa, String nombreDepartamento) {
			super(nombre, apellidos, nombreUsuario, passw, email, foto, administrador, departamento, empresa, id);
			// TODO Auto-generated constructor stub
			
			this.nombreDepartamento= nombreDepartamento;
			this.nombreEmpresa=nombreEmpresa;
		}
			
		
		//Getters y setters exclusivos para listados
		public String getNombreEmpresa() {
			return nombreEmpresa;
		}

		public void setNombreEmpresa(String nombreEmpresa) {
			this.nombreEmpresa = nombreEmpresa;
		}

		public String getNombreDepartamento() {
			return nombreDepartamento;
		}

		public void setNombreDepartamento(String nombreDepartamento) {
			this.nombreDepartamento = nombreDepartamento;
		}

		@Override
		public String toString() {
			return "ListaladorUserWeb [nombreEmpresa=" + nombreEmpresa + ", nombreDepartamento=" + nombreDepartamento
					+ "]";
		}

		
		

	
	

	
	
	
	
}
