package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * La clase DBConexion se encarga de gestionar la conexión a la base de datos.
 * <p>
 * Esta clase proporciona un método para obtener una conexión a la base de datos, lo que 
 * facilita la interacción con la base de datos para las operaciones de consulta y actualización.
 */
public class DBConexion {
	/**
	 * La instancia de la conexión a la base de datos. 
	 * haciendo uso del patrón Singleton
	 */
	public static Connection instance = null;
	
	/**
	 * El constructor de la clase DBConexion.
	 * <p>
	 * Este es un constructor vacío que no realiza ninguna acción.
	 */
	public DBConexion() {
		
		
	}
	/**
	 * Este método se utiliza para obtener una conexión a la base de datos.
	 * <p>
	 * En función del valor del parámetro bbdd, se seleccionará una u otra base de datos (para implementar en el futuro).
	 *
	 * @param bbdd un entero que indica la base de datos a la que se quiere conectar.
	 * @return una instancia de Connection que representa la conexión a la base de datos.
	 * @throws SQLException si hay un error al establecer la conexión con la base de datos.
	 */
	public static Connection getConnection(int bbdd) throws SQLException {
		
		String basedeDatos="";
		String userBBDD="";
		String passBBDD="";
		
		switch (bbdd) {
		case 0: {
			basedeDatos="jdbc:mysql://localhost:3306/daedalusWeb";
			userBBDD="root";
			passBBDD="Spigen2000!!";
		break;
		}
		case 1: {
			basedeDatos="jdbc:mysql://localhost:3306/web";
			userBBDD="root";
			passBBDD="Spigen2000!!";
			
			break;
			}
		case 2: {
			
			break;
			}
		default:
			throw new IllegalArgumentException("Unexpected value: " + bbdd);
		}

		
		instance=DriverManager.getConnection(basedeDatos, userBBDD, passBBDD);
		
		
		return instance;
		}

}
