package strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Die Random Strategie spielt immer zufällige Karten aus.
 * Diese Strategie ist also nicht vorhersehbar, jedoch auch relativ leicht zu schlagen.
 *
 * @author Till N.
 * @version 0.1
 */

public class Randomized extends Strategie {

    private List<Integer> karten = new ArrayList<>();

    public Randomized(){
        mischeKarten();
    }

    private void mischeKarten(){
        for(int i=1; i<=15; i++) {
            karten.add(i);
        }
    }

    @Override
    public int gibKarte(int letzteKarte) {
        Random random = new Random();
        int index = random.nextInt(karten.size());
        return karten.remove(index);
    }

    @Override
    public void reset() {
        karten.clear();
        mischeKarten();
    }
}
