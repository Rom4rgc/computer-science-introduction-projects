/**
 * Se permite acceder a este código para uso personal, con fines didácticos.
 * No está permitido realizar trabajos derivados directamente de él, para
 * no afectar a otros estudiantes que lo utilicen para sus cursos.
 */
package icc.mundo;

/**
 * Estados que corresponden a las acciones que puede estar
 * realizando el personaje.
 */
public enum Estado {
	Quieto("idle", true),
	Corriendo("run", false),
	Saltando("jump", false);

	/**
	 * Palabra clave para completar el nombre de los
	 * archivos de imágen correspondientes a este
	 * estado.
	 */
	private String nombreId;

	/**
	 * Indica si la animación de este estado se repite
	 * indefinidamente.
	 */
	private boolean cíclico;

	/**
	 * Constructor para los objetos constante.
	 * @param nombreId
	 * @param cíclico
	 */
	Estado(String nombreId, boolean cíclico) {
		this.nombreId = nombreId;
		this.cíclico = cíclico;
	}

	/**
	 * Devuelve el identificador de recursos para el estado.
	 * @return palabra usada para completar el nombre de las
	 *         imágenes asociadas a este estado.
	 */
	public String nombreId() {
		return nombreId;
	}

	/**
	 * Indica si la animación se repite de forma indefinida.
	 * @return si la animación se repite de forma indefinida.
	 */
	public boolean cíclico() {
		return cíclico;
	}
}
