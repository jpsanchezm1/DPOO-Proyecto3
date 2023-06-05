package consola.empleado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import componentes_graficos.CalendarChooser;

public class PanelOpciones extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static final String CONSUMO_SERVICIO = "Registrar consumo de un servicio";
    private static final String CONSUMO_REST = "Registrar consumo del restaurante";
    private static final String DATE = "DATE";
    private JButton bRegistrarConsumoServicio, bDates, bRegistrarConsumoRest;
    private InterfazEmpleado principalInterfazEmp;

    public PanelOpciones(InterfazEmpleado p) {

        principalInterfazEmp = p;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.darkGray);
        setSize(700, 600);
        add(Box.createRigidArea(new Dimension(60, 50)));

        bRegistrarConsumoServicio = new JButton(CONSUMO_SERVICIO);
        bRegistrarConsumoServicio.addActionListener(this);
        bRegistrarConsumoServicio.setActionCommand(CONSUMO_SERVICIO);
        bRegistrarConsumoServicio.setMaximumSize(new Dimension(300, 50));
        add(bRegistrarConsumoServicio);

        add(Box.createRigidArea(new Dimension(60, 50)));
        
        bRegistrarConsumoRest = new JButton(CONSUMO_REST);
        bRegistrarConsumoRest.addActionListener(this);
        bRegistrarConsumoRest.setActionCommand(CONSUMO_REST);
        bRegistrarConsumoRest.setMaximumSize(new Dimension(300, 50));
        add(bRegistrarConsumoRest);

        add(Box.createRigidArea(new Dimension(60, 50)));

        bDates = new JButton(DATE);
        bDates.addActionListener(this);
        bDates.setActionCommand(DATE);
        bDates.setMaximumSize(new Dimension(300, 50));
        //add(bDates);

        add(Box.createRigidArea(new Dimension(60, 50)));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals(CONSUMO_SERVICIO)) {
            principalInterfazEmp.panelConsumoServicio("Servicios");
        }
        if (comando.equals(CONSUMO_REST)) {
        	principalInterfazEmp.panelConsumoServicio("Restaurante");
        }
        if (comando.equals(DATE)) {
            CalendarChooser c = new CalendarChooser();
            System.out.println(c.getFechaInicioLD().toString());
        }
    }
}

