package players;

import strategies.MyStrategy;
import strategies.Strategie;

/**
 * Die Klasse BATWF (Best Algorithm To Win Fast) ist ein Bot, der die Karte ausspielt, die er für am besten empfindet.
 *
 * @author THM
 * @version 0.1
 */

public class BATWF extends HolsDerGeierSpieler{

    private Strategie currentStrategie = new MyStrategy();

    @Override
    public void reset() {

    }

    @Override
    public int gibKarte(int naechsteKarte) {
        return currentStrategie.gibKarte();

    }

    public Strategie getCurrentStrategie() {
        return currentStrategie;
    }

    public void setCurrentStrategie(Strategie currentStrategie) {
        this.currentStrategie = currentStrategie;
    }
}