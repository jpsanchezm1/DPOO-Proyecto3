package modelo.servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class CargadorServicios {

	private void anadirServicio(Map<String, Servicio> mapaServicios, String nombre, String precioString)
			throws IOException {
		Float precio = Float.parseFloat(precioString);
		mapaServicios.computeIfAbsent(nombre, k -> new Servicio(nombre, precio));
		mapaServicios.get(nombre).setPrecio(precio);
	}

	public void cargarServicios(String rutaArchivo, Map<String, Servicio> mapaServicios, String archivoServicios) throws IOException {
		try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea = lector.readLine();
			while (linea != null) {
				String[] parametros = linea.split(";");
				String nombre = parametros[0];
				String precio = parametros[1];
				anadirServicio(mapaServicios, nombre, precio);
				linea = lector.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}