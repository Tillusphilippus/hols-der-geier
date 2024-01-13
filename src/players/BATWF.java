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
    private Strategie currentStrategie = new MyStrategy(this, scanner);
    private final int nummerGegner = (this.getNummer() == 1) ? 0 : 1;
    private int letzteGeierKarte;

    @Override
    public void reset() {
        scanner.reset();
        currentStrategie.reset();
    }

    @Override
    public int gibKarte(int naechsteKarte) {
        updateScanner();
        letzteGeierKarte = naechsteKarte;
        return currentStrategie.gibKarte(naechsteKarte);
    }

    private void updateScanner() {
        int letzterZug = this.getHdg().letzterZug(this.getNummer());
        int letzterZugGegner = this.getHdg().letzterZug(nummerGegner);

        scanner.newTurn(letzterZug, letzterZugGegner, letzteGeierKarte);
    }

    public void setCurrentStrategie(Strategie currentStrategie) {
        this.currentStrategie = currentStrategie;
    }
}