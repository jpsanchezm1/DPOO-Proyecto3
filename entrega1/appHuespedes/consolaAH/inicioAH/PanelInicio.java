package consolaAH.inicioAH;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Panel auxiliar donde metemos el panelFormulario
public class PanelInicio extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelInicio(PanelFormulario pf) {

		PanelFormulario panelForm = pf;

		// Panel principal
		new BorderLayout();
		setBackground(Color.darkGray);
		setPreferredSize(new Dimension(900, 600));

		// Panel Norte
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.darkGray);
		panelNorte.setPreferredSize(new Dimension(800, 30));

		// Panel oeste 
		JPanel panelImagen = new JPanel(new GridBagLayout());
		panelImagen.setBackground(Color.darkGray);
		panelImagen.setPreferredSize(new Dimension(120, 140));

		JPanel panelOeste = new JPanel();
		panelOeste.setLayout(new GridBagLayout());
		//panelOeste.add(panelImagen);

		ImageIcon logoIcon = new ImageIcon("./data/logoApp/IMG-0410.jpg");
		JLabel etiquetaImagen = new JLabel(logoIcon);
		etiquetaImagen.setPreferredSize(new Dimension(300, 300));
		panelImagen.add(etiquetaImagen);

		// Panel centro
		JPanel panelCentro = new JPanel(new BorderLayout());
		panelCentro.setBackground(Color.darkGray);
		panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		panelCentro.setPreferredSize(new Dimension(500, 430));
		panelCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

		panelCentro.add(panelForm, BorderLayout.CENTER);

		add(panelNorte, BorderLayout.NORTH);
		add(panelOeste, BorderLayout.WEST);
		add(panelCentro, BorderLayout.CENTER);

		setVisible(true);
	}

}
