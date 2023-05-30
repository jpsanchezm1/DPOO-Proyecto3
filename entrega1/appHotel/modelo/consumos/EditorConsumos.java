package modelo.consumos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditorConsumos {
	public void registrarConsumo(String rutaArchivo, String idRepresentante, String referencia) throws IOException {
		BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true));
		String registro = (idRepresentante + ";" + referencia);
		editor.write(registro);
		editor.newLine();
		editor.close();
	}
}
