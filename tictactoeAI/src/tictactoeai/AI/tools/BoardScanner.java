package tictactoeai.AI.tools;

import tictactoeai.AI.SpaceRank;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class BoardScanner {
    public static SpaceRank scan(int x, int y, GridValues grid, short mark) {
        SpaceRank sr = new SpaceRank(x, y);
        
        horizontalScan(sr, grid, mark);
        verticalScan(sr, grid, mark);
        diagonalLeftRightScan(sr, grid, mark);
        diagonalRightLeftScan(sr, grid, mark);
        
        if (mark == 1) {
            mark = 2;
        }
        else {
            mark = 1;
        }
        
        horizontalScan(sr, grid, mark);
        verticalScan(sr, grid, mark);
        diagonalLeftRightScan(sr, grid, mark);
        diagonalRightLeftScan(sr, grid, mark);
        
        return sr;
    }
    
    public static void horizontalScan(SpaceRank sr, GridValues grid, short mark) {
        int x = sr.getX();
        int y = sr.getY();
        int consecutives = 0;
        int opensides = 0;
        
        for (int distance = 1; distance < 5; distance++) {
            if (grid.getMark(x-distance, y) == 0) {
                opensides++;
                break;
            }
            if (grid.getMark(x-distance, y) == mark) {
                consecutives++;
            }
            else {
                break;
            }
        }
        
        for (int distance = 1; distance < 5; distance++) {
            if (grid.getMark(x+distance, y) == 0) {
                opensides++;
                break;
            }
            if (grid.getMark(x+distance, y) == mark) {
                consecutives++;
            }
            else {
                break;
            }
        }
        sr.setOpenSidesAndConsecutives(opensides, consecutives);
        
    }
    
    public static void verticalScan(SpaceRank sr, GridValues grid, short mark) {
        int x = sr.getX();
        int y = sr.getY();
        int consecutives = 0;
        int opensides = 0;
        
        
        for (int distance = 1; distance < 5; distance++) {
            if (grid.getMark(x, y+distance) == 0) {
                opensides++;
                break;
            }
            if (grid.getMark(x, y+distance) == mark) {
                consecutives++;
            }
            else {
                break;
            }
        }
        
        for (int distance = 1; distance < 5; distance++) {
            if (grid.getMark(x, y-distance) == 0) {
                opensides++;
                break;
            }
            if (grid.getMark(x, y-distance) == mark) {
                consecutives++;
            }
            else {
                break;
            }
        }
        sr.setOpenSidesAndConsecutives(opensides, consecutives);
        
    }
    
    public static void diagonalRightLeftScan(SpaceRank sr, GridValues grid, short mark) {
        int x = sr.getX();
        int y = sr.getY();
        int consecutives = 0;
        int opensides = 0;
        
        for (int distance = 1; distance < 5; distance++) {
            if (grid.getMark(x+distance, y+distance) == 0) {
                opensides++;
                break;
            }
            if (grid.getMark(x+distance, y+distance) == mark) {
                consecutives++;
            }
            else {
                break;
            }
        }
        
        for (int distance = 1; distance < 5; distance++) {
            if (grid.getMark(x-distance, y-distance) == 0) {
                opensides++;
                break;
            }
            if (grid.getMark(x-distance, y-distance) == mark) {
                consecutives++;
            }
            else {
                break;
            }
        }
        
        sr.setOpenSidesAndConsecutives(opensides, consecutives);
    }
    
    public static void diagonalLeftRightScan(SpaceRank sr, GridValues grid, short mark) {
        int x = sr.getX();
        int y = sr.getY();
        int consecutives = 0;
        int opensides = 0;
        
         for (int distance = 1; distance < 5; distance++) {
            if (grid.getMark(x-distance, y+distance) == 0) {
                opensides++;
                break;
            }
            if (grid.getMark(x-distance, y+distance) == mark) {
                consecutives++;
            }
            else {
                break;
            }
        }
        
        for (int distance = 1; distance < 5; distance++) {
            if (grid.getMark(x+distance, y-distance) == 0) {
                opensides++;
                break;
            }
            if (grid.getMark(x+distance, y-distance) == mark) {
                consecutives++;
            }
            else {
                break;
            }
        }
        sr.setOpenSidesAndConsecutives(opensides, consecutives);
        
    }
}
