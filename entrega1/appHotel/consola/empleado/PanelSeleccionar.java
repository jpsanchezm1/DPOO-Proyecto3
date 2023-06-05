package consola.empleado;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class PanelSeleccionar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<String> listaItems;
	private DefaultListModel<String> modelo;
	private PanelBotones panelBotones;
	private String categoria;

	public PanelSeleccionar(InterfazEmpleado p ,String categoria, List<String> listaElementos) {
		
		this.categoria = categoria;

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 300));
		setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

		JPanel fechas = new JPanel();
        fechas.setLayout(new GridLayout(2, 1));

        JLabel titulo = new JLabel(categoria);
        JLabel seleccionar = new JLabel("Seleccione los items (mantenga seleccionado cmd o ctr para escoger multiples)");

        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, titulo.getFont().getSize() + 7.0f));
        fechas.add(titulo);

        JPanel seleccionarPanel = new JPanel();
        seleccionarPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        seleccionarPanel.add(seleccionar);
        fechas.add(seleccionarPanel);

        add(fechas, BorderLayout.NORTH);

		modelo = new DefaultListModel<>();
		for (String item : listaElementos) {
			modelo.addElement(item);
		}
		listaItems = new JList<>(modelo);
		listaItems.setMaximumSize(new Dimension(700, 400));
		listaItems.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listaItems.setCellRenderer(new CustomListCellRenderer());

		JScrollPane scrollPane = new JScrollPane(listaItems);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollPane);

		JPanel pAbajo = new JPanel();
		pAbajo.setLayout(new BorderLayout());
		panelBotones = new PanelBotones(p);
		pAbajo.add(panelBotones, BorderLayout.EAST);

		add(pAbajo, BorderLayout.SOUTH);

	}
	
	public String getCategoria() {
		return categoria;
	}

	private class CustomListCellRenderer extends DefaultListCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			// Aumentar el tama�o del texto
			Font font = component.getFont();
			component.setFont(font.deriveFont(font.getSize() + 7.0f));

			return component;
		}
	}

	public List<String> getItemsSeleccionados() {
		ArrayList<String> elementos = new ArrayList<>();
		for (String info : listaItems.getSelectedValuesList()) {
			elementos.add(info);
		}
		return elementos;
	}

}