package consola.recepcion;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.io.IOException;
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
	private PanelRegistrarSalida opcionRegistrarSalida;
	private PanelConsultarHabitaciones opcionConsultar;
	private JDialog dialogRegistrar;
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

		dialogReservar = new JDialog();
		dialogReservar.setTitle("Reservar habitaciones");
		dialogReservar.setSize(700, 600);
		dialogReservar.setLocationRelativeTo(null);
		this.panelReservar = new PanelReservar(this);
		dialogReservar.add(panelReservar);

		dialogRegistrar = new JDialog();
		dialogReservar.setTitle("Reservar habitaciones");
		dialogReservar.setSize(700, 600);
		dialogReservar.setLocationRelativeTo(null);

		// Configuraci�n del layout
		// setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

	}

	public void mostrarPanelReservar() {
		// TODO Auto-generated method stub
		dialogReservar.setVisible(true);
	}

	public void mostrarPanelRegistrar() {
		// TODO Auto-generated method stub
		dialogReservar.setVisible(false);
		dialogRegistrar.setVisible(true);

	}

	public void consultarHabitacionesDisp() {
		List<String> infoHabs = padre.consultarHabitacionesDisponibles(panelReservar.getFechaInicio(),panelReservar.getFechaFin());
		for (String hab : infoHabs) {
			panelReservar.addToList(hab);
		}
	}
	
	public void reservarHabitaciones() {
		ArrayList<Integer> habsSeleccionadas = (ArrayList<Integer>) panelReservar.getHabitacionesSeleccionadas();
		
		for (int id : habsSeleccionadas) {
			System.out.println(id);
		}
	}

}
