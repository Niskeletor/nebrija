package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexion {
	
	public static Connection instance = null;
	
	
	public DBConexion() {
		
		
	}
	
	public static Connection getConnection(int bbdd) throws SQLException {
		
		String basedeDatos="";
		String userBBDD="";
		String passBBDD="";
		
		switch (bbdd) {
		case 0: {
			basedeDatos="jdbc:mysql://localhost:3306/webadmin";
			userBBDD="root";
			passBBDD="123456";
		break;
		}
		case 1: {
			
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
