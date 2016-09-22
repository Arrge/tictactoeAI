
package tictactoeai.AI.tools;

import tictactoeai.AI.SpaceRank;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class BoardScanner {
    
    /**
     * check for marks and consecutive marks up to 4 spaces away from current space
     * @param sr 
     * @param grid
     * @param mark true = cross, false = circle
     * @return returns rank of the space
     */
    public static SpaceRank calculateRank(SpaceRank sr, GridValues grid, boolean mark) {
        //if space is already marked, give negative rank 
        if (grid.getMark(sr.getX(), sr.getY()) != null) {
            sr.setRank(-1);
            return sr;
        }
        BoardScanner.horizontalMarks(sr, grid, mark);
        BoardScanner.verticalMarks(sr, grid, mark);
        BoardScanner.DiagonalMarks(sr, grid, mark);
        return sr;
    }
    
    /**
     * check horizontally for marks and consecutive marks up to 4 spaces away from current space
     * @param sr
     * @param grid
     * @param mark true = cross, false = circle
     * @return returns the updated SpaceRank
     */
    public static SpaceRank horizontalMarks(SpaceRank sr, GridValues grid, boolean mark) {
        int x = sr.getX();
        int y = sr.getY();
        int consecutive = 0;
        
        for (int ax = x + 1; ax < grid.getSideLength() && ax < x + 5; ax++) {
            if (grid.getMark(ax, y) == null) {
                sr.addHorizontalOpen(ax - x);
                break;
            }
            if (grid.getMark(ax, y) == !mark) {
                sr.addHorizontalConsecutives(consecutive);
                consecutive = 0;
                break;
            }
            else {
                sr.addHorizontalMark(ax - x);
                consecutive++;
            }
        }
        
        for (int ax = x - 1; ax > 0 && ax > x - 5; ax--) {
            if (grid.getMark(ax, y) == null) {
                sr.addHorizontalOpen(ax - x);
                break;
            }
            if (grid.getMark(ax, y) == !mark) {
                sr.addHorizontalConsecutives(consecutive);
                consecutive = 0;
                break;
            }
            else {
                sr.addHorizontalMark(ax - x);
                consecutive++;
            }
        }
        sr.addHorizontalConsecutives(consecutive);
        
        return sr;
    }
    
    /**
     * check vertically for marks and consecutive marks up to 4 spaces away from current space and finds the first open space to the left and right
     * @param sr
     * @param grid
     * @param mark true = cross, false = circle
     * @return returns the updated SpaceRank
     */
    public static SpaceRank verticalMarks(SpaceRank sr, GridValues grid, boolean mark) {
        int x = sr.getX();
        int y = sr.getY();
        int consecutive = 0;
        
        for (int ay = y + 1; ay < grid.getSideLength() && ay < y + 5; ay++) {
            if (grid.getMark(x, ay) == null) {
                sr.addVerticalOpen(ay - y);
                break;
            }
            if (grid.getMark(x, ay) == !mark) {
                sr.addVerticalConsecutives(consecutive);
                consecutive = 0;
                break;
            }
            else {
                sr.addVerticalMark(ay - y);
                consecutive++;
            }
        }
        
        for (int ay = y - 1; ay >= 0 && ay > y - 5; ay--) {
            if (grid.getMark(x, ay) == null) {
                sr.addVerticalOpen(ay - y);
                break;
            }
            if (grid.getMark(x, ay) == !mark) {
                sr.addVerticalConsecutives(consecutive);
                consecutive = 0;
                break;
            }
            else {
                sr.addVerticalMark(ay - y);
                consecutive++;
            }
        }
        
        sr.addVerticalConsecutives(consecutive);
        
        return sr;
    }
    
    /**
     * check diagonally for marks and consecutive marks up to 4 spaces away from current space
     * @param sr
     * @param grid
     * @param mark true = cross, false = circle
     * @return returns the updated SpaceRank
     */
    public static SpaceRank DiagonalMarks(SpaceRank sr, GridValues grid, boolean mark) {
        int x = sr.getX();
        int y = sr.getY();
        int consecutive = 0;
        
        for (int a = 1; a + x < grid.getSideLength() && a+y < grid.getSideLength() && a < 5; a++) {
            if (grid.getMark(x+a, y+a) == null) {
                sr.addDiagonalOpen(a);
                break;
            }
            if (grid.getMark(x+a, y+a) == !mark) {
                sr.addDiagonalConsecutives(consecutive);
                consecutive = 0;
                break;
            }
            else {
                sr.addDiagonalMark(a);
                consecutive++;
            }
        }
        
        for (int a = -1; a + x >= 0 && a+y >= 0 && a > -5; a--) {
            if (grid.getMark(x+a, y+a) == null) {
                sr.addDiagonalOpen(a);
                break;
            }
            if (grid.getMark(x+a, y+a) == !mark) {
                sr.addDiagonalConsecutives(consecutive);
                consecutive = 0;
                break;
            }
            else {
                sr.addDiagonalMark(a);
                consecutive++;
            }
        }
        sr.addDiagonalConsecutives(consecutive);
        return sr;
    }
    
    
}
