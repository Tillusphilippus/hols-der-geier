package game;

public class GameManager {

    public static void main(String[] args) {
        GameBuilder gameBuilder = new GameBuilder();
        HolsDerGeier aktuellesSpiel = gameBuilder.aktuellesSpiel;
        int aktuelleRunde;
        try {
            gameBuilder.baueNeuesSpiel();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        for(int i = 1; i <= gameBuilder.anzahlDerZuSpielendenRunden; i++){
            try {
                aktuellesSpiel.ganzesSpiel();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
