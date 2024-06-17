package tetris.logic.shapes;

import tetris.logic.Point2D;
import java.awt.Color;

public class Tetrimino3 implements Shape {
    private static final int N_ROTATIONS = 4;
    private Color fillColor;
    private Color borderColor;
    private int nTiles;
    private Point2D[][] rotation;
    private int currentRotationIndex;

    public Tetrimino3() {
        this.nTiles = 4;
        this.fillColor = new Color(0, 191, 255);
        this.borderColor = new Color(135, 206, 250);
        this.currentRotationIndex = 0;
        this.rotation = new Point2D[Tetrimino3.N_ROTATIONS][this.nTiles];
 
        // Rotate 0 degrees 
        this.rotation[0] = new Point2D[] {
            new Point2D(0, 0),
            new Point2D(0, 1),
            new Point2D(0, 2),
            new Point2D(0, 3)
        };
        // Rotate 90 degrees 
        this.rotation[1] = new Point2D[]{
            new Point2D(0, 0),
            new Point2D(1, 0),
            new Point2D(2, 0),
            new Point2D(3, 0)
        };
        // Rotate 180 degrees 
        this.rotation[2] = new Point2D[]{
            new Point2D(0, 0),
            new Point2D(0, 1),
            new Point2D(0, 2),
            new Point2D(0, 3)
        };
        // Rotate 270 degrees
        this.rotation[3] = new Point2D[]{
            new Point2D(0, 0),
            new Point2D(1, 0),
            new Point2D(2, 0),
            new Point2D(3, 0)
        };
    }

    public void rotateRigth() {
        this.currentRotationIndex = (this.currentRotationIndex + 1) % Tetrimino3.N_ROTATIONS;
    }

    public void rotateLeft() {
        this.currentRotationIndex = (Tetrimino3.N_ROTATIONS + this.currentRotationIndex - 1) % Tetrimino3.N_ROTATIONS;
    }

    public Point2D[] getInitialShape() {
        // Used to clone the points
        return this.move(new Point2D());
    }

    public Point2D[] move(Point2D dxy) {
        Point2D[] newLocation = new Point2D[this.nTiles];
        for (int i = 0; i < newLocation.length; i++) {
            newLocation[i] = this.rotation[this.currentRotationIndex][i].add(dxy);
        }

        return newLocation;
    }

    public Color getFillColor(){
        return this.fillColor;
    }

    public Color getBorderColor(){
        return this.borderColor;
    }

    public void reset() {
        this.currentRotationIndex = 0;
    }
}