package implementaciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class PayU extends Pasarela {
    @Override
    public void registrarTransaccion(String idCliente, String monto, String numeroTarjeta) {
    	try (BufferedWriter editor = new BufferedWriter(new FileWriter("./data/pasarelas/PayU.txt", true))) {
    		String transaccion = idCliente + ";" + monto + ";" + numeroTarjeta + ";" + LocalDate.now().toString() + ";" + LocalTime.now().toString();
			editor.write(transaccion);
			editor.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
