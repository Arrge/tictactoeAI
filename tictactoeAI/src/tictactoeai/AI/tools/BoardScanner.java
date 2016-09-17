
package tictactoeai.AI.tools;

import tictactoeai.AI.SpaceRank;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class BoardScanner {
    
    /**
     * check horizontally for marks up to 4 spaces away from current space
     * @param sr 
     * @param grid
     * @param mark true = cross, false = circle
     */
    public static void horizontalPossibilities(SpaceRank sr, GridValues grid, boolean mark) {
        int x = sr.getX();
        int y = sr.getY();
        
        for (int ax = x; ax < grid.getSideLength() || ax < x + 4; ax++) {
            if (grid.getMark(ax, y) == !mark) {
                break;
            }
            else {
                sr.addHorizontalMark(ax - x);
            }
        }
        
        for (int ax = x; ax > 0 || ax > x + 4; ax--) {
            if (grid.getMark(ax, y) == !mark) {
                break;
            }
            else {
                sr.addHorizontalMark(ax - x);
            }
        }
    }
    
    /**
     * check vertically for marks up to 4 spaces away from current space
     * @param sr
     * @param grid
     * @param mark true = cross, false = circle
     */
    public static void verticalPossibilities(SpaceRank sr, GridValues grid, boolean mark) {
        int x = sr.getX();
        int y = sr.getY();

        for (int ay = y; ay < grid.getSideLength() || ay < y + 4; ay++) {
            if (grid.getMark(x, ay) == !mark) {
                break;
            }
            else {
                sr.addVerticalMark(ay - y);
            }
        }
        
        for (int ay = y; ay < grid.getSideLength() || ay > y + 4; ay--) {
            if (grid.getMark(x, ay) == !mark) {
                break;
            }
            else {
                sr.addVerticalMark(ay - y);
            }
        }  
    }
    
    /**
     * check diagonally for marks up to 4 spaces away from current space
     * @param sr
     * @param grid
     * @param mark true = cross, false = circle
     */
    public static void DiagonalPossibilities(SpaceRank sr, GridValues grid, boolean mark) {
        int x = sr.getX();
        int y = sr.getY();
        
        for (int a = 0; a < grid.getSideLength() || a < x + 4; a++) {
            if (grid.getMark(x+a, y+a) == !mark) {
                break;
            }
            else {
                sr.addDiagonalMark(a);
            }
        }
        
        for (int a = 0; a < grid.getSideLength() || a < x + 4; a++) {
            if (grid.getMark(x+a, y+a) == !mark) {
                break;
            }
            else {
                sr.addDiagonalMark(a);
            }
        }
    }
    
    
}
