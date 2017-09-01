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
        int numBots;
        int maxBots = 4;
        boolean userIsPlayer;
        userIsPlayer = Console.askYesNo("Do you want to be a player? ");
        if (userIsPlayer) {
            maxBots--;
        }
        numBots = Console.readIntInterval("Choose number of bots: ", 1, maxBots);
        if (userIsPlayer) {
            String userName = Console.readString("Enter your name:");
            setDominoGame(new DominoGame(numBots, userName));
        }
        else {
            setDominoGame(new DominoGame(numBots));
        }
        play();
    }
    
    /**
     * Prints player's current status.
     */
    private void printPlayerStatus() {
        System.out.println(getDominoGame().getCurrentPlayer().getName() + " it is your turn.");
        System.out.println("Your hand: " + getDominoGame().getCurrentPlayer().getHand() + "\n");
    }

    /**
     * Prints current turn.
     */
    private void printCurrentTurn() {
        System.out.println("Round\t: " + getDominoGame().getTable().getRound());
        System.out.println("Player\t: " + getDominoGame().getCurrentPlayer().getName());
        System.out.println("Hand\t: " + getDominoGame().getCurrentPlayer().getHand());
        System.out.println("Drew\t: " + getDominoGame().getCurrentPlayer().getDrewTiles());
        System.out.println("Used\t: " + getDominoGame().getCurrentPlayer().getPlayedTile());
        System.out.println("Table\t: " + getDominoGame().getTable().getTilesChain() + "\n");
    }

    /**
     * Prompts player for action.
     */
    private void play() {
        Player winner = null;
        do {
            if (getDominoGame().getCurrentPlayer().getIsUser()) {
                printPlayerStatus();
                printCurrentTurn();
                playUser();
            }
            else {
                playAI();
                printCurrentTurn();
            }
            winner = getDominoGame().searchWinner();
        } while (winner == null);
        System.out.println(winner.getName() + " is the winner.");
    }
    
    /**
     * AI plays
     */
    private void playAI() {
        for (int tileIndex = 0; tileIndex < getDominoGame().getCurrentPlayer().getHand().size(); tileIndex++) {
            if (getDominoGame().playPlayerTile(tileIndex));
                return;
        }
        
        if (getDominoGame().drawPlayerTile()) {
            return;
        }
        
        getDominoGame().passPlayer();
    }

  
    /**
     * Prints user menu.
     */
    private void playUser() {
        int userOption;
        boolean repeatTurn = true;
        while(repeatTurn) {
            userOption = userMenu();
            switch (userOption) {
                case 1:
                    int tilePosition = Console.readIntInterval("Which tile do you want to play? ", 1, getDominoGame().getCurrentPlayer().getHand().size());
                    if (getDominoGame().playPlayerTile(tilePosition - 1)) {
                        repeatTurn = false;
                    }
                    else {
                        System.out.println("Your tile does not fit within the tile chain.");
                    }
                    break;
                case 2:
                    if (getDominoGame().drawPlayerTile()) {
                        repeatTurn = false;
                    }
                    else {
                        System.out.println("You cannot draw a tile either because you have something to play or the boneyard is empty.");
                    }
                    break;
                case 3:
                    if (getDominoGame().passPlayer()) {
                        repeatTurn = false;
                    }
                    else {
                        System.out.println("You cannot pass either because you have something to play or the boneyard is not empty.");
                    }
                    break;
            }
        }
    }
    
    private int userMenu() {
        return Console.readIntInterval("Choose:\n"
                    + "1 - Play a tile.\n"
                    + "2 - Draw a tile.\n"
                    + "3 - Pass.\n", 1, 3);
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