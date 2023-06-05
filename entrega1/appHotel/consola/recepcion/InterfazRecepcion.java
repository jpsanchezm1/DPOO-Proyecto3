package consola.recepcion;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import consola.InterfazPMS;

public class InterfazRecepcion extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelOpciones panelOpciones;
	private JDialog dialogReservar;
	private PanelReservar panelReservar;
	private PanelRegistroIngreso panelRegistroIngreso;
	private PanelRegistrarSalida opcionRegistrarSalida;
	private PanelConsultarHabitaciones opcionConsultar;
	private JDialog dialogRegistrar;
	private InterfazPMS padre;
	private List<Integer> listHabs;

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
		// TODO Auto-generated method stub
		dialogReservar = new JDialog();
		dialogReservar.setTitle("Reservar habitaciones");
		dialogReservar.setSize(700, 600);
		dialogReservar.setLocationRelativeTo(null);
		this.panelReservar = new PanelReservar(this);
		dialogReservar.add(panelReservar);
		dialogReservar.setVisible(true);
	}

	public void mostrarPanelRegistrar() {
		// TODO Auto-generated method stub
		listHabs = panelReservar.getHabitacionesSeleccionadas();
		dialogReservar.setVisible(false);
		dialogRegistrar = new JDialog();
		dialogRegistrar.setTitle("Reservar habitaciones");
		dialogRegistrar.setSize(800, 600);
		dialogRegistrar.setLocationRelativeTo(null);
		panelRegistroIngreso = new PanelRegistroIngreso(this);
		dialogRegistrar.add(panelRegistroIngreso);
		dialogRegistrar.setVisible(true);

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
		String infoRep = panelRegistroIngreso.getInfoRep();
		List<String> infoAcomp = panelRegistroIngreso.getInfoAcompaniantes();
		String fechaInicio = panelReservar.getFechaInicio();
		String fechaFin = panelReservar.getFechaFin();
		padre.reservar(listHabs, infoRep, infoAcomp, fechaInicio, fechaFin);
	}

}
