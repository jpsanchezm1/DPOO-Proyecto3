package coordinadores;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import modelo.huespedes.ControladorHuespedes;
import modelo.pagos.ControladorPagos;
import modelo.consumos.ControladorConsumos;
import modelo.servicios.restaurante.ProductoMenu;
import modelo.servicios.Servicio;

public class CoordinadorEmpleado {

	ControladorConsumos controladorConsumos;

	ControladorPagos controladorPagos;

	public CoordinadorEmpleado(ControladorHuespedes controladorRegistro, ControladorPagos controladorPagos,
			Map<String, Servicio> mapaServicios, Map<String, ProductoMenu> mapaProductosMenu) throws IOException {
		this.controladorConsumos = new ControladorConsumos(controladorRegistro, mapaProductosMenu, mapaServicios);
		this.controladorPagos = controladorPagos;
	}

	public void registrarConsumo(String tipoConsumo, String idHuesped, String referencia, String pago)
			throws IOException {
		String precio = "";
		if (tipoConsumo.equals("Restaurante")) {
			controladorConsumos.crearConsumoRest(idHuesped, referencia);
			precio = controladorConsumos.mapaProductos().get(referencia).getPrecio().toString();
		} else {
			controladorConsumos.crearConsumoServicio(idHuesped, referencia);
			precio = controladorConsumos.mapaServicios().get(referencia).getPrecio().toString();
		}
		if (Boolean.parseBoolean(pago)) {
			controladorPagos.pagarConsumo(idHuesped, referencia, precio);
		} else {
			controladorConsumos.getControladorRegistro().cargarMonto(Integer.parseInt(idHuesped),
					controladorConsumos.consultarPrecioServicio(referencia));
		}
	}

	public List<String> getListaServicios() {
		return controladorConsumos.getListaServicios();
	}

	public List<String> getListaProductos() {
		return controladorConsumos.getListaProductos();
	}
	
	public ControladorConsumos getControladorConsumos() {
		return controladorConsumos;
	}
}
