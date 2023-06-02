package controlador;
import modeloUserWeb.AdminWeb;
import jakarta.servlet.http.Part;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

/**
 * Servlet implementation class SvModificarUserWebApply
 */
public class SvModificarUserWebApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvModificarUserWebApply() {
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
		
		/**
		 * Capturamos todas las variables posibles que nos puedan lanzar desde
		 * el post
		 */
		
		String nombreUsuario = request.getParameter("select-user-modificado").toString();
		String nombre= request.getParameter("input-user-name2").toString();
		String apellidos= request.getParameter("input-user-surname2").toString();
		String email= request.getParameter("input-Email2").toString();
		String nombreUsuario2 = request.getParameter("input-user-name2").toString();
		String passw = request.getParameter("input-Password2").toString();
		String empresa2 = request.getParameter("select-company2").toString();
		String departamento2 = request.getParameter("select-departament2").toString();
		
		// nombre , apellidos , email, passw, empresa2, departamento2
	//	
		//CONTROL VARIABLES
		System.out.println("Nombre Usuario: " + nombreUsuario);
		System.out.println("password: " + passw);
		System.out.println("Nombre : " + nombre);
		System.out.println("apellidos: " + apellidos);
		System.out.println("email: " + email);

        
			/* 
		String departamento= request.getParameter("select-departament");
				//PARSEAR!!
		
		System.out.println("Departamentoo: " + departamento);
		int departamentoId =0;
			
				if (departamento == null || departamento.equals("Elegir departamento")) {
				    // El usuario no seleccionó un departamento
					
				} else {
				    // El usuario seleccionó un departamento, y departamento contiene el valor del departamento seleccionado
				     departamentoId = Integer.parseInt(departamento);
				    // Ahora departamentoId es el id del departamento seleccionado, como un int
				}
		
		
		String empresa="";
		Integer empresaSelect= Integer.parseInt(request.getParameter("select-company"));
		switch (empresaSelect) {
	    case 1:
	    {	
	    	empresa="Harkonnen";
	        break;
	    }   
	    case 2:
	    {	
	    	empresa="Atreides";
	        
	        break;
	    }
	    case 3:
	    {	
	    	empresa="Corrino";
	        break;
	    }   
	    case 4:
	    {	
	    	empresa="IT";
	        break;
	    }
	    case 5:
	    {	
	    	empresa="Mantenimiento";
	        break;
	    }
	    default:
	        empresa = "null";
	        
	}
		System.out.println("Empresa: " + empresa);
		System.out.println("Empresa: " + empresaSelect);
		*/
	
		
		
		
		
		
		/*Si en el formulario dependiendo de el estado
		 * creamos  un objeto tipo administrador o consultor
		 *  para poder aplicar futuras funcionalidades
		*/
		
			
		
		
		
			
			// nombre , apellidos , email, passw, empresa2, departamento2
			
			//crear objeto 
			AdminWeb t1 = new AdminWeb();
			//AdminWeb z1 = new AdminWeb(nombre, apellidos, nombreUsuario, passw, email, empresaSelect, departamentoId);
			if (nombreUsuario!=null) {
				System.out.println("El username para el objeto es "  + nombreUsuario);
				t1.setNombreUsuario(nombreUsuario);
			}

			if (nombre!=null){
				System.out.println("El nombre para el objeto es "  + nombre );
				t1.setNombre(nombre);
			}
			if (apellidos!=null){
				System.out.println("El apellido para el objeto es "  + apellidos);
				t1.setApellidos(apellidos);
			}
			if (email!=null){
				System.out.println("El email para el objeto es "  + email);
				t1.setEmail(email);
			}
			if (passw!=null){
				System.out.println("El passw para el objeto es "  + passw);
				t1.setPassw(passw);
			}
			//super(nombre, apellidos, nombreUsuario, passw, email, foto, administrador, departamento, empresa);
			try {
			 //   z1.insertar();
				t1.modificar();
			    System.out.println("Intentando Introducir datos");
			} catch (SQLIntegrityConstraintViolationException e) {
			    System.out.println("Entrada duplicada para 'nameUsuario'");
			    response.setStatus(HttpServletResponse.SC_CONFLICT);  // 409 Conflict
			    response.getWriter().write("Entrada duplicada para 'nameUsuario'");
			    e.printStackTrace();
			} catch (SQLSyntaxErrorException e) {
			    System.out.println("La tabla no existe en la base de datos");
			    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
			    response.getWriter().write("La tabla no existe en la base de datos");
			    e.printStackTrace();
			} catch (SQLException e) {
			    // Manejo general de excepciones de SQL
			    e.printStackTrace();
			}

		
		
		
		
		
	}

}
