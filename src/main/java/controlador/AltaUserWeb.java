package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import modeloUserWeb.*;
import java.sql.SQLException;

/**
 * Servlet implementation class AltaUserWeb
 */
public class AltaUserWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUserWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//variable creada para recibir desde la web 0 Admin 1 Consultor
		//parseamos y convertimos a tipo numerico
		int tipoUsuario=Integer.parseInt(request.getParameter("rol"));
		
		
		/**
		 * Capturamos todas las variables posibles que nos puedan lanzar desde
		 * el post
		 */
		String nombreUsuario = request.getParameter("nombreUsuario");
		String passw = request.getParameter("passw");
		String nombre= request.getParameter("nombre");
		String apellidos= request.getParameter("apellidos");
		String email= request.getParameter("email");
		String foto= request.getParameter("foto");
		String departamento= request.getParameter("departamento");
		String empresa= request.getParameter("passw");
		
		
		System.out.println(tipoUsuario);
		
		if (tipoUsuario==0) {
			
			AdminWeb a1 = new AdminWeb(nombreUsuario,passw);
			
			try {
				a1.insertar();
				System.out.println("Intentando Introducir datos");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
