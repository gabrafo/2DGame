package game;

import entities.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    private final int originalTIleSize = 16; // 16x16
    final int scale = 3;

    private final int tileSize = originalTIleSize*scale; // 48x48
    private final int maxScreenColumn = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize*maxScreenColumn; // 768px
    private final int screenHeight = tileSize*maxScreenRow; // 576px

    private Thread gameThread;
    private KeyHandler keyH ;
    private TileManager tileM;
    private Player player;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // Melhor performance de rendering
        this.addKeyListener(keyH = new KeyHandler());
        this.player = new Player(this, keyH);
        this.tileM = new TileManager(this);
        this.setFocusable(true); // Pode receber entrada via teclado
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // Chama o método run
    }

    @Override
    public void run() {

        int FPS = 60;
        double drawInterval = 1000000000.0/ FPS; // 0.016...7 segundos
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        // Game Loop
        while(gameThread!=null){ // Enquanto a thread existir, o loop segue

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            timer += currentTime-lastTime;
            lastTime = currentTime;

            if(delta >= 1) {
                // ATUALIZAÇÃO: Atualizar informações
                update();

                // DESENHAR: Redesenhar a tela de acordo com as atualizações
                repaint();

                delta--;

                drawCount++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: "+ drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        tileM.draw(g2d);
        player.draw(g2d);
        g2d.dispose();
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getMaxScreenColumn() {
        return maxScreenColumn;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}