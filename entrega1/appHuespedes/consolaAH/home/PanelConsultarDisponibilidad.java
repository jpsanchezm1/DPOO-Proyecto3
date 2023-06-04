package consolaAH.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class PanelConsultarDisponibilidad extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField fechaInicio;
	private JTextField fechaFin;
	private JList<String> listaHabitaciones;
	private DefaultListModel<String> modelo;
	private PanelBotonesConsDisp panelBotones;

	public PanelConsultarDisponibilidad(InterfazHome p) {

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 200));
		setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
		
		//Panel arriba
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new BoxLayout(panelNorte, BoxLayout.Y_AXIS));
		
		panelNorte.add(Box.createRigidArea(new Dimension(40, 10)));
		
		JLabel labelIndicacion1 = new JLabel("Digite el rango y luego oprima consultar (formato de fecha:  yyyy-mm-dd)");
		labelIndicacion1.setOpaque(true);
		labelIndicacion1.setBackground(Color.LIGHT_GRAY);
		labelIndicacion1.setFont(new Font("Arial",Font.BOLD,14));
		labelIndicacion1.setAlignmentX(LEFT_ALIGNMENT);
		panelNorte.add(labelIndicacion1);
		
		panelNorte.add(Box.createRigidArea(new Dimension(40, 10)));
		
		JPanel fechas = new JPanel();
		fechas.setLayout(new GridLayout(1, 0));
		fechas.setAlignmentX(LEFT_ALIGNMENT);

		JLabel lFechaInicial = new JLabel("Fecha inicial:");
		fechaInicio = new JTextField();
		fechaInicio.setMaximumSize(new Dimension(80, 30));
		JLabel lFechaFin = new JLabel("Fecha fin:");
		fechaFin = new JTextField();
		fechaFin.setPreferredSize(new Dimension(80, 30));

		fechas.add(lFechaInicial);
		fechas.add(fechaInicio);
		fechas.add(Box.createRigidArea(new Dimension(10, 30)));
		fechas.add(lFechaFin);
		fechas.add(fechaFin);

		panelNorte.add(fechas, BorderLayout.NORTH);
		
		panelNorte.add(Box.createRigidArea(new Dimension(40, 10)));
		
		add(panelNorte, BorderLayout.NORTH);
		
		//Panel centro
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		panelCentro.setPreferredSize(new Dimension(100, 100));
		
		panelCentro.add(Box.createRigidArea(new Dimension(40, 30)));
		
		JLabel labelIndicacion2 = new JLabel("A continuación seleccione las habitaciones que quiera reservar y oprima Reservar");
		labelIndicacion2.setOpaque(true);
		labelIndicacion2.setBackground(Color.LIGHT_GRAY);
		labelIndicacion2.setFont(new Font("Arial",Font.BOLD,14));
		labelIndicacion2.setAlignmentX(LEFT_ALIGNMENT);
		panelCentro.add(labelIndicacion2);
		
		panelCentro.add(Box.createRigidArea(new Dimension(30, 15)));

		modelo = new DefaultListModel<>();

		listaHabitaciones = new JList<>(modelo);
		listaHabitaciones.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listaHabitaciones.setCellRenderer(new CustomListCellRenderer());

		JScrollPane scrollPane = new JScrollPane(listaHabitaciones);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(100, 100));
		scrollPane.setAlignmentX(LEFT_ALIGNMENT);
		panelCentro.add(scrollPane);

		add(panelCentro);
		
		//Panel abajo
		JPanel pAbajo = new JPanel();
		pAbajo.setLayout(new BorderLayout());
		panelBotones = new PanelBotonesConsDisp(p);
		pAbajo.add(panelBotones, BorderLayout.EAST);

		add(pAbajo, BorderLayout.SOUTH);

	}

	private class CustomListCellRenderer extends DefaultListCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			// Aumentar el tamaño del texto
			Font font = component.getFont();
			component.setFont(font.deriveFont(font.getSize() + 7.0f));

			return component;
		}
	}

	public void addToList(String item) {
		modelo.addElement(item);
	}
	
	public String getFechaInicio() {
		return fechaInicio.getText();
	}
	
	public String getFechaFin() {
		return fechaFin.getText();
	}
	
	public List<Integer> getHabitacionesSeleccionadas(){
		ArrayList<Integer> idsSelec = new ArrayList<>();
		for (String info : listaHabitaciones.getSelectedValuesList()) {
			int index = info.indexOf(" ");
			String idSring = info.substring(0, index);
			idsSelec.add(Integer.parseInt(idSring));
		}
		
		return idsSelec;
	}

}
