package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends JFrame {

    Canvas canvas = new Canvas();
    ArrayList<GameObject> list = new ArrayList<GameObject>();
    Ball ball;
    // Canvas = Leinwand

    public Game() {
        setSize(800, 600);
        canvas.setSize(800, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().add(canvas);

        init();

        setVisible(true);

        run();
        canvas.requestFocus();
    }

    private void init() {

        schläger1 schläger1 = new schläger1(10, 30);
        canvas.addKeyListener(schläger1.keyListener);
        list.add(schläger1);

        schläger2 schläger2 = new schläger2(765, 10);
        canvas.addKeyListener(schläger2.keyListener);

        list.add(schläger2);

        ball = new Ball(300, 30);
        list.add(ball);

    }

    private void run() {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Graphics2D canvasGraphic = (Graphics2D) canvas.getGraphics();

                    BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g = image.createGraphics();

                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, 800, 600);
                    for (int i = 0; i < list.size(); i++) {
                        GameObject object = list.get(i);
                        object.update(list);
                        object.draw(g);
                    }

                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Arial", Font.PLAIN, 25));
                    g.drawString(ball.counter.toString(), 358, 100);

                    g.setFont(new Font("Arial", Font.BOLD, 45));
                    g.drawString("Pong", 330, 50);
                    g.dispose();
                    canvasGraphic.drawImage(image, 0, 0, 800, 600, null);
                    canvasGraphic.dispose();

                    try {

                        Thread.sleep(1000 / 60);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

    }
}