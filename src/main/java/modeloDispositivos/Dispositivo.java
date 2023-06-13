package modeloDispositivos;

/**
 * Clase Abstracta creada para reflejar los elementos del inventario todos ellos
 * tienen en comun id, marca, modelo, numero de serie, notas , estado, empresa ,
 * averiado y usuario
 * 
 * A primer indicio son los campos que se van a utilizar con la BBDD
 * 
 * @author pablonr
 *
 */

public abstract class Dispositivo {

	int id;
	String marca;
	String modelo;
	String numSerie;
	String notas;
	String estado;
	Integer empresa;
	Boolean averiado;
	String usuario;

	// Constructor completo
	public Dispositivo(int id, String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa, Boolean averiado, String usuario) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.notas = notas;
		this.estado = estado;
		this.empresa = empresa;
		this.averiado = averiado;
		this.usuario = usuario;
	}

	// Constructor sin id ni usuario ni averiado
	public Dispositivo(String marca, String modelo, String numSerie, String notas, String estado, Integer empresa) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.notas = notas;
		this.estado = estado;
		this.empresa = empresa;
	}

	// Constructor sin id ni averiado
	public Dispositivo(String marca, String modelo, String numSerie, String notas, String estado, Integer empresa,
			String usuario) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.notas = notas;
		this.estado = estado;
		this.empresa = empresa;
		this.usuario = usuario;
	}

	// Constructor vario
	public Dispositivo() {
		// TODO Auto-generated constructor stub
	}

	// Getters y Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Boolean getAveriado() {
		return averiado;
	}

	public void setAveriado(Boolean averiado) {
		this.averiado = averiado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	// To String

	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", numSerie=" + numSerie
				+ ", notas=" + notas + ", estado=" + estado + ", empresa=" + empresa + ", averiado=" + averiado
				+ ", usuario=" + usuario + "]";
	}

}
