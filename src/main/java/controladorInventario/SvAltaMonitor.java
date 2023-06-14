package controladorInventario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modeloDispositivos.DispositivoMonitor;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class SvAltaMonitor
 */
public class SvAltaMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvAltaMonitor() {
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
		
		String getMarca = "";
		String getModelo = "";
		String getnumSer = "";
		Integer getCompany = 0;

		getMarca = request.getParameter("input-mon-brand");
			System.out.println("Marca del monitor es  : " + getMarca);
		getModelo = request.getParameter("input-mon-model");
			System.out.println("Modelo del monitor es  : " + getModelo);
		getnumSer = request.getParameter("input-mon-serialNum");
		String compania = request.getParameter("select-company-mon");
		System.out.println("Empresa del monitor es  : " + compania);
		getCompany = Integer.parseInt(request.getParameter("select-company-mon"));
		System.out.println("Empresa del monitor es  : " + getCompany);

		//CONTROLAR SI LLEGAN LOS DATOS DEL FORMULARIO

		System.out.println("Marca del monitor es  : " + getMarca);
		System.out.println("Modelo del monitor es  : " + getModelo);
		System.out.println("Numero Serie del monitor es  : " + getnumSer);
		System.out.println("Empresa del monitor es  : " + getCompany);

		//Perfecto los datos llegan, ahora hay que preparar la consulta a la base de datos para enviarlos
		//primero crear una instancia de la clase DispositivoMonitor para cargar los datos

		//CREAR CONSTRUCTOR PARA ESTOS DATOS 


		DispositivoMonitor dmon = new DispositivoMonitor(getMarca, getModelo, getnumSer, getCompany);

		System.out.println("Se ha creado la clase : " + dmon.toString());

		try {
			dmon.insertarSimple();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
