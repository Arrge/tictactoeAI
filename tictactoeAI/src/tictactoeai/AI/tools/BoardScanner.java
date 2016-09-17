/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeai.AI;

import tictactoeai.gui.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class RowScanner {
    
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
