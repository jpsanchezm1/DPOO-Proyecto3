package implementaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class ControladorPasarelas {
    Map<String, String> pasarelas = new HashMap<>();

    public ControladorPasarelas() {
        try {
            cargarPasarelas();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarPasarelas() throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader("./data/pasarelas/listadoPasarelas.txt"));
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] parametros = linea.split("\\.");
            pasarelas.put(parametros[2], linea);
        }
        lector.close();
    }

    public Set<String> getPasarelasDisponibles() {
        return pasarelas.keySet();
    }

    public void iniciarTransaccion() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Seleccione una pasarela:\n");
        for (String pasarela : pasarelas.keySet()) {
            mensaje.append("- ").append(pasarela).append("\n");
        }
        String seleccion = JOptionPane.showInputDialog(null, mensaje.toString());

        String pasarelaS = pasarelas.get(seleccion);

        if (!seleccion.equals("")) {

            String idCliente = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente:");
            String monto = JOptionPane.showInputDialog(null, "Ingrese el monto:");
            String numeroTarjeta = JOptionPane.showInputDialog(null, "Ingrese el número de tarjeta:");

            Pasarela pasarela = cargarPasarela(pasarelaS);
            if (pasarela != null) {
                pasarela.registrarTransaccion(idCliente, monto, numeroTarjeta);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selección inválida");
        }
    }

    private Pasarela cargarPasarela(String ruta) {
        try {
            Class<?> pasarelaClass = Class.forName(ruta);
            Pasarela pasarelaObj = (Pasarela) pasarelaClass.getDeclaredConstructor(null).newInstance(null);
            return pasarelaObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
		ControladorPasarelas c = new ControladorPasarelas();
		c.iniciarTransaccion();
	}
}
