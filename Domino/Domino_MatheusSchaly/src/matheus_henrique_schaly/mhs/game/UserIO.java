package matheus_henrique_schaly.mhs.game;

import java.io.IOException;
import java.nio.channels.InterruptedByTimeoutException;

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
        playOneTurn();
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
    private void playOneTurn() {
        do {
            if (getDominoGame().getCurrentPlayer().getIsUser()) {
                printPlayerStatus();
                printCurrentTurn();
                promptUser();
            }
            else {
                playAI(); 
                printCurrentTurn();
            }
        } while (false); // winner
    }
    
    private void playAI() {
        boolean aiPlayed = false;
        do {
            aiPlayed = playAiTile();
            if (aiPlayed) {
                break;
            }
            aiPlayed = drawAiTile();
            if (aiPlayed) {
                break;
            }
        } while (getDominoGame().getTable().getBoneyard().isEmpty());
        try {
            getDominoGame().checkIfPlayerCanPass();
        } catch (Exception e) {
            
        }
        
    }
    
    private boolean drawAiTile() {
        try {
            getDominoGame().drawPlayerTile();
        } 
        catch (IOException e) {
            return false;
        }
        getDominoGame().getCurrentPlayer().getDrewTiles();
        return true;
    }
    
    private boolean playAiTile() {
        int i = 0;
        do {
            try {
                getDominoGame().playPlayerTile(i);
                return true;
            } catch (IOException e) {
                i++;
            }
        } while (i < getDominoGame().getCurrentPlayer().getHand().size());
        return false;
    }
  
    /**
     * Prints user menu.
     */
    private void promptUser() {
        int userOption;
        boolean userPlayed = false;
        boolean playerPassed = false;
        do {
            userOption = Console.readIntInterval("Choose:\n"
                    + "1 - Play a tile.\n"
                    + "2 - Draw a tile.\n"
                    + "3 - Pass.\n", 1, 3);
            switch (userOption) {
                case 1:
                    userPlayed = playingTile();
                    break;
                case 2:
                    userPlayed = drawingTile();
                    break;
                case 3:
                    userPlayed = passTurn();
                    if (userPlayed) {
                        playerPassed = true;
                    }
                    break;
            }
        } while (!userPlayed);
        if (!playerPassed) {
            getDominoGame().passPlayerTurn();
        }
    }
    
    private boolean playingTile() { // Not chained exceptions below
        int tilePosition;
        do {
            try {
                tilePosition = Console.readIntInterval("Which tile do you want to play? ", 1, getDominoGame().getCurrentPlayer().getHand().size());
                getDominoGame().playPlayerTile(tilePosition - 1);
                return true;
            }
            catch (IOException e) {
                System.out.println("Your tile does not fit within the tile chain");
            }
            if(Console.askYesNo("Do you want to go back to the menu? ")) {
                return false;
            }
        } while (true);
    }
    
    private boolean drawingTile() {
        try {
            getDominoGame().drawPlayerTile();
        } 
        catch (IOException e) {
            System.out.println("You can only draw a tile if you do not have any tile to be played, go check it.");
            return false;
        }
        System.out.println("The tiles that you've already drewn are:");
        getDominoGame().getCurrentPlayer().getDrewTiles();
        return true;
    }
    
    private boolean passTurn() {
        try {
            getDominoGame().checkIfPlayerCanPass();
        }
        catch (InterruptedByTimeoutException e) {
            System.out.println("You could pass if the boneyard was empty, go check it");
            return false;
        }
        catch (IOException e) {
            System.out.println("You could pass if you had not a tile to play, go check it");
            return false;
        }
        return true;
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

//            do { // MAKE A CHAINED EXCEPTIONS OR NOT ??
//                tilePosition = Console.readIntInterval("Which tile do you want to play?", 1, getDominoGame().getCurrentPlayer().getHand().size());
//                if (getDominoGame().getTable().getChainLeftTile().getLeftValue() == getDominoGame().getCurrentPlayer().getHand().get(tileIndex).getRightValue()) {
//                    validTile = true;
//                }
//                else if (getDominoGame().getTable().getChainRightTile().getRightValue() == getDominoGame().getCurrentPlayer().getHand().get(tileIndex).getLeftValue()) {
//                    validTile = true;
//                }
//                else {
//                    System.out.println("Invalid tile, ");
//                }
//            } while (!validTile);
//        getDominoGame().playPlayerTile(tilePosition - 1);