package tictactoeai.AI;

/**
 * maximum heap for holding SpaceRank objects
 * @author Liekkipipo-pc
 */
public class MaxHeap {
    private int size, maxSize;
    private SpaceRank[] heapArray;

    /**
     * maximum heap for holding SpaceRank objects
     * @param maxSize maximum amount of SpaceRank objects the heap can hold
     */
    public MaxHeap(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        this.heapArray = new SpaceRank[maxSize];
    }
    
    private void heapify(int pos) {
        if (!leaf(pos)) {
            if (HeapRank(leftChild(pos)) > HeapRank(pos) || HeapRank(rightChild(pos)) > HeapRank(pos)) {
                if (HeapRank(leftChild(pos)) > HeapRank(rightChild(pos))) {
                    swap(leftChild(pos), pos);
                    heapify(leftChild(pos));
                }
                else {
                    swap(rightChild(pos), pos);
                    heapify(rightChild(pos));
                }
            }
        }
    }
    
    private int HeapRank(int pos) {
        if (heapArray[pos] == null) {
            return -1;
        }
        return heapArray[pos].getRank();
    }
    
    private int leftChild(int pos)
    {
        return 2 * pos;
    }
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
    private int parent(int pos) {
        return pos / 2;
    }
    
    private void swap(int pos1, int pos2) {
        SpaceRank sr = heapArray[pos1];
        heapArray[pos1] = heapArray[pos2];
        heapArray[pos2] = sr;
    }
    
    private boolean leaf(int pos) {
        return pos <= size && pos >= (size / 2);
    }
    
    /**
     * add a Spacerank into the heap
     * @param sr
     */
    public void add(SpaceRank sr) {
        
        heapArray[size] = sr;
        int pos = size;
        size += 1;
        while (HeapRank(pos) > HeapRank(parent(pos))) {
            swap(pos, parent(pos));
        }
    }
    
    /**
     * get the highest ranking space
     * @return highest ranking SpaceRank
     */
    public SpaceRank poll() {
        SpaceRank sr = heapArray[0];
        heapArray[0] = heapArray[size];
        size -= 1;
        heapify(0);
        return sr;
    }

    public int size() {
        return size;
    }
    
    /**
     *  sort the heap
     */
    public void sort() {
        for (int pos = size / 2; pos >= 0; pos--) {
            heapify(pos);
        }
    }
}
