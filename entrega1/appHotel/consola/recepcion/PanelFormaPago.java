package consola.recepcion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelFormaPago extends JPanel implements ActionListener{
	
	private static final String TARJETA = "Tarjeta";
	private static final String EFECTIVO = "Efectivo";
	private static final long serialVersionUID = 1L;
	private JButton bEfectivo = new JButton(EFECTIVO);
	private JButton bTarjeta = new JButton(TARJETA);
	private JPanel padre;
	private CardLayout clPadre;
	
	public PanelFormaPago(JPanel padre,CardLayout p) {
		
		this.padre = padre;
		clPadre = p;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(Box.createRigidArea(new Dimension(60, 50)));
		
		JLabel lPregunta = new JLabel("¿Que forma de pago?");
		lPregunta.setAlignmentX(LEFT_ALIGNMENT);
		lPregunta.setOpaque(true);
		lPregunta.setBackground(Color.LIGHT_GRAY);
		add(lPregunta);
		
		add(Box.createRigidArea(new Dimension(20, 10)));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setAlignmentX(LEFT_ALIGNMENT);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		bEfectivo.addActionListener(this);
		bEfectivo.setActionCommand(EFECTIVO);
		bTarjeta.addActionListener(this);
		bTarjeta.setActionCommand(TARJETA);
		
		panelBotones.add(bEfectivo);
		panelBotones.add(Box.createRigidArea(new Dimension(30, 50)));
		panelBotones.add(bTarjeta);
		
		add(panelBotones);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if(comando.equals(EFECTIVO)) {
			JOptionPane.showConfirmDialog(this, "Se ha realizado el pago con exito","",JOptionPane.DEFAULT_OPTION);
			
		}
		else if (comando.equals(TARJETA)) {
			clPadre.show(padre, "Pagar con tarjeta");
		}
		
	}

}
