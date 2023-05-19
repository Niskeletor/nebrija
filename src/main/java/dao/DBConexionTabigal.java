package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import java.sql.*;

public class DBConexionTabigal {

    public static  Connection instance = null;
	/**
	 * Establecemos conexion
	 */
	public static final String JDBC_URL = "jdbc:mysql://localhost:3360/inventarioportatiles";


    public static Connection getConnection() throws SQLException {
		
		if (instance == null) {                                       
			Properties props = new Properties();
			props.put("user","root");
			props.put("password","Spigen2000!!");
			String user = "root";
			String passw = "Spigen2000!!";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Error de login");
			}
			instance = DriverManager.getConnection("jdbc:mysql://localhost:3360/web","root","123456");
			}
		return instance;
		}
    
}
