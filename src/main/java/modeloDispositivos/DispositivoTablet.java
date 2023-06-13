package modeloDispositivos;

public class DispositivoTablet extends Dispositivo {

	// Constructor completo
	public DispositivoTablet(int id, String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa, Boolean averiado, String usuario) {
		super(id, marca, modelo, numSerie, notas, estado, empresa, averiado, usuario);

	}

	// Constructor sin id ni averiado

	public DispositivoTablet(String marca, String modelo, String numSerie, String notas, String estado, Integer empresa,
			String usuario) {
		super(marca, modelo, numSerie, notas, estado, empresa, usuario);
		// TODO Auto-generated constructor stub
	}

	// Constructor sin id ni usuario ni averiado
	public DispositivoTablet(String marca, String modelo, String numSerie, String notas, String estado,
			Integer empresa) {
		super(marca, modelo, numSerie, notas, estado, empresa);
		// TODO Auto-generated constructor stub
	}

	// Constructor vacio
	public DispositivoTablet() {
		super();
	}

	@Override
	public String toString() {
		return "DispositivoTablet [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", numSerie=" + numSerie
				+ ", notas=" + notas + ", estado=" + estado + ", empresa=" + empresa + ", averiado=" + averiado
				+ ", usuario=" + usuario + "]";
	}

}