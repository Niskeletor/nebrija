package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dao.DaoUserWeb;
import modeloUserWeb.BuscadorUserWeb;

/**
 * Servlet implementation class ConsultaUserWebFiltro
 */
public class ConsultaUserWebFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUserWebFiltro() {
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
		
		//AQUI PREPARO LA ESCUCHA A TRAVES DEL FORMULARIO CUANDO SE QUIERE EFECTUAR UN FILTRO
				String nombreUsuario="";
				String nombre="";
				String apellidos="";
				String departamento="";
				String empresa="";
				String admin="";
				StringBuilder sql = new StringBuilder("SELECT * FROM Usuarios WHERE 1=1");
				BuscadorUserWeb b1 = new BuscadorUserWeb();
				
				if (request.getParameter("username")!= null) {
				nombreUsuario = request.getParameter("username");
				sql.append(" AND nombreUsuario = " + nombreUsuario);
				b1.setNombreUsuario(nombreUsuario);		
				}
				if (request.getParameter("nombre")!= null) {
				nombre= request.getParameter("nombre");
				sql.append(" AND nombre = " + nombre);
				b1.setNombre(nombre);
				}
				if (request.getParameter("surname")!= null) {
				apellidos= request.getParameter("surname");
				sql.append(" AND apellidos = " + apellidos);
				b1.setApellidos(apellidos);
				}
				if (request.getParameter("departament")!= null) {
					departamento= request.getParameter("departament");
					sql.append(" AND departamento = " + departamento);
					b1.setDepartamento((Integer.parseInt(departamento)));
					}
				if (request.getParameter("company")!= null) {
					empresa= request.getParameter("company");
					sql.append(" AND company = " + empresa);
					b1.setempresa(Integer.parseInt(empresa));
					}
				if (request.getParameter("admin")!= null) {
					admin= request.getParameter("admin");
					sql.append(" AND admin = " + admin);
					b1.setAdministrador(true);
					}
			/*	System.out.println(sql);
				
				System.out.println(b1.toString());
				
				
				
				//CONTROL VARIABLES
				System.out.println("Nombre Usuario: " + nombreUsuario);
				
				System.out.println("Nombre : " + nombre);
				System.out.println("apellidos: " + apellidos);
				System.out.println("departamento: " + departamento);
				System.out.println("empresa: " + empresa);
				System.out.println("admin: " + admin);
		*/
		
		try {
			DaoUserWeb daoUserWeb = new DaoUserWeb();
			String json = daoUserWeb.obtenerenJSONFiltro(b1);
	
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			System.out.println(json); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
