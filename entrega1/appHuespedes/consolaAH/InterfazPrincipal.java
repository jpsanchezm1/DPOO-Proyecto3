package consolaAH;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import consolaAH.home.InterfazHome;
import consolaAH.inicioAH.PanelFormulario;
import consolaAH.inicioAH.PanelInicio;
import consolaAH.inicioAH.PanelRegistro;
import coordinadores.CoordinadorRecepcion;
import modelo.autenticador.Autenticador;
import modelo.habitaciones.ControladorHabitaciones;

public class InterfazPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private PanelFormulario panelFormulario = new PanelFormulario(this);
	private JDialog dialogRegistro;
	private PanelRegistro panelRegistro;
	private InterfazHome home;
	private Autenticador autenticador = new Autenticador();
	private CoordinadorRecepcion coordinadorRecepcion = new CoordinadorRecepcion(new ControladorHabitaciones());

	public InterfazPrincipal() throws IOException {

		setTitle("Huespedes");
		setSize(700, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PanelInicio panelInicio = new PanelInicio(panelFormulario);
		add(panelInicio);

		dialogRegistro = new JDialog();
		dialogRegistro.setLayout(new BorderLayout());
		dialogRegistro.setSize(500, 400);
		dialogRegistro.setLocationRelativeTo(null);
		this.panelRegistro = new PanelRegistro(this);
		dialogRegistro.add(panelRegistro);

		autenticador.crearAutenticadores();
	}

	public static void main(String[] args) throws IOException {
		InterfazPrincipal interfaz = new InterfazPrincipal();
		interfaz.setVisible(true);
	}

	public void mostrarPanelRegistro() {
		dialogRegistro.setVisible(true);
	}

	public void registrarUsuario(String nombreUsuario, String contrasena) throws IOException {
		autenticador.registrarUsuarioAH(nombreUsuario, contrasena);
		dialogRegistro.dispose();
	}

	public void iniciarSesion(String usuario, String contrasenia) throws IOException {

		boolean validarUsuario = autenticador.validarUsuarioAH(usuario);
		boolean validarContrasena = autenticador.validarContrasenaAH(usuario, contrasenia);

		if (validarContrasena && validarUsuario) {
			dispose();
			home = new InterfazHome(this);
			home.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(null, "Usuario y/o contraseña inválidos", "Error de autenticación",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public List<String> consultarHabitacionesDisponibles(String fechaInicio, String fechaFin) {
		return coordinadorRecepcion.consultarHabitaciones(fechaInicio, fechaFin);
	}
	
	public void reservar(ArrayList<Integer> habsSeleccionadas, String infoRep, List<String> infoAcomp,
			String fechaInicio, String fechaFin) {
		coordinadorRecepcion.realizarReserva(habsSeleccionadas, infoRep, infoAcomp, fechaInicio, fechaFin);
	}

}
