package sorting;

public class MinHeap {
    private int[] heap;
    private int maxSize;
    private int currSize = 0;

    MinHeap(int size) {
        this.maxSize = size;
        heap = new int[size];
    }

    public void insert(int elem) {
        if(currSize == maxSize)
            System.out.println("Overflow");

        heap[currSize++] = elem;

//        System.out.println("Curr: "+currSize);

        int curr = currSize -1;

        while(parent(curr) >=0 && heap[curr] < heap[parent(curr)]) {
            int tmp = heap[curr];
            heap[curr] = heap[parent(curr)];
            heap[parent(curr)] = tmp;
            curr = parent(curr);
        }
    }

    private int parent(int pos) {
        return (pos-1)/2;
    }

    private boolean isLeafElement(int pos) {
        return pos >= currSize/2 && pos <= currSize;
    }

    private void heapify(int pos) {

        if(pos >= currSize)
            return;
        if(!isLeafElement(pos)) {
            int leftChild = pos*2+1;
            int rightChild = pos*2 + 2;

            if((heap[pos] > heap[leftChild] && leftChild < currSize) || (heap[pos] > heap[rightChild] && rightChild < currSize)) {
                if(heap[pos] > heap[leftChild]) {
                    int tmp = heap[pos];
                    heap[pos] = heap[leftChild];
                    heap[leftChild] = tmp;
                    heapify(leftChild);
                } else {
                    int tmp = heap[pos];
                    heap[pos] = heap[rightChild];
                    heap[rightChild] = tmp;
                    heapify(rightChild);
                }

            }
        }
    }

    public int getMin() {
        int min = Integer.MIN_VALUE;
        if(currSize > 0) {
            min = heap[0];
            heap[0] = heap[currSize-1];
            currSize--;
            heapify(0);
        }
        return min;
    }
    public int poll() {
        return currSize-1 < 0 ? null: heap[0];
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(4);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);

//        System.out.println(minHeap.poll());
        System.out.println(minHeap.getMin());
        System.out.println(minHeap.getMin());
        System.out.println(minHeap.getMin());
        System.out.println(minHeap.getMin());
        System.out.println(minHeap.getMin());
    }
}
