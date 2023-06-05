package modelo.consumos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditorConsumos {
	public void registrarConsumo(String rutaArchivo, String idRepresentante, String referencia, String precio, String hora) throws IOException {
		BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true));
		String registro = (idRepresentante + ";" + referencia + ";" + precio + ";" + hora);
		editor.write(registro);
		editor.newLine();
		editor.close();
	}
}
