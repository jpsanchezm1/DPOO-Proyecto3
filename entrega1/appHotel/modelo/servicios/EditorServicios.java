package modelo.servicios;

import java.io.BufferedWriter;
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
}
