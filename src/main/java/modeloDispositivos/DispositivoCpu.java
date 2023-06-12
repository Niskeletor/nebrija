package modeloDispositivos;

public class DispositivoCpu extends Dispositivo{
	
	String dirIp;
	String nameBios;
	Boolean winRemote;

	
	//Constructor completo
	
	public DispositivoCpu(int id, String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa, Boolean averiado, String usuario, String dirIP, String nameBios, Boolean winRemote) {
		super(id, marca, modelo, numSerie, notas, estado, empresa, averiado, usuario);
		
		this.dirIp = dirIP;
		this.winRemote = winRemote;
		this.nameBios = nameBios;
	}
	
	
	//Constructor completo
	public DispositivoCpu(int id, String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa, Boolean averiado, String usuario) {
		super(id, marca, modelo, numSerie, notas, estado, empresa, averiado, usuario);
		
	}
	
	//Constructor sin id ni averiado

	public DispositivoCpu(String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa, String usuario) {
		super(marca, modelo, numSerie, notas, estado, empresa, usuario);
		// TODO Auto-generated constructor stub
	}

	
	//Constructor sin  id ni usuario ni averiado	
	public DispositivoCpu(String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa) {
		super(marca, modelo, numSerie, notas, estado, empresa);
		// TODO Auto-generated constructor stub
	}
	
	//Constructor vacio
	public DispositivoCpu(){
		super();
	}
	
	
	
	//Getters y Setters 
	

	public String getDirIp() {
		return dirIp;
	}


	public void setDirIp(String dirIp) {
		this.dirIp = dirIp;
	}


	public String getNameBios() {
		return nameBios;
	}


	public void setNameBios(String nameBios) {
		this.nameBios = nameBios;
	}


	public Boolean getWinRemote() {
		return winRemote;
	}


	public void setWinRemote(Boolean winRemote) {
		this.winRemote = winRemote;
	}


	@Override
	public String toString() {
		return "DispositivoCpu [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", numSerie=" + numSerie
				+ ", notas=" + notas + ", estado=" + estado + ", empresa=" + empresa + ", averiado=" + averiado
				+ ", usuario=" + usuario + "]";
	}
	
	
	
	
	
	

}
