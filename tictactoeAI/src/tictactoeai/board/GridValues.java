package tictactoeai.board;

/**
 *
 * @author Liekkipipo-pc
 */
public class GridValues {
    private short[][] grid;
    private int sideLength;

    /**
     * 
     * @param sideLength the grid size is sideLength * sideLength
     */
    public GridValues(int sideLength) {
        this.grid = new short[sideLength][sideLength];
        this.sideLength = sideLength;
    }
    
    public GridValues cloneGrid() {
        GridValues newGridValues = new GridValues(sideLength);
        short[][] newGrid = new short[sideLength][sideLength];
        
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }
        newGridValues.setGrid(newGrid);
        return newGridValues;
    }
    /**
     * Set the mark of a unset space
     * @param x 
     * @param y
     * @param mark true for cross, false for circle
     * @return returns false if space has a mark
     */
    public boolean setSpace(int x, int y, short mark) {
        if (grid[x][y] != 0) {
            return false;
        }
        grid[x][y] = mark;
        return true;
    }
    
    /**
     * check if space is set
     * @param x
     * @param y
     * @return returns the value of space
     */
    public boolean isEmpty(int x, int y) {
        return grid[x][y] == 0;
    }
    
    /**
     * gets the mark of the space
     * @param x
     * @param y
     * @return returns the mark of the space or 3 if outside of board
     */
    public short getMark(int x, int y) {
        if (x < 0 || y < 0 || x >= sideLength || y >= sideLength) {
            return 3;
        }
        return grid[x][y];
    }

    /**
     *
     * @return 
     */
    public int getSideLength() {
        return sideLength;
    }

    /**
     *
     * @return
     */
    public short[][] getGrid() {
        return grid;
    }
    
    public void setGrid(short[][] grid) {
        this.grid = grid;
    }
    
    
}
