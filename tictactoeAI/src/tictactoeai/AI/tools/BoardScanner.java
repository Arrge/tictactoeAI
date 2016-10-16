package tictactoeai.AI.tools;

import tictactoeai.AI.SpaceRank;
import tictactoeai.board.GridValues;

/**
 * scan adjacent spaces for information required in ranking a move
 * @author Liekkipipo-pc
 */
public class BoardScanner {

    /**
     * scan adjacent spaces 
     * @param x coordinate
     * @param y coordinate
     * @param grid board
     * @param mark 1 = cross, 2 = circle 0 = empty
     * @return SpaceRank with the required information to calculate the rank
     */
    public static SpaceRank scan(int x, int y, GridValues grid, int mark) {
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
    
    /**
     * scan adjacent spaces horizontally 
     * @param sr
     * @param grid board
     * @param mark 1 = cross, 2 = circle 0 = empty
     */
    private static void horizontalScan(SpaceRank sr, GridValues grid, int mark) {
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
    
    /**
     * scan adjacent spaces vertically
     * @param sr
     * @param grid board
     * @param mark 1 = cross, 2 = circle 0 = empty
     */
    private static void verticalScan(SpaceRank sr, GridValues grid, int mark) {
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
    
    /**
     * scan adjacent spaces diagonally top right to bottom left
     * @param sr
     * @param grid board
     * @param mark 1 = cross, 2 = circle 0 = empty
     */
    private static void diagonalRightLeftScan(SpaceRank sr, GridValues grid, int mark) {
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
    
    /** 
     * scan adjacent spaces diagonally top left to bottom right
     * @param sr 
     * @param grid board
     * @param mark 1 = cross, 2 = circle 0 = empty
     */
    private static void diagonalLeftRightScan(SpaceRank sr, GridValues grid, int mark) {
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
