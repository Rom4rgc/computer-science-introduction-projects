/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Sphere;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.util.Random;


public class Astro {
	
	/**
	 * Panel sobre el cual se dibuja este astro y sus satélites.
	 */
	protected Pane nodo;
	
	/**
	 * Figura que representa a este astro.
	 */
	protected Sphere figura;
	
	/**
	 * Constructor.
	 * @param diametro Pixeles de diámetro.
	 */
	public Astro(double diametro) {
		AnchorPane root = new AnchorPane();
		root.setStyle("-fx-background-color: #333333;");
		nodo = new StackPane();
		nodo.setMaxSize(100, 100);
		figura = new Sphere(diametro);
   		PhongMaterial color = new PhongMaterial();
    	color.setDiffuseColor(Color.YELLOW);
    	figura.setMaterial(color);
		nodo.getChildren().add(figura);
		root.getChildren().add(nodo);
		}	
	
	/**
	 * Devuelve al panel sobre el cual se dibujará este astro y sus satélites.
	 * @return nodo
	 */
	public Pane getNodo() {
		return nodo;
	}
	
	/**
	 * Devuelve el nodo figura que dibuja a este astro.
	 * Sus coordenadas son relativas al panel que la contiene.
	 * @return 
	 */
	public Node getFigura() {
		return figura;
	}
	
}
