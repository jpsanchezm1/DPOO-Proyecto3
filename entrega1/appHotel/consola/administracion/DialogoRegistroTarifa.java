package consola.administracion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

public class DialogoRegistroTarifa extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String REGISTRAR = "Registrar";
	private JComboBox<String> tipoCuarto;
	private JDateChooser fechaFinal;
	private JDateChooser fechaInicial;
	private JCheckBox[] checkBoxes;
	private JTextField precio;
	private InterfazAdministracion padreAdministracion;

	public DialogoRegistroTarifa(InterfazAdministracion padre) {
		super(padre, "Registro de Habitación", true);
		this.padreAdministracion = padre;

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setPreferredSize(new Dimension(400, 360));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 25, 15));

		JPanel panelTitulo = new JPanel(new BorderLayout());
		panelTitulo.setBackground(Color.WHITE);

		JLabel labelTitulo = new JLabel("Tarifa");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(labelTitulo, BorderLayout.NORTH);

		panelPrincipal.add(panelTitulo);

		TitledBorder bordeTipo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Tipo de habitacion");
		bordeTipo.setTitleJustification(TitledBorder.LEFT);
		bordeTipo.setTitlePosition(TitledBorder.TOP);

		JPanel panelTipo = new JPanel(new GridLayout(1, 1));
		panelTipo.setBorder(bordeTipo);
		panelTipo.setBackground(Color.WHITE);

		String[] tipos = { "estandar", "suite", "suite doble" };
		tipoCuarto = new JComboBox<>(tipos);
		tipoCuarto.setBackground(Color.WHITE);
		panelTipo.add(tipoCuarto);

		panelPrincipal.add(panelTipo);
		panelPrincipal.add(Box.createRigidArea(new Dimension(40, 10)));

		// -------------------------------FECHA INICIAL--------------------------

		TitledBorder bordeFechaInicial = BorderFactory
				.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Fecha inicial");
		bordeFechaInicial.setTitleJustification(TitledBorder.LEFT);
		bordeFechaInicial.setTitlePosition(TitledBorder.TOP);

		JPanel panelFechaInicial = new JPanel(new GridLayout(1, 1));
		panelFechaInicial.setBorder(bordeFechaInicial);
		panelFechaInicial.setBackground(Color.WHITE);

		fechaInicial = new JDateChooser();
		fechaInicial.setBorder(BorderFactory.createEmptyBorder());
		panelFechaInicial.add(fechaInicial);

		panelPrincipal.add(panelFechaInicial);
		panelPrincipal.add(Box.createRigidArea(new Dimension(40, 10)));

		TitledBorder bordeFechaFinal = BorderFactory
				.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Fecha final");
		bordeFechaFinal.setTitleJustification(TitledBorder.LEFT);
		bordeFechaFinal.setTitlePosition(TitledBorder.TOP);

		JPanel panelFechaFinal = new JPanel(new GridLayout(1, 1));
		panelFechaFinal.setBorder(bordeFechaFinal);
		panelFechaFinal.setBackground(Color.WHITE);

		fechaFinal = new JDateChooser();
		fechaFinal.setBorder(BorderFactory.createEmptyBorder());
		panelFechaFinal.add(fechaFinal);

		panelPrincipal.add(panelFechaFinal);
		panelPrincipal.add(Box.createRigidArea(new Dimension(40, 10)));

		TitledBorder bordeDias = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Dias de la semana");
		bordeDias.setTitleJustification(TitledBorder.LEFT);
		bordeDias.setTitlePosition(TitledBorder.TOP);

		JPanel panelDias = new JPanel(new GridLayout(1, 1));
		panelDias.setBorder(bordeDias);
		panelDias.setBackground(Color.WHITE);

		String[] nombresDias = { "L", "M", "I", "J", "V", "S", "D" };
		checkBoxes = new JCheckBox[nombresDias.length];

		for (int i = 0; i < nombresDias.length; i++) {
			JCheckBox checkBox = new JCheckBox(nombresDias[i]);
			checkBoxes[i] = checkBox;
			panelDias.add(checkBox);
		}

		panelPrincipal.add(panelDias);
		panelPrincipal.add(Box.createRigidArea(new Dimension(40, 10)));

		TitledBorder bordePrecio = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Precio");
		bordePrecio.setTitleJustification(TitledBorder.LEFT);
		bordePrecio.setTitlePosition(TitledBorder.TOP);

		JPanel panelPrecio = new JPanel(new GridLayout(1, 1));
		panelPrecio.setBorder(bordePrecio);
		panelPrecio.setBackground(Color.WHITE);

		precio = new JTextField();
		precio.setBorder(BorderFactory.createEmptyBorder());
		panelPrecio.add(precio);

		panelPrincipal.add(panelPrecio);
		panelPrincipal.add(Box.createRigidArea(new Dimension(40, 10)));

		JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBoton.setBackground(Color.WHITE);
		JButton bRegistrar = new JButton(REGISTRAR);
		bRegistrar.addActionListener(this);
		bRegistrar.setActionCommand(REGISTRAR);
		panelBoton.add(bRegistrar);

		panelPrincipal.add(panelBoton);

		setContentPane(panelPrincipal);
		pack();
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(REGISTRAR)) {
			try {
				String tipo = tipoCuarto.getSelectedItem().toString();

				Date fechainicial = fechaInicial.getDate();
				Date fechafinal = fechaFinal.getDate();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String fechaInicialTexto = dateFormat.format(fechainicial);
				String fechaFinalTexto = dateFormat.format(fechafinal);

				StringBuilder diasSeleccionados = new StringBuilder();

				for (JCheckBox checkBox : checkBoxes) {
					if (checkBox.isSelected()) {
						if (diasSeleccionados.length() > 0) {
							diasSeleccionados.append("-");
						}
						diasSeleccionados.append(checkBox.getText());
					}
				}

				String diasSeleccionadosResultado = diasSeleccionados.toString();

				String precioT = precio.getText();

				String infoTarifa = tipo + ";" + fechaInicialTexto + ";" + fechaFinalTexto + ";"
						+ diasSeleccionadosResultado + ";" + precioT;
				padreAdministracion.registrarTarifa(infoTarifa);
				dispose();
			} catch (Exception e2) {
				e2.getMessage();
				e2.printStackTrace();
			}

		}
	}

}
