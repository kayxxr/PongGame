package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class schläger2 extends GameObject {

    boolean moveUp = false;
    boolean moveDown = false;

    final int FELOCITY = 10;

    public schläger2(int x, int y) {
        super(x, y, 7, 133, GameObject.SCHLÄGER2);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update(ArrayList<GameObject> objects) {
        // TODO Auto-generated method stub
        if (moveUp) {
            y -= FELOCITY;
        }
        if (moveDown) {
            y += FELOCITY;
        }

        x += 0;
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
            if (e.getKeyCode() == KeyEvent.VK_L) {
                moveDown = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_O) {
                moveUp = false;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_L) {
                moveDown = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_O) {
                moveUp = true;
            }

        }
    };

}