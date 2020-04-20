package arrays;

import java.util.*;

@SuppressWarnings("ALL")
public class LeetProblem_1 {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_Approach1(int[] nums, int target) {
        Map<Integer, List<Integer>> indexes = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int elem = nums[i];
            if(indexes.containsKey(elem)) {
                int elemCount = indexes.get(elem).get(0) + 1;
                indexes.get(elem).set(0, elemCount);
                indexes.get(elem).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(i);
                indexes.put(elem, list);
            }
        }


        System.out.println(indexes);

        int[] ans = new int[2];

        for(int i=0; i<nums.length; i++) {
            int elem = nums[i];
            ans[0] = i;

            if(indexes.containsKey(target- elem) && indexes.get(target-elem).get(0) > 1) {
                ans[1] = indexes.get(target-elem).get(2);
                break;
            } else if(elem != (target-elem) && indexes.containsKey(target-elem)) {
                ans[1] = indexes.get(target-elem).get(1);
                break;
            }
        }
        return ans;
    }

    public int[] twoSum_Approach2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int targetCandidate = target - nums[i];
            if(map.containsKey(targetCandidate)) {
                return new int[]{i, map.get(targetCandidate)};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No Two Sum solution Found!!");
    }

    public static void main(String[] args) {

        int[] nums = {3,2,4};
        int target = 6;

        int[] ans = new LeetProblem_1().twoSum_Approach1(nums, target);

        System.out.println("Ans: ["+ans[0]+","+ans[1]+"]");
    }
}
