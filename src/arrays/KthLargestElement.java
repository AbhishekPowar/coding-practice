package arrays;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class KthLargestElement {
    
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<k; i++)
            queue.add(nums[i]);
        for(int i=k; i<nums.length; i++) {
            if(nums[i] > queue.peek()) {
                queue.add(nums[i]);
                queue.poll();
            }
        }
        return queue.poll();
    }

    public int findKthLargest_2(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        while(true) {
            int pivotIndex = pivot(nums, start, end);
            if(pivotIndex < k-1)
                start = pivotIndex+1;
            if(pivotIndex > k-1)
                end = pivotIndex -1;
            else
                break;
        }
        return nums[k-1];
    }

    public int pivot(int[] numArray, int start, int end) {
        Random random = new Random();
        int pos = start;
        int random_pivot = start + (end-start ==0 ? 0: random.nextInt(end-start));
        int pivotElem = numArray[random_pivot];
        swap(numArray, random_pivot, start);

        for(int i=start+1; i<=end; i++) {
            if(numArray[i] >= pivotElem) {
                swap(numArray, ++pos, i);
            }
        }
        swap(numArray, start, pos);
        return pos;
    }

    public static void swap(int[] numArray, int i, int j) {
        numArray[i] = numArray[i] + numArray[j];
        numArray[j] = numArray[i] - numArray[j];
        numArray[i] = numArray[i] - numArray[j];
    }
    
    public static void main(String[] args) {
        System.out.println(new KthLargestElement().findKthLargest_2(new int[]{5,2,1,3,4}, 3));
    }
}
