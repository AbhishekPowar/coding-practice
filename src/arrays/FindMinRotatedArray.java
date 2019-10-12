package arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class FindMinRotatedArray {

    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return findMin(nums, 0,  nums.length-1);
    }

    private int findMin(int[] nums, int start , int end) {
        if(start > end)
            return Integer.MAX_VALUE;

        if (start == end)
            return nums[start];

        int mid = (start + end)/2;

        // if this condition holds true, then minimum will either  be the "mid" or be in left half
        if(nums[start] > nums[mid]) {
            return Math.min(nums[mid], findMin(nums, start, mid-1));
        } else if(nums[start] < nums[mid]) { // if this condition holds true, then minimum will either be "start" or be in right half
            return Math.min(nums[start], findMin(nums, mid+1, end));
        } else {
            // else minimum will be either be "mid" or Min(leftHalf, rightHalf)
            return Math.min(nums[mid], Math.min(findMin(nums, start, mid-1), findMin(nums, mid+1, end)));
        }
    }

    public static void main(String[] args) {
        int[]  nums = {3,1,3,3,3};
        System.out.println(new FindMinRotatedArray().findMin(nums));
    }
}
