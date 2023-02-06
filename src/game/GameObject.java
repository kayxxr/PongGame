package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class GameObject {

    public static final int SCHLÄGER1 = 0;

    public static final int SCHLÄGER2 = 1;

    public static final int BALL = 2;

    public static final int WALL = 3;

    int x;
    int y;
    int breite;
    int höhe;
    int ID;


    public GameObject(int x, int y, int breite, int höhe, int ID) {
        this.x = x;
        this.y = y;
        this.breite = breite;
        this.höhe = höhe;
        this.ID = ID;
    }

    public abstract void update(ArrayList<GameObject> objects);

    public abstract void draw(Graphics2D g);

    public Rectangle getBounds() {
        // Rectangle = Hitbox
        return new Rectangle(x, y, breite, höhe);

    }

}
