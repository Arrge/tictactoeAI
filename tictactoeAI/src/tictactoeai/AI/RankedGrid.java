
package tictactoeai.AI;

import java.util.PriorityQueue;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class RankedGrid extends GridValues {
    private PriorityQueue<SpaceRank> maxHeap;
    
    public RankedGrid(int sideLength) {
        super(sideLength);
        maxHeap = new PriorityQueue(sideLength * sideLength, new RankComparator());
    }
    
    public void addSpaceRank(SpaceRank sr) {
        maxHeap.add(sr);
    }
    public SpaceRank getBestMove() {
        return maxHeap.poll();
    }
}
