package modelo.servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditorServicios {
	public void registrarServicio(String nombre, String precio, String archivoServicios) throws IOException {
		BufferedWriter editor = new BufferedWriter(new FileWriter(archivoServicios, true));
		String registro = (nombre + ";" + precio);
		editor.write(registro);
		editor.newLine();
		editor.close();
	}

	public void registrarServicios(String rutaArchivoServicios, String rutaArchivoServiciosPersistencia) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoServicios))) {

			String linea = br.readLine();

			while (linea != null) {
				String[] partes = linea.split(";");
				String nombre = partes[0];
				String precio = partes[1];
				registrarServicio(nombre,precio, rutaArchivoServiciosPersistencia);
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
