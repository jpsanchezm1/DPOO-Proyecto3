package consola.recepcion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRegistrarSalida extends JPanel implements ActionListener{
	
	private static final String VOLVER = "Volver";
	private static final String CONSULTAR = "Consultar";
	private static final long serialVersionUID = 1L;
	private InterfazRecepcion principal;
	private JTextField id;
	private JButton bConsultar;
	private PanelPagarReserva panelPagarReserva;
	
	public PanelRegistrarSalida(InterfazRecepcion p) {
		
		principal = p;

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 300));
		setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 0));

		JLabel lIndicacion = new JLabel("Digite el ID del huesped:");
		panelNorte.add(lIndicacion);
		
		id = new JTextField();
		id.setMaximumSize(new Dimension(80, 30));
		panelNorte.add(id);
		
		bConsultar = new JButton(CONSULTAR);
		bConsultar.addActionListener(this);
		bConsultar.setActionCommand(CONSULTAR);
		bConsultar.setMaximumSize(new Dimension(30,35));
		panelNorte.add(bConsultar);


		add(panelNorte, BorderLayout.NORTH);
		
		//Centro
		CardLayout cl = new CardLayout();
		JPanel panelCentro = new JPanel(cl);
		
		PanelFormaPago panelFormaPago = new PanelFormaPago(panelCentro,cl);
		panelPagarReserva = new PanelPagarReserva();
		
		panelCentro.add(panelFormaPago, "Forma de pago");
		panelCentro.add(panelPagarReserva, "Pagar con tarjeta");
		
		add(panelCentro);

		JPanel pAbajo = new JPanel();
		pAbajo.setPreferredSize(new Dimension(800,80));
		pAbajo.setLayout(new BorderLayout());
		
		add(pAbajo, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if(comando.equals(CONSULTAR)) {
			principal.existeReserva(id.getText());
		}
		else if (comando.equals(VOLVER)) {
			
		}
		
	}

}
