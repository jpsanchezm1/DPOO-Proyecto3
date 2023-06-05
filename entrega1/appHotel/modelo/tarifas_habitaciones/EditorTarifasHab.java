package modelo.tarifas_habitaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditorTarifasHab {

	public void guardarTarifa(String infoTarifa, String rutaArchivo) {

		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			editor.write(infoTarifa);
			editor.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guardarTarifas(String rutaArchivoTarifas, String rutaArchivoTarifasPersistencia) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoTarifas))) {

			String linea = br.readLine();
			while (linea != null) {
				guardarTarifa(linea, rutaArchivoTarifasPersistencia);
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
