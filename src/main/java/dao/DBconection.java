package dao;

import java.util.Properties;
import java.sql.*;

/**
 * Esta clase proporciona un único punto de conexión a la base de datos a través
 * del patrón Singleton. Una vez que se establece la conexión, la misma
 * instancia se puede utilizar en todo el proyecto. Sirve de referencia para
 * haber creado finalmente la clase DBConexion
 * 
 * @author Pablo Alejandro Nistal del Río
 */
public class DBconection {

	/**
	 * La instancia de la conexión a la base de datos. JDBC_URL como variable global
	 * de la dirección de BBDD usada como entorno de pruebas
	 */

	public static Connection instance = null;
	public static final String JDBC_URL = "jdbc:mysql://localhost:3360/web";

	/**
	 * Este método se encarga de establecer la conexión a la base de datos. Si la
	 * conexión ya está establecida, devuelve la instancia existente. Si la conexión
	 * aún no está establecida, la crea.
	 *
	 * @return La instancia de la conexión a la base de datos.
	 * @throws SQLException Si ocurre algún error al intentar conectarse a la base
	 *                      de datos.
	 */

	public static Connection getConnection() throws SQLException {

		if (instance == null) {
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "123456");
			String user = "root";
			String passw = "123456";

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Error de login");
			}
			instance = DriverManager.getConnection("jdbc:mysql://localhost:3360/web", "root", "123456");
		}
		return instance;
	}

}
