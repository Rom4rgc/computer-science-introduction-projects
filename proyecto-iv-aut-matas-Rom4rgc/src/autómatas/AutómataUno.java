package autómatas;

import java.util.Random;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;


public class AutómataUno extends Autómata {
    private int[][] estadoActual;
    private final int filas = 10;
    private final int columnas = 10;
    private Rectangle[][] celdas;
    private final int M = 5; // Valor umbral
    private Random random = new Random();
    private int sismosGenerados = 0; // Contador de sismos
    private boolean markingMode = false; // Modo de marcado para simular sismo
    private boolean running = true; // Estado de la simulación
    private double simulationSpeed = 4; // Velocidad de la simulación 

    public AutómataUno() {
        super();
        estadoActual = new int[filas][columnas];
        celdas = new Rectangle[filas][columnas];
        Group group = new Group();
        double size = 20; // Tamaño de cada celda

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Rectangle cell = new Rectangle(size, size, Color.WHITE);
                cell.setX(j * size);
                cell.setY(i * size);
                group.getChildren().add(cell);
                celdas[i][j] = cell;

                estadoActual[i][j] = random.nextInt(M); // Valores iniciales entre 0 y M-1
                cell.setFill(obtenerColor(estadoActual[i][j]));
            }
        }

        root.getChildren().add(group);
        root.setOnMouseClicked(this::handleMouseClick);

    }

private void handleMouseClick(MouseEvent event) {
        if (markingMode && running) {
            double cellSize = 20; // Tamaño de celda
            int column = (int) (event.getX() / cellSize);
            int row = (int) (event.getY() / cellSize);

            // Incrementar el valor de la celda marcada
            if (row >= 0 && row < filas && column >= 0 && column < columnas) {
                estadoActual[row][column]++;
                estadoActual[row][column] = Math.min(estadoActual[row][column], M);
                actualizarGraficos();
            }
        }
    }

    public void toggleMarkingMode() {
        markingMode = !markingMode; // Activar/desactivar el modo de marcado
    }

    public void toggleSimulation() {
        running = !running; // Pausar/reanudar la simulación
    }

    public void setSimulationSpeed(double speed) {
        simulationSpeed = speed; // Ajustar la velocidad de la simulación
    }


    @Override
    public void handle(long now) {
        if (running) {
            int sismoEnEsteCiclo = 0; // Contador para detectar sismos en este ciclo

            int randomRow = random.nextInt(filas);
            int randomColumn = random.nextInt(columnas);
            estadoActual[randomRow][randomColumn]++;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (estadoActual[i][j] >= M) {
                        estadoActual[i][j] -= 4;
                        sismoEnEsteCiclo++;
                    }
                }
            }

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    int vecinosUmbral = contarVecinosUmbral(i, j);
                    if (estadoActual[i][j] < M && vecinosUmbral > 0) {
                        estadoActual[i][j] += vecinosUmbral;
                        estadoActual[i][j] = Math.min(estadoActual[i][j], M);
                    }
                }
            }

            if (sismoEnEsteCiclo > 0) {
                sismosGenerados += sismoEnEsteCiclo;
                generarSismo(sismoEnEsteCiclo); // Notificar el sismo con su magnitud
            }

            actualizarGraficos();
        }
    }

    private int contarVecinosUmbral(int fila, int columna) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int x = fila + i;
                int y = columna + j;

                if (x >= 0 && x < filas && y >= 0 && y < columnas) {
                    if (estadoActual[x][y] == M) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void generarSismo(int magnitud) {
        System.out.println("¡Se generó un sismo! Magnitud: " + magnitud);
    }

    private Color obtenerColor(int valor) {
        double colorValue = ((double) valor / (double) M) * 255.0;
        return Color.rgb((int) colorValue, 0, 0);
    }

    private void actualizarGraficos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j].setFill(obtenerColor(estadoActual[i][j]));
            }
        }
    }

    @Override
    public Parent getAutómataNode() {
        return root;
    }

    public void showControls() {
    }

    public void hideControls() {
    }
}
