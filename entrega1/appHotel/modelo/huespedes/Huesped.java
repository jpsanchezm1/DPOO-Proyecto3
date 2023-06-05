package modelo.huespedes;

public class Huesped {

	private String nombre;
	private Integer identificacion;
	private String numCelular;
	private String correo;

	public Huesped(String nombre, int identificacion, String numCelular, String correo) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.numCelular = numCelular;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getIdentificacion() {
		return identificacion;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
