package modelo.habitaciones;

public class Habitacion {

	private int id;
	private String tipo;
	private int capacidad;
	private String descripcion;
	private String descripcionHotel;

	public Habitacion(int id, String tipo, int capacidad, String descripcion) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.descripcion = descripcion;
		this.descripcionHotel = "Parqueadero pago en el hotel, Parqueadero gratuito en el hote, Piscina, Zonas húmedas, BBQ, Wifi gratis, Recepción 24 horas, Pet Friendly";
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
		return "Descripcion habitacion: \n" + descripcion + "\nCaracteristicas del hotel:\n"+descripcionHotel;
	}

	@Override
	public String toString() {
		return Integer.toString(id) + " \nTipo Habitacion: " + tipo + "\n" + "Capacidad habitacion: " + capacidad;
	}

}
