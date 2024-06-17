package autómatas;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class AutómataDos extends Autómata {
    private final int filas = 10;
    private final int columnas = 10;
    private int[][] estadoActual;
    private VBox root;
    private GridPane gridPane;
    private Random random = new Random();
    private final int a = 3; // Número de pasos hasta ser inmune
    private final int g = 2; // Número de pasos hasta volver a ser susceptible

    public AutómataDos() {
        super();
        estadoActual = new int[filas][columnas];
        root = new VBox();
        gridPane = new GridPane();
        root.getChildren().add(gridPane);
        inicializarEstadoInicial();
        actualizarGraficos();
    }

    private void inicializarEstadoInicial() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Inicialización aleatoria con diferentes probabilidades para cada estado
                int randomNumber = random.nextInt(100);
                if (randomNumber < 40) {
                    estadoActual[i][j] = 0; // Sano con probabilidad del 40%
                } else if (randomNumber < 70) {
                    estadoActual[i][j] = 1; // Expuesto con probabilidad del 30%
                } else if (randomNumber < 85) {
                    estadoActual[i][j] = 2; // Infectado con probabilidad del 15%
                } else {
                    estadoActual[i][j] = 3; // Recuperado con probabilidad del 15%
                }
            }
        }
    }

    private void actualizarEstado() {
        int[][] nuevoEstado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int estadoActualCelda = estadoActual[i][j];

                if (estadoActualCelda == 0) {
                    // Si está sano y tiene vecinos infectados, se expone
                    if (contarVecinosInfectados(i, j) > 0) {
                        nuevoEstado[i][j] = 1;
                    } else {
                        nuevoEstado[i][j] = estadoActualCelda;
                    }
                } else if (estadoActualCelda == 1) {
                    // Si está expuesto, tiene una probabilidad del 30% de convertirse en infectado
                    if (random.nextInt(100) < 30) {
                        nuevoEstado[i][j] = 2;
                    } else {
                        nuevoEstado[i][j] = estadoActualCelda;
                    }
                } else if (estadoActualCelda == 2) {
                    // Si está infectado, tiene una probabilidad del 10% de convertirse en recuperado
                    if (random.nextInt(100) < 10) {
                        nuevoEstado[i][j] = 3;
                    } else {
                        nuevoEstado[i][j] = estadoActualCelda;
                    }
                } else if (estadoActualCelda == 3) {
                    // Si está recuperado, tiene una probabilidad del 15% de volver a estar sano
                    if (random.nextInt(100) < 15) {
                        nuevoEstado[i][j] = 0;
                    } else {
                        nuevoEstado[i][j] = estadoActualCelda;
                    }
                }
            }
        }

        estadoActual = nuevoEstado;
        actualizarGraficos();
    }

    private int contarVecinosInfectados(int x, int y) {
        int vecinosInfectados = 0;
        int[][] vecinos = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

        for (int[] vecino : vecinos) {
            int i = vecino[0];
            int j = vecino[1];

            if (i >= 0 && i < filas && j >= 0 && j < columnas && estadoActual[i][j] == 2) {
                vecinosInfectados++;
            }
        }

        return vecinosInfectados;
    }

    private void actualizarGraficos() {
        gridPane.getChildren().clear();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Rectangle cell = new Rectangle(20, 20);
                int estadoCelda = estadoActual[i][j];

                switch (estadoCelda) {
                    case 0:
                        cell.setFill(Color.GREEN); // Sano
                        break;
                    case 1:
                        cell.setFill(Color.YELLOW); // Expuesto
                        break;
                    case 2:
                        cell.setFill(Color.RED); // Infectado
                        break;
                    case 3:
                        cell.setFill(Color.BLUE); // Recuperado
                        break;
                    default:
                        cell.setFill(Color.GRAY);
                        break;
                }

                gridPane.add(cell, j, i);
            }
        }
    }

    @Override
    public Parent getAutómataNode() {
        return root;
    }

    public void showControls() {
        // Implementa los controles específicos para modificar los parámetros del modelo
    }

    public void hideControls() {
        // Oculta los controles específicos cuando se cambia a otro tipo de autómata
    }

    @Override
    public void handle(long now) {
        super.handle(now);
        actualizarEstado();
    }
}
