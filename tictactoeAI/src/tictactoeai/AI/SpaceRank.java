/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeai.AI;

/**
 *
 * @author Liekkipipo-pc
 */
public class SpaceRank {
    private int rank;
    private int x, y;
    private boolean[] marksHoriz, marksVert, marksDiag;
    
    
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
    
    
}
