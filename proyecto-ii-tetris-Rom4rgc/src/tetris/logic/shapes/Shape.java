package tetris.logic.shapes;

import tetris.logic.Point2D;
import java.awt.Color;

/**
 * Interfaz con lo métodos para todas las figuras
 * de Tetris.
 */
public interface Shape {
    public Point2D[] move(Point2D dxy);
    public Point2D[] getInitialShape();
    public void rotateRigth();
    public void rotateLeft();
    public Color getFillColor();
    public Color getBorderColor();
    public void reset();
}
