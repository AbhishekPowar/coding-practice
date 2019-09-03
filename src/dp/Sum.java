package dp;

import java.util.Arrays;

public class Sum {

    public int getWaysNONDP(int sum, int[] ar)  {

        if(sum == 0)
            return 1;
        int  ways = 0;
        for(int i=0; i<ar.length; i++) {
            if(ar[i] <= sum)
                ways += getWaysNONDP(sum - ar[i], ar);
        }

        return ways;
    }

    public int getWaysDP(int sum, int[] ar, int[]  memo)  {

        if(sum == 0)
            return 1;
        if(memo[sum] >= 0)
            return memo[sum];
        int  ways = 0;
        for(int i=0; i<ar.length; i++) {
            if(ar[i] <= sum)
                ways += getWaysDP(sum - ar[i], ar, memo);
            memo[sum] = ways;
        }

        return memo[sum];
    }
    public static void main(String[] args) {
        int[] ar  = {1,3,4};

        int sum = 5;
        int[] memo = new int[sum+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
//        System.out.println(new Sum().getWaysNONDP(5,ar));
        System.out.println(new Sum().getWaysDP(sum,ar, memo));
    }
}
