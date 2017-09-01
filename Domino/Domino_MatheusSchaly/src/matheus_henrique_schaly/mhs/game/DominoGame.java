package matheus_henrique_schaly.mhs.game;

import java.util.*;

/**
 * The Domino Game.
 */
public final class DominoGame {

    /**
     * Domino's match winner.
     */
    private String winner;
    
    /**
     * Current player.
     */
    private Player currentPlayer;
    
    /**
     * Current player position.
     */
    private int playerArrayIndex;

    /**
     * Domino's game type.
     */
    private int numPlayers;

    /**
     * Domino's table.
     */
    private Table table = new Table();

    /**
     * Domino's players.
     */
    private final ArrayList<Player> players = new ArrayList(4);
    
    
    
    /**
     * Domino game's constructor.
     * @param numBots
     */
    public DominoGame(int numBots) {
        createBots(numBots);
        numPlayers = numBots;
        setPlayersHand();
        playFirstTile();
    }
    
    /**
     * Domino game's constructor.
     * @param numBots
     * @param name
     */
    public DominoGame(int numBots, String name) {
        createBots(numBots);
        getPlayers().add(new Player(name));
        numPlayers = numBots + 1;
        getPlayers().get(numPlayers - 1).setIsUser(true);
        setPlayersHand();
        playFirstTile();
    }
    
    /**
     * Getter.
     * @return winner
     */
    public String getWinner() {
        return winner;
    }

    /**
     * Setter.
     * @param winner
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    /**
     * Getter.
     * @return currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Setter.
     * @param currentPlayer
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    /**
     * Getter.
     * @return playerCurrentPosition
     */
    public int getPlayerArrayIndex() {
        return playerArrayIndex;
    }
    
    /**
     * Setter.
     * @param playerArrayIndex
     */
    public void setPlayerArrayIndex(int playerArrayIndex) {
        this.playerArrayIndex = playerArrayIndex;
    }

    /**
     * Getter.
     * @return players
     */
    public ArrayList getPlayersNames() {
        return players;
    }

    /**
     * Setter.
     * @param numBots
     */
    public void createBots(int numBots) {
        String botNames[] = {"Roy Batty", "Leaon Kowalski", "Pris Stratton", "Zhora Salome"};
        for (int i = 0; i < numBots; i++) {
            getPlayers().add(new Player(botNames[i]));
        }
    }
    
    /**
     * Getter.
     * @param player
     * @return ArrayList
     */
    public ArrayList<Tile> getPlayersHand(int player) {
        return getPlayers().get(player).getHand();
    }
    
    /**
     * Setter.
     */
    
    public void setPlayersHand() {
        for (int i = 0; i < getNumPlayers(); i++) {
            for (int j = 0; j < 7; j++) {
                getPlayers().get(i).addHandTile(getTable().drawBoneyardTile());
            }
        }
    }
    
    /**
     * Select the player that plays the first tile.
     */
    public void playFirstTile() {
        Tile playedTile;
        for (int i = 6; i != -1; i--) {
            for (int j = 0; j < getNumPlayers(); j++) {
                for (int k = 0; k < getPlayers().get(j).getHand().size(); k++) {
                    if (getPlayers().get(j).getHand().get(k).getLeftValue() == i && getPlayers().get(j).getHand().get(k).getRightValue() == i) {
                        playedTile = getPlayers().get(j).playTile(k);  
                        getTable().chainFirstTile(playedTile);
                        setCurrentPlayer(getPlayers().get(j));
                        setPlayerArrayIndex(j);
                        return;
                    }
                }
            }
        }
        for (int i = 5; i > -1; i--) {
            for (int j = 6; j > i - 1; j--) {
                if (j != i) {
                     for (int k = 0; j < getNumPlayers(); j++) {
                         for (int l = 0; l < getPlayers().get(k).getHand().size(); l++) {
                            if (getPlayers().get(k).getHand().get(l).getLeftValue() == i && getPlayers().get(k).getHand().get(l).getRightValue() == j) {
                                playedTile = getPlayers().get(j).playTile(k);  
                                getTable().chainFirstTile(playedTile);
                                setCurrentPlayer(getPlayers().get(k));
                                setPlayerArrayIndex(k);
                                return;
                            }
                        }
                    }
                }
            }
        }
        getTable().addRound();
    }
    
    /**
     * Plays a tile for the player, add a tile to tile chain.
     * @param tileIndex 
     * @return tile played or not
     */
    public boolean playPlayerTile(int tileIndex) {      
        if (checkPlayedTile(tileIndex)) {
            Tile playerPlayedTile = getCurrentPlayer().playTile(tileIndex);
            if (!getTable().addChainRightTile(playerPlayedTile)) {
                getTable().addChainLeftTile(playerPlayedTile);
            }
            return true;
        }
        
        return false;
    }
    
    private boolean checkPlayedTile(int tileIndex) {
        for (int i = 0; i < 2; i++) {
            if (getTable().getChainLeftTile().getLeftValue() == getCurrentPlayer().getHand().get(tileIndex).getRightValue() ||
                    getTable().getChainRightTile().getRightValue() == getCurrentPlayer().getHand().get(tileIndex).getLeftValue()) {
                return true;
            }
            getCurrentPlayer().getHand().get(tileIndex).tileFlip();
        }
        
        return false;
    }
    
    
    /**
     * Draws a tile for the player, remove a tile from boneyard.
     * @return bool
     */
    public boolean drawPlayerTile() {
        if (checkDrawTile()) {
            Tile drewTile = getTable().drawBoneyardTile();
            getCurrentPlayer().drawTile(drewTile);
            return true;
        }
        
        return false;
    }
    
    private boolean checkDrawTile() {
        if (getTable().getBoneyard().isEmpty()) {
            return false;
        }

        for (int i = 0; i < getCurrentPlayer().getHand().size(); i++) {
            if (checkPlayedTile(i)) {
                return false;
            }
        }
        
        return true;
    } 
    
    
    /**
     * Passes player turn.
     * @return 
     */
    public boolean passPlayer() {
        if (checkPass()) {
            getCurrentPlayer().setPassed(true);
            if (getPlayerArrayIndex() == getPlayers().size() - 1) {
                setCurrentPlayer(getPlayers().get(0));
            }
            else {
                setCurrentPlayer(getPlayers().get(getPlayerArrayIndex() + 1));
            }
            return true;
        }
        return false;        
    }
    
    private boolean checkPass() {
        if (getTable().getBoneyard().isEmpty()) {
            return false;
        }

        for (int i = 0; i < getCurrentPlayer().getHand().size(); i++) {
            if (checkPlayedTile(i)) {
                return false;
            }
        }
        
        return true;
    } 
    
    public Player searchWinner() {
        if (getCurrentPlayer().getHand().isEmpty()) {
            return getCurrentPlayer();
        }
        
        for (int playerIndex = 0; playerIndex < getNumPlayers(); playerIndex++) {
            if (!getPlayers().get(playerIndex).getPassed()) {
                return null;
            }
        }
        
        ArrayList<Integer> playerPoints = new ArrayList(getNumPlayers());
        for (int playerIndex = 0; playerIndex < getNumPlayers(); playerIndex++) {
            playerPoints.add(getPlayers().get(playerIndex).calculatePoints());
        }
        
        for (int playerIndex = 0; playerIndex < getNumPlayers(); playerIndex++) {
            if (getPlayers().get(playerIndex).getPoints() == Collections.max(playerPoints)) {
                return getPlayers().get(playerIndex);
            }
        }
        
        return null;
    }
    

    /**
     * Getter.
     * @return numPlayers
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * Setter.
     * @param numPlayers
     */
    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    /**
     * Getter.
     * @return table
     */
    public Table getTable() {
        return table;
    }

    /**
     * Setter.
     * @param table
     */
    public void setTable(Table table) {
        this.table = table;
    }
    
    /**
     * Getter
     * @return players 
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

}