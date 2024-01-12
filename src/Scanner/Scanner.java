package Scanner;

import players.BATWF;
import strategies.MyStrategy;
import strategies.Strategie;
import strategiesCounter.DefensiveCounter;
import strategiesCounter.MappedCounter;
import strategiesCounter.OffensiveCounter;
import strategiesCounter.RandomCounter;

import java.util.ArrayList;

/**
 * Die Klasse Scanner ist dafür zuständig nach jeder Runde den Gegner zu analysieren und eine passende Gegenstrategie zu wählen.
 *
 * @author Till N.
 * @version 0.1
 */

public class Scanner {

    BATWF batwf;
    private ArrayList<Integer> handkartenGegner = new ArrayList<>();
    private ArrayList<Integer> zuletztGespieltGegner = new ArrayList<>();
    private ArrayList<Integer> handkarten = new ArrayList<>();
    private ArrayList<Integer> zuletztGespielt = new ArrayList<>();

    public void handkartenZuruecksetzen() {
        for (int i = 1; i <= 15; i++) {
            this.handkartenGegner.add(i);
            this.handkarten.add(i);
        }
    }

    public int getLetzterZug() {
        return batwf.letzterZug();
    }

    public Strategie starteNeuenScan(){
        if(scanAufMapped()) return new MappedCounter();
         else if (scanAufOffensive()) return new OffensiveCounter();
         else if (scanAufDefensive()) return new DefensiveCounter();
         else if (scanAufRandom()) return new RandomCounter();
         else return new MyStrategy();
    }

    public void reset() {
        handkartenZuruecksetzen();
    }

    private boolean scanAufDefensive(){
        return false;
    }

    private boolean scanAufOffensive(){
        return false;
    }

    private boolean scanAufMapped(){
        return false;
    }

    private boolean scanAufRandom(){
        return false;
    }



    public BATWF getBatwf() {
        return batwf;
    }

    public void setBatwf(BATWF batwf) {
        this.batwf = batwf;
    }

}
