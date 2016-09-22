
package tictactoeai.AI;

/**
 *
 * @author Liekkipipo-pc
 */
public class SpaceRank {

    /**
     *
     */
    int rank;
    int x, y;
    boolean[] marksHoriz, marksVert, marksDiag;
    int consecutiveHoriz, consecutiveVert, consecutiveDiag;
    //index of the first open space from (x,y)
    int horizOpenLeft, horizOpenRight, vertOpenLeft, vertOpenRight, diagOpenLeft, diagOpenRight;
    /**
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public SpaceRank(int x, int y) {
        this.rank = 0;
        this.x = x;
        this.y = y;
        this.marksHoriz = new boolean[9];
        this.marksVert = new boolean[9];
        this.marksDiag = new boolean[9];
    }
    
    /**
     * Calculates the rank of the space
     * @return returns the rank of the space
     */
    public int calculateRank() {
        
        
        
        calculateMarks();
        rank += checkConsecutives();
        rank += (consecutiveHoriz + consecutiveDiag + consecutiveVert)/2;
        
        return rank;
    }
    
    private int checkConsecutives() {
        //add 10000 to rank if the move wins the game
        if (consecutiveHoriz == 4 || consecutiveVert == 4 || consecutiveDiag == 4) {
            return 10000;
        }
        //if 3 consecutive marks around the space and open slot on both sides
        if (consecutiveHoriz == 3) {
            if (horizOpenRight - horizOpenLeft == 5) {
                return 10000;
            }
        }
        
        if (consecutiveVert == 3) {
            if (vertOpenRight - vertOpenLeft == 5) {
                return 10000;
            }
        }
        
        if (consecutiveDiag > 2) {
            if (diagOpenRight - diagOpenLeft == 5) {
                return 10000;
            }
        }
        return 0;
    }
    
    private void calculateMarks() {
        for (int i = 0; i < marksHoriz.length; i++) {
            if (marksHoriz[i] == true) {
                rank++;
            }
            if (marksVert[i] == true) {
                rank++;
            }
            if (marksDiag[i] == true) {
                rank++;
            }
        }
    }
    
    public void addVerticalOpen(int distance) {
        if (distance < 0) {
            vertOpenLeft = 4 + distance;
        }
        else if (distance > 0) {
            vertOpenRight = 4 + distance;
        }
    }
    
    public void addHorizontalOpen(int distance) {
        if (distance < 0) {
            horizOpenLeft = 4 + distance;
        }
        else if (distance > 0) {
            horizOpenRight = 4 + distance;
        }
    }
    
    public void addDiagonalOpen(int distance) {
        if (distance < 0) {
            diagOpenLeft = 4 + distance;
        }
        else if (distance > 0) {
            diagOpenRight = 4 + distance;
        }
    }
    
    /**
     * add the amount of consecutive marks from space on the horizontal sides of the space
     * @param consecutive consecutive horizontal marks from space
     */
    public void addHorizontalConsecutives(int consecutive) {
        if (consecutive > consecutiveHoriz) {
            consecutiveHoriz = consecutive;
        }
    }

    /**
     * add the amount of consecutive marks from space on the vertical sides of the space
     * @param consecutive consecutive vertical marks from space
     */
    public void addVerticalConsecutives(int consecutive) {
        if (consecutive > consecutiveVert) {
            consecutiveVert = consecutive;
        }
    }
    
    /**
     * add the amount of consecutive marks from space on the diagonal sides of the space
     * @param consecutive consecutive diagonal marks from space 
     */
    public void addDiagonalConsecutives(int consecutive) {
        if (consecutive > consecutiveDiag) {
            consecutiveDiag = consecutive;
        }
    }
    
    /**
     * add mark that is horizontal distance away from the space
     * @param distance
     */
    public void addHorizontalMark(int distance) {
        marksHoriz[4+distance] = true;
    }
    
    /**
     * add mark that is vertical distance away from the space
     * @param distance
     */
    public void addVerticalMark(int distance) {
        marksVert[4+distance] = true;
    }
    
    /**
     * add mark that is diagonal distance away from the space
     * @param distance
     */
    public void addDiagonalMark(int distance) {
        marksDiag[4+distance] = true;
    }
    
    /**
     * remove all horizontal marks that are equal and over the distance from space
     * @param distance
     */
    public void removeHorizontalMark(int distance) {
        if (distance < 0) {
            for (int i = 4+distance;i >= 0; i--) {
                marksHoriz[i] = false;
            }
        }
        else {
            for (int i = 4+distance; i < 10;i++) {
                marksHoriz[i] = false;
            }
        }
    }
    
    /**
     * remove all vertical marks that are equal and over the distance from space
     * @param distance
     */
    public void removeVerticalMark(int distance) {
        if (distance < 0) {
            for (int i = 4+distance;i >= 0; i--) {
                marksVert[i] = false;
            }
        }
        else {
            for (int i = 4+distance; i < 10;i++) {
                marksVert[i] = false;
            }
        }
    }
    
    /**
     * remove all diagonal marks that are equal and over the distance from space
     * @param distance
     */
    public void removeDiagonalMark(int distance) {
        if (distance < 0) {
            for (int i = 4+distance;i >= 0; i--) {
                marksDiag[i] = false;
            }
        }
        else {
            for (int i = 4+distance; i < 10;i++) {
                marksDiag[i] = false;
            }
        }
    }
    
    /**
     * 
     * @return return the x coordinate of the space
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return return the y coordinate of the space
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return return the rank of the space
     */
    public int getRank() {
        return rank;
    }

    /**
     * set the rank of the space
     * @param rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public void addToRank(int rank) {
        this.rank += rank;
    }
}
