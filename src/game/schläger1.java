package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class schläger1 extends GameObject {

    boolean moveUp = false;
    boolean moveDown = false;

    final int VELOCITY = 10;

    public schläger1(int x, int y) {

        super(x, y, 7, 133, GameObject.SCHLÄGER1);
        // TODO Auto-generated constructor stub
        //7, 133
    }

    @Override
    public void update(ArrayList<GameObject> objects) {

        if (moveUp) {
            y -= VELOCITY;

        }
        if (moveDown) {
            y += VELOCITY;

        }

    }

    @Override
    public void draw(Graphics2D g) {
        // TODO Auto-generated method stub
        {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, breite, höhe);
        }
    }

    KeyListener keyListener = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                moveDown = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                moveUp = false;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                moveDown = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                moveUp = true;
            }

        }

    };

}
