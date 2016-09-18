
package tictactoeai.AI;

import java.awt.Point;
import tictactoeai.AI.tools.BoardScanner;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class AI {
    private RankedGrid rg;
    private boolean mark;

    /**
     * 
     * @param mark true = cross, false = circle
     */
    public AI(boolean mark) {
        this.rg = new RankedGrid(15);
        this.mark = mark;
    }
    
    /**
     * gets the next move for the AI
     * @param grid the board
     * @return returns x,y coordinates for the next move
     */
    public Point getMove(GridValues grid) {
        SpaceRank sr;
        rg = new RankedGrid(15);
        for (int i = 0; i < grid.getSideLength() * grid.getSideLength(); i++) {
            sr = new SpaceRank(i % (grid.getSideLength()), i / (grid.getSideLength()));
            System.out.println(sr.getX() + ", " + sr.getY());
            BoardScanner.possibilities(sr, grid, mark);
            BoardScanner.possibilities(sr, grid, !mark);
            sr.calculateRank();
            rg.addSpaceRank(sr);
        }
        sr = rg.getBestMove();
        Point p = new Point(sr.getX(), sr.getY());
        return p;
    }
    
    /**
     * 
     * @return return the mark of the AI (cross/circle)
     */
    public boolean getMark() {
        return mark;
    }
}
