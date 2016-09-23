package tictactoeai.AI;

/**
 *
 * @author Liekkipipo-pc
 */
public class SpaceRank {
    int x, y;
    int rank;
    int opponentsRank;
    int index;
    
    int[] consecutives;
    int[] openSides;
    int forcedMove;
    int winningMove;
    int enemyWinningMove;
    
    
    public SpaceRank(int x, int y) {
        this.x = x;
        this.y = y;
        this.consecutives = new int[8];
        this.openSides = new int[8];
    }
    
    public void setOpenSidesAndConsecutives(int openSides, int consecutives) {
        this.consecutives[index] = consecutives;
        this.openSides[index] = openSides;
        index++;
    }
    
    public boolean calculateRank() {
        //game can be won in (7 - sum) moves if sum >= 5
        int sum;
        for (int i = 0; i < 4; i++) {
            sum = consecutives[i] + openSides[i];
            if (sum == 5) {
                winningMove = 1;
            }
            else if(consecutives[i] >= 4 || sum > 5) {
                return true;
            }
            else {
                rank += consecutives[i];
            }
        } 
        
        return false;
    }
    
    public void calculateOpponentsRank() {
        //game can be won in (7 - sum) moves if sum >= 5
        int sum; 
        for (int i = 4; i < 8; i++) {
            sum = consecutives[i] + openSides[i];
            
            if (sum == 5 && winningMove == 0) {
                enemyWinningMove = 1;
            }
            else if (consecutives[i] >= 4 || sum > 5) {
                forcedMove = 1;
                break;
            }
            else {
                opponentsRank += consecutives[i];
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRank() {
        return rank;
    }

    public int getOpponentsRank() {
        return opponentsRank;
    }
    
    public int getTotalRank() {
        return rank + opponentsRank;
    }

    public int isForcedMove() {
        return forcedMove;
    }

    public int isWinningMove() {
        return winningMove;
    }

    public int isEnemyWinningMove() {
        return enemyWinningMove;
    }
}
