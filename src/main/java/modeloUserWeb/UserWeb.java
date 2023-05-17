package modeloUserWeb;

public abstract class UserWeb {
	
	
	protected String nombre;
    protected String apellidos;
    protected String nombreUsuario;
    protected String passw;
    protected String email;
    protected String foto;
    protected String departamento; 
    protected String Empresa;
    protected int id;
	
    //Constructor vacio
    public UserWeb() {
		super();
	}
    
    //Constructor solo con nombre usuario y password
    
  public UserWeb(String nombreUsuario, String passw) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.passw = passw;
	}



//Constructor sin id ni foto

	public UserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email,
			String departamento, String empresa) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.passw = passw;
		this.email = email;
		this.departamento = departamento;
		this.Empresa = empresa;
	}
	
	 //constructor completo

	public UserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto,
		String departamento, String empresa, int id) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.nombreUsuario = nombreUsuario;
	this.passw = passw;
	this.email = email;
	this.foto = foto;
	this.departamento = departamento;
	Empresa = empresa;
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
    
    
    //metodos
	
	

}
