package sorting;

public class HeapSort {

    public static void sort(int[] ar) {

        for(int i = ar.length/2 -1; i>=0 ;i--) {
            heapify(ar, ar.length, i);
        }

        for(int i=ar.length-1; i>=0; i--) {
            int max = ar[0];
            ar[0] = ar[i];
            ar[i] = max;

            heapify(ar, i, 0);
        }
    }

    private static void heapify(int[] ar, int size, int pos) {
        int maxIdx = pos;
        int leftIdx = pos*2  + 1;
        int rightIdx = pos*2 + 2;

        if(leftIdx < size && ar[leftIdx] > ar[maxIdx])
            maxIdx = leftIdx;
        if(rightIdx < size && ar[rightIdx] > ar[maxIdx])
            maxIdx = rightIdx;

        if(maxIdx != pos) {
            int tmp = ar[pos];
            ar[pos] = ar[maxIdx];
            ar[maxIdx] = tmp;

            heapify(ar, size, maxIdx);
        }
    }
    public static void main(String[] args) {

        int[] ar = {2,1,5,3,4};

        HeapSort.sort(ar);

        for(int i=0; i<ar.length; i++)
            System.out.println(ar[i]);
    }
}
