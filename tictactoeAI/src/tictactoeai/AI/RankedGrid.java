
package tictactoeai.AI;

import java.util.PriorityQueue;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class RankedGrid {
    private PriorityQueue<SpaceRank> maxHeap;
    
    /**
     * 
     * @param sideLength board size is sideLength * sideLength
     */
    public RankedGrid(int sideLength) {
        maxHeap = new PriorityQueue(sideLength * sideLength, new RankComparator());
    }
    
    /**
     * 
     * @param sr space rank
     */
    public void addSpaceRank(SpaceRank sr) {
        maxHeap.add(sr);
    }

    /**
     * 
     * @return returns the highest ranked space from heap
     */
    public SpaceRank getBestMove() {
        return maxHeap.poll();
    }
}
