package arrays;

public class SwapZeroes {

    public void swaps(int[] ar) {

        int currIdx = 0;
        int updateIdx = 0;

        while(currIdx < ar.length) {
            if(ar[currIdx] != 0) {
                ar[updateIdx++] = ar[currIdx];

            }
            currIdx++;
        }

        for(int i=updateIdx; i<ar.length; i++)
            ar[i] = 0;
    }

    public void swap(int[] ar) {
        int swapIdx = 0;
        int currIdx = 0;

        while(currIdx < ar.length) {
            if(ar[currIdx] != 0) {
                int tmp = ar[swapIdx];
                ar[swapIdx] = ar[currIdx];
                ar[currIdx] = tmp;
                swapIdx++;
            }
            currIdx++;
        }
    }
    public static void main(String[] args) {
        int[] ar = {3,0,0, 7, 1, 2, 0,4};

        new SwapZeroes().swap(ar);
        for(int i=0; i<ar.length; i++)
            System.out.println(ar[i]);

    }
}
