package modelo.pagos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditorPagos {
	public void registarPago(String rutaArchivo, String infoTarifa) {

		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			editor.write(infoTarifa);
			editor.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
