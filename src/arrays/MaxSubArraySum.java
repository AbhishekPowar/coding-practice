package arrays;

public class MaxSubArraySum {

    public int getMaxSum(int[] ar) {
        int currSum = ar[0];
        int maxSum = ar[0];

        for (int i = 1; i < ar.length; i++) {
            currSum = Math.max(currSum + ar[i], ar[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] ar = {1, 4, -2, -1, 2, 9};

        System.out.println(new MaxSubArraySum().getMaxSum(ar));
    }
}
