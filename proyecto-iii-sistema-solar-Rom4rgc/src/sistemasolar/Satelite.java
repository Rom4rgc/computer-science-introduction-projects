/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;



/**
 * Clase que describe astros que giran alrededor de otro.
 * @author blackzafiro
 */
public class Satelite extends Astro {
	
	// Escala para dibujar a los planetas
	private static final double ESCALA_RADIO = 10.0;
	private static final double ESCALA_ORBITA = 400.0;
	private static final double ESCALA_ORBITA_SATELITE = ESCALA_RADIO * 2;
	private static final double ESCALA_TIEMPO = 7.0;
	
	/**
	 * Datos de cada planeta y satélite.
	 * Deben ser ficticios, pues de otro modo la simulación no cabe en pantalla.
	 */

	public enum DatosSatelite {
          
			MERCURIO(0.4, 0.134, 0.133, 0.3),
			VENUS(0.95, 0.164, 0.163, 0.4),
			TIERRA(1.0, 0.274, 0.273, 1.0),
			LUNA(0.22, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.094),
			MARTE(0.8, 0.394, 0.393, 1.2),
			JUPITER(2, 0.594, 0.593, 1.5),
			SATJUPIO(0.22, ESCALA_ORBITA_SATELITE * 0.005, ESCALA_ORBITA_SATELITE * 0.0045, 0.05),
			SATJUPEUROPA(0.22, ESCALA_ORBITA_SATELITE * 0.0051, ESCALA_ORBITA_SATELITE * 0.0046, 0.06),
			SATJUPGANYMEDE(0.22, ESCALA_ORBITA_SATELITE * 0.0052, ESCALA_ORBITA_SATELITE * 0.0047, 0.07),
			SATJUPCALLISTO(0.22, ESCALA_ORBITA_SATELITE * 0.0053, ESCALA_ORBITA_SATELITE * 0.0048, 0.08),
			SATURNO(1.8, 0.794, 0.793, 2),
			URANO(1.5, 0.934, 0.933, 2.4),
			NEPTUNO(1.2, 1.054, 1.053, 2.6),
			PLUTON(0.5, 1.5, 1.4, 2.8);


		
		private final double diametroEcuatorial;
		private final double semiejeMayor;
		private final double semiejeMenor;
		private final double periodoOrbital;		
		
		DatosSatelite(double diametroEcuatorial,
			      double semiejeMayor, double semiejeMenor,
			      double periodoOrbital) {
			this.diametroEcuatorial = diametroEcuatorial;
			this.semiejeMayor = semiejeMayor;
			this.semiejeMenor = semiejeMenor;
			this.periodoOrbital = periodoOrbital;
		}
	}
	
	/// Inician atributos
	
	private final DatosSatelite datos;
	private OrbitaTransition orbita;
	private Astro foco;
	private double orbitaInclinacion = 0.0;

	
	
	/// Inician métodos
        
	/**
	 * Astro alrededor del cual gira este satélite.
	 * @return astro alrededor del cual girar este satélite.
	 */
	public Astro getFoco() {
		return foco;
	}
	
	/**
	 * Crea la órbita de este planea y lo pone a girar alrededor del foco.
	 */
	private void creaOrbita(Astro foco) {
		foco.getNodo().getChildren().add(this.nodo);
		this.foco = foco;
		
		orbita = new OrbitaTransition(this,
					      datos.semiejeMayor * ESCALA_ORBITA,
					      datos.semiejeMenor * ESCALA_ORBITA,
					      datos.periodoOrbital * ESCALA_TIEMPO
		);
		orbita.play();
	}
	// Método para establecer la órbita de Plutón con inclinación
    public void setOrbitaInclinacion(double inclinacion) {
    	this.orbitaInclinacion = inclinacion;
	}

	// Método para obtener la inclinación de la órbita de Plutón
    public double getOrbitaInclinacion() {
        return this.orbitaInclinacion;
	}
	
	/**
	 * Constructor.
	 * @param datos información del astro y su órbita.
	 * @param foco astro alrededor del cual gira este satélite.
	 */
	public Satelite(DatosSatelite datos, Astro foco) {
		super(datos.diametroEcuatorial * ESCALA_RADIO);
		this.datos = datos;
		creaOrbita(foco);
		PhongMaterial material = new PhongMaterial();
        switch (datos) {
            case MERCURIO:
                material.setDiffuseColor(Color.GRAY);
                break;
            case VENUS:
                material.setDiffuseColor(Color.LIGHTGOLDENRODYELLOW);
                break;
            case TIERRA:
                material.setDiffuseColor(Color.BLUE);
                break;
            case LUNA:
                material.setDiffuseColor(Color.GRAY);
                break;
            case MARTE:
                material.setDiffuseColor(Color.RED);
                break;
            case JUPITER:
                material.setDiffuseColor(Color.DARKORANGE);
                break;
            case SATURNO:
                material.setDiffuseColor(Color.LIGHTGOLDENRODYELLOW);
                break;
            case URANO:
                material.setDiffuseColor(Color.LIGHTBLUE);
                break;
            case NEPTUNO:
                material.setDiffuseColor(Color.DARKBLUE);
                break;
			case SATJUPCALLISTO:
				material.setDiffuseColor(Color.GRAY);
				break;
			case SATJUPEUROPA:
				material.setDiffuseColor(Color.BROWN);
				break;
			case SATJUPIO:
				material.setDiffuseColor(Color.ORANGE);
				break;
			case SATJUPGANYMEDE:
				material.setDiffuseColor(Color.GRAY);
				break;
			case PLUTON:
				material.setDiffuseColor(Color.RED);
				break;
			

        }
        figura.setMaterial(material);
    
	}
	
	/**
	 * Devuelve el nombre de este satélite.
	 * @return nombre
	 */
	public String getNombre() {
		return this.datos.toString();
	}
	public double getCoordenadaX() {
        return this.getNodo().getTranslateX();
    }

    public double getCoordenadaY() {
        return this.getNodo().getTranslateY();
    }
}
