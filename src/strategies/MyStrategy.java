package strategies;

import Scanner.Scanner;
import players.HolsDerGeierSpieler;

/**
 * Die MyStrategy ist eine selbst entwickelte Strategie, die sich immer bestmöglich an das Spiel anpassen soll.
 * Sie orientiert sich daran, wie ich ein Spiel spielen würde.
 * Mithilfe des Scanners kann sie jedoch den Spielverlauf analysieren und die Spielweise anpassen.
 *
 * @author Till N.
 * @version 0.1
 */

public class MyStrategy extends Strategie {

    private final HolsDerGeierSpieler spieler;
    private final Scanner scanner;
    private boolean isErsteRunde = true;
    private int letzteKarte;
    private int letzteGegnerKarte;
    private int letzteGeierKarte;

    public MyStrategy(HolsDerGeierSpieler spieler, Scanner scanner){
        this.spieler = spieler;
        this.scanner = scanner;
        scanner.reset();
    }

    @Override
    public int gibKarte(int naechsteKarte) {

        scanner.starteNeuenZug(naechsteKarte);

        int auszuspielendeKarte;
        int letzteKarte = scanner.berechneLetzteKarte();
        int letzteKarteGegner = scanner.berechneLetzteGegnerKarte();
        int letzteKarteGeier = scanner.berechneLetzteGeierKarte();

        if( letzteKarte == letzteKarteGegner && letzteKarteGeier != 97 && letzteKarteGeier >=5) {
            auszuspielendeKarte = scanner.berechneHoechsteKarte();
            return auszuspielendeKarte;
        }

        auszuspielendeKarte = berechneEmpfohlenenKartenwert(naechsteKarte);
        auszuspielendeKarte = pruefeObNiedrigereKarteMoeglichIst(auszuspielendeKarte);
        auszuspielendeKarte = pruefeObKarteAufHand(auszuspielendeKarte);

        return auszuspielendeKarte;
    }

    private int berechneEmpfohlenenKartenwert(int naechsteKarte) {
        if (naechsteKarte<0) {
            return naechsteKarte+6;
        } else {
            return naechsteKarte+5;
        }
    }

    private int pruefeObNiedrigereKarteMoeglichIst(int karte) {
        if(karte > scanner.berechneHoechsteGegnerKarte()+1) {
            karte = scanner.berechneHoechsteGegnerKarte()+1;
        }
        return karte;
    }

    private int pruefeObKarteAufHand(int karte) {
        if(!scanner.handkarten.contains(karte)) {
            if(karte > scanner.berechneHoechsteKarte()) {
                karte = scanner.berechneHoechsteKarte();
            } else if(karte < scanner.berechneNiedrigsteKarte()) {
                karte = scanner.berechneNiedrigsteKarte();
            } else {
                while (!scanner.handkarten.contains(karte)) {
                    karte++;
                }
            }
        }
        return karte;
    }

    @Override
    public void reset() {

    }
}
