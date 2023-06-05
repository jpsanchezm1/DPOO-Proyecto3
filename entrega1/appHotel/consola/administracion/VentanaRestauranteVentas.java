package consola.administracion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaRestauranteVentas extends JFrame{

	private static final long serialVersionUID = 1L;
	private InterfazAdministracion interfazAdministracion;
	private PanelBannerVentas panelBannerVentas;
	private PanelOpcionesVentas panelOpcionesVentas;
	
	public VentanaRestauranteVentas(InterfazAdministracion interfazAdministracion) {
		
		this.interfazAdministracion = interfazAdministracion;
		
		setTitle("Ventas Restaurante");
		setSize(750, 450);
		setResizable(false);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.darkGray);
		
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setPreferredSize(new Dimension(750,450));
		panelPrincipal.setBackground(Color.DARK_GRAY);
		
		panelBannerVentas = new PanelBannerVentas(interfazAdministracion, this);

		panelOpcionesVentas = new PanelOpcionesVentas(interfazAdministracion);
		JPanel panelOpsCentrado = new JPanel();
		panelOpsCentrado.setLayout(new GridBagLayout());
		panelOpsCentrado.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panelOpsCentrado.setBackground(Color.DARK_GRAY);
		panelOpsCentrado.add(panelOpcionesVentas);
		
		panelPrincipal.add(panelBannerVentas, BorderLayout.NORTH);
		
		panelPrincipal.add(panelOpsCentrado, BorderLayout.CENTER);

		add(panelPrincipal);

		pack(); 
	    setLocationRelativeTo(null); 
	}

}
