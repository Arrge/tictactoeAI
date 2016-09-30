
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
    private int maxDepth = 2;
    /**
     * 
     * @param mark 1 = cross, 2 = circle
     */
    public AI(short mark) {
        this.mark = mark;
    }
    
    /**
     * get the coordinates of next move
     * @param gv current board 
     * @return returns coordinates of best move
     */
    public Point getMove(GridValues gv) {
        SpaceRank[] srList = getMoves(gv, mark);

        srList[0].setMoveOnGrid(gv, mark);
        
        int indexOfBestMove = 0;
        int rankOfBestMove = rankByFutureMoves(srList[0].getGridValues(), 1);
        int comparingRank;
        
        for (int i = 1; i < srList.length && srList[i] != null; i++) {
            srList[i].setMoveOnGrid(gv, mark);
            comparingRank = rankByFutureMoves(srList[i].getGridValues(), 1);
            if (comparingRank > rankOfBestMove) {
                indexOfBestMove = i;
                rankOfBestMove = comparingRank;
            }
        }
        SpaceRank move = srList[indexOfBestMove];
        return new Point(move.getX(), move.getY());
    }
    
    /**
     * get rank of future moves
     * @param gv board
     * @param depth iteration
     * @return returns the rank of best future move 
     */
    public int rankByFutureMoves(GridValues gv, int depth) {
        short nextMoveMark;
        if (depth % 2 == 0) {
            nextMoveMark = mark;
        } 
        else {
            nextMoveMark = getOppositeMark();
        } 
        SpaceRank[] srList = getMoves(gv, nextMoveMark);
        

        if (depth >= maxDepth) {
            return bestMove(srList).getTotalRank()/depth;
        }

        int highestRank = 0;
        int compareRank = 0;
        for (int i = 0; i < srList.length && srList[i] != null; i++) {
            srList[i].setMoveOnGrid(gv, nextMoveMark);
            compareRank = rankByFutureMoves(srList[i].getGridValues(), depth++);
            if (compareRank > highestRank) {
                highestRank = compareRank;
            }
        }
        
        return highestRank;
    }
    
    /**
     * rank all possible moves on board
     * @param gv board
     * @param mark
     * @return returns RankedGrid containing ranked moves 
     */
    public RankedGrid rankMoves(GridValues gv, short mark) {
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
   
    /**
     * get at most an amount of maxBestMoves moves from the board
     * @param gv board 
     * @param mark
     * @return array of moves
     */
    public SpaceRank[] getMoves(GridValues gv, short mark) {
        RankedGrid rg = rankMoves(gv, mark);
        SpaceRank sr = rg.getBestMove();

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
     * get the highest ranked move from an array of moves
     * @param moves
     * @return 
     */
    public SpaceRank bestMove(SpaceRank[] moves) {
        SpaceRank bestMove = moves[0];
        
        for (int i = 1; i < moves.length && moves[i] != null;i++) {
            if (bestMove.getTotalRank() < moves[i].getTotalRank()) {
                bestMove = moves[i];
            }
        }
        
        return bestMove;
    }
    
    /**
     * 
     * @return return the mark of the AI (1 = cross 2 = circle)
     */
    public short getMark() {
        return mark;
    }
    
    /**
     *
     * @return
     */
    public short getOppositeMark() {
        if (mark == 1) {
            return 2;
        } 
        else {
            return 1;
        }
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
    
}
