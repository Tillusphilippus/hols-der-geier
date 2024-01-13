package players;

import Scanner.Scanner;
import strategies.*;

import java.util.ArrayList;

/**
 * Die Klasse AdaptiverBot (Best Algorithm To Win Fast) ist ein Bot, der die Karte ausspielt, die er für am besten empfindet.
 *
 * @author THM
 * @version 0.1
 */

public class AdaptiverBot extends HolsDerGeierSpieler{

    private final Scanner scanner = new Scanner(this, this.getHdg());
    private Strategie currentStrategie = new AdaptiveStrategy(this, scanner);
    private final ArrayList<Strategie> ausgelagerteStrategien = new ArrayList<>();

    public AdaptiverBot() {
        setCurrentStrategie(new AdaptiveStrategy(this, scanner));
    }

    public AdaptiverBot(Strategie strategie) {
        setCurrentStrategie(strategie);
    }

    @Override
    public void reset() {
        scanner.reset();
        currentStrategie.reset();
    }

    @Override
    public int gibKarte(int naechsteKarte) {
        scanner.spiel = this.getHdg();
        scanner.starteNeuenZug(naechsteKarte);
        return currentStrategie.gibKarte(naechsteKarte);
    }

    public void setCurrentStrategie(Strategie currentStrategie) {
        ausgelagerteStrategien.add(this.currentStrategie);
        this.currentStrategie = currentStrategie;
    }

    public int getNummerGegner() {
        return (this.getNummer() == 1) ? 0 : 1;
    }

    public void ausgangsStrategie() {
        this.currentStrategie = ausgelagerteStrategien.getFirst();
    }

    public void letzteStrategie() {
        this.currentStrategie = ausgelagerteStrategien.getLast();
    }
}