package game;

import players.*;

import java.util.Scanner;



public class GameBuilder {
    //Scanner zum Erfassen von Benutzereingaben
    Scanner scanner = new Scanner(System.in);
    GameLogic gameLogic = new GameLogic();

    BlueprintPlayer[] players = new BlueprintPlayer[2];
    int amountOfRounds;


    //Baut ein neues Spiel.
    public void buildNewGame() {
        createPlayers();
        getAmountOfRounds();
        gameLogic.neueSpieler(players[0], players[1]);
        gameLogic.resetGame();

        for(int i = 1; i <= amountOfRounds; i++){
            try {
                gameLogic.newGame();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //Lässt zwei neue Spieler erstellen und fügt sie in das player Array ein.
    private void createPlayers() {
        for (int i = 1; i<=2; i++) {
            try {
                players[i-1] = getPlayerParameters(i);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //Fragt die Parameter für einen Spieler vom Benutzer ab.
    private BlueprintPlayer getPlayerParameters(int numberOfPlayer) throws Exception {

        String Message =    "Typ des " + numberOfPlayer + ". Spielers:" + "\n"
                            +"1 = Mensch als Spieler \n"
                            +"2 = Bot Random \n"
                            +"3 = Bot THM \n"
                            +"4 = Bot Final \n"
                            //+"5 = \n"
                            //+"6 = \n"
                            //+"7 = \n"
                            //+"8 = \n"
                            //+"9 = \n"
                            ;

        System.out.println(Message);
        String strategyOfPlayerAsString = scanner.next();

        return switch (strategyOfPlayerAsString) {
            case "1" -> new PlayerHuman();
            case "2" -> new BotRandom();
            case "3" -> new BotTHM();
            case "4" -> new BotFinal();
            default -> throw new IllegalArgumentException("Die Eingabe ist nicht gültig!");
        };
    }

    //Fragt die Rundenanzahl des Games vom Benutzer ab
    private void getAmountOfRounds() {
        System.out.println("Wie viele Runden sollen gespielt werden?");
        amountOfRounds = scanner.nextInt();
    }


}
