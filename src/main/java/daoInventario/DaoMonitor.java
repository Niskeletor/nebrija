package daoInventario;
import dao.DBConexion;
import modeloDispositivos.DispositivoMonitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoMonitor {
	
	
	//Metodo Singleton 
	private Connection con = null;
	
	
	
	public DaoMonitor() throws SQLException {
		
		con = DBConexion.getConnection(1);
		
	}
	
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

}
