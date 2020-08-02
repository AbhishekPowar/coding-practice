package arrays;

import java.util.*;

public class AmazonDeletingArrays {

    public int[] solution(int[] nums, int[] query) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int q: query)
            queue.add(q);

        if(queue.isEmpty())
            return nums;
        int idx = queue.poll();
        int curr = nums[idx];

        for(int i=idx+1; i< nums.length; i++) {
            if(nums[i] < curr)
                nums[i] = 0;
            if(!queue.isEmpty() && i == queue.peek())
                curr = Math.max(curr, nums[queue.poll()]);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] ar = {4,3,4,3,2};
        int[] q = {3,2};

        int[] solution = new AmazonDeletingArrays().solution(new int[]{4,3,4,3,2}, new int[]{3,2});

        for(int s: solution)
            System.out.print(s+" ");
        solution = new AmazonDeletingArrays().solution(new int[]{3,2,1}, new int[]{2});

        for(int s: solution)
            System.out.print(s+" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.toString().trim();
    }
}
