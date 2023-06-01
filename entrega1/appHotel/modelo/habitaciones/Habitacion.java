package modelo.habitaciones;

public class Habitacion {

	private int id;
	private String tipo;
	private int capacidad;
	private String descripcion;

	public Habitacion(int id, String tipo, int capacidad, String descripcion) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() { 
		return Integer.toString(id) + " \nTipo Habitacion: " + tipo + "\n" + "Capacidad habitacion: " + capacidad;
	}

}
