package modelo.habitaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CargadorHabitaciones {

	public void cargarHabitaciones(String rutaArchivo, HashMap<Integer, Habitacion> mapaHabitaciones)
			throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = br.readLine();
			EditorHabitaciones editorHabitaciones = new EditorHabitaciones();

			while (linea != null) {
				String[] partes = linea.split(";");
				int id = Integer.valueOf(partes[0]);
				String tipoHabitacion = partes[1];
				int capacidad = Integer.parseInt(partes[2]);
				String descripcion = partes[3];
				
				Habitacion habitacionActual = new Habitacion(id, tipoHabitacion, capacidad,descripcion);

				mapaHabitaciones.put(id, habitacionActual);
				editorHabitaciones.guardarHabitacion(linea, "./data/habitaciones/habitaciones.txt");
				
				linea = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}

}
