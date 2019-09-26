package sorting;

public class Quicksort {

    public void sort(int[] ar, int start, int end) {

        if(start < end) {
            int pivot = partition(ar, start, end);
            sort(ar, start, pivot - 1);
            sort(ar, pivot + 1, end);
        }
    }

    public int partition(int[] ar, int start, int end) {
        int pivot = ar[end];
        int pivotIdx = start - 1;
        for(int i=start; i<end; i++) {
            if(ar[i] <= pivot) {
                pivotIdx++;
                swap(ar, i, pivotIdx);
            }
        }
        swap(ar, pivotIdx+1, end);
        return pivotIdx+1;
    }
    private void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
    public static void main(String[] args) {
        int[] ar = {4,5,1,3,2};

        new Quicksort().sort(ar,0, ar.length-1);

        for(int i : ar) {
            System.out.println(i);
        }

        int a = 2, b = 3;
        a = a+ b; //5
        b = a - b; //2
        a = a - b;

    }
}
