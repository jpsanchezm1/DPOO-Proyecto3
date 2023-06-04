package consolaAH.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelReservar extends JPanel implements ActionListener{
	
	private static final String VOLVER = "Volver";
	private static final long serialVersionUID = 1L;
	private JButton botonVolver;
	private InterfazHome principal;

	public PanelReservar(InterfazHome p) {
		
		principal = p;
		
		JLabel labelPrueba = new JLabel("Quibo chamo, aqui reserva");
		add(labelPrueba);
		
		botonVolver = new JButton("VolverChamo");
		botonVolver.addActionListener(this);
		botonVolver.setActionCommand(VOLVER);
		add(botonVolver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();

		if (comando.equals(VOLVER)) {
			principal.mostrarPanelConsDisp();
		}
		
	}

}
