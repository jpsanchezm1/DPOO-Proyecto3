package modelo.huespedes;

import java.util.ArrayList;

public class Grupo {

	private Huesped representante;
	private ArrayList<Huesped> acompanantes;
	private Float cuotaTotal = 0F;

	public Grupo(Huesped representante) {
		this.representante = representante;
		acompanantes = null;
	}

	public Huesped getRepresentante() {
		return representante;
	}

	public Float getCuotaTotal() {
		return cuotaTotal;
	}

	public ArrayList<Huesped> getAcompanantes() {
		return acompanantes;
	}

	public void aniadirAcompanantes(ArrayList<Huesped> acompanantes) {
		this.acompanantes = new ArrayList<>();
		this.acompanantes.addAll(acompanantes);
	}

	public void sumarACuotaTotal(Float float1) {
		this.cuotaTotal += float1;
	}

}
