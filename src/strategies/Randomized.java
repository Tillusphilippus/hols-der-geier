package strategies;

/**
 * Die Random Strategie spielt immer zufällige Karten aus.
 * Diese Strategie ist also nicht vorhersehbar, jedoch auch relativ leicht zu schlagen.
 *
 * @author Till N.
 * @version 0.1
 */

public class Randomized extends Strategie {
    @Override
    public int gibKarte(int letzteKarte) {
        return 0;
    }

    @Override
    public void reset() {

    }
}
