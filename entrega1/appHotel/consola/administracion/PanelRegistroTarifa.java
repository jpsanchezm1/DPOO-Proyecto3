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

public class PanelRegistroTarifa extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String REGISTRAR = "Registrar";

	private JComboBox<String> tipoCuarto;
	private JTextField fechaInicial;
	private JComboBox<String> diasSemana;
	private JTextField fechaFinal;
	private InterfazAdministracion padreAdministracion;

	public PanelRegistroTarifa(InterfazAdministracion padre) {

		super(padre, "Registro de Habitación", true);
		this.padreAdministracion = padre;

		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setPreferredSize(new Dimension(460, 400));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 25, 15));

		// --------------------panel Norte----------------------------------------

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.magenta);
		panelNorte.setPreferredSize(new Dimension(460, 60));

		panelPrincipal.add(panelNorte, BorderLayout.NORTH);

		// ------------------- panel Centro --------------------------------------

		JPanel panelTarifa = new JPanel();
		panelTarifa.setBackground(Color.RED);
		panelTarifa.setLayout(new BoxLayout(panelTarifa, BoxLayout.Y_AXIS));
		panelTarifa.setPreferredSize(new Dimension(460, 340));

		panelPrincipal.add(panelTarifa, BorderLayout.CENTER);

		// ------------------Titulo-------------------------------------------

		JPanel panelTitulo = new JPanel(new BorderLayout());
		panelTitulo.setBackground(Color.WHITE);

		JLabel labelTitulo = new JLabel("Tarifa");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(labelTitulo, BorderLayout.NORTH);

		panelTarifa.add(panelTitulo);

		// -------------------------------TIPO-------------------------

		TitledBorder bordeId = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Id habitacion");
		bordeId.setTitleJustification(TitledBorder.LEFT);
		bordeId.setTitlePosition(TitledBorder.TOP);

		JPanel panelIdentificadorJPanel = new JPanel(new GridLayout(1, 1));
		panelIdentificadorJPanel.setBorder(bordeId);
		panelIdentificadorJPanel.setBackground(Color.WHITE);

		fechaInicial = new JTextField();
		fechaInicial.setBorder(BorderFactory.createEmptyBorder());
		panelIdentificadorJPanel.add(fechaInicial);

		panelTarifa.add(panelIdentificadorJPanel);
		panelTarifa.add(Box.createRigidArea(new Dimension(40, 10)));

		// -------------------------------FECHA INICIAL--------------------------

		TitledBorder bordeTipo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Tipo de habitacion");
		bordeTipo.setTitleJustification(TitledBorder.LEFT);
		bordeTipo.setTitlePosition(TitledBorder.TOP);

		JPanel panelTipo = new JPanel(new GridLayout(1, 1));
		panelTipo.setBorder(bordeTipo);
		panelTipo.setBackground(Color.WHITE);

		String[] opciones = { "estandar", "suite", "suite doble" };
		tipoCuarto = new JComboBox<>(opciones);
		tipoCuarto.setBackground(Color.WHITE);
		panelTipo.add(tipoCuarto);

		panelTarifa.add(panelTipo);
		panelTarifa.add(Box.createRigidArea(new Dimension(40, 10)));

		// -------------------------------FECHA FINAL--------------------------

		TitledBorder bordeCapacidad = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Capacidad");
		bordeCapacidad.setTitleJustification(TitledBorder.LEFT);
		bordeCapacidad.setTitlePosition(TitledBorder.TOP);

		JPanel panelCapacidad = new JPanel(new GridLayout(1, 1));
		panelCapacidad.setBorder(bordeCapacidad);
		panelCapacidad.setBackground(Color.WHITE);

		fechaFinal = new JTextField();
		fechaFinal.setBorder(BorderFactory.createEmptyBorder());
		panelCapacidad.add(fechaFinal);

		panelTarifa.add(panelCapacidad);
		panelTarifa.add(Box.createRigidArea(new Dimension(40, 10)));

		// -------------------------------DIAS SEMANA--------------------------

		TitledBorder bordeDescripcion = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Descripcion (caracteristicas separadas por comas)");
		bordeDescripcion.setTitleJustification(TitledBorder.LEFT);
		bordeDescripcion.setTitlePosition(TitledBorder.TOP);

		JPanel panelDescripcion = new JPanel(new GridLayout(1, 1));
		panelDescripcion.setBorder(bordeDescripcion);
		panelDescripcion.setBackground(Color.WHITE);

		diasSemana = new JComboBox<>(opciones);
		diasSemana.setBackground(Color.white);
		panelDescripcion.add(diasSemana);

		panelTarifa.add(panelDescripcion);
		panelTarifa.add(Box.createRigidArea(new Dimension(40, 10)));

		// -------------------------------Boton--------------------------

		JButton bRegistrar = new JButton(REGISTRAR);
		bRegistrar.addActionListener(this);
		bRegistrar.setActionCommand(REGISTRAR);
		panelTarifa.add(bRegistrar);

		// -------------------------------------------------------------------

		setContentPane(panelPrincipal);
		pack();
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
