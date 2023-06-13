package modeloListador;

import java.util.*;

public class ListadorUserWebMapper {
	private Map<String, Object> campos;

	public ListadorUserWebMapper() {
		campos = new HashMap<>();
	}

	public Object getCampo(String nombreCampo) {
		return campos.get(nombreCampo);
	}

	public void setCampo(String nombreCampo, Object valorCampo) {
		campos.put(nombreCampo, valorCampo);
	}
}
