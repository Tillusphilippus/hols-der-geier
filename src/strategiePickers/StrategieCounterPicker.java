package strategiePickers;

import strategies.CustomMapped;
import strategies.Strategie;

import java.util.ArrayList;

public class StrategieCounterPicker {

    private ArrayList<Integer> mappingLastRound = new ArrayList<>();
    private ArrayList<Integer> alignedLastRound = new ArrayList<>();

    public boolean sucheAlignedStrategie(ArrayList<Integer> gegnerKartenLetztesSpiel) {

        for (int i = 1; i <= 15; i++) {
            if (!gegnerKartenLetztesSpiel.contains(i)) {
                gegnerKartenLetztesSpiel.add(i);
                break; // Die Schleife beenden, nachdem die fehlende Zahl gefunden wurde
            }
        }
        System.out.println("Aligned Last Round: " + alignedLastRound.toString());
        System.out.println("Aligned this Round: " + gegnerKartenLetztesSpiel.toString());

        if(!alignedLastRound.isEmpty() && alignedLastRound.equals(gegnerKartenLetztesSpiel) ) {
            alignedLastRound.clear();
            alignedLastRound.addAll(gegnerKartenLetztesSpiel);
            return true;
        } else {
            alignedLastRound.clear();
            alignedLastRound.addAll(gegnerKartenLetztesSpiel);
            return false;
        }
    }

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

        System.out.println("Mapping Last Round: " + mappingLastRound.toString());
        System.out.println("Mapping this Round: " + mapping.toString());

        if(!mappingLastRound.isEmpty() && mappingLastRound.equals(mapping) ) {
            mappingLastRound.clear();
            mappingLastRound.addAll(mapping);
            return true;
        } else {
            mappingLastRound.clear();
            mappingLastRound.addAll(mapping);
            return false;
        }
    }

    public Strategie kontereGegenstrategieAligned() {
        ArrayList<Integer> alignedTemp = new ArrayList<>(alignedLastRound);
        return waehleGegenstrategieAligned(alignedTemp);
    }
    public Strategie kontereGegenstrategieMapped() {
        ArrayList<Integer> mappedTemp = new ArrayList<>(mappingLastRound);
        return waehleGegenstrategieMapped(mappedTemp);
    }

    private Strategie waehleGegenstrategieAligned(ArrayList<Integer> alignedTemp) {
        alignedTemp.set(alignedTemp.indexOf(15), 0);
        alignedTemp.replaceAll(integer -> integer + 1);
        return new CustomMapped(alignedTemp);
    }


    private Strategie waehleGegenstrategieMapped(ArrayList<Integer> mappingTemp) {
        mappingTemp.set(mappingTemp.indexOf(15), 0);
        mappingTemp.replaceAll(integer -> integer + 1);
        return new CustomMapped(mappingTemp);
    }
}
