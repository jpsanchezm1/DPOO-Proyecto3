package modelo.huespedes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorHuespedes {

	// guardamos los huespedes por su id
	private Map<Integer, Huesped> huespedesReg = new HashMap<>();

	// guardamos los grupos por la id de cada huesped. Los valores son el grupo del
	// huesped
	private Map<Integer, Grupo> huespedesGruposReg = new HashMap<>();

	private String archivoHuespedes = "./data/huespedes/huespedes.txt";
	private String archivoGrupos = "./data/huespedes/grupos.txt";

	private Map<Integer, Float> cuotasTotales;

	public ControladorHuespedes(Map<Integer, Float> cuotasTotales) throws IOException {
		this.cuotasTotales = cuotasTotales;
		recuperarInformacion();
	}

	public Grupo crearGrupo(String infoHuesped) {
		String[] partes = infoHuesped.split(";");

		Huesped representante = new Huesped(partes[0], Integer.parseInt(partes[1]), (partes[2]), partes[3]);
		Grupo grupo = new Grupo(representante);

		huespedesReg.put(representante.getIdentificacion(), representante);
		huespedesGruposReg.put(representante.getIdentificacion(), grupo);

		EditorHuespedes editorHuespedes = new EditorHuespedes();
		editorHuespedes.guardarHuesped(infoHuesped, archivoHuespedes);

		return grupo;
	}

	public void aniadirAcompanantes(List<String> infoAcomp, Grupo grupo) {
		ArrayList<Huesped> acompanantes = new ArrayList<>();
		EditorHuespedes editorHuespedes = new EditorHuespedes();

		for (String infoAcompanante : infoAcomp) {

			String[] partes = infoAcompanante.split(";");

			Huesped acompanante = new Huesped(partes[0], Integer.parseInt(partes[1]), (partes[2]), partes[3]);
			acompanantes.add(acompanante);

			huespedesReg.put(acompanante.getIdentificacion(), acompanante);
			huespedesGruposReg.put(acompanante.getIdentificacion(), grupo);

			editorHuespedes.guardarHuesped(infoAcompanante, archivoHuespedes);
		}

		grupo.aniadirAcompanantes(acompanantes);
		editorHuespedes.guardarGrupos(grupo, archivoGrupos);

	}

	// Recibe una id de un huesped y retorna el grupo al que pertenece el huesped
	public Grupo getGrupoPorId(int id) {
		return huespedesGruposReg.get(id);
	}

	// Recibe una id de un huesped y retorna el huesped como objeto
	public Huesped getHuespedPorId(int id) {
		return huespedesReg.get(id);
	}

	// Recibe una id de un huesped y un monto y carga el monto a la cuota del
	// huesped principal
	public void cargarMonto(int id, float monto) {

		Grupo grupo = getGrupoPorId(id);
		Float montoTotal = cuotasTotales.get(grupo.getRepresentante().getIdentificacion());
		montoTotal += monto;
	}

	private void recuperarInformacion() throws IOException {
		CargadorHuespedes cargadorHuespedes = new CargadorHuespedes();
		cargadorHuespedes.cargarHuespedes(archivoHuespedes, huespedesReg);
		cargadorHuespedes.cargarHuespedesGrupos(archivoGrupos, huespedesReg, huespedesGruposReg);
	}

}
