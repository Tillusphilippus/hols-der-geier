package strategies;

import Scanner.Scanner;
import players.HolsDerGeierSpieler;

/**
 * Die MyStrategy ist eine selbst entwickelte Strategie, die sich immer bestmöglich an das Spiel anpassen soll.
 * Sie orientiert sich daran, wie ich ein Spiel spielen würde.
 * Mithilfe des Scanners kann sie jedoch die Spielweise des Gegners analysieren und sich anpassen.
 *
 * @author Till N.
 * @version 0.1
 */

public class MyStrategy extends Strategie {

    private HolsDerGeierSpieler spieler;
    private Scanner scanner;

    public MyStrategy(HolsDerGeierSpieler spieler, Scanner scanner){
        this.spieler = spieler;
        this.scanner = scanner;
    }

    @Override
    public int gibKarte(int letzteKarte) {
        return 0;
    }

    @Override
    public void reset() {

    }
}
