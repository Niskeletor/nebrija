package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Login;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.io.File;


import modeloUserWeb.AdminWeb;
import dao.*;
/**
 * Servlet implementation class AltaLoginFoto
 */
@MultipartConfig
public class AltaLoginFoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaLoginFoto() {
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
		
		Part filePart = request.getPart("foto"); // Obtiene el archivo subido
        String filename = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Obtén el nombre del archivo
        
        // El directorio donde se guardarán los archivos cargados.
     // Esto se puede hacer configurable a través de la configuración de la aplicación.
     String uploadsDirectory = "./data/uploads";

     // Asegúrate de que el directorio exista. Si no, créalo.
     File fileSaveDir = new File(uploadsDirectory);
     if (!fileSaveDir.exists()) {
         fileSaveDir.mkdirs();
     }

     // Ahora, el archivo se guardará en este directorio
     File file = new File(fileSaveDir, filename);

     try (InputStream input = filePart.getInputStream()) {
         Files.copy(input, file.toPath());
         System.out.println("Archivo creado en: " + file.getAbsolutePath());
     } catch (Exception e) {
    	 System.out.println("Archivo no copiado");
         // TODO: handle exception
     }

	 


	}

}
