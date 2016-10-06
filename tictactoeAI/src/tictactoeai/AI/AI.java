
package tictactoeai.AI;

import java.awt.Point;
import tictactoeai.AI.tools.BoardScanner;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class AI {
    private final int mark;
    private int maxBestMoves = 5;
    private int maxDepth = 2;
    /**
     * 
     * @param mark 1 = cross, 2 = circle
     */
    public AI(int mark) {
        this.mark = mark;
    }
    public AI(int mark, int maxDepth) {
        this.mark = mark;
        this.maxDepth = maxDepth;
    }
    
    /**
     * get the coordinates of next move
     * @param gv current board 
     * @return returns coordinates of best move
     */
    public Point getMove(GridValues gv) {
        
        SpaceRank[] srList = getMoves(gv);

        srList[0].setMoveOnGrid(gv, mark);
        
        int indexOfBestMove = 0;
        int rankOfBestMove = rankByFutureMoves(srList[0].getGridValues(), 1) + srList[0].getRank();
        int comparingRank;
        
        for (int i = 1; i < srList.length && srList[i] != null; i++) {
            srList[i].setMoveOnGrid(gv, mark);
            comparingRank = rankByFutureMoves(srList[i].getGridValues(), 1) + srList[i].getRank();
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
    private int rankByFutureMoves(GridValues gv, int depth) {
        int rankDivisor = 1 + (depth/2);
        int nextMoveMark;
        
        if (depth % 2 == 0) {
            nextMoveMark = mark;
        } 
        else {
            nextMoveMark = getOpponentsMark();
        }
        
        SpaceRank[] srList = getMoves(gv);

        if (depth >= maxDepth || srList[1] == null) {
            return bestMove(srList).getRank()/rankDivisor;
        }
        
        int highestRank = 0;
        int compareRank = 0;
        for (int i = 0; i < srList.length && srList[i] != null; i++) {
            srList[i].setMoveOnGrid(gv, nextMoveMark);
            compareRank = rankByFutureMoves(srList[i].getGridValues(), depth + 1);
            if (compareRank > highestRank) {
                highestRank = compareRank;
            }
        }
        return highestRank / rankDivisor;
    }

    public int getMaxDepth() {
        return maxDepth;
    }
    
    
   
    /**
     * get at most an amount of maxBestMoves moves from the board
     * @param gv board
     * @return array of moves
     */
    private SpaceRank[] getMoves(GridValues gv) {
        RankedGrid rg = rankMoves(gv);
        SpaceRank sr = rg.getBestMove();
        
        SpaceRank[] srList = new SpaceRank[maxBestMoves];
        srList[0] = sr;

        for (int i = 1; i < srList.length && rg.heapSize()> 0; i++) {
            sr = rg.getBestMove();
            
            if (srList[0].getRank() - sr.getRank() > 10 * 4) {
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
    private SpaceRank bestMove(SpaceRank[] moves) {
        SpaceRank bestMove = moves[0];
       
        for (int i = 1; i < moves.length && moves[i] != null;i++) {
            if (bestMove.getRank() < moves[i].getRank()) {
                bestMove = moves[i];
            }
        }
        
        return bestMove;
    }
    
    /**
     * rank all possible moves on board
     * @param gv board
     * @return returns RankedGrid containing ranked moves 
     */
    private RankedGrid rankMoves(GridValues gv) {
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
            if (sr.getRank() == 0) {
                continue;
            }
            rg.addSpaceRank(sr);
        }
        
        return rg;
    }
    
    
    /**
     *  
     * @return return the mark of the AI (1 = cross 2 = circle)
     */
    public int getMark() {
        return mark;
    }
    
    /**
     * 
     * @return returns opponents mark
     */
    public int getOpponentsMark() {
        if (mark == 1) {
            return 2;
        } 
        else {
            return 1;
        }
    }

    /**
     * set the max number of moves the AI can think ahead
     * @param maxDepth
     */
    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
    
}
