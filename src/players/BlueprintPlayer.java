package players;

import game.GameLogic;

public abstract class BlueprintPlayer {

    private int playerNumber;
    private GameLogic currentGame;

    
    public int getPlayerNumber() {
        return playerNumber;
    }
    public GameLogic getCurrentGame()  {
        return currentGame;
    }

    public int letzterZug() {
        return currentGame.letzterZug(playerNumber);
    }
    
    public void register(GameLogic currentGame, int playerNumber) {
        this.currentGame =currentGame;
        this.playerNumber =playerNumber;
    }
    
    public abstract void reset();    
    public abstract int gibKarte(int naechsteKarte);
        
}
