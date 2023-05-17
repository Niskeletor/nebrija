package dao;
import java.util.Properties;
import java.sql.*;

public class DBconection {
	
	public static  Connection instance = null;
	public static final String JDBC_URL = "jdbc:mysql://localhost:3360/web";
	
	
	
	public static Connection getConnection() throws SQLException {
		
		if (instance == null) {                                       
			Properties props = new Properties();
			props.put("user","root");
			props.put("password","123456");
			String user = "root";
			String passw = "123456";
			
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

