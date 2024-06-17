package tetris.logic;

import tetris.gui.Window;
import tetris.logic.shapes.Shape;
import tetris.logic.shapes.Tetrimino1;
import tetris.logic.shapes.Tetrimino2;
import tetris.logic.shapes.Tetrimino3;
import tetris.logic.shapes.Tetrimino4;
import tetris.logic.shapes.Tetrimino5;
import tetris.logic.shapes.Tetrimino6;
import tetris.logic.shapes.Tetrimino7;
import tetris.logic.Board;
import tetris.logic.Point2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.util.Random;

/**
 * Lógica del juego de Tetris.
 */
public class Tetris {
    public static final int PIXEL_SIZE = 30;
    private Board board;
    private Shape[] shapes;
    private Point2D currentPoint;
    private Shape currentShape;
    private Random random;
    private boolean isGameOver;
    private int IDShape;
    public int score;

    /**
     * Constructor.
     */
    public Tetris() {
        this.score = 0;
        this.random = new Random();
        this.isGameOver = false;
        this.board = new Board();
            // Insertar Figuras aqui
        
        this.shapes = new Shape[] {
            new Tetrimino2(),
            new Tetrimino1(),
            new Tetrimino3(),
            new Tetrimino4(),
            new Tetrimino5(),
            new Tetrimino6(),
            new Tetrimino7(),
        };
        
        this.currentPoint = new Point2D(4, 0);
        this.IDShape = random.nextInt(shapes.length);
        this.currentShape = this.shapes[this.IDShape];
    }

    /**
     * Puntuación del jugador.
     */
    public int getScore() {
        return this.score;
    }

    private boolean canMoveDown() {
        Point2D[] shapeTiles = this.currentShape.move(this.currentPoint);
        for (int i = 0; i < shapeTiles.length; i++) {
            int x = shapeTiles[i].getX();
            int y = shapeTiles[i].getY();
            // NOTE: 0 in the matrix means empty slot
            if (y + 1 >= Board.HEIGTH || board.get(x, y + 1) != 0) {
                return false;
            }
        }

        return true;
    }

    private boolean canMoveRight() {
        Point2D[] shapeTiles = this.currentShape.move(this.currentPoint);
        for (int i = 0; i < shapeTiles.length; i++) {
            int x = shapeTiles[i].getX();
            int y = shapeTiles[i].getY();
            if (x + 1 >= Board.WIDTH || board.get(x + 1, y) != 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isColliding() {
        Point2D[] shapeTiles = this.currentShape.move(this.currentPoint);
        for (int i = 0; i < shapeTiles.length; i++) {
            int x = shapeTiles[i].getX();
            int y = shapeTiles[i].getY();
            if (x < 0 || x >= Board.WIDTH || y >= Board.HEIGTH || board.get(x, y) != 0) {
                return true;
            }
        }

        return false;
    }

    private boolean canMoveLeft() {
        Point2D[] shapeTiles = this.currentShape.move(this.currentPoint);
        for (int i = 0; i < shapeTiles.length; i++) {
            int x = shapeTiles[i].getX();
            int y = shapeTiles[i].getY();
            if (x - 1 < 0 || board.get(x - 1, y) != 0) {
                return false;
            }
        }

        return true;
    }

    private void fixShapeInBoard() {
        Point2D[] shapeTiles = this.currentShape.move(this.currentPoint);
        for (int i = 0; i < shapeTiles.length; i++) {
            int x = shapeTiles[i].getX();
            int y = shapeTiles[i].getY();
            // NOTE: Set the ID of the figura to tracking the positions. 
            // 0 is empty, so we need to add + 1
            this.board.set(x, y, this.IDShape + 1);
        }
    }

    /**
     * Responde al evento en que el usuario presiona una tecla tipo flecha.
     */
    public void keyPressed(KeyEvent key) {
        int x = this.currentPoint.getX();
        int y =  this.currentPoint.getY();
        if (key.getKeyCode() == KeyEvent.VK_RIGHT && this.canMoveRight()) {
            this.currentPoint = new Point2D(x + 1, y);
        } else if (key.getKeyCode() == KeyEvent.VK_LEFT && this.canMoveLeft()) {
            this.currentPoint = new Point2D(x - 1, y);
        }else if(key.getKeyCode() == KeyEvent.VK_UP) {
            this.currentShape.rotateRigth();
            if (this.isColliding()) {
                this.currentShape.rotateLeft();
            }
        } else if(key.getKeyCode() == KeyEvent.VK_DOWN){
            this.currentShape.rotateLeft();
            if (this.isColliding()) {
                this.currentShape.rotateRigth();
            }
        }
    }

    /**
     * Actualiza el estado del juego cuando el usuario presiona una tecla.
     */
    public void update() {
        int x = this.currentPoint.getX();
        int y =  this.currentPoint.getY();
        if (this.canMoveDown()) {
            this.currentPoint = new Point2D(x, y + 1);
        } else if (y == 0 && this.isColliding()) {
            Window.getTimer().stop();
            this.isGameOver = true;
        } else {
            // NOTE: Primero fijamos la figura en el tablero y actualizamos el tablero
            this.fixShapeInBoard();
            this.score += this.board.computeFilledRows();
            // Luego creo una nueva figura
            this.currentPoint = new Point2D(4, 0);
            this.IDShape = this.random.nextInt(this.shapes.length);
            this.currentShape = this.shapes[this.IDShape];
        }
    }

    /**
     * Dibuja los tetriminos en pantalla.
     */
    public void draw(Graphics graphics) {
        // NOTE: Draw board First, only non empty tiles
        for (int y = 0; y < Board.HEIGTH; y++) {
            for (int x = 0; x < Board.WIDTH; x++) {
                if (this.board.get(x, y) != 0) {
                    // See: fixShapeInBoard function
                    int shapeID = this.board.get(x, y) - 1;
                    Shape shape = this.shapes[shapeID];

                    graphics.setColor(shape.getFillColor());
                    graphics.fillRect(x * Tetris.PIXEL_SIZE, y * Tetris.PIXEL_SIZE, Tetris.PIXEL_SIZE, Tetris.PIXEL_SIZE);
                    graphics.setColor(shape.getBorderColor());
                    graphics.drawRect(x * Tetris.PIXEL_SIZE, y * Tetris.PIXEL_SIZE, Tetris.PIXEL_SIZE, Tetris.PIXEL_SIZE);
                }
            }
        }

        // Now, draw current shape
        Point2D[] shapeTiles = this.currentShape.move(this.currentPoint);
        Color fillColor = this.currentShape.getFillColor();
        Color borderColor = this.currentShape.getBorderColor();

        for (int i = 0; i < shapeTiles.length; i++) {
            int x = shapeTiles[i].getX();
            int y = shapeTiles[i].getY();
            graphics.setColor(fillColor);
            graphics.fillRect(x * Tetris.PIXEL_SIZE, y * Tetris.PIXEL_SIZE, Tetris.PIXEL_SIZE, Tetris.PIXEL_SIZE);
            graphics.setColor(borderColor);
            graphics.drawRect(x * Tetris.PIXEL_SIZE, y * Tetris.PIXEL_SIZE, Tetris.PIXEL_SIZE, Tetris.PIXEL_SIZE);
        }

        if (this.isGameOver) {
            graphics.setFont(new Font("Book Antiqua",Font.BOLD,40));
            graphics.setColor(Color.WHITE);
            graphics.drawString("Game Over", (Board.WIDTH / 4) * (Tetris.PIXEL_SIZE - 1), (Board.HEIGTH / 2) * Tetris.PIXEL_SIZE);
        }
    }
}
