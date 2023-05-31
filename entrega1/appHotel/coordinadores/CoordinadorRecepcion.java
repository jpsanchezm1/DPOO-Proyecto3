package coordinadores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.habitaciones.ControladorHabitaciones;
import modelo.habitaciones.Habitacion;
import modelo.huespedes.ControladorHuespedes;
import modelo.pagos.ControladorPagos;
import modelo.reservas.ControladorReserva;

public class CoordinadorRecepcion {

	// Hay que definir el constructor y como se pasa el inventario a contrReserva

	private ControladorReserva contrReserva;

	private ControladorHuespedes controladorHuespedes;

	private ControladorHabitaciones contrHabitacion;
	
	private ControladorPagos controladorPagos;
	
	public CoordinadorRecepcion() throws IOException {
		super();
		this.controladorHuespedes = new ControladorHuespedes();
		this.contrHabitacion = new ControladorHabitaciones();
		this.contrReserva = new ControladorReserva(contrHabitacion.getHabitaciones());
		this.controladorPagos = new ControladorPagos();
	}
	
	public ControladorHuespedes getControladorHuespedes() {
		return controladorHuespedes;
	}
	
	public ControladorPagos getControladorPagos() {
		return controladorPagos;
	}

	public void realizarReserva() {
		System.out.println("Aún no se ha definido");
	}

	public void registrarSalida() {
		System.out.println("Aún no se ha definido");
	}

	public List<String> consultarHabitaciones(String fechaInicio, String fechaFin) {
		List<Integer> ids = contrReserva.consultarHabitacionesDisponibles(fechaInicio, fechaFin);
		ArrayList<String> habitaciones = new ArrayList<String>();
		
		for (Integer id : ids) {
			Habitacion habActual = contrHabitacion.getHabitaciones().get(id);
			habitaciones.add(habActual.toString());
		}
		
		return habitaciones;
	}
}
