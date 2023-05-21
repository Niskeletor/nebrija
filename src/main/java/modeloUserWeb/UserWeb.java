package modeloUserWeb;

public abstract class UserWeb {
	
	
	private String nombre;
    private String apellidos;
    private String nombreUsuario;
    private String passw;
    private String email;
    private String foto;
	private Boolean administrador;
    private Integer departamento; 
    private Integer empresa;
    private int id;
	
    //Constructor vacio
    public UserWeb() {
		
	}
    
    //Constructor solo con nombre usuario y password
    
  public UserWeb(String nombreUsuario, String passw) {
		
		this.nombreUsuario = nombreUsuario;
		this.passw = passw;
	}
  
  //Contructor con mail usuario y password
		 public UserWeb(String nombreUsuario, String passw, String email) {
		
		this.nombreUsuario = nombreUsuario;
		this.passw = passw;
		this.email = email;
	 }
  



//Constructor sin id ni foto

	public UserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email,
			Integer departamento, Integer empresa, Boolean admin) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.passw = passw;
		this.email = email;
		this.departamento = departamento;
		this.empresa = empresa;
		this.administrador=admin;
	}
	
	
	//Constructor completo sin id

	public UserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto,
		Boolean administrador, Integer departamento, Integer empresa) {
	
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.nombreUsuario = nombreUsuario;
	this.passw = passw;
	this.email = email;
	this.foto = foto;
	this.administrador = administrador;
	this.departamento = departamento;
	this.empresa = empresa;
}

	//constructor completo con id, foto , administrador boolean
	
	
	public UserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto,
			Boolean administrador, Integer departamento, Integer empresa, int id) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.passw = passw;
		this.email = email;
		this.foto = foto;
		this.administrador = administrador;
		this.departamento = departamento;
		this.empresa = empresa;
		this.id = id;
	}
	
	
    // getter y setters

	public String getNombre() {
		return nombre;
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}

	public Integer getempresa() {
		return empresa;
	}

	public void setempresa(Integer empresa) {
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

	@Override
	public String toString() {
		return "UserWeb [nombre=" + nombre + ", apellidos=" + apellidos + ", nombreUsuario=" + nombreUsuario
				+ ", passw=" + passw + ", email=" + email + ", foto=" + foto + ", administrador=" + administrador
				+ ", departamento=" + departamento + ", empresa=" + empresa + ", id=" + id + "]";
	}

	
	
    
    
    //metodos
	
	

}
