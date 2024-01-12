package strategiesCounter;

/**
 * Der RandomCounter kommt dann zum Einsatz, wenn erkannt wird, dass der Gegner random spielt.
 * Er soll sich daran anpassen.
 *
 * @author Till N.
 * @version 0.1
 */

public class RandomCounter extends StrategieCounter {
    @Override
    public int gibKarte(int letzteKarte) {
        return 0;
    }

    @Override
    public void reset() {

    }
}
