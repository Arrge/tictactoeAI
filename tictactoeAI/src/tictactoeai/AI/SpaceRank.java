
package tictactoeai.AI;

/**
 *
 * @author Liekkipipo-pc
 */
public class SpaceRank {

    /**
     *
     */
    public int rank;
    public int x,

    /**
     *
     */
    y;
    private boolean[] marksHoriz, marksVert, marksDiag;

    /**
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public SpaceRank(int x, int y) {
        this.rank = 0;
        this.x = x;
        this.y = y;
        this.marksHoriz = new boolean[10];
        this.marksVert = new boolean[10];
        this.marksDiag = new boolean[10];
    }
    
    /**
     * Calculates the rank of the space
     * @return returns the rank of the space
     */
    public int calculateRank() {
        for (int i = 0; i < 10; i++) {
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
        return rank;
    }
    
    //replace with addMark/removeMark(direction, distance)?

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
    
    
}
