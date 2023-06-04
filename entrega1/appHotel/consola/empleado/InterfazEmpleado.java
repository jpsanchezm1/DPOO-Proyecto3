package consola.empleado;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import consola.InterfazPMS;

public class InterfazEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDialog dialogConsumo, dialogCantidades;
	private PanelSeleccionar panelSeleccionar;
	private PanelOpciones panelOpciones;
	private ItemPanel itemPanel;
	private InterfazPMS padre;
	private String cat;

	public InterfazEmpleado(InterfazPMS padreI) {
		this.padre = padreI;
		setLayout(new GridBagLayout());
		setTitle("Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 600);
		getContentPane().setBackground(Color.DARK_GRAY);
		setResizable(false);
		setLocationRelativeTo(null); // Centra la ventana en la pantalla

		panelOpciones = new PanelOpciones(this);
		add(panelOpciones);
	}
	
	public void panelConsumoServicio(String cat) {
		this.cat = cat;
		dialogConsumo = new JDialog();
		dialogConsumo.setTitle("Registrar consumo(s)");
		dialogConsumo.setSize(700, 600);
		dialogConsumo.setLocationRelativeTo(null);
		String categoria = (cat.equals("Restaurante")) ? "Productos disponibles" : "Servicios disponibles";
		List<String> lista = (cat.equals("Restaurante")) ? padre.getProductosDisponibles() : padre.getServiciosDisponibles();
		this.panelSeleccionar = new PanelSeleccionar(this ,categoria, lista);
		dialogConsumo.add(panelSeleccionar);
		dialogConsumo.setVisible(true);
	}
	
	public void mostrarItemsYCantidad() {
		dialogConsumo.setVisible(false);
		dialogCantidades = new JDialog();
		dialogCantidades.setTitle("Ajustar cantidades");
		dialogCantidades.setSize(700, 600);
		dialogCantidades.setLocationRelativeTo(null);
		itemPanel = new ItemPanel(panelSeleccionar.getItemsSeleccionados(), this);
		dialogCantidades.add(itemPanel);
		dialogCantidades.setVisible(true);
	}
	
	public void realizarRegistros(String payment, String idHuesped) throws IOException {
		dialogCantidades.setVisible(false);
		List<List<String>> items = itemPanel.getItemList();
		padre.registrarConsumo(cat, items, payment, idHuesped);
	}
	
	public static void main(String[] args) throws IOException {
		InterfazEmpleado interfazEmpleado = new InterfazEmpleado(new InterfazPMS());
		interfazEmpleado.setVisible(true);
	}
}