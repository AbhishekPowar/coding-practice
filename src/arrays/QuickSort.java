package arrays;

import java.util.Arrays;
import static arrays.utils.Utilities.swap;

public class QuickSort {
    public int pivoting(int[] n, int pivot) {
        int pe = n[pivot];
        int curr_pos = 0;
        swap(n, pivot, n.length-1);
        int i=0;
        while(i<n.length-1) {
            if(n[i] < pe)
                swap(n, curr_pos++, i);
            i++;
        }
        swap(n, curr_pos, n.length-1);
        return curr_pos;
    }

    public void pivoting_1(int[] n, int pivot) {
        int equal = 0, smaller = 0, larger = n.length-1;
        int pivot_element = n[pivot];

        while(equal < larger) {
            if(n[equal] < pivot_element) {
                swap(n, smaller++, equal++);
            } else if(n[equal] == pivot_element) {
                ++equal;
            } else {
                swap(n, equal, --larger);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {0,1,2,0,2,1,1};
        new QuickSort().pivoting_1(a, 2);
        Arrays.stream(a).forEach(System.out::println);
    }
}
