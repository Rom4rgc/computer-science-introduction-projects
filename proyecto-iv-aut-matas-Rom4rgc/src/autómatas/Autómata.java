/*
 * Autómatas
 */
package autómatas;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;


/**
 *
 * @author blackzafiro
 */
public abstract class Autómata extends AnimationTimer {
    
    protected Group root;
    protected Text text;
    protected long paso = 0;
    protected Text textPaso;
    protected int filas;
    protected int columnas;
    protected VBox controls;


    public Autómata() {
        this.root = new Group ();
        text = new Text ("Inicio");
        text.setStroke(Color.BLACK);
        text.setY(200);
        Line line = new Line(0, 210, 800, 210);
        line.setStroke(Color.BLACK);
        root.getChildren().add(text);
        root.getChildren().add(line);
    }
   
    /**
     * Permite asignar un elemento tipo texto donde
     * el autómata reportará cuántos pasos lleva la 
     * simulación.
     */
    public void setTextPaso(Text text) {
    	textPaso = text;
        textPaso.setText("" + paso);
    }

    public Parent getAutómataNode() {
    	return root;
    }

    @Override
    public void handle(long now) {
    	paso++;
    	if (textPaso != null) textPaso.setText("" + paso);
        text.setText("Tiempo " + now);
    }
    public abstract void showControls();

    public abstract void hideControls();
    
}
