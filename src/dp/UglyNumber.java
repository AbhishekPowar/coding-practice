package dp;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class UglyNumber {

    public int nthUglyNumber_1(int n) {

        PriorityQueue<Long> ll = new PriorityQueue<>();
        HashSet<Long> visited = new HashSet<>();
        int[] primes = {2,3,5};

        ll.add(1L);
        visited.add(1L);

        int curr = 1;

        while(curr < n) {
            long min = ll.poll();
            for(int i=0; i<3; i++) {
                long nextUgly = min * primes[i];
                if(!visited.contains(nextUgly)) {
                    ll.add(nextUgly);
                    visited.add(nextUgly);
                }
            }
            curr++;
        }
        return ll.poll().intValue();
    }

    public int nthUglyNumber_2(int n) {
        int[] nums = new int[1690];
        nums[0] = 1;
        int ugly, i2=0, i3=0, i5=0;

        for(int i=1; i<1690; i++) {
            ugly = Math.min(nums[i2]*2, Math.min(nums[i3]*3, nums[i5]*5));
            nums[i] = ugly;

            if(ugly == nums[i2]*2) i2++;
            if(ugly == nums[i3]*3) i3++;
            if(ugly == nums[i5]*5) i5++;
        }

        return nums[n-1];

    }

}
