package arrays;

import arrays.utils.Utilities;

import java.util.Arrays;

public class MultiplyArbitraryPrecisionIntegers {

    public int[] multiply(int[] a1, int[] a2) {
        int[] ans = new int[a1.length+a2.length+1];

        int ans_idx = 0;
        int carry = 0;
        for(int i=a2.length-1; i>=0; i--) {
            ans_idx = a2.length-1 -i;
            for(int j=a1.length-1; j>=0; j--) {
                int t =  a2[i]*a1[j] + ans[ans_idx] + carry;
                ans[ans_idx++] = t%10;
                carry = t/10;
            }
            ans[ans_idx] = carry;
        }

        int i=0;
        int j = ans_idx-1;
        while(i < j) {
            Utilities.swap(ans, i++,j--);
        }

        return Arrays.copyOfRange(ans, 0, ans_idx);
    }
    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,9,4,5};
        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9};

        int[] ans = new MultiplyArbitraryPrecisionIntegers().multiply(a1, a2);
        Arrays.stream(ans).forEach(System.out::print);
    }
}
