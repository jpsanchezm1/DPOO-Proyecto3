package modelo.consumos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingUtilities;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

import modelo.huespedes.ControladorHuespedes;
import modelo.huespedes.Huesped;
import modelo.servicios.restaurante.ProductoMenu;
import modelo.servicios.Servicio;

public class ControladorConsumos {

	private String archivoConsumosServicios = "./data/consumos/consumosServicios.txt";

	private String archivoConsumosRest = "./data/consumos/consumosRestaurante.txt";

	private Map<Integer, List<ConsumoServicio>> mapaConsumosServicios = new HashMap<>(); // id representante: consumos

	private Map<Integer, List<ConsumoRestaurante>> mapaConsumosRest = new HashMap<>(); // id representante: consumos

	private ControladorHuespedes controladorRegistro;

	private Map<String, ProductoMenu> mapaProductosMenu;

	private Map<String, Servicio> mapaServicios;

	public ControladorConsumos(ControladorHuespedes controladorRegistro, Map<String, ProductoMenu> mapaProductosMenu,
			Map<String, Servicio> mapaServicios) throws IOException {
		this.controladorRegistro = controladorRegistro;
		this.mapaProductosMenu = mapaProductosMenu;
		this.mapaServicios = mapaServicios;
		recuperarInformacion();
	}
	
	public ControladorHuespedes getControladorRegistro() {
		return controladorRegistro;
	}

	public void crearConsumoServicio(String idHuesped, String servicioString) throws IOException {
		Huesped huesped = controladorRegistro.getHuespedPorId(Integer.parseInt(idHuesped));
		Servicio servicio = mapaServicios.get(servicioString);
		ConsumoServicio consumo = new ConsumoServicio(huesped, servicio);
		mapaConsumosServicios.computeIfAbsent(Integer.parseInt(idHuesped), k -> new ArrayList<>());
		mapaConsumosServicios.get(Integer.parseInt(idHuesped)).add(consumo);
		EditorConsumos editor = new EditorConsumos();
		editor.registrarConsumo(archivoConsumosServicios, idHuesped, servicioString, servicio.getPrecio().toString(), LocalTime.now().toString());
	}

	public void crearConsumoRest(String idHuesped, String productoMenu) throws IOException {
		Huesped huesped = controladorRegistro.getHuespedPorId(Integer.parseInt(idHuesped));
		ProductoMenu producto = mapaProductosMenu.get(productoMenu);
		ConsumoRestaurante consumo = new ConsumoRestaurante(huesped, producto);
		mapaConsumosRest.computeIfAbsent(Integer.parseInt(idHuesped), k -> new ArrayList<>());
		mapaConsumosRest.get(Integer.parseInt(idHuesped)).add(consumo);
		EditorConsumos editor = new EditorConsumos();
		editor.registrarConsumo(archivoConsumosRest, idHuesped, productoMenu, producto.getPrecio().toString(), LocalTime.now().toString());
	}

	public List<ConsumoServicio> getConsumosServicio(Integer idRepresentante) {
		return mapaConsumosServicios.get(idRepresentante);
	}

	public List<ConsumoRestaurante> getConsumosRestaurante(Integer idRepresentante) {
		return mapaConsumosRest.get(idRepresentante);
	}

	private void recuperarInformacion() throws IOException {
		CargadorConsumos cargadorConsumos = new CargadorConsumos();
		cargadorConsumos.cargarConsumos(archivoConsumosServicios, archivoConsumosRest, mapaConsumosServicios,
				mapaConsumosRest, controladorRegistro, mapaServicios, mapaProductosMenu);
	}
	
	public List<String> getListaServicios() {
		return new ArrayList<String>(mapaServicios.keySet());
	}
	
	public List<String> getListaProductos() {
		return new ArrayList<String>(mapaProductosMenu.keySet());
	}
	
	public Float consultarPrecioServicio(String nombre) {
		return mapaServicios.get(nombre).getPrecio();
	}
	
	public Float consultarPrecioProducto(String nombre) {
		return mapaProductosMenu.get(nombre).getPrecio();
	}
	
	public Map<String, ProductoMenu> mapaProductos() {
		return mapaProductosMenu;
	}
	
	public Map<String, Servicio> mapaServicios() {
		return mapaServicios;
	}

	public void ventasProductos() {
		Map<String, Integer> productos = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoConsumosRest))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String producto = partes[1];
                productos.put(producto, productos.getOrDefault(producto, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
   
        java.util.List<String> categorias = new java.util.ArrayList<>();
        java.util.List<Integer> cantidades = new java.util.ArrayList<>();

       
        for (Map.Entry<String, Integer> entry : productos.entrySet()) {
            categorias.add(entry.getKey());
            cantidades.add(entry.getValue());
        }
        
        CategoryChart chart = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title("Histograma de Productos")
                .xAxisTitle("Producto")
                .yAxisTitle("Cantidad")
                .build();

        chart.getStyler().setLegendVisible(false);
        chart.getStyler().setXAxisLabelRotation(45);

        chart.addSeries("Cantidad", categorias, cantidades);
        
        Thread chartThread = new Thread(() -> {
            new SwingWrapper<>(chart).displayChart();
        });
        chartThread.start();
	}

}
