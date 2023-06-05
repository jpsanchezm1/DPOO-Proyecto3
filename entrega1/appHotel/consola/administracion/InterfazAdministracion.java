package consola.administracion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import consola.InterfazPMS;
import coordinadores.CoordinadorAdministrador;

public class InterfazAdministracion extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelOpciones panelOpciones;
	private PanelBanner panelBanner;
	private DialogoRegistroHabitacion registroHabitacion;
	private CoordinadorAdministrador coordAdministrador;
	private DialogoRegistroTarifa dialogoRegistroTarifa;
	private VentanaRestauranteVentas ventanaRestauranteVentas;
	private static final String CORRECTO = "El archivo se ha cargado correctamente.";
	private static final String CORRECTO_HAB = "La habitacion se ha cargado correctamente.";
	private static final String CORRECTO_TAR = "La tarifa se ha cargado correctamente.";
	private static final String FALLO_CARGA = "No se pudo cargar el archivo";
	private static final String FALLO_txt = "El archivo seleccionado no es un archivo de texto.";
	private static final String CANCELADO = "No se seleccionó ningún archivo.";
	private static final String CANCELADO_DOS = "No se seleccionó el segundo archivo.";
	private static final String CANCELADO_UNO = "No se seleccionó el primer archivo.";
	private InterfazPMS padre;

	public InterfazAdministracion(InterfazPMS padreI) throws IOException {

		this.padre = padreI;
		setTitle("Administracion");
		setSize(750, 450);
		setResizable(false);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);

		coordAdministrador = new CoordinadorAdministrador();
		
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setPreferredSize(new Dimension(750,450));
		panelPrincipal.setBackground(Color.DARK_GRAY);
		
		panelBanner = new PanelBanner(this, padre);

		panelOpciones = new PanelOpciones(this);
		JPanel panelOpsCentrado = new JPanel();
		panelOpsCentrado.setLayout(new GridBagLayout());
		panelOpsCentrado.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panelOpsCentrado.setBackground(Color.DARK_GRAY);
		panelOpsCentrado.add(panelOpciones);
		
		panelPrincipal.add(panelBanner, BorderLayout.NORTH);
		
		panelPrincipal.add(panelOpsCentrado, BorderLayout.CENTER);

		add(panelPrincipal);

		pack(); 
	    setLocationRelativeTo(null); 
	}

	public void cargarHabitaciones() throws IOException {

		JFileChooser archivoHabitaciones = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
		archivoHabitaciones.setFileFilter(filtro);
		archivoHabitaciones.setAcceptAllFileFilterUsed(false);
		archivoHabitaciones.setMultiSelectionEnabled(false);
		int resultado = archivoHabitaciones.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {

			File selectedFile = archivoHabitaciones.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();

			if (filePath.endsWith(".txt")) {
				try {
					coordAdministrador.cargarHabitaciones(filePath);
					JOptionPane.showMessageDialog(null, CORRECTO, "Archivo cargado", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, FALLO_CARGA, "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, FALLO_txt, "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, CANCELADO, "Operación cancelada", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void cargarTarifas() {

		JFileChooser archivoTarifas = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
		archivoTarifas.setFileFilter(filtro);
		archivoTarifas.setAcceptAllFileFilterUsed(false);
		archivoTarifas.setMultiSelectionEnabled(false);
		int resultado = archivoTarifas.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File selectedFile = archivoTarifas.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();

			if (filePath.endsWith(".txt")) {
				try {
					coordAdministrador.cargarTarifas(filePath);
					JOptionPane.showMessageDialog(null, CORRECTO, "Archivo cargado", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, FALLO_CARGA, "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, FALLO_txt, "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, CANCELADO, "Operación cancelada", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void cargarMenu() {
		JFileChooser archivoMenu = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
		archivoMenu.setFileFilter(filtro);
		archivoMenu.setMultiSelectionEnabled(false);

		JOptionPane.showMessageDialog(null,
				"Por favor, selecciona los archivos en el siguiente orden: \n1. Archivo que contenga platos. \n2. Archivo que contenga bebidas.",
				"Instrucciones", JOptionPane.INFORMATION_MESSAGE);

		int resultado = archivoMenu.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File platos = archivoMenu.getSelectedFile();
			String pathPlatos = platos.getAbsolutePath();

			int segundoResultado = archivoMenu.showOpenDialog(this);

			if (segundoResultado == JFileChooser.APPROVE_OPTION) {
				File bebidas = archivoMenu.getSelectedFile();
				String pathBebidas = bebidas.getAbsolutePath();

				if (pathPlatos.endsWith(".txt") && pathBebidas.endsWith(".txt")) {
					try {
						coordAdministrador.cargarMenuRestaurante(pathPlatos, pathBebidas);
						JOptionPane.showMessageDialog(null, CORRECTO, "Archivo cargado",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, FALLO_CARGA, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, CANCELADO_DOS, "Operación cancelada", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, CANCELADO_UNO, "Operación cancelada", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void mostrarRegistroHabitacion() {
		registroHabitacion = new DialogoRegistroHabitacion(this);
		registroHabitacion.setVisible(true);
	}

	public void registrarHabitacion(String infoHabitacion) {
		try {
			coordAdministrador.registrarHabitacion(infoHabitacion);
			JOptionPane.showMessageDialog(null, CORRECTO_HAB, "Habitacion cargada",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			
		}	
	}
	
	public void mostrarRegistroTarifa() {
		dialogoRegistroTarifa = new DialogoRegistroTarifa(this);
		dialogoRegistroTarifa.setVisible(true);
	}

	public void registrarTarifa(String infoTarifa) {
		try {
			coordAdministrador.registrarTarifa(infoTarifa);
			JOptionPane.showMessageDialog(null, CORRECTO_TAR, "Tarifa cargada",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al registrar la tarifa: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cargarServicios() {

		JFileChooser archivoServicios = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
		archivoServicios.setFileFilter(filtro);
		archivoServicios.setMultiSelectionEnabled(false);
		archivoServicios.setAcceptAllFileFilterUsed(false);
		int resultado = archivoServicios.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File selectedFile = archivoServicios.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();

			if (filePath.endsWith(".txt")) {
				try {
					coordAdministrador.cargarServicios(filePath);
					JOptionPane.showMessageDialog(null, CORRECTO, "Archivo cargado", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, FALLO_CARGA, "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, FALLO_txt, "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, CANCELADO, "Operación cancelada", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void mostrarVentanaRestauranteVentas() {
		dispose();
		ventanaRestauranteVentas = new VentanaRestauranteVentas(this);
		ventanaRestauranteVentas.setVisible(true);
	}
}
