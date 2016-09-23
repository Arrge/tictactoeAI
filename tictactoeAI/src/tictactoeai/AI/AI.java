
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
    private final short mark;

    /**
     * 
     * @param mark 1 = cross, 2 = circle
     */
    public AI(short mark) {
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
        int x, y;
        
        rg = new RankedGrid(15);
        
        for (int i = 0; i < grid.getSideLength() * grid.getSideLength(); i++) {
            x = i % (grid.getSideLength());
            y = i / (grid.getSideLength());

            if (!grid.isEmpty(x, y)) {
                continue;
            }
            sr = BoardScanner.scan(x, y, grid, mark);
            
            if (sr.calculateRank() == true) {
                return new Point(sr.getX(), sr.getY());
            }
            
            
            sr.calculateOpponentsRank();
            rg.addSpaceRank(sr);
        }
        sr = rg.getBestMove();
        
        return new Point(sr.getX(), sr.getY());
    }
    
    /**
     * 
     * @return return the mark of the AI (cross/circle)
     */
    public short getMark() {
        return mark;
    }
}
