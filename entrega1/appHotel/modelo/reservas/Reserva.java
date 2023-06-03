package modelo.reservas;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

	private int idRepresentante;
	private String fechaInicio;
	private String fechaFin;
	private boolean activa;
	private List<Integer> habitaciones;

	public Reserva(int representante, String fechaInicio, String fechaFin) {
		this.idRepresentante = representante;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		activa = true;
		habitaciones = new ArrayList<>();
	}

	public Reserva(int representante, String fechaInicio, String fechaFin, boolean activa,
			List<Integer> habitaciones2) {
		this.idRepresentante = representante;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.activa = activa;
		this.habitaciones = habitaciones2;
	}

	public int getRepresentante() {
		return idRepresentante;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public List<Integer> getHabitaciones() {
		return habitaciones;
	}

	public void aniadirHabitacion(int id) {
		habitaciones.add(id);
	}
}
