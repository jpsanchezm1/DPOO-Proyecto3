package consola.recepcion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPagarReserva extends JPanel implements ActionListener {
	
	private static final String VOLVER = "Volver";
	private static final long serialVersionUID = 1L;
	private JButton bVolver;
	
	public PanelPagarReserva() {
		
		
		bVolver = new JButton(VOLVER);
		bVolver.addActionListener(this);
		bVolver.setActionCommand(VOLVER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
