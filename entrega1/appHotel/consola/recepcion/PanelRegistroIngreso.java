package consola.recepcion;

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
public class PanelRegistroIngreso extends JPanel {
	private InterfazRecepcion padre;
	private JTextField nombreField;
	private JTextField idField;
	private JTextField numCelularField;
	private JTextField correoField;
	private JToggleButton siButton;
	private JToggleButton noButton;
	private List<JTextField[]> acompaniantesFields;
	private JButton agregarAcompanianteButton;
	private JButton realizarRegistrosButton;
	private boolean acompaniantes;

	public PanelRegistroIngreso(InterfazRecepcion padre) {
		this.padre = padre;
		setPreferredSize(new Dimension(500, 500));
		setLayout(null);

		// Información del representante
		JLabel repLabel = new JLabel("Información del representante");
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
		JLabel acompaniantesLabel = new JLabel("¿Tiene acompañantes?");
		acompaniantesLabel.setBounds(10, 95, 200, 20);
		add(acompaniantesLabel);

		siButton = new JToggleButton("Sí");
		siButton.setBounds(10, 120, 80, 25);
		siButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableAcompaniantesFields(true);
				acompaniantes = true;
			}
		});
		add(siButton);

		noButton = new JToggleButton("No"); // Cambiamos JButton por JToggleButton
		noButton.setBounds(100, 120, 80, 25);
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableAcompaniantesFields(false);
				acompaniantes = false;
			}
		});
		add(noButton);

		// Acompañantes
		JLabel acompLabel = new JLabel("Información de los acompañantes");
		acompLabel.setBounds(10, 180, 220, 20);
		add(acompLabel);

		acompaniantesFields = new ArrayList<>();

		// Crear 3 líneas de acompañantes por defecto y añadirlas a la lista
		for (int i = 0; i < 3; i++) {
			JTextField[] nuevoAcompanianteFields = createAcompanianteFields(10, 210 + i * 30);
			acompaniantesFields.add(nuevoAcompanianteFields);
			addAcompanianteFields(nuevoAcompanianteFields);
		}

		agregarAcompanianteButton = new JButton("Agregar Acompañante");
		agregarAcompanianteButton.setBounds(10, 220 + 3 * 30, 200, 25);
		agregarAcompanianteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lastY = acompaniantesFields.get(acompaniantesFields.size() - 1)[0].getY();
				JTextField[] nuevoAcompanianteFields = createAcompanianteFields(10, lastY + 30);
				acompaniantesFields.add(nuevoAcompanianteFields);
				addAcompanianteFields(nuevoAcompanianteFields);
				agregarAcompanianteButton.setLocation(agregarAcompanianteButton.getX(),
						agregarAcompanianteButton.getY() + 30);
				realizarRegistrosButton.setLocation(realizarRegistrosButton.getX(),
						realizarRegistrosButton.getY() + 30);
				revalidate();
				repaint();
				enableAcompaniantesFields(true);
			}
		});
		agregarAcompanianteButton.setEnabled(false);
		add(agregarAcompanianteButton);

		realizarRegistrosButton = new JButton("Realizar registros");
		realizarRegistrosButton.setBounds(agregarAcompanianteButton.getX() + agregarAcompanianteButton.getWidth() + 10,
				agregarAcompanianteButton.getY(), 150, 25);
		realizarRegistrosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarRegistros();
			}
		});
		add(realizarRegistrosButton);

		enableAcompaniantesFields(false);
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
		fields[3].setBounds(x + 578, y, 200, 20);
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

		agregarAcompanianteButton.setEnabled(enable);
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
			padre.reservarHabitaciones();
		}
	}
}