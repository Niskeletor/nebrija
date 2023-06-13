package modeloUserWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import dao.DaoUserWeb;
import dao.DBConexion;

public class BuscadorUserWeb extends UserWeb {

	private String nombreEmpresa;
	private String nombreDepartamento;

	// Constructor vacio
	public BuscadorUserWeb() {
		super();
	}

	// Constructor con todos los atributos
	public BuscadorUserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email,
			String foto, Boolean administrador, Integer departamento, Integer empresa, int id, String nombreEmpresa,
			String nombreDepartamento) {
		super(nombre, apellidos, nombreUsuario, passw, email, foto, administrador, departamento, empresa, id);
		this.nombreEmpresa = nombreEmpresa;
		this.nombreDepartamento = nombreDepartamento;
	}

	// Getters
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	// Setters
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public List<BuscadorUserWeb> buscarParaSelect() throws SQLException {
		List<BuscadorUserWeb> usuarios = new ArrayList<>();

		// Aquí obtienes la conexión.
		Connection con = DBConexion.getConnection(0);

		String query = "SELECT * FROM Usuario";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			// Tu código
		}

		rs.close();
		ps.close();

		return usuarios;
	}

	public void buscarPorFiltro() throws SQLException {

		DaoUserWeb daol1 = new DaoUserWeb();
		// daol1.insertar(this);

		try {
			daol1.buscarPorFiltro(this);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// toString
	@Override
	public String toString() {
		return "BuscadorUserWeb{" + "nombreEmpresa='" + nombreEmpresa + '\'' + ", nombreDepartamento='"
				+ nombreDepartamento + '\'' + ", nombre='" + getNombre() + '\'' + ", apellidos='" + getApellidos()
				+ '\'' + ", nombreUsuario='" + getNombreUsuario() + '\'' + ", passw='" + getPassw() + '\'' + ", email='"
				+ getEmail() + '\'' + ", foto='" + getFoto() + '\'' + ", administrador=" + getAdministrador()
				+ ", departamento=" + getDepartamento() + ", empresa=" + getempresa() + ", id=" + getId() + '}';
	}
}
