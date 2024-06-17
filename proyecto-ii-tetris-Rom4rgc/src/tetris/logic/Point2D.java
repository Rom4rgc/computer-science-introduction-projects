package tetris.logic;

public class Point2D {
    private int x;
    private int y;

    public Point2D() {
        this(0, 0);
    }
    
    public Point2D(int x, int y) {
        // Completar
        this.x = x;
        this.y = y;
    }

    public int getX() {
        // Completar
        return this.x;
    }

    public void setX(int x) {
        // Completar
        this.x = x;
    }

    public int getY() {
        // Completar
        return this.y;

    }

    public void setY(int y) {
        // Completar
        this.y = y;
    }

    /*
     * Regresa un nuevo punto en donde el resultado es la suma coordenada
     * a coordenada del objecto que invoca y de la instacia other.
     */
    public Point2D add(Point2D other) {
        int newX = this.x + other.getX();
        int newY = this.y + other.getY();
        return new Point2D(newX, newY);
    }
}
