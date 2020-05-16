package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class FindNumbersDisappearedArray {


    /**
     * Idea behind this solution is that, we need to place number at index 'i' to it correct position in array
     * Lets say, we know number 4 will be at index '3' in our final array. So if we encounter 4 at any other position we need to place it at it's correct position.
     * Placing it to it's correct position might not help here. So we need modify our array somehow without missing information.
     * We can just change the sign of the number present at correct position of number n. ie., we will change the sign of number at index '3' for number 4.
     * We'll do the same for our entire array. At end, only numbers which are missing, Their indexes will have a positive numbers. Hence we'll just add number i+1 in our answer array
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i=0; i<nums.length; i++) {
            int target = Math.abs(nums[i]) -1;

            if(target > 0)
                nums[target] = -nums[target];
        }

        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++)
            if(nums[i] > 0)
                ans.add(i+1);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindNumbersDisappearedArray().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

}
