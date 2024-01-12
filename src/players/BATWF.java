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

    private Strategie currentStrategie = new Defensive(true);
    private Scanner scanner = new Scanner();

    public BATWF(){
        scanner.setBatwf(this);
    }

    public void gegnerAnalysieren(){
        currentStrategie = scanner.starteNeuenScan();
    }

    @Override
    public void reset() {
        scanner.reset();
        currentStrategie.reset();
    }

    @Override
    public int gibKarte(int naechsteKarte) {
        return currentStrategie.gibKarte(naechsteKarte);
    }

    public Strategie getCurrentStrategie() {
        return currentStrategie;
    }

    public void setCurrentStrategie(Strategie currentStrategie) {
        this.currentStrategie = currentStrategie;
    }
}