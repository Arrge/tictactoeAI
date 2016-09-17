package tictactoeai.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Liekkipipo-pc
 */
public class GridValues {
    private Boolean[][] grid;
    private int sideLength;

    public GridValues(int sideLength) {
        this.grid = new Boolean[sideLength][sideLength];
        this.sideLength = sideLength;
    }
    /**
     *
     * @param sideLength
     */
    
    
    /**
     * Set the mark of a unset space
     * @param x 
     * @param y
     * @param mark true for cross, false for circle
     * @return returns false if space has a mark
     */
    public boolean setSpace(int x, int y, boolean mark) {
        if (grid[x][y] != null) {
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
    public boolean isUnset(int x, int y) {
        return (grid[x][y] == null);
    }
    
    /**
     * gets the current mark of the space
     * @param x
     * @param y
     * @return returns the current mark of the space
     */
    public Boolean getMark(int x, int y) {
        return grid[x][y];
    }

    public int getSideLength() {
        return sideLength;
    }
}
