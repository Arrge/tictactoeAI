
package tictactoeai.AI.tools;

import tictactoeai.AI.SpaceRank;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class BoardScanner {
    
    /**
     * check for marks up to 4 spaces away from current space
     * @param sr 
     * @param grid
     * @param mark true = cross, false = circle
     * @return returns rank of the space
     */
    public static SpaceRank possibilities(SpaceRank sr, GridValues grid, boolean mark) {
        if (grid.getMark(sr.getX(), sr.getY()) != null) {
            sr.setRank(-1);
            return sr;
        }
        BoardScanner.horizontalPossibilities(sr, grid, mark);
        BoardScanner.verticalPossibilities(sr, grid, mark);
        BoardScanner.DiagonalPossibilities(sr, grid, mark);
        return sr;
    }
    
    /**
     * check horizontally for marks up to 4 spaces away from current space
     * @param sr
     * @param grid
     * @param mark true = cross, false = circle
     * @returns returns the updated SpaceRank
     */
    public static SpaceRank horizontalPossibilities(SpaceRank sr, GridValues grid, boolean mark) {
        int x = sr.getX();
        int y = sr.getY();
        
        for (int ax = x + 1; ax < grid.getSideLength() && ax < x + 5; ax++) {
            if (grid.getMark(ax, y) == null) {
                continue;
            }
            if (grid.getMark(ax, y) == !mark) {
                break;
            }
            else {
                sr.addHorizontalMark(ax - x);
            }
        }
        
        for (int ax = x - 1; ax > 0 && ax > x - 5; ax--) {
            if (grid.getMark(ax, y) == null) {
                continue;
            }
            if (grid.getMark(ax, y) == !mark) {
                break;
            }
            else {
                sr.addHorizontalMark(ax - x);
            }
        }
        return sr;
    }
    
    /**
     * check vertically for marks up to 4 spaces away from current space
     * @param sr
     * @param grid
     * @param mark true = cross, false = circle
     * @return returns the updated SpaceRank
     */
    public static SpaceRank verticalPossibilities(SpaceRank sr, GridValues grid, boolean mark) {
        int x = sr.getX();
        int y = sr.getY();

        for (int ay = y + 1; ay < grid.getSideLength() && ay < y + 5; ay++) {
            if (grid.getMark(x, ay) == null) {
                continue;
            }
            if (grid.getMark(x, ay) == !mark) {
                break;
            }
            else {
                sr.addVerticalMark(ay - y);
            }
        }
        
        for (int ay = y - 1; ay >= 0 && ay > y - 5; ay--) {
            if (grid.getMark(x, ay) == null) {
                continue;
            }
            if (grid.getMark(x, ay) == !mark) {
                break;
            }
            else {
                sr.addVerticalMark(ay - y);
            }
        }  
        return sr;
    }
    
    /**
     * check diagonally for marks up to 4 spaces away from current space
     * @param sr
     * @param grid
     * @param mark true = cross, false = circle
     * @return returns the updated SpaceRank
     */
    public static SpaceRank DiagonalPossibilities(SpaceRank sr, GridValues grid, boolean mark) {
        int x = sr.getX();
        int y = sr.getY();
        
        for (int a = 1; a + x < grid.getSideLength() && a+y < grid.getSideLength() && a < 5; a++) {
            if (grid.getMark(x+a, y+a) == null) {
                continue;
            }
            if (grid.getMark(x+a, y+a) == !mark) {
                break;
            }
            else {
                sr.addDiagonalMark(a);
            }
        }
        
        for (int a = -1; a + x >= 0 && a+y >= 0 && a > -5; a--) {
             if (grid.getMark(x+a, y+a) == null) {
                continue;
            }
            if (grid.getMark(x+a, y+a) == !mark) {
                break;
            }
            else {
                sr.addDiagonalMark(a);
            }
        }
        
        return sr;
    }
    
    
}
