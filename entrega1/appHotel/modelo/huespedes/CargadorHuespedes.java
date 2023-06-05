package modelo.huespedes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class CargadorHuespedes {

	public void cargarHuespedes(String rutaArchivo, Map<Integer, Huesped> huespedesReg) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = br.readLine();

			while (linea != null) {
				String[] partes = linea.split(";");
				String nombre = partes[0];
				int id = Integer.parseInt(partes[1]);
				String numCel = partes[2];
				String correo = partes[3];

				Huesped huespedActual = new Huesped(nombre, id, numCel, correo);

				huespedesReg.put(id, huespedActual);

				linea = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void cargarHuespedesGrupos(String rutaArchivo, Map<Integer, Huesped> huespedesReg,
			Map<Integer, Grupo> huespedesGruposReg) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = br.readLine();

			while (linea != null) {
				String[] partes = linea.split(";");
				int idRepre = Integer.parseInt(partes[0]);
				Huesped representante = huespedesReg.get(idRepre);

				Grupo grupoActual = new Grupo(representante);
				huespedesGruposReg.put(idRepre, grupoActual);

				ArrayList<Huesped> acompanantes = new ArrayList<>();

				String[] partesAcompanantes = partes[1].split("-");
				for (String idAcom : partesAcompanantes) {
					acompanantes.add(huespedesReg.get(Integer.parseInt(idAcom)));
					huespedesGruposReg.put(Integer.parseInt(idAcom), grupoActual);
				}

				grupoActual.aniadirAcompanantes(acompanantes);

				linea = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
