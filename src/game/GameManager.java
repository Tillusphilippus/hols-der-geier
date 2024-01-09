package game;

public class GameManager {
    public static void main(String[] args) {

        int gameIterations;
        GameBuilder gameBuilder = new GameBuilder();

        try
        {
            gameBuilder.buildNewGame();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}