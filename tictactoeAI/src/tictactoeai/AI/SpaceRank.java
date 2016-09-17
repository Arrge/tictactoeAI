
package tictactoeai.AI;

/**
 *
 * @author Liekkipipo-pc
 */
public class SpaceRank {
    private int rank;
    private int x, y;
    private boolean[] marksHoriz, marksVert, marksDiag;

    public SpaceRank(int x, int y) {
        this.rank = 0;
        this.x = x;
        this.y = y;
        this.marksHoriz = new boolean[8];
        this.marksVert = new boolean[8];
        this.marksDiag = new boolean[8];
    }
    
    
    
    //replace with addMark/removeMark(direction, distance)?
    public void addHorizontalMark(int distance) {
        marksHoriz[4+distance] = true;
    }
    
    public void addVerticalMark(int distance) {
        marksVert[4+distance] = true;
    }
    
    public void addDiagonalMark(int distance) {
        marksDiag[4+distance] = true;
    }
    
    public void removeHorizontalMark(int distance) {
        if (distance < 0) {
            for (int i = 4+distance;i >= 0; i--) {
                marksHoriz[i] = false;
            }
        }
        else {
            for (int i = 4+distance; i < 8;i++) {
                marksHoriz[i] = false;
            }
        }
    }
    
    public void removeVerticalMark(int distance) {
        if (distance < 0) {
            for (int i = 4+distance;i >= 0; i--) {
                marksVert[i] = false;
            }
        }
        else {
            for (int i = 4+distance; i < 8;i++) {
                marksVert[i] = false;
            }
        }
    }
    
    public void removeDiagonalMark(int distance) {
        if (distance < 0) {
            for (int i = 4+distance;i >= 0; i--) {
                marksDiag[i] = false;
            }
        }
        else {
            for (int i = 4+distance; i < 8;i++) {
                marksDiag[i] = false;
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
    
    
}
