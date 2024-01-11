package Scanner;

import strategies.Strategie;

import java.util.ArrayList;
import java.util.Set;

/**
 * Die Klasse Scanner ist dafür zuständig nach jeder Runde den Gegner zu analysieren und eine passende Gegenstrategie zu wählen.
 *
 * @author Till N.
 * @version 0.1
 */

public class Scanner {

    private ArrayList<Integer> handkartenGegner = new ArrayList<>();
    private ArrayList<Integer> zuletztGespieltGegner = new ArrayList<>();
    private ArrayList<Integer> handkarten = new ArrayList<>();

    public void handkartenZuruecksetzen() {
        for (int i = 1; i <= 15; i++) {
            this.handkartenGegner.add(i);
            this.handkarten.add(i);
        }
    }

    public Strategie berechneKurzfristigieGegnerStrategie(){
        return null;
    }

    public Strategie berechneMittelfristigieGegnerStrategie(){
        return null;
    }

    public Strategie berechneLangfristigieGegnerStrategie(){
        return null;
    }
}
