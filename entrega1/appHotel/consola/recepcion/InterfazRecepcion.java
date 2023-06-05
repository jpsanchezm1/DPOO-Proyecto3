package consola.recepcion;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import consola.InterfazPMS;
import modelo.reservas.ControladorReserva;

public class InterfazRecepcion extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelOpciones panelOpciones;
	private JDialog dialogReservar;
	private PanelReservar panelReservar;
	private JDialog dialogRegistrar;
	private PanelRegistroIngreso panelRegistroIngreso;
	private JDialog dialogRegistrarSalida;
	private PanelRegistrarSalida panelRegistrarSalida;
	//private PanelConsultarHabitaciones opcionConsultar;
	private InterfazPMS padre;

	public InterfazRecepcion(InterfazPMS padreI) {

		this.padre = padreI;
		setLayout(new GridBagLayout());
		setTitle("Recepcion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 600);
		getContentPane().setBackground(Color.DARK_GRAY);
		setResizable(false);
		setLocationRelativeTo(null); // Centra la ventana en la pantalla

		panelOpciones = new PanelOpciones(this);
		add(panelOpciones);
		// Configuraci�n del layout
		// setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

	}

	public void mostrarPanelReservar() {
		
		dialogReservar = new JDialog();
		dialogReservar.setTitle("Reservar habitaciones");
		dialogReservar.setSize(700, 600);
		dialogReservar.setLocationRelativeTo(null);
		panelReservar = new PanelReservar(this);
		dialogReservar.add(panelReservar);
		dialogReservar.setVisible(true);
	}

	public void mostrarPanelRegistrar() {
		
		dialogReservar.setVisible(false);
		dialogRegistrar = new JDialog();
		dialogRegistrar.setTitle("Reservar habitaciones");
		dialogRegistrar.setSize(800, 600);
		dialogRegistrar.setLocationRelativeTo(null);
		panelRegistroIngreso = new PanelRegistroIngreso(this);
		dialogRegistrar.add(panelRegistroIngreso);
		dialogRegistrar.setVisible(true);

	}
	
	public void mostrarPanelRegistrarSalida() {
		
		dialogRegistrarSalida = new JDialog();
		dialogRegistrarSalida.setTitle("Registrar Salida");
		dialogRegistrarSalida.setSize(700, 600);
		dialogRegistrarSalida.setLocationRelativeTo(null);
		panelRegistrarSalida = new PanelRegistrarSalida(this);
		dialogRegistrarSalida.add(panelRegistrarSalida);
		dialogRegistrarSalida.setVisible(true);
		
	}

	public void consultarHabitacionesDisp() {
		List<String> infoHabs = padre.consultarHabitacionesDisponibles(panelReservar.getFechaInicio(),
				panelReservar.getFechaFin());
		for (String hab : infoHabs) {
			panelReservar.addToList(hab);
		}
	}

	public void reservarHabitaciones() {
		dialogRegistrar.setVisible(false);
		ArrayList<Integer> habsSeleccionadas = (ArrayList<Integer>) panelReservar.getHabitacionesSeleccionadas();
		String infoRep = panelRegistroIngreso.getInfoRep();
		List<String> infoAcomp = panelRegistroIngreso.getInfoAcompaniantes();
		String fechaInicio = panelReservar.getFechaInicio();
		String fechaFin = panelReservar.getFechaFin();
		padre.reservar(habsSeleccionadas, infoRep, infoAcomp, fechaInicio, fechaFin);
	}
	
	public static void main(String[] args) throws IOException {
		InterfazRecepcion interfaz = new InterfazRecepcion(new InterfazPMS());
		interfaz.setVisible(true);
	}

	public boolean existeReserva(String id) {
		
		return padre.existeReserva(id);
		
	}

	public void pagarReservaEfectivo(String id) {
		
		padre.pagarReservaEfectivo(Integer.parseInt(id));
		
	}

}
