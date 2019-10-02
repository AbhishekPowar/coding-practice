package leetcode;

public class MinSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {

        int lastIdx = 0;
        int currIdx = 0;

        int currSum = 0;
        int min = Integer.MAX_VALUE;
        int currLength = 0;

        if(nums.length == 0)
            return 0;
        while(currIdx < nums.length) {

            while(currSum < s && currIdx < nums.length) {
                currLength += 1;;
                currSum += nums[currIdx];
                currIdx++;
            }

            while (lastIdx <= currIdx && currSum  >= s) {
                min = Math.min(min, currLength);
                currSum -= nums[lastIdx];
                lastIdx += 1;
                currLength -= 1;
            }
        }

        return (currSum >= s) ? Math.min(min, currLength): min;
    }

    public static void main(String[] args) {
        int[] ar = {2,3,1,2,4,3};
        int sum = 7;

        System.out.println(new MinSizeSubarraySum_209().minSubArrayLen(sum, ar));
    }
}
