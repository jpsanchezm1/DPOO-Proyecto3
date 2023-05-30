package modelo.servicios.restaurante;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditorRestaurante {

	private String archivoPlatos = "./data/servicios/menuRestaurante/platos.txt";

	private String archivoBebidas = "./data/servicios/menuRestaurante/bebidas.txt";

	public void registrarProducto(String categoria, String nombre, String precio, String rangoDisp,
			String llevableAHabitacion) throws IOException {
		
		String archivoBase = (categoria.equals("platos")) ? archivoPlatos : archivoBebidas;
		BufferedWriter editor = new BufferedWriter(new FileWriter(archivoBase, true));
		String registro = (nombre + ";" + precio + ";" + rangoDisp + ";" + llevableAHabitacion);
		editor.write(registro);
		editor.newLine();
		editor.close();
	}
}
