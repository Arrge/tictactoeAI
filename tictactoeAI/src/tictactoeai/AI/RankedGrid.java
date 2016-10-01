
package tictactoeai.AI;

import java.util.PriorityQueue;

/**
 *
 * @author Liekkipipo-pc
 */
public class RankedGrid {
    private PriorityQueue<SpaceRank> maxHeap;
    
    /**
     * a maximum heap containing the ranks of every space
     * @param sideLength board size is sideLength * sideLength
     */
    public RankedGrid(int sideLength) {
        maxHeap = new PriorityQueue(sideLength * sideLength, new RankComparator());
    }
    
    /**
     * add SpaceRank to the heap
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
    
    /**
     *
     * @return
     */
    public int heapSize() {
        return maxHeap.size();
    }
}
