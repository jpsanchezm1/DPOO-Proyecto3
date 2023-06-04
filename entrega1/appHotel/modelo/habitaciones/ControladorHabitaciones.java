package modelo.habitaciones;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

//Se encarga de generar el inventario de habitaciones. Esta clase es usada por el admin.
public class ControladorHabitaciones {

	// guardamos por id todas las habitaciones
	private HashMap<Integer, Habitacion> habitaciones;

	private String archivoHabitaciones = "./data/habitaciones/habitaciones.txt";

	public ControladorHabitaciones() throws IOException {

		habitaciones = new HashMap<>();
		recuperarInformacion();
	}

	public void cargarHabitaciones(String rutaArchivo) throws IOException {
		CargadorHabitaciones cargador = new CargadorHabitaciones();
		cargador.cargarHabitaciones(rutaArchivo, habitaciones);
		EditorHabitaciones editorHabitaciones = new EditorHabitaciones();
		editorHabitaciones.guardarHabitaciones(rutaArchivo, archivoHabitaciones);
	}

	public void crearHabitacion(String infoHabitacion) {

		try {
			String[] partes = infoHabitacion.split(";");
			int id = Integer.parseInt(partes[0]);
			String tipoHabitacion = partes[1];
			int capacidad = Integer.parseInt(partes[2]);
			String descripcion = partes[3];

			Habitacion nuevaHab = new Habitacion(id, tipoHabitacion, capacidad, descripcion);
			habitaciones.put(id, nuevaHab);
			EditorHabitaciones editorHabitaciones = new EditorHabitaciones();
			editorHabitaciones.guardarHabitacion(infoHabitacion, archivoHabitaciones);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al crear la habitacion, asegurese de llenar bien los campos.x");
		}

	}

	private void recuperarInformacion() throws IOException {
		CargadorHabitaciones cargador = new CargadorHabitaciones();
		cargador.cargarHabitaciones(archivoHabitaciones, habitaciones);
	}

	public HashMap<Integer, Habitacion> getHabitaciones() {
		return habitaciones;
	}

}
