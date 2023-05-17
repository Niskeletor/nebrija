package modelo;

import java.sql.SQLException;

import dao.DaoLogin;

public class Login {

		/**
		 * @author Pablo Nistal
		 * @category Clase Login
		 * Clase creada para controlar el Login de la página web
		 */
	
		private String name ="";
		private String contra="";
		private int id=0;
		
		/**
		 * Constructor vacío
		 */
		
		public Login() {
			
		}
		
		/**
		 * 
		 * @param name Usuario a verificar en la base de datos
		 * @param contra Contraseña verificar en la base de datos
		 * @param id id a verificar en la base de datos
		 */
		
		public Login(String name, String contra, int id) {
			
			this.name = name;
			this.contra = contra;
			this.id = id;
		}
		
		/**
		 * Constructor sin id
		 * @param name
		 * @param contra
		 */

		public Login(String name, String contra) {
			
			this.name = name;
			this.contra = contra;
		}
		
		/**
		 * Getters y Setters 
		 * @return devuelve la propiedad de cada uno
		 */

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContra() {
			return contra;
		}

		public void setContra(String contra) {
			this.contra = contra;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		
		//metodos para insertar
		
		public void insertar() throws SQLException {
			
			DaoLogin daol1 = new DaoLogin();
			daol1.insertar(this);
			
		}

		/**
		 * Para verificar la entrada y salida de variables en la clase
		 */
		@Override
		public String toString() {
			return "Login [name=" + name + ", contra=" + contra + ", id=" + id + "]";
		}
		
		
		
		
		
		
		
		
		
		
		
}
