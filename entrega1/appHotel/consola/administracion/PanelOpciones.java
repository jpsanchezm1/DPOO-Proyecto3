package consola.administracion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String CARGAR_HABITACIONES = "Cargar habitaciones";
	private static final String CARGAR_TARIFAS = "Cargar tarifas";
	private static final String CARGAR_MENU = "Cargar menu restaurante";
	private static final String REGISTRAR_HABITACION = "Registrar habitacion";
	private static final String REGISTRAR_TARIFA = "Registrar tarifa";
	private static final String CARGAR_SERVICIOS = "Cargar servicios";
	private static final String VENTAS_RESTAURANTE = "Ventas restaurante";
	private JButton bCargarHabitaciones, bCargarTarifas, bCargarMenu, bRegistrarHabitacion, bRegistrarTarifa,
			bCargarServicios,bVentasRestaurante;
	private InterfazAdministracion interfazAdministracion;

	public PanelOpciones(InterfazAdministracion interfaz) {
		interfazAdministracion = interfaz;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(750, 400));
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.darkGray);
		panelNorte.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 10));
		panelNorte.setLayout(new BoxLayout(panelNorte, BoxLayout.X_AXIS));

		bCargarHabitaciones = new JButton(CARGAR_HABITACIONES);
		bCargarHabitaciones.setMaximumSize(new Dimension(200, 50));
		bCargarHabitaciones.addActionListener(this);
		bCargarHabitaciones.setActionCommand(CARGAR_HABITACIONES);
		panelNorte.add(bCargarHabitaciones);

		panelNorte.add(Box.createRigidArea(new Dimension(40, 50)));

		bCargarTarifas = new JButton(CARGAR_TARIFAS);
		bCargarTarifas.setMaximumSize(new Dimension(200, 50));
		bCargarTarifas.addActionListener(this);
		bCargarTarifas.setActionCommand(CARGAR_TARIFAS);
		panelNorte.add(bCargarTarifas);

		panelNorte.add(Box.createRigidArea(new Dimension(40, 50)));

		bCargarMenu = new JButton(CARGAR_MENU);
		bCargarMenu.setMaximumSize(new Dimension(200, 50));
		bCargarMenu.addActionListener(this);
		bCargarMenu.setActionCommand(CARGAR_MENU);
		panelNorte.add(bCargarMenu);

		add(panelNorte);

		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.darkGray);
		panelSur.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 10));
		panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.X_AXIS));

		bRegistrarHabitacion = new JButton(REGISTRAR_HABITACION);
		bRegistrarHabitacion.setMaximumSize(new Dimension(200, 50));
		bRegistrarHabitacion.addActionListener(this);
		bRegistrarHabitacion.setActionCommand(REGISTRAR_HABITACION);
		panelSur.add(bRegistrarHabitacion);

		panelSur.add(Box.createRigidArea(new Dimension(40, 50)));

		bRegistrarTarifa = new JButton(REGISTRAR_TARIFA);
		bRegistrarTarifa.setMaximumSize(new Dimension(200, 50));
		bRegistrarTarifa.addActionListener(this);
		bRegistrarTarifa.setActionCommand(REGISTRAR_TARIFA);
		panelSur.add(bRegistrarTarifa);

		panelSur.add(Box.createRigidArea(new Dimension(40, 50)));

		bCargarServicios = new JButton(CARGAR_SERVICIOS);
		bCargarServicios.setMaximumSize(new Dimension(200, 50));
		bCargarServicios.addActionListener(this);
		bCargarServicios.setActionCommand(CARGAR_SERVICIOS);
		panelSur.add(bCargarServicios);
		
		panelSur.add(Box.createRigidArea(new Dimension(40, 50)));

		bVentasRestaurante = new JButton(VENTAS_RESTAURANTE);
		bVentasRestaurante.setMaximumSize(new Dimension(200, 50));
		bVentasRestaurante.addActionListener(this);
		bVentasRestaurante.setActionCommand(VENTAS_RESTAURANTE);
		panelSur.add(bVentasRestaurante);

		add(panelSur);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(CARGAR_HABITACIONES)) {
			try {
				interfazAdministracion.cargarHabitaciones();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (comando.equals(CARGAR_TARIFAS)) {
			interfazAdministracion.cargarTarifas();
		}

		if (comando.equals(CARGAR_MENU)) {
			interfazAdministracion.cargarMenu();
		}

		if (comando.equals(REGISTRAR_HABITACION)) {
			interfazAdministracion.mostrarRegistroHabitacion();
		}

		if (comando.equals(REGISTRAR_TARIFA)) {
			interfazAdministracion.mostrarRegistroTarifa();
		}

		if (comando.equals(CARGAR_SERVICIOS)) {
			interfazAdministracion.cargarServicios();
		}
		
		if (comando.equals(VENTAS_RESTAURANTE)) {
			interfazAdministracion.mostrarVentanaRestauranteVentas();
		}
	}

}
