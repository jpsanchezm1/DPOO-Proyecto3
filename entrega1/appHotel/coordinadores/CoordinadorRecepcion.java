package coordinadores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.habitaciones.ControladorHabitaciones;
import modelo.habitaciones.Habitacion;
import modelo.huespedes.ControladorHuespedes;
import modelo.huespedes.Grupo;
import modelo.pagos.ControladorPagos;
import modelo.reservas.ControladorReserva;
import modelo.reservas.Reserva;
import modelo.tarifas_habitaciones.ControladorTarifaHabitacion;

public class CoordinadorRecepcion {

	// Hay que definir el constructor y como se pasa el inventario a contrReserva

	private ControladorReserva contrReserva;

	private ControladorHuespedes controladorHuespedes;

	private ControladorHabitaciones contrHabitacion;

	private ControladorPagos controladorPagos;

	private ControladorTarifaHabitacion controladorTarifas;

	public CoordinadorRecepcion(ControladorHabitaciones contrHabitacion) throws IOException {
		super();
		this.controladorTarifas = new ControladorTarifaHabitacion();
		this.contrHabitacion = contrHabitacion;
		this.contrReserva = new ControladorReserva(contrHabitacion.getHabitaciones());
		this.controladorHuespedes = new ControladorHuespedes(contrReserva.getCuotasTotales());
		this.controladorPagos = new ControladorPagos();
	}

	public ControladorHuespedes getControladorHuespedes() {
		return controladorHuespedes;
	}

	public ControladorPagos getControladorPagos() {
		return controladorPagos;
	}

	public void realizarReserva(List<Integer> listHabs, String infoRep, List<String> infoAcomp, String fechaInicio,
			String fechaFin) {
		Grupo grupo = controladorHuespedes.crearGrupo(infoRep);
		controladorHuespedes.aniadirAcompanantes(infoAcomp, grupo); // aniade acomps al grupo
		contrReserva.crearReserva(Integer.parseInt(infoRep.split(";")[1]), fechaInicio, fechaFin); // crea reserva
		Reserva reserva = contrReserva.getReservaPorIdHuesped(Integer.parseInt(infoRep.split(";")[1]));
		contrReserva.reservarHabitaciones(listHabs, reserva);
		for (int id : listHabs) { // aniadir precio de reserva a monto de huesped
			String tipo = contrHabitacion.getHabitaciones().get(id).getTipo();
			Float precio = controladorTarifas.consultarTarifaHabitacion(tipo, fechaInicio, fechaFin);
			contrReserva.sumarACuotaTotal(Integer.parseInt(infoRep.split(";")[1]),precio);

		}
		// System.out.println(grupo.getCuotaTotal());
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

	public boolean existeReserva(String id) {
		
		Reserva reserva = contrReserva.getReservaPorIdHuesped(Integer.parseInt(id));
		if(reserva != null) {return false;}
		else {return true;}
		
	}

	public void pagarReservaEfectivo(int id) {
		
		
	}
}
