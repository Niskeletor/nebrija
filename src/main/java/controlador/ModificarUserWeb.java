package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import dao.DaoUserWeb;
import modeloUserWeb.BuscadorUserWeb;

//SIN USO!!

/**
 * Servlet implementation class ModificarUserWeb
 */
public class ModificarUserWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarUserWeb() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			DaoUserWeb daoUserWeb = new DaoUserWeb();
			String json = daoUserWeb.obtenerenJSON();

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			System.out.println(json);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * try { BuscadorUserWeb buscador = new BuscadorUserWeb(); List<BuscadorUserWeb>
		 * usuarios = buscador.buscarParaSelect();
		 * 
		 * String json = new Gson().toJson(usuarios);
		 * 
		 * response.setContentType("application/json");
		 * response.setCharacterEncoding("UTF-8"); response.getWriter().write(json); }
		 * catch (SQLException e) { e.printStackTrace(); }
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
