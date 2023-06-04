package consola.administracion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import consola.InterfazPMS;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PanelBanner extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static final String SALIR = "Salir";
	private InterfazAdministracion padreAdministracion;
	private InterfazPMS padreInterfazPMS;

	public PanelBanner(InterfazAdministracion padre, InterfazPMS abuelo) {
		this.padreAdministracion = padre;
		this.padreInterfazPMS = abuelo;
		new BorderLayout();
		setPreferredSize(new Dimension(700, 70));
		setBackground(Color.WHITE);
		
		JPanel panelBienvenido = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBienvenido.setPreferredSize(new Dimension(500,70));
		panelBienvenido.setBackground(Color.WHITE);
		JLabel bannerLabel = new JLabel("Bienvenido administrador!");
		bannerLabel.setFont(new Font("Arial", Font.BOLD, 27));
		panelBienvenido.add(bannerLabel);
		
		JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBoton.setPreferredSize(new Dimension(100,70));
		panelBoton.setBackground(Color.WHITE);
        JButton bSalir = new JButton(SALIR);
        bSalir.addActionListener(this);
        bSalir.setActionCommand(SALIR);
        panelBoton.add(bSalir);
        
        add(panelBienvenido, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(SALIR)) {
			padreAdministracion.dispose();
			padreInterfazPMS.setVisible(true);
		}
		
	}
}
