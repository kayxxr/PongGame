package game;

public class Counter {
    private int punkte1 = 0;
    private int punkte2 = 0;


    @Override
    public String toString() {
        return getPunkte1() + " : " + getPunkte2();
    }

    public int getPunkte1() {
        return punkte1;
    }

    public int getPunkte2() {
        return punkte2;
    }

    public void punkte1einserhöhen() {
        punkte1++;

    }

    public void punkte2einserhöhen() {
        punkte2++;

    }
}