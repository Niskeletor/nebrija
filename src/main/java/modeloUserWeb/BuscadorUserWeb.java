package modeloUserWeb;

public class BuscadorUserWeb extends UserWeb {
    private String nivelPrivilegios;

    //Constructor vacio
    public BuscadorUserWeb() {
        super();
    }

    //Constructor con todos los atributos
    public BuscadorUserWeb(String nombre, String apellidos, String nombreUsuario, String passw, String email, String foto, Boolean administrador, Integer departamento, Integer empresa, int id, String nivelPrivilegios) {
        super(nombre, apellidos, nombreUsuario, passw, email, foto, administrador, departamento, empresa, id);
        this.nivelPrivilegios = nivelPrivilegios;
    }

    //Getters
    public String getNivelPrivilegios() {
        return nivelPrivilegios;
    }

    //Setters
    public void setNivelPrivilegios(String nivelPrivilegios) {
        this.nivelPrivilegios = nivelPrivilegios;
    }

    //toString
    @Override
    public String toString() {
        return "BuscadorUserWeb{" +
                "nivelPrivilegios='" + nivelPrivilegios + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", nombreUsuario='" + getNombreUsuario() + '\'' +
                ", passw='" + getPassw() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", foto='" + getFoto() + '\'' +
                ", administrador=" + getAdministrador() +
                ", departamento=" + getDepartamento() +
                ", empresa=" + getEmpresa() +
                ", id=" + getId() +
                '}';
    }
}
