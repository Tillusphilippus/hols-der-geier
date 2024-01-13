package Scanner;

import game.HolsDerGeier;
import players.HolsDerGeierSpieler;

import java.util.ArrayList;

/**
 * Die Klasse Scanner ist dafür zuständig nach jeder Runde den Gegner zu analysieren und eine passende Gegenstrategie zu wählen.
 *
 * @author Till N.
 * @version 0.1
 */

public class Scanner {

    HolsDerGeier spiel;
    HolsDerGeierSpieler spieler;

    public ArrayList<Integer> handkartenGegner = new ArrayList<>();
    public ArrayList<Integer> handkartenGegnerAusgespielt = new ArrayList<>();
    public ArrayList<Integer> handkarten = new ArrayList<>();
    public ArrayList<Integer> handkartenAusgespielt = new ArrayList<>();
    public ArrayList<Integer> geierKartenRunde = new ArrayList<>();
    public ArrayList<Integer> geierKartenRundeAusgespielt = new ArrayList<>();

    public Scanner(HolsDerGeierSpieler spieler, HolsDerGeier spiel) {
        this.spieler = spieler;
        this.spiel = spiel;
        handKartenZuruecksetzen();
    }

    public void newTurn(int letzteKarte, int letzteKarteGegner, int geierKarte) {
        handkarten.remove((Integer) letzteKarte);
        handkartenGegner.remove((Integer) letzteKarteGegner);
        geierKartenRunde.remove((Integer) geierKarte);
        handkartenAusgespielt.add(letzteKarte);
        handkartenGegnerAusgespielt.add(letzteKarteGegner);
        geierKartenRundeAusgespielt.add(geierKarte);
    }

    private void berechneGegnerStrategie() {

    }

    public void reset() {
        handKartenZuruecksetzen();
        geierKartenZuruecksetzen();
        berechneGegnerStrategie();
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
