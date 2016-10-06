package tictactoeai.board;

/**
 *
 * @author Liekkipipo-pc
 */
public class GridValues {
    int[][] grid;
    int sideLength;
    int setValues;
    /**
     * 
     * @param sideLength the grid size is sideLength * sideLength
     */
    public GridValues(int sideLength) {
        this.grid = new int[sideLength][sideLength];
        this.sideLength = sideLength;
        setValues = 0;
    }
    
    /**
     * 
     * @return returns a copy of the grid
     */
    public GridValues cloneGrid() {
        GridValues newGridValues = new GridValues(sideLength);
        int[][] newGrid = new int[sideLength][sideLength];
        newGridValues.setValues = setValues;
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                newGrid[i][j] = this.grid[i][j];
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
    public boolean setSpace(int x, int y, int mark) {
        if (grid[x][y] != 0) {
            return false;
        }
        setValues++;
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
    public int getMark(int x, int y) {
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
    public int[][] getGrid() {
        return grid;
    }

    public int getSetValues() {
        return setValues;
    }
    
    
    
    /**
     *
     * @param grid
     */
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    
    
}
