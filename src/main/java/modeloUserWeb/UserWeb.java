package modeloUserWeb;

public abstract class UserWeb {
	
	
	protected String nombre;
    protected String apellidos;
    protected String nombreUsuario;
    protected String passw;
    protected String email;
    protected String foto;
    protected String departamentoEmpresa;
    protected int id;

    
    //constructor sin id y con foto
    
    public UserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto, String departamentoEmpresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.passw = passw;
        this.email = email;
        this.foto = foto;
        this.departamentoEmpresa = departamentoEmpresa;
    }
    
    //Constructor sin id ni foto
    public UserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String departamentoEmpresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.passw = passw;
        this.email = email;        
        this.departamentoEmpresa = departamentoEmpresa;
    }
    
    //constructor completo
    public UserWeb( int id, String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto, String departamentoEmpresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.passw = passw;
        this.email = email;
        this.foto = foto;
        this.departamentoEmpresa = departamentoEmpresa;
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

	public String getpassw() {
		return passw;
	}

	public void setpassw(String passw) {
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

	public String getDepartamentoEmpresa() {
		return departamentoEmpresa;
	}

	public void setDepartamentoEmpresa(String departamentoEmpresa) {
		this.departamentoEmpresa = departamentoEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
    //metodos

}
