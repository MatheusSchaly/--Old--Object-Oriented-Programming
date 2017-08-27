package matheus_henrique_schaly.mhs.game;

/**
 * User input output.
 */
public class UserIO {

    /**
     * UserIO's domino game.
     */
    private DominoGame dominoGame;
    
    
    
    /**
     * Runs UserIO.
     */
    public void run() {
        String userIsPlayer = Console.readString("Do you want to play?");
        String userName = Console.readString("Enter your name:");
        int numBots = Console.readInt("Number of bots: ");
        setDominoGame(new DominoGame(numBots, userName));
        setDominoGame(new DominoGame(numBots));
        playOneTurn();
    }

    /**
     * Prompts player for action.
     */
    public void playOneTurn() {
        do {
            if (getDominoGame().getCurrentPlayer().getIsUser()) {
                printPlayerStatus();
                promptUser();
                printCurrentTurn();
            }
            else {
                // CONTINUE HERE, MAKE AN AI
            }
        } while (false); // winner
    }

    /**
     * Prints player's current status.
     */
    public void printPlayerStatus() {
        System.out.println(getDominoGame().getCurrentPlayer().getName() + " it is your turn.");
        System.out.println("Your hand\t: " + getDominoGame().getCurrentPlayer().getHand() + "\n");
    }

    /**
     * Prints current turn.
     */
    public void printCurrentTurn() {
        System.out.println("Round\t: " + getDominoGame().getTable().getRound());
        System.out.println("Player\t: " + getDominoGame().getCurrentPlayer().getName());
        System.out.println("Hand\t: " + getDominoGame().getCurrentPlayer().getHand());
        System.out.println("Drew:\t: " + getDominoGame().getCurrentPlayer().getDrewTiles());
        System.out.println("Used tile:\t " + getDominoGame().getCurrentPlayer().getPlayedTile());
        System.out.println("Table:\t " + getDominoGame().getTable().getTilesChain() + "\n");
    }
    
    /**
     * Prints user menu.
     */
    public void promptUser() {
        int userOption = Console.readInt("Choose:\n"
                + "1 - Play a tile.\n"
                + "2 -Draw a tile.\n"
                + "3 - Pass.\n");
        switch (userOption) {
            case 1:
                int tilePosition = Console.readInt("Which tile do you want to play?");
                getDominoGame().playPlayerTile(tilePosition);
                break;
            case 2:
                getDominoGame().drawPlayerTile();
                System.out.println("The tiles that you've already drawn are:");
                getDominoGame().getCurrentPlayer().getDrewTiles();
                break;
            case 3:
                getDominoGame().passPlayerTurn();
                break;
        }
    }

    /**
     * Prints domino game's winner.
     */
    public void printWinner() {
        // TODO implement here
    }
    
    /**
     * Getter.
     * @return dominoGame 
     */
    public DominoGame getDominoGame() {
        return dominoGame;
    }
    
    /**
     * Setter.
     * @param dominoGame
     */
    public void setDominoGame(DominoGame dominoGame) {
        this.dominoGame = dominoGame;
    }

}