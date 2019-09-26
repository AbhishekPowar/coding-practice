package sorting;

/**
 * Program to sort array with 0's, 1's and 2's only
 *
 * Runtime Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Sort_0_1_2 {

    public void sort(int[] ar) {
        int placeZero = 0;
        int placeTwo = ar.length-1;

        int idx = 0;
        while(idx < ar.length) {
            if(ar[idx] == 0 && idx > placeZero) {
                int tmp = ar[placeZero];
                ar[placeZero++] = 0;
                ar[idx] = tmp;
            } else if(ar[idx] == 2 && idx < placeTwo) {
                int tmp = ar[placeTwo];
                ar[placeTwo--] = 2;
                ar[idx] = tmp;
            }

            idx++;
        }
    }

    public static void main(String[] args) {
        int[] ar = {0,1,0,2,0,1,1,2,0};

        new Sort_0_1_2().sort(ar);

        for(int i=0; i<ar.length;i++)
            System.out.println(ar[i]);

    }
}
