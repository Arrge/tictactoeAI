package tictactoeai.AI;

import tictactoeai.board.GridValues;

/**
 * 
 * @author Liekkipipo-pc
 */
public class SpaceRank {
    int x, y;
    int rank;
    int opponentsRank;
    int futureMovesRank;
    int index;
    GridValues gv;
    int[] consecutives;
    int[] openSides;
    int forcedMove;
    int winningMove;
    int enemyWinningMove;
    
    /**
     * value calculator for a single space
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
        //game can be won in (7 - sum) moves if sum >= 5
        int sum;
        for (int i = 0; i < 4; i++) {
            sum = consecutives[i] + openSides[i];
            if (sum == 5) {
                winningMove = 1;
                rank += 30;
            }
            if(consecutives[i] >= 4 || sum > 5) {
                rank += 30000;
            }
            else {
                if (consecutives[i] > 0) {
                    rank += consecutives[i] + (openSides[i]/2);
                }
                else {
                    rank += consecutives[i];
                }
            }
        } 
        
        return rank >= 30000;
    }
    
    /**
     * calculates the opponents rank for the space after required information has been entered
     */
    public void calculateOpponentsRank() {
        //game can be won in (7 - sum) moves if sum >= 5
        int sum; 
        for (int i = 4; i < 8; i++) {
            sum = consecutives[i] + openSides[i];
            
            if (sum == 5 && winningMove == 0) {
                enemyWinningMove = 1;
                opponentsRank += 30;
            }
            if (consecutives[i] >= 4 || sum > 5) {
                forcedMove = 1;
                opponentsRank += 30000;
                break;
            }
            else {
                if (consecutives[i] > 0) {
                    opponentsRank += consecutives[i] + (openSides[i]/2);
                }
                else {
                    opponentsRank += consecutives[i];
                }
                
            }
        }
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

    /**
     *
     * @return
     */
    public int getRank() {
        return rank;
    }

    public void setGrid(GridValues gv) {
        this.gv = gv.cloneGrid();
    }

    
    
    public void setMoveOnGrid(GridValues gv, short mark) {
        this.gv = gv.cloneGrid();
        this.gv.setSpace(x, y, mark);
    }

    
    
    /**
     *
     * @return
     */
    public int getOpponentsRank() {
        return opponentsRank;
    }
    
    /**
     *
     * @return opponents rank + rank
     */
    public int getTotalRank() {
        return rank + opponentsRank + futureMovesRank;
    }

    /**
     * does the space have to be filled or the game is lost
     * @return 
     */
    public int isForcedMove() {
        return forcedMove;
    }

    /**
     * 
     * @return
     */
    public int isWinningMove() {
        return winningMove;
    }

    /**
     *
     * @return
     */
    public int isEnemyWinningMove() {
        return enemyWinningMove;
    }

    public GridValues getGridValues() {
        return gv;
    }

    public void addToFutureMovesRank(int futureMovesRank) {
        this.futureMovesRank += futureMovesRank;
    }
}
