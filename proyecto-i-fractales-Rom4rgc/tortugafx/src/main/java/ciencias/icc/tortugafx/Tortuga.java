/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 *
 * Se permite utilizarlo de forma personal para fines didácticos, pero no está
 * permitido transferirlo.
 */
package ciencias.icc.tortugafx;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * Tortuga para dibujar en el lienzo.
 * @author blackzafiro
 */
public class Tortuga {
	
	protected final static Logger LOGGER = Logger.getLogger("ciencias.icc.tortugafx.Tortuga");
	static { LOGGER.setLevel(Level.FINE); }
	
	private AnchorPane tortuguero;
	private Canvas canvas;
	private GraphicsContext gc;
	
	private static final int LADO_TORTUGA = 40;
	private ImageView figTortuga;
	private boolean plumaAbajo = true;
	
	/**
	 * Tortuga con una imagen que la representa, vive en el tortuguero y puede
	 * dibujar sobre el lienzo.
	 * @param tortuguero 
	 */
	public Tortuga(AnchorPane tortuguero) {
		LOGGER.log(Level.FINER, "Constructor ");
		this.tortuguero = tortuguero;
		this.canvas = (Canvas)(tortuguero.getChildren().get(0));
		this.gc = canvas.getGraphicsContext2D();
		
		figTortuga = new ImageView(getClass().getResource("tortuguita.png").toString());
		figTortuga.setFitWidth(LADO_TORTUGA);
		figTortuga.setFitHeight(LADO_TORTUGA);
		figTortuga.setX((tortuguero.getWidth() - LADO_TORTUGA) / 2);
		figTortuga.setY(tortuguero.getHeight() / 2);
		
		LOGGER.log(Level.FINER, "Constructor " + figTortuga);
		tortuguero.getChildren().add(figTortuga);
		LOGGER.log(Level.FINER, "Se añadió ");
	}
	
	/**
	 * Quita la imagen de esta tortuga del tortuguero. Se pensó para ser llamado
	 * justo antes de borrar las tortugas, de modo que no queden zombies.
	 */
	public void remuevete() {
		tortuguero.getChildren().remove(figTortuga);
	}
	
	/**
	 * Coordenada x donde se dibujará en el canvas.
	 * @return x
	 */
	private double x() {
		return figTortuga.getX() + figTortuga.getTranslateX() + LADO_TORTUGA/2;
	}
	
	/**
	 * Coordenada y donde se dibujará en el canvas.
	 * @return y
	 */
	private double y() {
		return figTortuga.getY() + figTortuga.getTranslateY() + LADO_TORTUGA/2;
	}
	
	/**
	 * Sube y baja la pluma. Cuando la pluma está abajo la tortuga se desplaza
	 * sin pintar.
	 * @param estaAbajo 
	 */
	public void plumaAbajo(boolean estaAbajo) {
		plumaAbajo = estaAbajo;
	}
	
	/**
	 * Mueve a la tortuga en la dirección en la que apunta.
	 * @param distancia en pixeles.
	 */
	public void avanza(double distancia) {
		/*
		* TODO: La tortuga debería salir por un lado y regresar por el otro,
		* actualmente sólo se sale de la pantalla.
		* TODO: Crear una animación para ver caminando a la tortuga mientras dibuja.
		*/
		LOGGER.log(Level.FINER, String.format("(%f, %f):%f Translate d = (%f, %f) - (%f, %f) yLay = %f",
				figTortuga.getX(),
				figTortuga.getY(),
				figTortuga.getRotate(),
				figTortuga.getTranslateX(),
				figTortuga.getTranslateY(),
				figTortuga.getX() + figTortuga.getTranslateX(),
				figTortuga.getY() + figTortuga.getTranslateY(),
				figTortuga.getLayoutY()));
		double xIni = x(), yIni = y();
		double ang = Math.toRadians(figTortuga.getRotate() + 90);
		double lenX = -distancia * Math.cos(ang);
		double lenY = -distancia * Math.sin(ang);
		figTortuga.setTranslateX(figTortuga.getTranslateX() + lenX);
		figTortuga.setTranslateY(figTortuga.getTranslateY() + lenY);
		double xFin = x(), yFin = y();
		
		if(plumaAbajo) {
			gc.strokeLine(xIni, yIni, xFin, yFin);
		}
		LOGGER.log(Level.FINER, String.format("(%f, %f):%f Translate d = (%f, %f) - (%f, %f) yLay = %f",
				figTortuga.getX(),
				figTortuga.getY(),
				figTortuga.getRotate(),
				figTortuga.getTranslateX(),
				figTortuga.getTranslateY(),
				figTortuga.getX() + figTortuga.getTranslateX(),
				figTortuga.getY() + figTortuga.getTranslateY(),
				figTortuga.getLayoutY()));
	}
	
	/**
	 * Gira la tortuga según el plano cartesiano.
	 * A la izquierda si <code>grados</code> es positivo y a la derecha si es
	 * negativo.
	 * @param grados 
	 */
	public void rota(double grados) {
		figTortuga.setRotate(figTortuga.getRotate() - grados);
	}
	
	/**
	 * Asigna el color con el que pintará la tortuga.
	 * @param color 
	 */
	public void asignaColor(Color color) {
		gc.setStroke(color);
	}
	
}
