package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import modeloUserWeb.*;
import java.sql.SQLException;

/**
 * Servlet implementation class AltaUserWeb
 */
@MultipartConfig
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
		int tipoUsuario=0;
		
		
		/**
		 * Capturamos todas las variables posibles que nos puedan lanzar desde
		 * el post
		 */
		String nombreUsuario = request.getParameter("input-system-username");
		String passw = request.getParameter("input-Password");
		String nombre= request.getParameter("input-user-name");
		String apellidos= request.getParameter("input-user-surname");
		String email= request.getParameter("input-Email");
		
		//CONTROL VARIABLES
		System.out.println("Nombre Usuario: " + nombreUsuario);
		System.out.println("password: " + passw);
		System.out.println("Nombre : " + nombre);
		System.out.println("apellidos: " + apellidos);
		System.out.println("email: " + email);
		
		//CONTROLAR SI SE ENVIA UN ARCHIVO
		
		Part filePart = request.getPart("foto"); // Obtiene el archivo subido		
		

		if (filePart != null && filePart.getSize() > 0) {
		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Obtiene el nombre del archivo
		    InputStream fileContent = filePart.getInputStream(); // Obtiene el contenido del archivo
		    // Haz algo con el archivo subido
		} else {
		    // No se subió ningún archivo
		}

		
		
		
		
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
	    /*case 4:
	    {	
	    	empresa="IT";
	        break;
	    }
	    case 5:
	    {	
	    	empresa="Mantenimiento";
	        break;
	    }*/
	    default:
	        empresa = "null";
	        
	}
		System.out.println("Empresa: " + empresa);
		System.out.println("Empresa: " + empresaSelect);
		
		String administrador = request.getParameter("admin-user");
		
		System.out.println("Administrador: " + administrador);
		Boolean admin = false;
		
		if (administrador==null)
		{
		    tipoUsuario = 0;
		} else if (administrador.equalsIgnoreCase("on")) {
		    tipoUsuario = 1;
		    admin= true;
		} else {
		    tipoUsuario = 0; // agregar caso de excepcion
		    admin=false;
		}
		
		
		
		System.out.println("El tipo usuario es: " + tipoUsuario);
		
		/*Si en el formulario dependiendo de el estado
		 * creamos  un objeto tipo administrador o consultor
		 *  para poder aplicar futuras funcionalidades
		*/
		if (tipoUsuario==1) {
			
			AdminWeb a1 = new AdminWeb(nombreUsuario,passw);
			AdminWeb t1 = new AdminWeb(nombreUsuario, apellidos, nombreUsuario, passw, email, empresaSelect, departamentoId, admin);
			
			try {
				t1.insertar();
				System.out.println("Intentando Introducir datos");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (tipoUsuario==0) {
			
			ConsultorWeb c1 = new ConsultorWeb(nombreUsuario,passw);
			
			try {
				c1.insertar();
				System.out.println("Intentando Introducir datos");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else {
			
			// TODO Auto-generated catch block
			System.out.println("Error interno del sistema");
		}
		
	}

}
