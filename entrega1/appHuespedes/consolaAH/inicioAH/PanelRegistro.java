package consolaAH.inicioAH;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import consolaAH.InterfazPrincipal;

public class PanelRegistro extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String REGISTRAR = "Registrar";
	private JTextField usuarioTextField;
	private JPasswordField passwordField;
	private JButton bRegistrar;
	private JLabel titleJLabel;
	private InterfazPrincipal principal;

	public PanelRegistro(InterfazPrincipal p) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300, 300));
		setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

		this.principal = p;

		add(Box.createRigidArea(new Dimension(40, 30)));

		JPanel titlePanel = new JPanel(new BorderLayout());
		titleJLabel = new JLabel("Crear Cuenta");
		titlePanel.add(titleJLabel, BorderLayout.CENTER);
		add(titlePanel);

		add(Box.createRigidArea(new Dimension(40, 30)));

		JPanel usuarioPanel = new JPanel(new BorderLayout());
		JLabel lUsuario = new JLabel("Usuario: ");
		usuarioPanel.add(lUsuario, BorderLayout.WEST);
		add(usuarioPanel);

		add(Box.createRigidArea(new Dimension(40, 10)));

		usuarioTextField = new JTextField();
		usuarioTextField.setPreferredSize(new Dimension(80, 30));
		add(usuarioTextField);

		add(Box.createRigidArea(new Dimension(40, 10)));

		

		add(Box.createRigidArea(new Dimension(40, 10)));

		JPanel contraseniaPanel = new JPanel(new BorderLayout());
		JLabel lContrasenia = new JLabel("Contrasenia: ");
		contraseniaPanel.add(lContrasenia, BorderLayout.WEST);
		add(contraseniaPanel);

		add(Box.createRigidArea(new Dimension(40, 10)));

		passwordField = new JPasswordField();
		passwordField.setEchoChar('�');
		passwordField.setPreferredSize(new Dimension(40, 30));
		add(passwordField);

		add(Box.createRigidArea(new Dimension(40, 35)));

		bRegistrar = new JButton(REGISTRAR);
		bRegistrar.setPreferredSize(new Dimension(100, 40));
		bRegistrar.setAlignmentX(CENTER_ALIGNMENT);
		bRegistrar.addActionListener(this);
		add(bRegistrar);

		add(Box.createRigidArea(new Dimension(40, 30)));
	}

	public String getUsuarioTextField() {
		return this.usuarioTextField.getText();
	}

	public String getPasswordField() {
		char[] caracteres = this.passwordField.getPassword();
		String contraseniaString = new String(caracteres);
		return contraseniaString;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(REGISTRAR)) {

			String usuario = usuarioTextField.getText();
			String contrasenia = getPasswordField();

			try {
				principal.registrarUsuario(usuario, contrasenia);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}
}
