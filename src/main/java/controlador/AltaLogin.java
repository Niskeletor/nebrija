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
 * Servlet implementation class AltaLogin
 */
//@WebServlet("/AltaLogin")
@MultipartConfig
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
		Integer admin = Integer.parseUnsignedInt(request.getParameter("admin")) ;
		/*
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
     }*/
        /*
        //Ficheros 
        String appPath = getServletContext().getRealPath("/"); // Obtiene la ruta real de tu aplicación
        String relativePath = "uploads"; // El directorio donde se guardarán los archivos

        // La ruta absoluta del directorio de carga
        String uploadDirectory = appPath + File.separator + relativePath;

        // Verifica si el directorio existe, si no, créalo
        File fileSaveDir = new File(uploadDirectory);
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
        }*/

		
		
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
	        if (e instanceof SQLIntegrityConstraintViolationException) {
	            // Error por datos duplicados
	            response.setStatus(HttpServletResponse.SC_CONFLICT); 
	            response.getWriter().write("Datos ya existen");
	        } else {
	            // Otros errores SQL
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            response.getWriter().write("Error en la base de datos");
	        }
	    } catch (Exception e) {
	        // Otros errores
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        response.getWriter().write("Error de Servidor");
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
