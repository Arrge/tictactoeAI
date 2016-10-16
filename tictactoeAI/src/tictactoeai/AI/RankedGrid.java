
package tictactoeai.AI;

/**
 * a maximum heap containing the ranks of every space
 * @author Liekkipipo-pc
 */
public class RankedGrid {
    private MaxHeap maxHeap;
    private boolean first;
    /**
     * a maximum heap containing the ranks of every space
     * @param sideLength board size is sideLength * sideLength
     */
    public RankedGrid(int sideLength) {
        first = true;
        maxHeap = new MaxHeap(sideLength * sideLength);
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
        if (first) {
            maxHeap.sort();
            first = !first;
        }
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
