package matheus_henrique_schaly.mhs.game;

import java.util.*;

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
        int numPlayers = Console.readInt("Number of players: ");
        getDominoGame().setNumPlayers(numPlayers); // talvez usar no construtor
        ArrayList<String> names = new ArrayList(numPlayers); // eh soh o nome do user carai
        for (int i = 0; i < numPlayers; i++) {
            names.add(Console.readString("Name of " + i + "º player:"));
        }
        getDominoGame().setPlayersNames(names);
        getDominoGame().setPlayersHand(); // talvez usar no construtor
        getDominoGame().playFirstTile();
        playOneTurn();
    }

    /**
     * Prompts player for action.
     */
    public void playOneTurn() {
        do {
            printCurrentTurn();
            if (getDominoGame().getCurrentPlayer().getIsUser()) {
                printPlayerStatus();
                promptUser();
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
        Scanner input = new Scanner(System.in);
        int userOption = userMenu();
        switch (userOption) {
            case 1:
                int userTile;
                System.out.println("Which tile do you want to play?");
                userTile = input.nextInt(); // Cagou de novo
                getDominoGame().getCurrentPlayer().playTile(userTile);
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
     * User menu.
     * @return userOption
     */
    public static int userMenu () {
        System.out.println("Choose:");
        System.out.println("1 - Play a tile.");
        System.out.println("2 - Draw a tile.");
        System.out.println("3 - Pass.\n");
        Scanner input = new Scanner(System.in); // Cagou pro console burro
        return input.nextInt();
    }
    
    /**
     * Getter.
     * @return dominoGame 
     */
    public DominoGame getDominoGame() {
        return dominoGame;
    }

}