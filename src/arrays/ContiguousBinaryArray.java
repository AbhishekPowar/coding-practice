package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * <strong>525. Contiguous Array</strong><br/>
 * Leetcode: https://leetcode.com/problems/contiguous-array/ <br/>
 * <div>
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * <code>Input: [0,1]</code>
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000
 * </div>
 */
public class ContiguousBinaryArray {
    public int max(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max_len = 0, count = 0;

        for(int i=0; i<nums.length; i++) {
            count += (nums[i]==0?-1:1);
            if(map.containsKey(count))
                max_len = Math.max(max_len, i - map.get(count));
            else
                map.put(count, i);
        }
        return max_len;
    }

    public static void main(String[] args) {
        System.out.println(new ContiguousBinaryArray().max(new int[]{1,0,1}));
    }
}
