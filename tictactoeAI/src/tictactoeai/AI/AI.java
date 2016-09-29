
package tictactoeai.AI;

import java.awt.Point;
import tictactoeai.AI.tools.BoardScanner;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class AI {
    private final short mark;
    private int maxBestMoves = 5;
    private int maxDepth = 1;
    /**
     * 
     * @param mark 1 = cross, 2 = circle
     */
    public AI(short mark) {
        this.mark = mark;
    }
    
    public Point getMove(GridValues gv) {
        SpaceRank[] srList = getMoves(gv);
        SpaceRank[] moves;
        //ranked by current board rank + enemy best move rank
        moves = getEnemyMoves(gv, srList);
        
        SpaceRank move = bestMove(moves);
        return new Point(move.getX(), move.getY());
    }
    
    public SpaceRank bestMove(SpaceRank[] moves) {
        SpaceRank bestMove = moves[0];
        
        for (int i = 1; i < moves.length && moves[i] != null;i++) {
            if (bestMove.getTotalRank() < moves[i].getTotalRank()) {
                bestMove = moves[i];
            }
        }
        
        return bestMove;
    }
    
    public SpaceRank[] getEnemyMoves(GridValues gv, SpaceRank[] srList) {    
        SpaceRank[] enemySRList;
        GridValues newGridValues;
        
        for (int i = 0; i < srList.length && srList[i] != null; i++) {
            srList[i].setMoveOnGrid(gv, mark);
            newGridValues = srList[i].getGridValues();
            
            enemySRList = getMoves(newGridValues);
            enemySRList[0].setMoveOnGrid(newGridValues, getOppositeMark());
            srList[i].setGrid(enemySRList[0].getGridValues());
            srList[i].addToFutureMovesRank(enemySRList[0].getTotalRank());
        }
        
        return srList;
    }
    
    
    public RankedGrid rankMoves(GridValues gv) {
        SpaceRank sr;
        RankedGrid rg = new RankedGrid(15);
        int x, y;
        
        for (int i = 0; i < gv.getSideLength() * gv.getSideLength(); i++) {
            x = i % (gv.getSideLength());
            y = i / (gv.getSideLength());

            if (!gv.isEmpty(x, y)) {
                continue;
            }
            sr = BoardScanner.scan(x, y, gv, mark);
            
            sr.calculateRank();
            sr.calculateOpponentsRank();
            if (sr.getTotalRank() > 0) {
                rg.addSpaceRank(sr);
            }
        }
        
        return rg;
    }
   
    public SpaceRank[] getMoves(GridValues gv) {
        RankedGrid rg = rankMoves(gv);
        SpaceRank sr = rg.getBestMove();
        if (sr == null) {
            System.out.println("no available moves????");
        }

        SpaceRank[] srList = new SpaceRank[maxBestMoves];
        srList[0] = sr;

        for (int i = 1; i < srList.length && rg.heapSize()> 0; i++) {
            sr = rg.getBestMove();
            if (srList[0].getTotalRank() - sr.getTotalRank() > 10) {
                break;
            }
            srList[i] = sr;
        }

        return srList;
    }
    
    
    
    /**
     * 
     * @return return the mark of the AI (1 = cross 2 = circle)
     */
    public short getMark() {
        return mark;
    }
    
    public short getOppositeMark() {
        if (mark == 1) {
            return 2;
        } 
        else {
            return 1;
        }
    }
}
