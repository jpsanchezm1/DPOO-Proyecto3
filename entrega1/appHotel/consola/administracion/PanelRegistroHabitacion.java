package consola.administracion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class PanelRegistroHabitacion extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String REGISTRAR = "Registrar";
	private JTextField textIdentificador;
	private JTextField textCapacidad;
	private JComboBox<String> comboBox;
	private JTextField textDescripcion;
	private InterfazAdministracion padreAdministracion;

	public PanelRegistroHabitacion(InterfazAdministracion padre) {
		super(padre, "Registro de Habitación", true);
		this.padreAdministracion = padre;

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setPreferredSize(new Dimension(360, 300));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 25, 15));

		// ---------------------------------------------------------------------

		JPanel panelTitulo = new JPanel(new BorderLayout());
		panelTitulo.setBackground(Color.WHITE);

		JLabel labelTitulo = new JLabel("Habitacion");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(labelTitulo, BorderLayout.NORTH);

		panelPrincipal.add(panelTitulo);

		// -------------------------------IDENTIFICADOR-------------------------

		TitledBorder bordeId = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Id habitacion");
		bordeId.setTitleJustification(TitledBorder.LEFT);
		bordeId.setTitlePosition(TitledBorder.TOP);

		JPanel panelIdentificadorJPanel = new JPanel(new GridLayout(1, 1));
		panelIdentificadorJPanel.setBorder(bordeId);
		panelIdentificadorJPanel.setBackground(Color.WHITE);

		textIdentificador = new JTextField();
		textIdentificador.setBorder(BorderFactory.createEmptyBorder());
		panelIdentificadorJPanel.add(textIdentificador);

		panelPrincipal.add(panelIdentificadorJPanel);
		panelPrincipal.add(Box.createRigidArea(new Dimension(40, 10)));

		// -------------------------------TIPO--------------------------

		TitledBorder bordeTipo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Tipo de habitacion");
		bordeTipo.setTitleJustification(TitledBorder.LEFT);
		bordeTipo.setTitlePosition(TitledBorder.TOP);

		JPanel panelTipo = new JPanel(new GridLayout(1, 1));
		panelTipo.setBorder(bordeTipo);
		panelTipo.setBackground(Color.WHITE);

		String[] opciones = { "estandar", "suite", "suite doble" };
		comboBox = new JComboBox<>(opciones);
		comboBox.setBackground(Color.WHITE);
		panelTipo.add(comboBox);

		panelPrincipal.add(panelTipo);
		panelPrincipal.add(Box.createRigidArea(new Dimension(40, 10)));

		// -------------------------------CAPACIDAD--------------------------

		TitledBorder bordeCapacidad = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Capacidad");
		bordeCapacidad.setTitleJustification(TitledBorder.LEFT);
		bordeCapacidad.setTitlePosition(TitledBorder.TOP);

		JPanel panelCapacidad = new JPanel(new GridLayout(1, 1));
		panelCapacidad.setBorder(bordeCapacidad);
		panelCapacidad.setBackground(Color.WHITE);

		textCapacidad = new JTextField();
		textCapacidad.setBorder(BorderFactory.createEmptyBorder());
		panelCapacidad.add(textCapacidad);

		panelPrincipal.add(panelCapacidad);
		panelPrincipal.add(Box.createRigidArea(new Dimension(40, 10)));

		// -------------------------------DESCRIPCION--------------------------

		TitledBorder bordeDescripcion = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Descripcion (caracteristicas separadas por comas)");
		bordeDescripcion.setTitleJustification(TitledBorder.LEFT);
		bordeDescripcion.setTitlePosition(TitledBorder.TOP);

		JPanel panelDescripcion = new JPanel(new GridLayout(1, 1));
		panelDescripcion.setBorder(bordeDescripcion);
		panelDescripcion.setBackground(Color.WHITE);

		textDescripcion = new JTextField();
		textDescripcion.setBorder(BorderFactory.createEmptyBorder());
		panelDescripcion.add(textDescripcion);

		panelPrincipal.add(panelDescripcion);
		panelPrincipal.add(Box.createRigidArea(new Dimension(40, 10)));

		// -------------------------------Boton--------------------------

		JButton bRegistrar = new JButton(REGISTRAR);
		bRegistrar.addActionListener(this);
		bRegistrar.setActionCommand(REGISTRAR);
		panelPrincipal.add(bRegistrar);

		setContentPane(panelPrincipal);
		pack();
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(REGISTRAR)) {
			String identificador = textIdentificador.getText();
			String tipo = comboBox.getSelectedItem().toString();
			String capacidad = textCapacidad.getText();
			String descripcion = textDescripcion.getText();
			String infoHabitacion = identificador + ";" + tipo + ";" + capacidad + ";" + descripcion;
			//padreAdministracion.registrarHabitacion(infoHabitacion);
			dispose();
		}

	}
}
