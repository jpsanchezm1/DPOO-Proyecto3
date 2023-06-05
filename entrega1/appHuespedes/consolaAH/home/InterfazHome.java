package consolaAH.home;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import consolaAH.InterfazPrincipal;

public class InterfazHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout = new CardLayout();
	private PanelConsultarDisponibilidad panelConsDisp;
	private PanelReservar panelReservar;
	// private PanelConsultarHabitaciones opcionConsultar;
	private InterfazPrincipal principal;

	public InterfazHome(InterfazPrincipal p) {

		this.principal = p;
		Container contentPane = getContentPane();
		contentPane.setLayout(cardLayout);
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		getContentPane().setBackground(Color.DARK_GRAY);
		setResizable(false);
		setLocationRelativeTo(null); // Centra la ventana en la pantalla

		this.panelConsDisp = new PanelConsultarDisponibilidad(this);
		contentPane.add(panelConsDisp, "Consultar disponibilidad");

		this.panelReservar = new PanelReservar(this);
		contentPane.add(panelReservar, "Reservar habitacion");

		// Configuraci�n del layout
		// setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

	}

	public void mostrarPanelConsDisp() {

		cardLayout.show(getContentPane(), "Consultar disponibilidad");
	}

	public void mostrarPanelReservar() {

		cardLayout.show(getContentPane(), "Reservar habitacion");
	}

	public void consultarHabitacionesDisp() {
		List<String> infoHabs = principal.consultarHabitacionesDisponibles(panelConsDisp.getFechaInicio(),
				panelConsDisp.getFechaFin());
		for (String hab : infoHabs) {
			panelConsDisp.addToList(hab);
		}
	}

	public void reservarHabitaciones() {

		ArrayList<Integer> habsSeleccionadas = (ArrayList<Integer>) panelConsDisp.getHabitacionesSeleccionadas();
		String infoRep = panelReservar.getInfoRep();
		List<String> infoAcomp = panelReservar.getInfoAcompaniantes();
		String fechaInicio = panelConsDisp.getFechaInicio();
		String fechaFin = panelConsDisp.getFechaFin();
		principal.reservar(habsSeleccionadas, infoRep, infoAcomp, fechaInicio, fechaFin);
	}

}
