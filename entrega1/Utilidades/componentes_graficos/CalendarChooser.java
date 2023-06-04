package componentes_graficos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class CalendarChooser {
	private JDateChooser botonFechaInicio = new JDateChooser();
	private JDateChooser botonFechaFin = new JDateChooser();
	private Object[] options = { "OK" };
	private Object[] messages = { "Desde:", botonFechaInicio, "Hasta:", botonFechaFin };
	private LocalDate fechaInicioLD;
	private LocalDate fechaFinLD;

	public CalendarChooser() {
		int result = javax.swing.JOptionPane.showOptionDialog(null, messages, "Seleccione las fechas",
				javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.PLAIN_MESSAGE, null, options,
				options[0]);

		if (result == javax.swing.JOptionPane.OK_OPTION) {
			Date fechaInicio = botonFechaInicio.getDate();
			Date fechaFin = botonFechaFin.getDate();

			this.fechaInicioLD = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			this.fechaFinLD = fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}
	}
	
	public LocalDate getFechaFinLD() {
		return fechaFinLD;
	}
	
	public LocalDate getFechaInicioLD() {
		return fechaInicioLD;
	}
}
