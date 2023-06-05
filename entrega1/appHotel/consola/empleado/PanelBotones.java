package consola.empleado;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel implements ActionListener {

	private static final String REGISTRAR = "Proceder";
	private static final long serialVersionUID = 1L;
	private JButton bRegistrar;
	private InterfazEmpleado padre;

	public PanelBotones(InterfazEmpleado p) {

		padre = p;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		add(Box.createRigidArea(new Dimension(60, 50)));

		bRegistrar = new JButton(REGISTRAR);
		bRegistrar.addActionListener(this);
		bRegistrar.setActionCommand(REGISTRAR);
		add(bRegistrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(REGISTRAR)) {
			padre.mostrarItemsYCantidad();
		}
	}
}
