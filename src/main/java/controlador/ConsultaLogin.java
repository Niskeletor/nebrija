package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Login;
import dao.DaoLogin;

/**
 * Servlet implementation class ConsultaLogin
 */
public class ConsultaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Se encarga de escuchar 
		String nombre = request.getParameter("nombre");
		PrintWriter respuesta = response.getWriter();
		respuesta.print("<h1>Hola Puto " + nombre + "</h1>");
		
		//
		
		try {
			DaoLogin Dao = new DaoLogin();
			ArrayList<Login> listado = Dao.obtener();
			
			
			respuesta.print("<ul>");
			for (Login s : listado) {
				
				respuesta.print("<li>" + s.getName() + "  " + s.getContra() + "  " + s.getId() + "</li>");
				
			}
			respuesta.print("</ul>");
			respuesta.print(Dao.obtenerenJSON());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		
		
		/*
		 * ArrayList<Usuario> usuarios = new ArrayList<>();
	while (resultSet.next()) {
  String nombre = resultSet.getString("nombre");
  String apellido = resultSet.getString("apellido");
  Usuario usuario = new Usuario(nombre, apellido);
  usuarios.add(usuario);
}

		 */
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
