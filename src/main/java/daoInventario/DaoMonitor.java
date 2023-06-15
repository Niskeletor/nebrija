package daoInventario;
import dao.DBConexion;
import modeloDispositivos.DispositivoMonitor;
import modeloListador.ListadorUserWebMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class DaoMonitor {
	
	
	//Metodo Singleton 
	private Connection con = null;
	
	
	
	public DaoMonitor() throws SQLException {
		
		con = DBConexion.getConnection(1);
		
	}

	/**
	 * Metodo para introducir en base de datos un monitor con el formulario simple
	 * @param m
	 * @throws SQLException
	 */

	public void insertarMonitorSimple (DispositivoMonitor m ) throws SQLException {

		PreparedStatement ps = con.prepareStatement("INSERT INTO monitor (marca, modelo, numSerie, empresa_id) VALUES (?,?,?,?)");

		ps.setString(1, m.getMarca());
		ps.setString(2, m.getModelo());
		ps.setString(3, m.getNumSerie());
		ps.setInt(4, m.getEmpresa());

		ps.executeUpdate();
		ps.close();
	}

	/**
	 * Metodo Para introducir en la base de datos inventario un formulario completo
	 * con Marca, Modelo , S/N, idenntificador, empresa y estado
	 * @param m
	 * @throws SQLException
	 */
	
	public void insetarMonitorCompleto (DispositivoMonitor m) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO monitor (marca, modelo, numSerie, notas, identificador, empresa_id, estado) VALUES (?,?,?,?,?,?,?)");
		
		// INSERT INTO monitor (marca, modelo, numSerie, notas, identificador, empresa_id, estado) VALUES (?,?,?,?,?,?,?)
		
		ps.setString(1, m.getMarca());
		ps.setString(2, m.getModelo());
		ps.setString(3, m.getNumSerie());
		ps.setString(4, m.getNotas());
		ps.setString(5, m.getIdentificador());
		ps.setInt(6, m.getEmpresa());
		ps.setString(7, m.getEstado());
		
		ps.executeUpdate();
		ps.close();
		
		
	}

	public String obtenerenJSONFiltro(DispositivoMonitor b) throws SQLException {
	    Gson gsonFinal = new Gson();
	    String jsonFinal = gsonFinal.toJson(this.buscarPorFiltro(b));
	    System.out.println(jsonFinal);
	    
	    return jsonFinal;
	}




	// metodo para buscar con Filtro

	public ArrayList<DispositivoMonitor> buscarPorFiltro (DispositivoMonitor b) throws SQLException{
		
		//comienzo con la creacion de una consulta básica, si no se ha eligido ningun campo devolverá una consulta completa
		//StringBuilder sql = new StringBuilder("SELECT * FROM Usuario WHERE 1=1");
		
		// LA CONSULTA ESTA BIEN HECHA 16/06/2023
		StringBuilder sql2 = new StringBuilder("SELECT u.nombre AS 'usuario', e.nombre AS 'Empresa', m.marca AS 'Marca', m.modelo AS 'Modelo', m.numSerie AS 'Número de Serie', m.notas AS 'Notas', m.estado AS 'Estado', m.averiado AS 'Averiado', m.identificador AS 'Identificador' "
			    + "FROM monitor AS m "
			    + "LEFT JOIN  Usuario_has_monitor AS um ON m.id = um.monitor_id "
			    + "LEFT JOIN Usuario AS u ON um.Usuario_id = u.id "
				+ "LEFT JOIN empresa AS e ON m.empresa_id = e.id "
			    + "WHERE 1=1");

		int index =1;
		
		//si tiene el campo de nombre relleno lo añadirá a la consulta
		if (b.getMarca()!=null) {
			sql2.append(" AND m.marca LIKE ?" );
		}
		if (b.getModelo()!=null){
			sql2.append("  AND m.modelo LIKE ?");
		}

		if (b.getNumSerie()!=null){
			sql2.append(" AND m.numSerie LIKE ?");
		}
		if (b.getNotas()!=null){
			sql2.append(" AND m.notas LIKE ?");
		}

		if (b.getEstado()!=null){
			sql2.append(" AND m.estado LIKE ?");
		}		

		if (b.getEmpresa()!=null){
			sql2.append(" AND m.empresa_id =?");
		}
		
		
		System.out.println(b.getMarca().toString() + b.getModelo().toString() + b.getNumSerie().toString() );
		//+ b.getempresa().toString() + b.getDepartamento()

		//compruebo por consola que se recojan los parametros
		System.out.println(sql2.toString());
		
		//preparo la consulta y a continación le paso las querys que no son null
		
		PreparedStatement ps = con.prepareStatement (sql2.toString());
		
		if (b.getMarca()!=null) {
			ps.setString(index++, "%" +  b.getMarca() + "%");
		}
		if (b.getModelo()!=null) {
			ps.setString(index++, "%" + b.getModelo() + "%");
		}
		if (b.getNumSerie()!=null) {
			ps.setString(index++, "%" + b.getNumSerie() + "%");
		}
		if (b.getNotas()!=null) {
			ps.setString(index++, "%" + b.getNotas() + "%");
		}

		if (b.getEstado()!=null) {
			ps.setString(index++, "%" + b.getEstado() + "%");
		}

		if (b.getEmpresa()!=null) {
			ps.setInt(index++,  b.getEmpresa() );
		}
		
		 
		ResultSet rs = ps.executeQuery();
		
		
		ArrayList<DispositivoMonitor> result = new ArrayList<>();
	    
	    while (rs.next()) {
			DispositivoMonitor dispositivoMonitor = new DispositivoMonitor();
			//dispositivoMonitor.setId(rs.getInt("id"));
			dispositivoMonitor.setMarca(rs.getString("Marca"));
			dispositivoMonitor.setModelo(rs.getString("Modelo"));
			dispositivoMonitor.setNumSerie(rs.getString("Número de Serie"));
			dispositivoMonitor.setNotas(rs.getString("Notas"));
			dispositivoMonitor.setEstado(rs.getString("estado")); 
			//dispositivoMonitor.setEmpresa(rs.getInt("Empresa")); // asumiendo que es un entero
			//dispositivoMonitor.setEmpresa(rs.getString("Empresa"));
			dispositivoMonitor.setNombreEmpresa((rs.getString("Empresa")));
			dispositivoMonitor.setUsuario(rs.getString("usuario"));
			dispositivoMonitor.setIdentificador(rs.getString("Identificador"));

			result.add(dispositivoMonitor);
	        
	    }

	    System.out.println(result.toString());
	    ps.close();
	    return result;
		
	}


}
