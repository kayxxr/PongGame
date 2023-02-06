package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

    public class Ball extends GameObject {

        final int FFELOCITY = 4;

        int speedX = 8;
        int speedY = 8;
        Counter counter;

        public Ball(int x, int y) {

            super(x, y, 27, 27, GameObject.BALL);
            counter = new Counter();

        }

        @Override
        public void update(ArrayList<GameObject> objects) {
            checkCollision(objects);

            if (y >= 530) {
                speedY *= -1;
            }
            if (y <= 0) {
                speedY *= -1;
            }
            if (ausen) {
                try {
                    Thread.sleep(2000);
                    ausen = false;
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            x += speedX;
            y += speedY;

            if (x >= 800) {
                x = 320;
                ausen = true;
                counter.punkte1einserhöhen();

            }
            if (x <= 0) {

                x = 320;
                ausen = true;
                counter.punkte2einserhöhen();
            }

        }

        boolean ausen = false;

        private void sleep(int i) {
            // TODO Auto-generated method stub

        }

        private void checkCollision(ArrayList<GameObject> objects) {
            for (GameObject object : objects) {
                if ((object.ID == GameObject.SCHLÄGER1 || object.ID == GameObject.SCHLÄGER2)
                        && object.getBounds().intersects(getBounds())) {
                    speedX *= -1;

                }

            }
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, breite, höhe);

        }
    }
