package matheus_henrique_schaly.mhs.game;

import java.util.*;

/**
 * The Domino's player.
 */
public class Player {

    /**
     * Player's hand.
     */
    private ArrayList<Tile> hand = new ArrayList();

    /**
     * Player's draw tiles.
     */
    private ArrayList<Tile> drewTiles = new ArrayList(14);

    /**
     * Player's name.
     */
    private String name;
    
    /**
     * Player's played tile.
     */
    private Tile playedTile;

    /**
     * True is the player is a user.
     */
    private boolean isUser;

    /**
     * True if the player has passed.
     */
    private boolean passed;
    
    
    private int points;
    
    
    /**
     * Player's constructor.
     * @param name 
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Getter.
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Getter.
     * @return playedTile
     */
    public Tile getPlayedTile() {
        return playedTile;
    }
    
    /**
     * Setter.
     * @param playedTile
     */
    public void setPlayedTile(Tile playedTile) {
        this.playedTile = playedTile;
    }

    /**
     * Getter.
     * @return hand
     */
    public ArrayList<Tile> getHand() {
        return hand;
    }

    /**
     * Adds one tile to the hand.
     * @param tile
     */
    public void addHandTile(Tile tile) {
        hand.add(tile);
    }

    /**
     * Setter.
     * @param isUser
     */
    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    /**
     * Getter.
     * @return isUser
     */
    public boolean getIsUser() {
        return isUser;
    }

    /**
     * Getter.
     * @return pass
     */
    public boolean getPassed() {
        return passed;
    }
    
    /**
     * Setter.
     * @param pass
     */
    public void setPassed(boolean pass) {
        passed = pass;
    }

    /**
     * Calculates playes points based on his or her remaining 
     * hand's tiles.
     * @return pointSum
     */
    public int calculatePoints() {
        int pointsSum = 0;
        for (Tile tile : getHand()) {
            pointsSum += tile.getTotalValue();
        }
        setPoints(pointsSum);
        return pointsSum;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public int getPoints() {
        return points;
    }

    /**
     * Draws a tile from boneyard.
     * @param tile
     */
    public void drawTile(Tile tile) {
        getHand().add(tile);
        getDrewTiles().add(tile);
    }

    /**
     * Plays a tile at the table's tile chain.
     * @param handTileIndex
     * @return playerPlayedTile
     */
    public Tile playTile(int handTileIndex) {
        Tile playerPlayedTile = getHand().get(handTileIndex);
        getHand().remove(handTileIndex);
        setPlayedTile(playerPlayedTile);
        return playerPlayedTile;
    }

    /**
     * Getter.
     * @return
     */
    
    public ArrayList getDrewTiles() {
        return drewTiles;
    }
    
}