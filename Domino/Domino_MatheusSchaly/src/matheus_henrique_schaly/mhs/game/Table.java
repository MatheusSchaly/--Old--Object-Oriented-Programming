package matheus_henrique_schaly.mhs.game;

import java.util.*;

/**
 * The Domino's table.
 */
public class Table {

    /**
     * Tables's boneyard.
     */
    private ArrayList<Tile> boneyard = new ArrayList<>(28);

    /**
     * Tables's tile chain.
     */
    private ArrayList<Tile> tilesChain = new ArrayList(28);
    
    /**
     * Table's round.
     */
    private int round;

    

    /**
     * Table's constructor.
     */
    public Table() {
        createBoneyard();
        shuffle();
        round = 1;
    }

    /**
     * Getter.
     * @return round
     */
    public int getRound() {
        return round;
    }
    
    /**
     * Setter.
     * @param round
     */
    public void setRound(int round) { // mudar para add
        this.round = round;
    }
    
    /**
     * Add one round
     */
    public void addRound() {
        setRound(getRound() + 1);
    }
    
    public void chainFirstTile(Tile tile) {
        getTilesChain().add(tile);
    }

    /**
     * Getter.
     * Gets the tiles chain's right tile.
     * @return Tile chain's right most tile
     */
    public Tile getChainRightTile() {
        return getTilesChain().get(getTilesChain().size() - 1);
    }

    /**
     * Add a new tile to tiles chain's right side.
     * @param tile
     * @return if added or not to the chain
     */
    public boolean addChainRightTile(Tile tile) {
        if (getChainRightTile().getRightValue() == tile.getLeftValue()) {
            getTilesChain().add(getTilesChain().size(), tile);
            return true;
        }
        return false;
    }

    /**
     * Getter.
     * Gets the tiles chain's left tile.
     * @return Tile left's right most tile
     */
    public Tile getChainLeftTile() {
        return getTilesChain().get(0);
    }

    /**
     * Add a new tile to tiles chain's left side.
     * @param tile
     * @return if added or not to the chain
     */
    public boolean addChainLeftTile(Tile tile) {
        if (getChainLeftTile().getLeftValue() == tile.getRightValue()) {
            getTilesChain().add(0, tile);
            return true;
        }
        return false;
    }
    
    /**
     * Getter.
     * @return tilesChain
     */
    public ArrayList<Tile> getTilesChain() {
        return tilesChain;
    }
    
    /**
     * Setter.
     * @param tilesChain 
     */
    public void setTilesChain(ArrayList<Tile> tilesChain) {
        this.tilesChain = tilesChain;
    }

    /**
     * Getter.
     * @return boneyard
     */
    public ArrayList<Tile> getBoneyard() {
        return boneyard;
    }
    
    /**
     * Setter.
     * @param boneyard
     */
    public void setBoneyard(ArrayList<Tile> boneyard) {
        this.boneyard = boneyard;
    }

    /**
     * Creates the boneyard.
     */
    public void createBoneyard() {
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                getBoneyard().add(new Tile(i, j));
            }
        }
    }
    
    /**
     * Remove a tile from boneyard.
     * @return drewTile
     */
    public Tile drawBoneyardTile() {
        Tile drewTile = getBoneyard().get(0);
        getBoneyard().remove(0);
        return drewTile;
    }

    /**
     * Shuffles the table's tiles.
     */
    public void shuffle() {
        Collections.shuffle(getBoneyard());
    }

}