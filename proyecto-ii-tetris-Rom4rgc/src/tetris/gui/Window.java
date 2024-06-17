package tetris.gui;

import tetris.logic.Board;
import tetris.logic.Tetris;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Window extends javax.swing.JFrame implements ActionListener, Runnable {
    private static Timer timer;
    private Tetris game;
    private JLabel panel;
    private JLabel score;
    private JLabel textScore;

    /**
     * Constructor.
     */
    public Window() {
        Window.timer = new Timer(500, this);
        this.game = new Tetris();
        initComponents();
        panel.setFocusable(true);
          panel.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent evt) {
                game.keyPressed(evt);
            }
        });
        setVisible(true);
    }

    /**
     * Permite acceder al temporizador del juego.
     */
    public static Timer getTimer() {
        return Window.timer;
    }

    /**
     * Actualiza el juego según los ticks del temporizador.
     */
    public void actionPerformed(ActionEvent e) {
        int width = Tetris.PIXEL_SIZE * Board.WIDTH;
        int heigth = Tetris.PIXEL_SIZE * Board.HEIGTH;
        BufferedImage canvas = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = canvas.getGraphics();

        this.game.update();
        this.game.draw(graphics);
        this.score.setText("" + this.game.getScore());
        panel.setIcon(new ImageIcon(canvas));
    }

    /**
     *  Inicia el temporizador.
     */
    public void run() {
        Window.timer.start();
    }

    /**
     * Crea componentes y acomoda la interfaz de usuario.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        this.panel = new JLabel();
        this.textScore = new JLabel();
        this.score = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setResizable(false);

        textScore.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        textScore.setText("Score:");

        score.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        score.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textScore)
                    .addComponent(score, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(score)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
}
