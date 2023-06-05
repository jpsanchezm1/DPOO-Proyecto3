package modelo.reservas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditorReservas {

	public void guardarReserva(int idRepre, Reserva reserva, String rutaArchivo) {

		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {

			String infoReserva = "" + idRepre;
			infoReserva += ";" + reserva.getFechaInicio();
			infoReserva += ";" + reserva.getFechaFin();
			infoReserva += ";" + reserva.isActiva();

			infoReserva += ";";
			for (int idHab : reserva.getHabitaciones()) {
				infoReserva += idHab + "-";
			}
			String newInfoReserva = infoReserva.substring(0, infoReserva.length() - 1);

			editor.write(newInfoReserva);
			editor.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guardarCuotaTotal(int id, Float cuotaTotal, String archivoCuotas) {

		try {
			File archivoTemporal = new File("./data/reservas/cuotasTemporal.txt");

			BufferedReader br = new BufferedReader(new FileReader(archivoCuotas));
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal));

			String linea;
			boolean referenciaEncontrada = false;

			while ((linea = br.readLine()) != null) {
				if (linea.startsWith(id + "")) {
					// Se encontró la referencia, se modifica la línea
					bw.write(id + ";" + cuotaTotal);
					bw.newLine();
					referenciaEncontrada = true;
				} else {
					// Se copia la línea tal cual
					bw.write(linea);
					bw.newLine();
				}
			}
			if (!referenciaEncontrada) {
				// La referencia no fue encontrada, se agrega una nueva línea
				bw.write(id + ";" + cuotaTotal);
				bw.newLine();
			}

			br.close();
			bw.close();

			// Reemplazar el archivo original con el archivo temporal
			new File(archivoCuotas).delete();
			archivoTemporal.renameTo(new File(archivoCuotas));

			System.out.println("Cambios realizados con éxito.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
