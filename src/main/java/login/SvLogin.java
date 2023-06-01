package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import modelo.Login;

/**
 * Servlet implementation class SvLogin
 */
public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvLogin() {
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
		//Aqui preparamos la esucha desde la web de index.html antes de pasar a la pagina de dashboard
		// Verificaremos si el usuario existe en la base de datos, si es correcto, le redirigirá al inicio
		
		/**
		 * Servlet encargado de controlar la funcion Login de a página principal
		 */
		
		Login login = new Login (request.getParameter("nombreUsuario"), request.getParameter("passw"));
		System.out.println(login.toString());
		try {
			if (login.verificarUsuario()){
				//Si el login es correcto , redirigimos a pagina principal
				response.sendRedirect("dashboard.html");

			}else{
				//si login no es correcto, redireccionamos de nuevo
				response.sendRedirect("index.html");

			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
