package consola.empleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private DefaultListModel<String> model;
    private JList<String> itemList;
    private ButtonGroup paymentGroup;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JButton registerButton;
    private InterfazEmpleado padre;

    public ItemPanel(List<String> items, InterfazEmpleado padre) {
    	this.padre = padre;
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300, 300));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel quantityLabel = new JLabel("Ajuste la cantidad a registrar para cada consumible");
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.gridx = 0;
        labelConstraints.gridy = 0;
        labelConstraints.anchor = GridBagConstraints.WEST;
        labelConstraints.insets = new Insets(0, 0, 10, 0);
        add(quantityLabel, labelConstraints);

        model = new DefaultListModel<>();
        for (String item : items) {
            model.addElement("1, " + item);
        }

        itemList = new JList<>(model);
        itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        itemList.setCellRenderer(new QuantityListCellRenderer());

        JScrollPane scrollPane = new JScrollPane(itemList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(scrollPane, constraints);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addQuantity();
            }
        });

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeQuantity();
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(10, 0, 0, 0);
        add(buttonPanel, constraints);

        JPanel paymentPanel = new JPanel(new GridLayout(1, 2));
        paymentGroup = new ButtonGroup();
        yesRadioButton = new JRadioButton("Sí");
        noRadioButton = new JRadioButton("No");
        paymentGroup.add(yesRadioButton);
        paymentGroup.add(noRadioButton);
        paymentPanel.add(new JLabel("Pago:"));
        paymentPanel.add(yesRadioButton);
        paymentPanel.add(noRadioButton);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.insets = new Insets(10, 0, 0, 0);
        add(paymentPanel, constraints);

        registerButton = new JButton("Registrar");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					register();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        JPanel registerPanel = new JPanel();
        registerPanel.add(registerButton);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.insets = new Insets(10, 0, 0, 0);
        add(registerPanel, constraints);
    }

    private void addQuantity() {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedItem = itemList.getSelectedValue();
            String[] parts = selectedItem.split(", ");
            if (parts.length == 2) {
                int quantity = Integer.parseInt(parts[0].trim());
                quantity++;
                String updatedItem = quantity + ", " + parts[1];
                model.set(selectedIndex, updatedItem);
            }
        }
    }

    private void removeQuantity() {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedItem = itemList.getSelectedValue();
            String[] parts = selectedItem.split(", ");
            if (parts.length == 2) {
                int quantity = Integer.parseInt(parts[0].trim());
                if (quantity > 1) {
                    quantity--;
                    String updatedItem = quantity + ", " + parts[1];
                    model.set(selectedIndex, updatedItem);
                }
            }
        }
    }

    private void register() throws IOException {
        String payment;
        if (yesRadioButton.isSelected()) {
            payment = "true";
        } else if (noRadioButton.isSelected()) {
            payment = "false";
        } else {
            payment = null;
        }

        if (payment == null) {
            JOptionPane.showMessageDialog(ItemPanel.this, "No se seleccionó una opción de pago", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String idCliente = JOptionPane.showInputDialog(ItemPanel.this, "Ingrese el ID del cliente:");
            if (idCliente != null && !idCliente.isEmpty()) {
                padre.realizarRegistros(payment, idCliente);
            } else {
                JOptionPane.showMessageDialog(ItemPanel.this, "No se ingresó el ID del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public List<List<String>> getItemList() {
        List<List<String>> itemList = new ArrayList<>();
        for (int i = 0; i < model.getSize(); i++) {
            String item = model.getElementAt(i);
            String[] parts = item.split(", ");
            if (parts.length == 2) {
                List<String> itemInfo = new ArrayList<>();
                itemInfo.add(parts[0].trim());
                itemInfo.add(parts[1]);
                itemList.add(itemInfo);
            }
        }
        return itemList;
    }

    private class QuantityListCellRenderer extends DefaultListCellRenderer {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            label.setFont(label.getFont().deriveFont(Font.PLAIN));

            Font font = label.getFont();
            label.setFont(font.deriveFont(font.getSize() + 3.0f));

            return label;
        }
    }
}


