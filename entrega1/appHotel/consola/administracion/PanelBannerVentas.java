package consola.administracion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBannerVentas extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static final String ATRAS = "Atras";
	private InterfazAdministracion interfazAdministracion;
	private VentanaRestauranteVentas ventasRestauranteVentas;
	
	public PanelBannerVentas(InterfazAdministracion abuelo, VentanaRestauranteVentas padre) {
		
		this.interfazAdministracion = abuelo;
		this.ventasRestauranteVentas = padre;
		new BorderLayout();
		setPreferredSize(new Dimension(700, 70));
		setBackground(Color.WHITE);
		
		JPanel panelBienvenido = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBienvenido.setPreferredSize(new Dimension(500,70));
		panelBienvenido.setBackground(Color.WHITE);
		JLabel bannerLabel = new JLabel("Ventas Restaurante Hotel");
		bannerLabel.setFont(new Font("Arial", Font.BOLD, 27));
		panelBienvenido.add(bannerLabel);
		
		JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBoton.setPreferredSize(new Dimension(100,70));
		panelBoton.setBackground(Color.WHITE);
        JButton bSalir = new JButton(ATRAS);
        bSalir.addActionListener(this);
        bSalir.setActionCommand(ATRAS);
        panelBoton.add(bSalir);
        
        add(panelBienvenido, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		String comando = e.getActionCommand();

		if (comando.equals(ATRAS)) {
			ventasRestauranteVentas.dispose();
			interfazAdministracion.setVisible(true);
		}
	}

	
}
