package modelo.huespedes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class EditorHuespedes {

	public void guardarHuesped(String infoHuesped, String rutaArchivo) {

		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			editor.write(infoHuesped);
			editor.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guardarGrupos(Grupo grupo, String rutaArchivo) {
		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true));) {
			ArrayList<Integer> representantesGuardados = new ArrayList<>();

			int idRepre = grupo.getRepresentante().getIdentificacion();
			if (!representantesGuardados.contains(idRepre)) {
				String infoGrupo = "" + idRepre;
				infoGrupo += ";";

				for (Huesped acompanante : grupo.getAcompanantes()) {
					infoGrupo += acompanante.getIdentificacion() + "-";
				}
				String nuevaInfoGrupo = infoGrupo.substring(0, infoGrupo.length() - 1);

				editor.write(nuevaInfoGrupo);
				representantesGuardados.add(idRepre);
				editor.newLine();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
