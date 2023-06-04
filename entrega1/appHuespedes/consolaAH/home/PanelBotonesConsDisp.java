package consolaAH.home;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesConsDisp extends JPanel implements ActionListener {

	private static final String CONSULTAR = "Consultar";
	private static final String RESERVAR = "Reservar";
	private static final long serialVersionUID = 1L;
	private JButton bConsultar;
	private JButton bReservar;
	private InterfazHome principal;

	public PanelBotonesConsDisp(InterfazHome p) {

		principal = p;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		bConsultar = new JButton(RESERVAR);
		bConsultar.addActionListener(this);
		bConsultar.setActionCommand(RESERVAR);
		add(bConsultar);

		add(Box.createRigidArea(new Dimension(60, 50)));

		bReservar = new JButton(CONSULTAR);
		bReservar.addActionListener(this);
		bReservar.setActionCommand(CONSULTAR);
		add(bReservar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();

		if (comando.equals(RESERVAR)) {
			principal.mostrarPanelReservar();
		}
		else if(comando.equals(CONSULTAR)) {
			principal.consultarHabitacionesDisp();
		}

	}

}
