package modeloDispositivos;

import java.sql.SQLException;
import daoInventario.DaoMonitor; 

public class DispositivoMonitor extends Dispositivo{
	
	private String identificador;
	
	//Constructor completo sin identificador
		public DispositivoMonitor(int id, String marca, String modelo, String numSerie, String notas, String estado,
				Integer empresa, Boolean averiado, String usuario, String identificador) {
			super(id, marca, modelo, numSerie, notas, estado, empresa, averiado, usuario);
			this.identificador = identificador;
		}

	
	//Constructor completo sin identificador
	public DispositivoMonitor(int id, String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa, Boolean averiado, String usuario) {
		super(id, marca, modelo, numSerie, notas, estado, empresa, averiado, usuario);
		
	}
	
	//Constructor sin id ni averiado

	public DispositivoMonitor(String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa, String usuario) {
		super(marca, modelo, numSerie, notas, estado, empresa, usuario);
		// TODO Auto-generated constructor stub
	}

	
	//Constructor sin  id ni usuario ni averiado	
	public DispositivoMonitor(String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa) {
		super(marca, modelo, numSerie, notas, estado, empresa);
		// TODO Auto-generated constructor stub
	}

	//Constructor sin  id ni usuario ni averiado, sin notas ni estado PARA FORMULARIO 
	public DispositivoMonitor(String marca, String modelo, String numSerie, 
			Integer empresa) {
		super(marca, modelo, numSerie, empresa);
		// TODO Auto-generated constructor stub
	}
	
	//Constructor vacio
	public DispositivoMonitor(){
		super();
		
	}
	
	
	//Getters and Setters 
	
	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	
	
	//metodo para introducir monitor de manera simple con marca, modelo, numSeri y empresa

	public void insertarSimple() throws SQLException {
		
		DaoMonitor d1 = new DaoMonitor();
		d1.insertarMonitorSimple(this);
		
		
	}


	
	//metodo para dar de alta a monitor con todos los campos
	
	public void insertarCompleto() throws SQLException {
		
		DaoMonitor d1 = new DaoMonitor();
		d1.insetarMonitorCompleto(this);
		
		
	}




	@Override
	public String toString() {
		return "DispositivoMonitor [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", numSerie=" + numSerie
				+ ", notas=" + notas + ", estado=" + estado + ", empresa=" + empresa + ", averiado=" + averiado
				+ ", usuario=" + usuario + "]";
	}
	
	
	
	
	
	

}
