package arrays;

import java.util.Arrays;

/**
 *Q:1365
 */
public class SmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);

        Arrays.sort(copy);
        int[] answer = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int idx = findIndex(copy,nums[i]);
            answer[i] = idx;
        }

        return answer;
    }

    private int findIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start < end) {
            int mid = start + (end-start)/2;
            if(nums[mid] >= target)
                end = mid;
            else
                start = mid+1;
        }

        return start;
    }

    public int[] smallerNumbersThanCurrent_2(int[] nums) {
        int[] counts = new int[101];

        Arrays.fill(counts, 0);
        for(int i=0; i<nums.length;i++) {
            counts[nums[i]]++;
        }

        for(int i=1; i<101; i++) {
            counts[i] += counts[i-1];
        }

        int[] answer = new int[nums.length];
        for(int i=0; i<nums.length;i++) {
            answer[i] = counts[nums[i]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        new SmallerThanCurrentNumber().smallerNumbersThanCurrent_2(new int[]{8,1,2,2,3});
    }
}
