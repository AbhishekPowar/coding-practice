package sorting;

/**
 * Program to sort array with 0's, 1's and 2's only
 *
 * Runtime Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Sort_0_1_2 {

    /**
     * Utility Method to swap two values
     * @param ar
     * @param a
     * @param b
     */
    private void swap(int[] ar, int a, int b) {
        int tmp = ar[a];
        ar[a] = ar[b];
        ar[b] = tmp;
    }

    /**
     * Method to sort values
     * This program uses concept of two pointers
     *  1. For holding position to place a '0'
     *  2. For holding position to place a '2'
     *
     *  We don't take care of '1' as, if we place '0' and '2' at their correct position, '1' will automatically be placed at its right
     *  position
     * @param ar
     */
    public void sort(int[] ar) {
        int placeZero = 0;
        int placeTwo = ar.length-1;

        int idx = 0;
        while(idx < ar.length) {
            if(ar[idx] == 2 && ar[placeTwo] == 2)
                placeTwo--;
            else if(ar[idx] == 0 && idx > placeZero) {
                swap(ar, idx++, placeZero++);
            } else if(ar[idx] == 2 && idx < placeTwo) {
                swap(ar, idx++, placeTwo--);
            } else
                idx++;
        }
    }

    public static void main(String[] args) {
        int[] ar = {2,2,1,1,0,0,1,1,2,1,1};

        new Sort_0_1_2().sort(ar);

        for(int i=0; i<ar.length;i++)
            System.out.println(ar[i]);

    }
}

