package consola.administracion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpcionesVentas extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static final String VENTAS_PRODUCTO = "Ventas por Producto";
	private static final String FACTURAS_TIEMPO = "Facturas en el tiempo";
	private static final String RES_HAB = "Relacion restaurante-habitaciones";
	private static final String CONSUMOS_TIEMPO = "Consumos en el tiempo";
	private static final String RES_SERV = "Relacion restaurante-servicios";
	private static final String PRODUCTO = "Ventas producto especifico";
	private JButton bVentasProducto, bFacturasTiempo, bResHab, bConsumosTiempo, bResServicio,
	bProductoEspecifico;
	private InterfazAdministracion interfazAdministracion;
	
	public PanelOpcionesVentas(InterfazAdministracion interfazAdministracion) {
		
		this.interfazAdministracion = interfazAdministracion;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.darkGray);
		setPreferredSize(new Dimension(750, 450));
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.darkGray);
		panelNorte.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 10));
		panelNorte.setLayout(new BoxLayout(panelNorte, BoxLayout.X_AXIS));

		bVentasProducto = new JButton(VENTAS_PRODUCTO);
		bVentasProducto.setMaximumSize(new Dimension(200, 50));
		bVentasProducto.addActionListener(this);
		bVentasProducto.setActionCommand(VENTAS_PRODUCTO);
		panelNorte.add(bVentasProducto);

		panelNorte.add(Box.createRigidArea(new Dimension(40, 50)));

		bFacturasTiempo = new JButton(FACTURAS_TIEMPO);
		bFacturasTiempo.setMaximumSize(new Dimension(200, 50));
		bFacturasTiempo.addActionListener(this);
		bFacturasTiempo.setActionCommand(FACTURAS_TIEMPO);
		panelNorte.add(bFacturasTiempo);

		panelNorte.add(Box.createRigidArea(new Dimension(40, 50)));

		bResHab = new JButton(RES_HAB);
		bResHab.setMaximumSize(new Dimension(200, 50));
		bResHab.addActionListener(this);
		bResHab.setActionCommand(RES_HAB);
		panelNorte.add(bResHab);

		add(panelNorte);
		

		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.darkGray);
		panelSur.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 10));
		panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.X_AXIS));

		bConsumosTiempo = new JButton(CONSUMOS_TIEMPO);
		bConsumosTiempo.setMaximumSize(new Dimension(200, 50));
		bConsumosTiempo.addActionListener(this);
		bConsumosTiempo.setActionCommand(CONSUMOS_TIEMPO);
		panelSur.add(bConsumosTiempo);

		panelSur.add(Box.createRigidArea(new Dimension(40, 50)));

		bResServicio = new JButton(RES_SERV);
		bResServicio.setMaximumSize(new Dimension(200, 50));
		bResServicio.addActionListener(this);
		bResServicio.setActionCommand(RES_SERV);
		panelSur.add(bResServicio);

		panelSur.add(Box.createRigidArea(new Dimension(40, 50)));

		bProductoEspecifico = new JButton(PRODUCTO);
		bProductoEspecifico.setMaximumSize(new Dimension(200, 50));
		bProductoEspecifico.addActionListener(this);
		bProductoEspecifico.setActionCommand(PRODUCTO);
		panelSur.add(bProductoEspecifico);
		
		add(panelSur);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equals(VENTAS_PRODUCTO)) {
			interfazAdministracion.ventasConsumo();
		}

		if (comando.equals(FACTURAS_TIEMPO)) {
			//interfazAdministracion.cargarMenu();
		}

		if (comando.equals(RES_HAB)) {
			//interfazAdministracion.mostrarRegistroHabitacion();
		}

		if (comando.equals(CONSUMOS_TIEMPO)) {
			//interfazAdministracion.mostrarRegistroTarifa();
		}

		if (comando.equals(RES_SERV)) {
			//interfazAdministracion.cargarServicios();
		}
		
		if (comando.equals(PRODUCTO)) {
			//interfazAdministracion.mostrarVentanaRestauranteVentas();
		}
	}

}
