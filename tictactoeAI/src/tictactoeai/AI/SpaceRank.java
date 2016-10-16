package tictactoeai.AI;

import tictactoeai.board.GridValues;

/**
 * rank calculator for a single space
 * @author Liekkipipo-pc
 */
public class SpaceRank {
    int x, y;
    int rank;
    int index;
    GridValues gv;
    int[] consecutives;
    int[] openSides;
    int rankMultiplier = 6;
    /**
     * rank calculator for a single space
     * @param x coordinate
     * @param y coordinate
     */
    public SpaceRank(int x, int y) {
        this.x = x;
        this.y = y;
        this.consecutives = new int[8];
        this.openSides = new int[8];
    }
    
    /**
     * set the amount of open sides and consecutive marks around the space
     * @param openSides the amount of open sides on the row/col/...
     * @param consecutives amount of consecutive marks around the space
     */
    public void setOpenSidesAndConsecutives(int openSides, int consecutives) {
        this.consecutives[index] = consecutives;
        this.openSides[index] = openSides;
        index++;
    }
    
    /**
     * calculates the rank of the space after required information has been entered
     * @return returns true if the move wins the game instantly
     */
    public boolean calculateRank() {
        for (int i = 0; i < 4; i++) {
            if (consecutives[i] == 4) {
                    rank += 48 * rankMultiplier;
                }
            else if (consecutives[i] + openSides[i] >= 5) {
                rank += 24 * rankMultiplier;
            }
            else {
                rank += consecutives[i] * openSides[i] * rankMultiplier;
            }
        } 
        
        return rank >= 48 * rankMultiplier;
    }
    
    /**
     * calculates the opponents rank for the space after required information has been entered
     */
    public void calculateOpponentsRank() {
        int sum;
        for (int i = 4; i < 8; i++) {
            if (consecutives[i] == 4) {
                rank += 36 * rankMultiplier;
            } 
            else if (consecutives[i] + openSides[i] >= 5) {
                rank += 18 * rankMultiplier;
            } 
            else {
                rank += consecutives[i] * openSides[i] * rankMultiplier;
            }
        }
        consecutives = null;
        openSides = null;
    }

    /**
     * 
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    public void setGrid(GridValues gv) {
        this.gv = gv.cloneGrid();
    }

    public void setMoveOnGrid(GridValues gv, int mark) {
        this.gv = gv.cloneGrid();
        this.gv.setSpace(x, y, mark);
    }

    /**
     *
     * @return opponents rank + rank
     */
    public int getRank() {
        return rank;
    }

    public GridValues getGridValues() {
        return gv;
    }
}
