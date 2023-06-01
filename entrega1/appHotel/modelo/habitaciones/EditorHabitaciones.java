package modelo.habitaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditorHabitaciones {

	public void guardarHabitacion(String infoHabitacion, String rutaArchivo) {

		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			editor.write(infoHabitacion);
			editor.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guardarHabitaciones(String rutaArchivo, String archivoHabitaciones) throws IOException {
		
		try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			
			String linea = br.readLine();
			
			while(linea != null) {
				
				guardarHabitacion(linea, archivoHabitaciones);
				linea = br.readLine();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
