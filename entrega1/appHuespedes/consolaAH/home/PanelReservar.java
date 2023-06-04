package consolaAH.home;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class PanelReservar extends JPanel {
	private InterfazHome principal;
	private JTextField nombreField;
	private JTextField idField;
	private JTextField numCelularField;
	private JTextField correoField;
	private JToggleButton bSi;
	private JToggleButton bNo;
	private List<JTextField[]> acompaniantesFields;
	private JButton bAgregarAcompaniante;
	private JButton bRealizarRegistros;
	private boolean acompaniantes;
	private JButton bVolver;

	public PanelReservar(InterfazHome p) {
		
		principal = p;
		
		setPreferredSize(new Dimension(500, 500));
		setLayout(null);

		// Información del representante
		JLabel repLabel = new JLabel("Informacion del representante");
		repLabel.setBounds(10, 10, 200, 20);
		add(repLabel);

		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(10, 40, 60, 20);
		add(nombreLabel);
		nombreField = new JTextField();
		nombreField.setBounds(70, 40, 130, 20);
		add(nombreField);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(210, 40, 20, 20);
		add(idLabel);
		idField = new JTextField();
		idField.setBounds(230, 40, 100, 20);
		add(idField);

		JLabel numCelularLabel = new JLabel("Celular:");
		numCelularLabel.setBounds(340, 40, 68, 20);
		add(numCelularLabel);
		numCelularField = new JTextField();
		numCelularField.setBounds(388, 40, 100, 20);
		add(numCelularField);

		JLabel correoLabel = new JLabel("Correo:");
		correoLabel.setBounds(488, 40, 60, 20);
		add(correoLabel);
		correoField = new JTextField();
		correoField.setBounds(538, 40, 200, 20);
		add(correoField);

		// Pregunta sobre acompañantes
		JLabel acompaniantesLabel = new JLabel("�Tiene acompaniantes?");
		acompaniantesLabel.setBounds(10, 95, 200, 20);
		add(acompaniantesLabel);

		bSi = new JToggleButton("Sí");
		bSi.setBounds(10, 120, 80, 25);
		bSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableAcompaniantesFields(true);
				acompaniantes = true;
			}
		});
		add(bSi);

		bNo = new JToggleButton("No"); // Cambiamos JButton por JToggleButton
		bNo.setBounds(100, 120, 80, 25);
		bNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableAcompaniantesFields(false);
				acompaniantes = false;
			}
		});
		add(bNo);

		// Acompañantes
		JLabel acompLabel = new JLabel("Informacion de los acompaniantes");
		acompLabel.setBounds(10, 180, 220, 20);
		add(acompLabel);

		acompaniantesFields = new ArrayList<>();

		// Crear 3 líneas de acompañantes por defecto y añadirlas a la lista
		for (int i = 0; i < 3; i++) {
			JTextField[] nuevoAcompanianteFields = createAcompanianteFields(10, 210 + i * 30);
			acompaniantesFields.add(nuevoAcompanianteFields);
			addAcompanianteFields(nuevoAcompanianteFields);
		}

		bAgregarAcompaniante = new JButton("Agregar Acompañante");
		bAgregarAcompaniante.setBounds(10, 220 + 3 * 30, 200, 25);
		bAgregarAcompaniante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lastY = acompaniantesFields.get(acompaniantesFields.size() - 1)[0].getY();
				JTextField[] nuevoAcompanianteFields = createAcompanianteFields(10, lastY + 30);
				acompaniantesFields.add(nuevoAcompanianteFields);
				addAcompanianteFields(nuevoAcompanianteFields);
				bAgregarAcompaniante.setLocation(bAgregarAcompaniante.getX(),
						bAgregarAcompaniante.getY() + 30);
				bRealizarRegistros.setLocation(bRealizarRegistros.getX(),
						bRealizarRegistros.getY() + 30);
				revalidate();
				repaint();
				enableAcompaniantesFields(true);
			}
		});
		bAgregarAcompaniante.setEnabled(false);
		add(bAgregarAcompaniante);

		bRealizarRegistros = new JButton("Realizar registros");
		bRealizarRegistros.setBounds(bAgregarAcompaniante.getX() + bAgregarAcompaniante.getWidth() + 10,
				bAgregarAcompaniante.getY(), 150, 25);
		bRealizarRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarRegistros();
			}
		});
		add(bRealizarRegistros);

		enableAcompaniantesFields(false);
		
		bVolver = new JButton("Volver");
		bVolver.setBounds(bRealizarRegistros.getX() + bRealizarRegistros.getWidth() + 10, bRealizarRegistros.getY(), 150, 25);
		bVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.mostrarPanelConsDisp();
			}
		});
		add(bVolver);
		
	}

	private JTextField[] createAcompanianteFields(int x, int y) {
		JTextField[] fields = new JTextField[4];

		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(x, y, 60, 20);
		add(nombreLabel);
		fields[0] = new JTextField();
		fields[0].setBounds(x + 70, y, 130, 20);
		fields[0].setEnabled(false);
		add(fields[0]);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(x + 210, y, 20, 20);
		add(idLabel);
		fields[1] = new JTextField();
		fields[1].setBounds(x + 230, y, 100, 20);
		fields[1].setEnabled(false);
		add(fields[1]);

		JLabel numCelularLabel = new JLabel("Celular:");
		numCelularLabel.setBounds(x + 340, y, 68, 20);
		add(numCelularLabel);
		fields[2] = new JTextField();
		fields[2].setBounds(x + 408, y, 100, 20);
		fields[2].setEnabled(false);
		add(fields[2]);

		JLabel correoLabel = new JLabel("Correo:");
		correoLabel.setBounds(x + 518, y, 60, 20);
		add(correoLabel);
		fields[3] = new JTextField();
		fields[3].setBounds(x + 578, y, 190, 20);
		fields[3].setEnabled(false);
		add(fields[3]);

		return fields;
	}

	private void addAcompanianteFields(JTextField[] fields) {
		for (JTextField field : fields) {
			add(field);
		}
	}

	private void enableAcompaniantesFields(boolean enable) {
		for (JTextField[] fields : acompaniantesFields) {
			for (JTextField field : fields) {
				field.setEnabled(enable);
			}
		}

		bAgregarAcompaniante.setEnabled(enable);
	}

	public String getInfoRep() {
		String nombre = nombreField.getText();
		String id = idField.getText();
		String numCelular = numCelularField.getText();
		String correo = correoField.getText();

		return nombre + ";" + id + ";" + numCelular + ";" + correo;
	}

	public List<String> getInfoAcompaniantes() {
		List<String> acompaniantesInfo = new ArrayList<>();
		if (acompaniantes) {
			for (JTextField[] fields : acompaniantesFields) {
				boolean completos = true;
				String nombre = fields[0].getText();
				completos = !(nombre.equals(""));
				String id = fields[1].getText();
				completos = completos && !(id.equals(""));
				String numCelular = fields[2].getText();
				completos = completos && !(numCelular.equals(""));
				String correo = fields[3].getText();
				completos = completos && !(correo.equals(""));
				String acompanianteInfo = nombre + ";" + id + ";" + numCelular + ";" + correo;
				if (completos) {
					acompaniantesInfo.add(acompanianteInfo);
				}
			}
		}
		return acompaniantesInfo;
	}

	public void realizarRegistros() {
		boolean camposRepresentanteCompletos = !(nombreField.getText().isEmpty()) && !(idField.getText().isEmpty())
				&& !(numCelularField.getText().isEmpty()) && !(correoField.getText().isEmpty());

		if (!camposRepresentanteCompletos) {
			JOptionPane.showMessageDialog(this, "La información del representante no está completa", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (acompaniantes) {
			for (JTextField[] fields : acompaniantesFields) {
				int conteo = 0;
				conteo = (fields[0].getText().isEmpty()) ? conteo + 1 : conteo;
				conteo = (fields[1].getText().isEmpty()) ? conteo + 1 : conteo;
				conteo = (fields[2].getText().isEmpty()) ? conteo + 1 : conteo;
				conteo = (fields[3].getText().isEmpty()) ? conteo + 1 : conteo;

				if (conteo != 0 && conteo != 4) {
					JOptionPane.showMessageDialog(this,
							"Las filas de los acompañantes no están completos. "
									+ "Complete o vacíe aquellas en las que insertó información.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}

		int option = JOptionPane.showConfirmDialog(this, "¿Desea verificar la información?", "Verificación",
				JOptionPane.YES_NO_OPTION);

		if (option == JOptionPane.NO_OPTION) {
			principal.reservarHabitaciones();
		}
	}
}
