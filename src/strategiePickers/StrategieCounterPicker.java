package strategiePickers;

import strategies.CustomMapped;
import strategies.Strategie;

import java.util.ArrayList;

public class StrategieCounterPicker {

    private ArrayList<Integer> mappingLastRound = new ArrayList<>();

    public boolean sucheMappedStrategie(ArrayList<Integer> geierKartenLetztesSpiel, ArrayList<Integer> gegnerKartenLetztesSpiel) {

        for (int i = 1; i <= 15; i++) {
            if (!gegnerKartenLetztesSpiel.contains(i)) {
                gegnerKartenLetztesSpiel.add(i);
                break; // Die Schleife beenden, nachdem die fehlende Zahl gefunden wurde
            }
        }

        ArrayList<Integer> mapping = new ArrayList<>();

        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(-1)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(1)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(2)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(3)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(4)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(5)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(6)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(7)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(8)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(9)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(10)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(-5)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(-4)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(-3)));
        mapping.add(gegnerKartenLetztesSpiel.get(geierKartenLetztesSpiel.indexOf(-2)));

        System.out.println(mapping);
        System.out.println(mappingLastRound);

        if(!mappingLastRound.isEmpty() && mappingLastRound.equals(mapping)) {
            mappingLastRound = mapping;
            System.out.println("Mapping erkannt!");
            return true;
        } else {
            mappingLastRound = mapping;
            return false;
        }
    }

    public Strategie kontereGegenstrategieMapped() {
        System.out.println("Gegenstrategie weitergegeben!");
        return waehleGegenstrategieMapped(mappingLastRound);
    }
    private Strategie waehleGegenstrategieMapped(ArrayList<Integer> mapping) {
        mapping.set(mapping.indexOf(15), 0);

        mapping.replaceAll(integer -> integer + 1);
        System.out.println("Gegenstrategie erstellt!");
        return new CustomMapped(mapping);
    }
}
