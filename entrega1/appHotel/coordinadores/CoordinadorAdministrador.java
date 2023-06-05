package coordinadores;

import java.io.IOException;
import java.util.Map;

import consola.InterfazPMS;
import modelo.consumos.ControladorConsumos;
import modelo.habitaciones.ControladorHabitaciones;
import modelo.servicios.ControladorServicios;
import modelo.servicios.Servicio;
import modelo.servicios.restaurante.ControladorRestaurante;
import modelo.servicios.restaurante.ProductoMenu;
import modelo.tarifas_habitaciones.ControladorTarifaHabitacion;

public class CoordinadorAdministrador {

	private ControladorHabitaciones contrHab;

	private ControladorTarifaHabitacion contrTarifaHabi;

	private ControladorServicios contrServicios;

	private ControladorRestaurante contrRest;
	
	private ControladorConsumos consumos;

	public CoordinadorAdministrador() throws IOException {
		contrHab = new ControladorHabitaciones();
		contrTarifaHabi = new ControladorTarifaHabitacion();
		contrServicios = new ControladorServicios();
		contrRest = new ControladorRestaurante();
	}
	
	public void setConsumos(ControladorConsumos consumos) {
		this.consumos = consumos;
	}

	public ControladorHabitaciones getContrHab() {
		return contrHab;
	}

	public void cargarHabitaciones(String rutaArchivo) throws IOException {
		contrHab.cargarHabitaciones(rutaArchivo);
	}

	public void cargarTarifas(String rutaArchivo) throws IOException {
		contrTarifaHabi.cargarTarifas(rutaArchivo);
	}

	public void ventasPorductos() {
		consumos.ventasProductos();
	}

	public void cargarMenuRestaurante(String rutaArchivoPlatos, String rutaArchivoBebidas) throws IOException {
		contrRest.cargarMenu(rutaArchivoPlatos, rutaArchivoBebidas);
	}

	public void registrarHabitacion(String infoHabitacion) {
		// infoHabitación es de la forma:
		// id;tipoHabitacion;capacidad;camas;balcon;vista;cocina
		// ejemplo: 123;suite;3;estandar,doble;true;false;true
		contrHab.crearHabitacion(infoHabitacion);
	}

	public Map<String, Servicio> mapaServicios() {
		return contrServicios.getMapaServicios();
	}

	public Map<String, ProductoMenu> mapaProductosMenu() {
		return contrRest.getMenuSimple();
	}

	public void registrarTarifa(String infoTarifa) {
		// infoTarifa es de la forma: tipoHabitacion;fechaDeInicio;fechaDeFin;precio
		// ejemplo: suite;2003-10-12;2003-11-12;24
		// precio puede ser float
		// el formato de fechas es yyyy-mm-dd
		contrTarifaHabi.configurarTarifa(infoTarifa);
	}

	public void cargarServicios(String rutaArchivo) throws IOException {
		contrServicios.cargarServicios(rutaArchivo);
	}

	public ControladorTarifaHabitacion getContrTarifaHabi() {
		return contrTarifaHabi;
	}

}
