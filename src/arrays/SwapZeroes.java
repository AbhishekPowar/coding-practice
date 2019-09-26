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
    public static void main(String[] args) {
        int[] ar = {3,0,0, 7, 1, 2, 0};

        new SwapZeroes().swaps(ar);
        for(int i=0; i<ar.length; i++)
            System.out.println(ar[i]);

    }
}
