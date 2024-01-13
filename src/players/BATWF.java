package players;

import Scanner.Scanner;
import strategies.*;

/**
 * Die Klasse BATWF (Best Algorithm To Win Fast) ist ein Bot, der die Karte ausspielt, die er für am besten empfindet.
 *
 * @author THM
 * @version 0.1
 */

public class BATWF extends HolsDerGeierSpieler{

    private final Scanner scanner = new Scanner(this, this.getHdg());
    private Strategie currentStrategie;

    public BATWF() {
        this.currentStrategie = new MyStrategy(this, scanner);
    }

    public BATWF(Strategie strategie) {
        this.currentStrategie = strategie;
    }

    @Override
    public void reset() {
        scanner.reset();
        currentStrategie.reset();
    }

    @Override
    public int gibKarte(int naechsteKarte) {
        scanner.spiel = this.getHdg();
        return currentStrategie.gibKarte(naechsteKarte);
    }

    public void setCurrentStrategie(Strategie currentStrategie) {
        this.currentStrategie = currentStrategie;
    }

    public int getNummerGegner() {
        return (this.getNummer() == 1) ? 0 : 1;
    }

}