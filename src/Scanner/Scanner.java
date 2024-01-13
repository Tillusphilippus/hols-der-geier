package Scanner;

import game.HolsDerGeier;
import players.AdaptiverBot;
import strategiePickers.StrategieCounterPicker;
import strategiePickers.StrategieRandomPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Die Klasse Scanner ist dafür zuständig nach jeder Runde den Gegner zu analysieren und eine passende Gegenstrategie zu wählen.
 *
 * @author Till N.
 * @version 0.1
 */

public class Scanner {

    public HolsDerGeier spiel;
    AdaptiverBot spieler;

    StrategieCounterPicker strategieCounterPicker = new StrategieCounterPicker();
    StrategieRandomPicker strategieRandomPicker = new StrategieRandomPicker();

    int strategieAnpassenTracker = 5;
    boolean mappedFound;
    boolean alignedFound;

    public ArrayList<Integer> handkartenGegner = new ArrayList<>();
    public ArrayList<Integer> handkartenGegnerAusgespielt = new ArrayList<>();
    public ArrayList<Integer> handkarten = new ArrayList<>();
    public ArrayList<Integer> handkartenAusgespielt = new ArrayList<>();
    public ArrayList<Integer> geierKartenRunde = new ArrayList<>();
    public ArrayList<Integer> geierKartenRundeAusgespielt = new ArrayList<>();

    public Scanner(AdaptiverBot spieler, HolsDerGeier spiel) {
        this.spieler = spieler;
        this.spiel = spiel;
        handKartenZuruecksetzen();
    }

    public void starteNeuenZug (int letzteGeierKarte) {
        if(spiel.letzterZug(spieler.getNummer()) != -99) {
            int nummer = spieler.getNummer();
            int letzteKarte = spiel.letzterZug(nummer);
            handkarten.remove((Integer) letzteKarte);
            handkartenAusgespielt.add(letzteKarte);
        }
        if(spiel.letzterZug(spieler.getNummerGegner()) != -99) {
            int nummerGegner = spieler.getNummerGegner();
            int letzteKarteGegner = spiel.letzterZug(nummerGegner);
            handkartenGegner.remove((Integer) letzteKarteGegner);
            handkartenGegnerAusgespielt.add(letzteKarteGegner);
        }
        geierKartenRunde.remove((Integer) letzteGeierKarte);
        geierKartenRundeAusgespielt.add(letzteGeierKarte);
    }

    private void findeBesteStrategie() {
        if(mappedFound) {
            spieler.setCurrentStrategie(strategieCounterPicker.kontereGegenstrategieMapped());
        } else if(alignedFound) {
            spieler.setCurrentStrategie(strategieCounterPicker.kontereGegenstrategieAligned());
        } else if (strategieAnpassenTracker == 0) {
            spieler.setCurrentStrategie(strategieRandomPicker.getRandomStrategie());
            Random random = new Random();
            strategieAnpassenTracker = random.nextInt(11);
        } else {
            spieler.ausgangsStrategie();
            strategieAnpassenTracker--;
        }
    }

    public void reset() {
        if(!handkartenGegnerAusgespielt.isEmpty()) {
            mappedFound = strategieCounterPicker.sucheMappedStrategie(geierKartenRundeAusgespielt, handkartenGegnerAusgespielt);
            alignedFound = strategieCounterPicker.sucheAlignedStrategie(handkartenGegnerAusgespielt);
            findeBesteStrategie();
        }
        handKartenZuruecksetzen();
        geierKartenZuruecksetzen();
    }

    private void handKartenZuruecksetzen() {
        handkarten.clear();
        handkartenAusgespielt.clear();
        handkartenGegner.clear();
        handkartenGegnerAusgespielt.clear();
        for (int i = 1; i <= 15; i++) {
            handkartenGegner.add(i);
            handkarten.add(i);
        }
    }

    private void geierKartenZuruecksetzen () {
        geierKartenRunde.clear();
        geierKartenRundeAusgespielt.clear();
        for (int i = -5; i <= 10; i++) {
            if(i != 0) {
                geierKartenRunde.add(i);
            }
        }
    }

    public int berechneHoechsteGegnerKarte() {
        return Collections.max(handkartenGegner);
    }
    public int berechneNiedrigsteGegnerKarte() {
        return Collections.min(handkartenGegner);
    }
    public int berechneLetzteGegnerKarte() {
        if(!handkartenGegnerAusgespielt.isEmpty()) {
            return handkartenGegnerAusgespielt.getLast();
        }
        return 99;
    }

    public int berechneLetzteGeierKarte() {
        if(!geierKartenRundeAusgespielt.isEmpty()) {
            return geierKartenRundeAusgespielt.getLast();
        }
        return 97;
    }

    public int berechneLetzteKarte() {
        if(!handkartenAusgespielt.isEmpty()) {
            return handkartenAusgespielt.getLast();
        }
        return 98;
    }


    public int berechneHoechsteKarte() {
        return Collections.max(handkarten);
    }

    public int berechneNiedrigsteKarte() {
        return Collections.min(handkarten);
    }

}
