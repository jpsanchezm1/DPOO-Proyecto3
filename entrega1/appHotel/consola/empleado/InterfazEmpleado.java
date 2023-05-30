package consola.empleado;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import consola.InterfazPMS;

public class InterfazEmpleado extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private PanelConsumo panelConsumo;
	private PanelOpciones panelOpciones;
	private InterfazPMS padre;

	public InterfazEmpleado(InterfazPMS padreI) {
		this.padre = padreI;
		setLayout(new GridBagLayout());
		setTitle("Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 600);
		getContentPane().setBackground(Color.DARK_GRAY);
		setResizable(false);
		setLocationRelativeTo(null); // Centra la ventana en la pantalla

		panelOpciones = new PanelOpciones(this);
		panelConsumo = new PanelConsumo(this);
		panelConsumo.setTitle("Registrar Consumos");
		// panelConsumo.setSize(700, 600);
		panelConsumo.setLocationRelativeTo(null);
		add(panelOpciones);
		// panelConsumo.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("Registrar")) {
			panelOpciones.setVisible(true);
			String categoria = panelConsumo.categoria();
			String pago = panelConsumo.pago();
			String id = panelConsumo.id();
			String referencia = panelConsumo.referencia();
			try {
				padre.registrarConsumo(categoria, id, referencia, pago);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void mostrarPanelConsumo() {
		panelConsumo.setVisible(true);
	}
}