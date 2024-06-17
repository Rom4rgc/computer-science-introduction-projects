/*
 * Free.
 */
package ciencias.icc.tortugafx.log;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * Sólo imprime lo necesario para información de depuración durante el
 * desarrollo del código.
 * @author blackzafiro
 */
public class Formateador extends SimpleFormatter {
	
	/**
	 * Cadena con la información básica del registro para la bitácora.
	 * @param record
	 * @return 
	 */
	public String format(LogRecord record) {
		return String.format("[%s]: %s%n", record.getLoggerName(),
		                                 record.getMessage());
	}
}
