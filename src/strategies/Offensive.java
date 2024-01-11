package strategies;

/**
 * Die Offensive Strategie beschreibt Spieler, die zu Spielbeginn eher hohe Karten spielen.
 * Im Laufe der Partie sinken dann die Kartenwerte.
 * Durch das frühe kämpfen um Karten werden schnell viele Punkte angesammelt.
 * Jedoch lässt die Stärke am Ende deutlich nach.
 * Es ist das Gegenteil zur Defensive Strategie.
 *
 * @author Till N.
 * @version 0.1
 */

public class Offensive extends Strategie {
    @Override
    public int gibKarte() {
        return 0;
    }
}
