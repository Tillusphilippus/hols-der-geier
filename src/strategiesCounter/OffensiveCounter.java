package strategiesCounter;

/**
 * Der OffensiveCounter kommt dann zum Einsatz, wenn erkannt wird, dass der Gegner eher offensiv spielt.
 * Er soll sich daran anpassen.
 *
 * @author Till N.
 * @version 0.1
 */

public class OffensiveCounter extends StrategieCounter {
    @Override
    public int gibKarte(int letzteKarte) {
        return 0;
    }

    @Override
    public void reset() {

    }
}
