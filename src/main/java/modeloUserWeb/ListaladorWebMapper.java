package modeloUserWeb;

public class ListaladorWebMapper {
	
	private int idUsuario;
	private String name;
	private String surname;
	private String nameUsuario;
	private String contra;
	private String correo;
	private String picture;
	private String admin;
	private String nameCompany;
	private String nameDepartament;
	
	
	//Constructor vacio
	public ListaladorWebMapper() {
	
	}
	
	//Constructor COmpleto para mostrar datos
	
	
	
	//setters y getters

	


//Constructor 2 elementos
	public ListaladorWebMapper(String name, String surname) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.surname=surname;
		
	}

	public ListaladorWebMapper(int idUsuario, String name, String surname, String nameUsuario, String contra,
			String correo, String picture, String admin, String nameCompany, String nameDepartament) {
		
		this.idUsuario = idUsuario;
		this.name = name;
		this.surname = surname;
		this.nameUsuario = nameUsuario;
		this.contra = contra;
		this.correo = correo;
		this.picture = picture;
		this.admin = admin;
		this.nameCompany = nameCompany;
		this.nameDepartament = nameDepartament;
	}

	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getNameUsuario() {
		return nameUsuario;
	}


	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}


	public String getContra() {
		return contra;
	}


	public void setContra(String contra) {
		this.contra = contra;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getAdmin() {
		return admin;
	}


	public void setAdmin(String admin) {
		this.admin = admin;
	}


	public String getNameCompany() {
		return nameCompany;
	}


	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}


	public String getNameDepartament() {
		return nameDepartament;
	}


	public void setNameDepartament(String nameDepartament) {
		this.nameDepartament = nameDepartament;
	}

	@Override
	public String toString() {
		return "ListaladorWebMapper [idUsuario=" + idUsuario + ", name=" + name + ", surname=" + surname
				+ ", nameUsuario=" + nameUsuario + ", contra=" + contra + ", correo=" + correo + ", picture=" + picture
				+ ", admin=" + admin + ", nameCompany=" + nameCompany + ", nameDepartament=" + nameDepartament + "]";
	}
	
	
	
	

	
	
	

}
