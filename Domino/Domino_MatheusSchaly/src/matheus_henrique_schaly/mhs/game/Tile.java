package matheus_henrique_schaly.mhs.game;

/**
 * The Table's tile.
 */
public class Tile {
    
    /**
     * Tile's left and right values.
     */
    private final int[] value = new int[2];
    
    /**
     * Tile's total value.
     */
    private final int totalValue;
    
    
    
    /**
     * Tile value's constructor.
     * @param leftValue
     * @param rightValue
     */
    public Tile(int leftValue, int rightValue) {
        value[0] = leftValue;
        value[1] = rightValue;
        totalValue = leftValue + rightValue;
    }
    
    /**
     * Getter.
     * @return Tile's left value
     */
    public int getLeftValue() {
        return value[0];
    }
    
    /**
     * Getter.
     * @return Tile's right value
     */
    public int getRightValue() {
        return value[1];
    }
    
    /**
     * Setter.
     * @param leftValue Tile's left value 
     */
    public void setLeftValue(int leftValue) {
        value[0] = leftValue;
    }
    
    
    /**
     * Setter.
     * @param rightValue Tile's right value 
     */
    public void setRightValue(int rightValue) {
        value[1] = rightValue;
    }
    
    /**
     * Getter.
     * @return totalValue
     */
    public int getTotalValue() {
        return totalValue;
    }
    
    /**
     * Flips the tile's values
     */
    public void tileFlip() {
        int aux = getLeftValue();
        setLeftValue(getRightValue());
        setRightValue(aux);
    }

    
    @Override
    public String toString() {
        return "[" + getLeftValue() + "," + getRightValue() + "]";
    }
    
}