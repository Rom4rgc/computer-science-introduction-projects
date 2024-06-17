/*
 * Free.
 */
package ciencias.icc.tortugafx.log;

import java.util.logging.ConsoleHandler;

/**
 * Manda los mensajes de la bitácora a la terminal.
 * @author blackzafiro
 */
public class LogConsola extends ConsoleHandler {
	
	public LogConsola() {
		this.setOutputStream(System.out);
	}
}
