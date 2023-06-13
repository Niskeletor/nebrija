package modeloUserWeb;

/**
 * Clase UserWeb que representa a un usuario en la web. Esta clase es abstracta
 * y debería ser extendida por las clases concretas que representan tipos
 * específicos de usuarios. Al nivel actual del proyecto he valorado tener un
 * admin web y un consultor web, a futuro se pueden integrar otro tipo de
 * perfiles Contiene varios constructores para facilitar la creación de usuarios
 * con diferentes cantidades de información.
 * 
 * @author Pablo Alejandro Nistal del Rio
 */

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

	/**
	 * Constructor vacío. Crea un objeto UserWeb sin inicializar sus campos.
	 */
	public UserWeb() {

	}

	/**
	 * Constructor que acepta solo nombre de usuario y contraseña. Ideal para
	 * escenarios para verificar Login o cambiar unicamente la contraseña
	 * 
	 * @param nombreUsuario el nombre de usuario
	 * @param passw         la contraseña
	 */

	public UserWeb(String nombreUsuario, String passw) {

		this.nombreUsuario = nombreUsuario;
		this.passw = passw;
	}

	/**
	 * Constructor que acepta nombre de usuario, contraseña y correo electrónico.
	 * 
	 * @param nombreUsuario el nombre de usuario
	 * @param passw         la contraseña
	 * @param email         el correo electrónico
	 */
	public UserWeb(String nombreUsuario, String passw, String email) {

		this.nombreUsuario = nombreUsuario;
		this.passw = passw;
		this.email = email;
	}

	/**
	 * Constructor que acepta todos los campos excepto id y foto.
	 * 
	 * @param nombre        el nombre
	 * @param apellidos     los apellidos
	 * @param nombreUsuario el nombre de usuario
	 * @param passw         la contraseña
	 * @param email         el correo electrónico
	 * @param departamento  el departamento
	 * @param empresa       la empresa
	 * @param administrador el indicador de si el usuario es un administrador web
	 */

	public UserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email,
			Integer departamento, Integer empresa, Boolean admin) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.passw = passw;
		this.email = email;
		this.departamento = departamento;
		this.empresa = empresa;
		this.administrador = admin;
	}

	/**
	 * Constructor que acepta todos los campos excepto id.
	 * 
	 * @param nombre        el nombre
	 * @param apellidos     los apellidos
	 * @param nombreUsuario el nombre de usuario
	 * @param passw         la contraseña
	 * @param email         el correo electrónico
	 * @param foto          la foto
	 * @param administrador el indicador de si el usuario es un administrador
	 * @param departamento  el departamento
	 * @param empresa       la empresa
	 */

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

	/**
	 * Constructor completo que acepta todos los campos.
	 * 
	 * @param nombre        el nombre
	 * @param apellidos     los apellidos
	 * @param nombreUsuario el nombre de usuario
	 * @param passw         la contraseña
	 * @param email         el correo electrónico
	 * @param foto          la foto
	 * @param administrador el indicador de si el usuario es un administrador
	 * @param departamento  el departamento
	 * @param empresa       la empresa
	 * @param id            el id del usuario
	 */

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

	/**
	 * Devuelve el nombre del usuario.
	 *
	 * @return el nombre del usuario.
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario.
	 *
	 * @param nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el apellido del usuario.
	 *
	 * @param apellido a devolver
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece el apellido del usuario.
	 *
	 * @param apellido a establecer
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Devuelve el nombre del usuario del sistema.
	 *
	 * @param el nombre del usuario del sistema a devolver
	 */

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Establece el nombre del usuario del sistema.
	 *
	 * @param nombre del usuario del sistema a establecer
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Devuelve la contraseña del usuario.
	 *
	 * @param la contraseña del usuario a devolver
	 */

	public String getPassw() {
		return passw;
	}

	/**
	 * Establece la contraseña del usuario.
	 *
	 * @param la contraseña a establecer
	 */
	public void setPassw(String passw) {
		this.passw = passw;
	}

	/**
	 * Devuelve el correo electrónico del usuario.
	 *
	 * @param el correo electrónico del usuario a devolver
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el correo electrónico del usuario.
	 *
	 * @param la contraseña a establecer
	 */
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

	/**
	 * Devuelve una representación en cadena de caracteres del usuario.
	 *
	 * @return una cadena que representa al usuario
	 */

	@Override
	public String toString() {
		return "UserWeb [nombre=" + nombre + ", apellidos=" + apellidos + ", nombreUsuario=" + nombreUsuario
				+ ", passw=" + passw + ", email=" + email + ", foto=" + foto + ", administrador=" + administrador
				+ ", departamento=" + departamento + ", empresa=" + empresa + ", id=" + id + "]";
	}

	// metodos

}
