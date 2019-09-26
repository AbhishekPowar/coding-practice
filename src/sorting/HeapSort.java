package sorting;

public class HeapSort {

    public int[] heap;
    private int currSize = 0;

    HeapSort(int[] ar, int size) {
        heap = new int[size];

        for(int i=0; i<size; i++) {
            this.add(ar[i]);
        }
    }

    public void add(int value) {
        if(currSize == heap.length)
            return;

        heap[currSize++] = value;

        heapify();
    }
    public int getMax() {
        int max = heap[0];
        heap[0] = heap[currSize-1];
        currSize -= 1;

        heapify();

        return max;
    }
    private void heapify() {
        for(int i= currSize/2-1; i >=0; i--) {
            if(heap[i*2 + 1] > heap[i]){
                swap(i*2 + 1, i);
            }
            if(heap[i*2 + 2] > heap[i])
                swap(i*2 + 2, i);
        }
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public static void main(String[] args) {

        int[] ar = {2,1,5,3,4};

        HeapSort s = new HeapSort(ar, ar.length);

        int[] h = s.heap;

        for(int i=0; i<h.length; i++)
            System.out.println(s.getMax());
    }
}
