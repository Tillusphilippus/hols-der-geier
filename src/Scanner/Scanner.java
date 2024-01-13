package Scanner;

import game.HolsDerGeier;
import players.BATWF;
import strategiePickers.StrategieCounterPicker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Die Klasse Scanner ist dafür zuständig nach jeder Runde den Gegner zu analysieren und eine passende Gegenstrategie zu wählen.
 *
 * @author Till N.
 * @version 0.1
 */

public class Scanner {

    public HolsDerGeier spiel;
    BATWF spieler;

    StrategieCounterPicker strategieCounterPicker = new StrategieCounterPicker();

    public ArrayList<Integer> handkartenGegner = new ArrayList<>();
    public ArrayList<Integer> handkartenGegnerAusgespielt = new ArrayList<>();
    public ArrayList<Integer> handkarten = new ArrayList<>();
    public ArrayList<Integer> handkartenAusgespielt = new ArrayList<>();
    public ArrayList<Integer> geierKartenRunde = new ArrayList<>();
    public ArrayList<Integer> geierKartenRundeAusgespielt = new ArrayList<>();

    public Scanner(BATWF spieler, HolsDerGeier spiel) {
        this.spieler = spieler;
        this.spiel = spiel;
        handKartenZuruecksetzen();
    }

    public void starteNeuenZug (int letzteGeierKarte) {
        if(spiel.letzterZug(spieler.getNummerGegner()) != -99) {
            int letzteGegnerkarte = spiel.letzterZug(spieler.getNummer());
            handkartenGegner.remove((Integer) letzteGegnerkarte);
            handkartenGegnerAusgespielt.add(letzteGegnerkarte);
        }
        if(spiel.letzterZug(spieler.getNummer()) != -99) {
            int letzteKarte = spiel.letzterZug(spieler.getNummerGegner());
            handkarten.remove((Integer) letzteKarte);
            handkartenAusgespielt.add(letzteKarte);
        }
        geierKartenRunde.remove((Integer) letzteGeierKarte);
        geierKartenRundeAusgespielt.add(letzteGeierKarte);
    }

    private void kontereGegnerStrategie() {
        System.out.println("Gegner ueberprueft!");
        if(strategieCounterPicker.sucheMappedStrategie(geierKartenRundeAusgespielt, handkartenGegnerAusgespielt)) {
            spieler.setCurrentStrategie(strategieCounterPicker.kontereGegenstrategieMapped());
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

    public void reset() {
        if(!handkartenGegnerAusgespielt.isEmpty()) {
            kontereGegnerStrategie();
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

}
