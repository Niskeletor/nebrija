package modeloInventario;

public class Inventario {

		private int idportatiles;
		private String empresa;
		private String empresaUsuario;
		private String usuario;
		private String departamento;
		private String autorizadoPor;
		private String autorizadoHasta;
		private String office;
		private String antivirus;
		private String modelo;
		private String numSerie;
		private String baja;
		private String notas;
		private String accionPendiente;
		private String procesador;
		private String ram;
		private String win11;
		private String hd;
		private String identificador;

		//constructor vacio
		public Inventario() {
		}

			//constructor sin id
		public Inventario(String empresa, String empresaUsuario, String usuario, String departamento,
				String autorizadoPor, String autorizadoHasta, String office, String antivirus, String modelo,
				String numSerie, String baja, String notas, String accionPendiente, String procesador, String ram,
				String win11, String hd, String identificador) {
			this.empresa = empresa;
			this.empresaUsuario = empresaUsuario;
			this.usuario = usuario;
			this.departamento = departamento;
			this.autorizadoPor = autorizadoPor;
			this.autorizadoHasta = autorizadoHasta;
			this.office = office;
			this.antivirus = antivirus;
			this.modelo = modelo;
			this.numSerie = numSerie;
			this.baja = baja;
			this.notas = notas;
			this.accionPendiente = accionPendiente;
			this.procesador = procesador;
			this.ram = ram;
			this.win11 = win11;
			this.hd = hd;
			this.identificador = identificador;
		}













		//contructor completo
		public Inventario(int idportatiles, String empresa, String empresaUsuario, String usuario, String departamento,
				String autorizadoPor, String autorizadoHasta, String office, String antivirus, String modelo,
				String numSerie, String baja, String notas, String accionPendiente, String procesador, String ram,
				String win11, String hd, String identificador) {
			this.idportatiles = idportatiles;
			this.empresa = empresa;
			this.empresaUsuario = empresaUsuario;
			this.usuario = usuario;
			this.departamento = departamento;
			this.autorizadoPor = autorizadoPor;
			this.autorizadoHasta = autorizadoHasta;
			this.office = office;
			this.antivirus = antivirus;
			this.modelo = modelo;
			this.numSerie = numSerie;
			this.baja = baja;
			this.notas = notas;
			this.accionPendiente = accionPendiente;
			this.procesador = procesador;
			this.ram = ram;
			this.win11 = win11;
			this.hd = hd;
			this.identificador = identificador;
		}

		// Getter and Setters 

		public int getIdportatiles() {
			return idportatiles;
		}

		public void setIdportatiles(int idportatiles) {
			this.idportatiles = idportatiles;
		}

		public String getEmpresa() {
			return empresa;
		}

		public void setEmpresa(String empresa) {
			this.empresa = empresa;
		}

		public String getEmpresaUsuario() {
			return empresaUsuario;
		}

		public void setEmpresaUsuario(String empresaUsuario) {
			this.empresaUsuario = empresaUsuario;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getDepartamento() {
			return departamento;
		}

		public void setDepartamento(String departamento) {
			this.departamento = departamento;
		}

		public String getAutorizadoPor() {
			return autorizadoPor;
		}

		public void setAutorizadoPor(String autorizadoPor) {
			this.autorizadoPor = autorizadoPor;
		}

		public String getAutorizadoHasta() {
			return autorizadoHasta;
		}

		public void setAutorizadoHasta(String autorizadoHasta) {
			this.autorizadoHasta = autorizadoHasta;
		}

		public String getOffice() {
			return office;
		}

		public void setOffice(String office) {
			this.office = office;
		}

		public String getAntivirus() {
			return antivirus;
		}

		public void setAntivirus(String antivirus) {
			this.antivirus = antivirus;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getNumSerie() {
			return numSerie;
		}

		public void setNumSerie(String numSerie) {
			this.numSerie = numSerie;
		}

		public String getBaja() {
			return baja;
		}

		public void setBaja(String baja) {
			this.baja = baja;
		}

		public String getNotas() {
			return notas;
		}

		public void setNotas(String notas) {
			this.notas = notas;
		}

		public String getAccionPendiente() {
			return accionPendiente;
		}

		public void setAccionPendiente(String accionPendiente) {
			this.accionPendiente = accionPendiente;
		}

		public String getProcesador() {
			return procesador;
		}

		public void setProcesador(String procesador) {
			this.procesador = procesador;
		}

		public String getRam() {
			return ram;
		}

		public void setRam(String ram) {
			this.ram = ram;
		}

		public String getWin11() {
			return win11;
		}

		public void setWin11(String win11) {
			this.win11 = win11;
		}

		public String getHd() {
			return hd;
		}

		public void setHd(String hd) {
			this.hd = hd;
		}

		public String getIdentificador() {
			return identificador;
		}

		public void setIdentificador(String identificador) {
			this.identificador = identificador;
		}

		


		
		
		

		
}
