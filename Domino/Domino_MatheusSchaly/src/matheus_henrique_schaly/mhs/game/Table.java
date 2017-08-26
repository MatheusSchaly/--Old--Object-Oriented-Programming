package matheus_henrique_schaly.mhs.game;

import java.util.*;

/**
 * The Domino's table.
 */
public class Table {

    /**
     * Tables's boneyard.
     */
    private ArrayList<Tile> boneyard = new ArrayList(28);

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
    public void Table() {
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
     * Getter.
     * Gets the tiles chain's right tile.
     * @return Tile chain's right most tile
     */
    public Tile getChainRightTile() {
        return getTilesChain().get(getTilesChain().size());
    }

    /**
     * Add a new tile to tiles chain's right side.
     * @param tile
     */
    public void addChainRightTile(Tile tile) {
        ArrayList<Tile> newChain = getTilesChain();
        newChain.add(newChain.size(), tile);
        setTilesChain(newChain);
        //setTilesChain(getTilesChain().add(getTilesChain().size(), tile));
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
     */
    public void addChainLeftTile(Tile tile) {
        ArrayList<Tile> newChain = getTilesChain();
        newChain.add(0, tile);
        setTilesChain(newChain);
        //setTilesChain(getTilesChain().add(0, tile));
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
    public ArrayList getBoneyard() {
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
        Tile drewTile = boneyard.get(0);
        boneyard.remove(0);
        return drewTile;
    }

    /**
     * Shuffles the table's tiles.
     */
    public void shuffle() {
        ArrayList<Tile> shuffledList = getBoneyard();
        Collections.shuffle(shuffledList);
        setBoneyard(shuffledList);
        setBoneyard(Collections.shuffle(getBoneyard())); // pod ser ele n da retorn
    }

}