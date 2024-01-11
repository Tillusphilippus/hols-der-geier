package strategies;

/**
 * Die Defensive Strategie beschreibt Spieler, die zu Spielbeginn eher niedrige Karten spielen.
 * Im Laufe der Partie steigen dann die Kartenwerte.
 * Somit wird das frühe angreifen vermieden und eher dann gespielt, wenn andere Spieler schon hohe karten ausgespielt haben.
 * Es ist also eine abwartende Strategie.
 *
 * @author Till N.
 * @version 0.1
 */

public class Defensive extends Strategie {
    @Override
    public int gibKarte() {
        return 0;
    }
}
