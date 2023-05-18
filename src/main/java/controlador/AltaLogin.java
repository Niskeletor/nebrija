package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Login;

import java.io.IOException;
import java.sql.SQLException;
import modeloUserWeb.AdminWeb;
import dao.*;

/**
 * Servlet implementation class AltaLogin
 */
//@WebServlet("/AltaLogin")
public class AltaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaLogin() {
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
		//int tipoUsuario=Integer.parseInt(request.getParameter("rol"));
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String nombreUsuario = request.getParameter("nombreUsuario");
		String passw = request.getParameter("passw");
		String email = request.getParameter("email");
		String departamento = request.getParameter("departamento");
		String empresa = request.getParameter("empresa");
		
		
		AdminWeb ad = new AdminWeb(nombre, apellidos, nombreUsuario, passw, email, departamento, empresa);
		System.out.println(ad.toString());
		System.out.println(ad.getApellidos());
		System.out.println(ad.getDepartamento());
		System.out.println(ad.getEmail());
		System.out.println(ad.getNombre());
		System.out.println(ad.getPassw());
		try {
			ad.insertar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al conectar con el metodo insertar desde POST");
			e.printStackTrace();
		}


		/* 
		String name = request.getParameter("name");
		String passw = request.getParameter("passw");
		
		System.out.println(tipoUsuario);
		
		if (tipoUsuario==0) {
			
			
		}
		*/

		/*Login l1 = new Login(name,contra);
		
		try {
			l1.insertar();
			System.out.println("Intentando Introducir datos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
